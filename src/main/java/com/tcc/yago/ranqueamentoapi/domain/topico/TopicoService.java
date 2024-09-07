package com.tcc.yago.ranqueamentoapi.domain.topico;

import com.tcc.yago.ranqueamentoapi.domain.topico.dto.TopicosListagemDTO;
import com.tcc.yago.ranqueamentoapi.domain.votos.VotosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final TopicoRepository topicoRepository;

    private final VotosService votosService;
    public List<TopicosListagemDTO> listar() {
        List<TopicosListagemDTO> topicosListagemDTOList = new ArrayList<>();
        List<Topico> topicos = new ArrayList<>();
        topicos = topicoRepository.listarTopicos();
        topicos.forEach(t -> {
            TopicosListagemDTO topicoListagem = new TopicosListagemDTO();
            topicoListagem.setTopico(t);
            topicoListagem.setPrimeiroSegundoTerceiro(votosService.obterTop3TecnologiasPorTopico(t.getId()));
            topicoListagem.setQtdVotos(votosService.obterQtdVotosPorTopico(t.getId()));
            topicosListagemDTOList.add(topicoListagem);
        });
        return topicosListagemDTOList;
    }
}
