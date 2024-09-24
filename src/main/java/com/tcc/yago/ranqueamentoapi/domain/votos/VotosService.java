package com.tcc.yago.ranqueamentoapi.domain.votos;

import com.tcc.yago.ranqueamentoapi.domain.tecnologias.Tecnologias;
import com.tcc.yago.ranqueamentoapi.domain.tecnologias.TecnologiasService;
import com.tcc.yago.ranqueamentoapi.domain.tecnologias.dto.TecnologiaDTO;
import com.tcc.yago.ranqueamentoapi.domain.topico.dto.PrimeiroSegundoTerceiroDTO;
import com.tcc.yago.ranqueamentoapi.domain.votos.dto.VotoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VotosService {

    private final VotosRepository votosRepository;

    private final TecnologiasService tecnologiasService;

    public PrimeiroSegundoTerceiroDTO obterTop3TecnologiasPorTopico(Long idTopico) {
        PrimeiroSegundoTerceiroDTO primeiroSegundoTerceiroDTO = new PrimeiroSegundoTerceiroDTO();

        Pageable pageable = PageRequest.of(0, 1);
        List<Tecnologias> resultado = votosRepository.obterTecnologiasOrdenadasPorVotos(idTopico, pageable);
        primeiroSegundoTerceiroDTO.setPrimeiro(resultado.isEmpty() ? null : resultado.get(0));

        pageable = PageRequest.of(1, 1);
        resultado = votosRepository.obterTecnologiasOrdenadasPorVotos(idTopico, pageable);
        primeiroSegundoTerceiroDTO.setSegundo(resultado.isEmpty() ? null : resultado.get(0));

        pageable = PageRequest.of(2, 1);
        resultado = votosRepository.obterTecnologiasOrdenadasPorVotos(idTopico, pageable);
        primeiroSegundoTerceiroDTO.setTerceiro(resultado.isEmpty() ? null : resultado.get(0));

        return primeiroSegundoTerceiroDTO;
    }

    public Long obterQtdVotosPorTopico(Long idTopico) {
        return votosRepository.obterQtdVotosPorTopico(idTopico);
    }

    public List<TecnologiaDTO> obterTecnologiasPorTopico(Long idTopico, Pageable pageable) {
        return votosRepository.obterTecnologiasPorTopico(idTopico, pageable);
    }

    public VotoDTO salvar(VotoDTO voto) {
//        Votos votoSalvo = votosRepository.obterVotoPorTopicoEUsuario(voto.getIdTopico(), voto.getIdUsuario());
//        Tecnologias tecnologia = tecnologiasService.buscarPorId(voto.getIdTecnologia()).orElse(null);
//        if (tecnologia != null) {
//            if (votoSalvo != null && votoSalvo.getId() != null) {
//                    votoSalvo.setTecnologias(tecnologia);
//                    votosRepository.save(votoSalvo);
//            } else {
//                usuarioservice
//                topicoService
//                Votos novoVoto = new Votos();
//                novoVoto.setTecnologias(tecnologia);
//                novoVoto.setUsuario();
//                novoVoto.setTopico();
//                votosRepository.save(voto);
//            }
//        }
        var votoT = voto;
        return voto;
    }
}
