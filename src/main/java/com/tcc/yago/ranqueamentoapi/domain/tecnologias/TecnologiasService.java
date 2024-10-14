package com.tcc.yago.ranqueamentoapi.domain.tecnologias;

import com.tcc.yago.ranqueamentoapi.domain.topico.dto.TopicoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TecnologiasService {

    private final TecnologiasRepository tecnologiasRepository;

    public List<Tecnologias> listarPorTipo(Long idTipo) {
        return tecnologiasRepository.listarPorTipo(idTipo);
    }

    public Optional<Tecnologias> buscarPorId(Long id) {
        return tecnologiasRepository.findById(id);
    }

    public Tecnologias findById(Long id) { return  tecnologiasRepository.findById(id).orElse(null); }
}
