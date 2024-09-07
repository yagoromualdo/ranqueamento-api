package com.tcc.yago.ranqueamentoapi.domain.votos;

import com.tcc.yago.ranqueamentoapi.domain.tecnologias.Tecnologias;
import com.tcc.yago.ranqueamentoapi.domain.topico.dto.PrimeiroSegundoTerceiroDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VotosService {

    private final VotosRepository votosRepository;

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
}
