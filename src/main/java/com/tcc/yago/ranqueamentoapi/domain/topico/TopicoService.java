package com.tcc.yago.ranqueamentoapi.domain.topico;

import com.tcc.yago.ranqueamentoapi.domain.tecnologias.Tecnologias;
import com.tcc.yago.ranqueamentoapi.domain.tecnologias.dto.TecnologiaDTO;
import com.tcc.yago.ranqueamentoapi.domain.topico.dto.TopicoDTO;
import com.tcc.yago.ranqueamentoapi.domain.topico.dto.TopicoSalvarDTO;
import com.tcc.yago.ranqueamentoapi.domain.topico.dto.TopicosListagemDTO;
import com.tcc.yago.ranqueamentoapi.domain.votos.Votos;
import com.tcc.yago.ranqueamentoapi.domain.votos.VotosService;
import com.tcc.yago.ranqueamentoapi.domain.votos.dto.VotoDTO;
import com.tcc.yago.ranqueamentoapi.security.user.User;
import com.tcc.yago.ranqueamentoapi.security.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final TopicoRepository topicoRepository;

    private final VotosService votosService;

    private final UserService userService;

    public List<TopicosListagemDTO> listarTopicosPorVotacao() {
        List<TopicosListagemDTO> topicosListagemDTOList = new ArrayList<>();
        List<Topico> topicos = new ArrayList<>();
        topicos = topicoRepository.listarTopicosPorVotacao();
        topicos.forEach(t -> {
            TopicosListagemDTO topicoListagem = new TopicosListagemDTO();
            topicoListagem.setTopico(t);
            topicoListagem.setPrimeiroSegundoTerceiro(votosService.obterTop3TecnologiasPorTopico(t.getId()));
            topicoListagem.setQtdVotos(votosService.obterQtdVotosPorTopico(t.getId()));
            topicosListagemDTOList.add(topicoListagem);
        });
        return topicosListagemDTOList;
    }

    public TopicoDTO buscarPorId(Long id) {
        TopicoDTO topicoInfosGerais = new TopicoDTO();
        Optional<Topico> topicoResult =  topicoRepository.findById(id);
        Topico topico = topicoResult.orElse(null);
        if (topico != null) {
            topicoInfosGerais.setTopico(topico);
            Long qtdVotosTotal = votosService.obterQtdVotosPorTopico(topico.getId());
            List<TecnologiaDTO> tecnologias = votosService.obterTecnologiasPorTopico(topico.getId(), PageRequest.of(0, 10));
            for (int i = 0; i < tecnologias.size(); i++) {
                tecnologias.get(i).setPosicao(i + 1);
                Long qtdVotos = tecnologias.get(i).getQtdVotos();

                if (qtdVotosTotal != null && qtdVotosTotal > 0) {
                    // Calcula a porcentagem
                    double porcentagem = (double) qtdVotos / qtdVotosTotal * 100;

                    // Formata como string com símbolo de %
                    String porcentagemFormatada = String.format("%.2f%%", porcentagem); // Limita a 2 casas decimais

                    // Define o valor da porcentagem na tecnologia
                    tecnologias.get(i).setPorcentagem(porcentagemFormatada);
                } else {
                    tecnologias.get(i).setPorcentagem("0%"); // Evita divisão por zero
                }
            }
            topicoInfosGerais.setTecnologias(tecnologias);
            topicoInfosGerais.setQtdVotos(qtdVotosTotal);
        }

        return topicoInfosGerais;
    }

    public Topico findById(Long id) {
        return topicoRepository.findById(id).orElse(null);
    }

    public Topico salvar(TopicoSalvarDTO topico) {
        try {
            User usuario = userService.findById(topico.getIdUsuario());
            if (usuario != null) {
                List<Long> topicosDoUsuario = topicoRepository.listarTopicosPorIdUsuario(topico.getIdUsuario());
                if(topicosDoUsuario.size() < 10) {
                    Topico novoTopico = new Topico();
                    novoTopico.setUsuario(usuario);
                    novoTopico.setCategoria(topico.getCategoria());
                    novoTopico.setIdTipo(topico.getIdTipo());
                    novoTopico.setNome(topico.getNome());
                    return topicoRepository.save(novoTopico);
                }
            }
            return null;
        } catch (Exception e) {
            System.err.println("Erro ao tentar salvar o tópico: " + e.getMessage());
            throw e;
        }
    }
}
