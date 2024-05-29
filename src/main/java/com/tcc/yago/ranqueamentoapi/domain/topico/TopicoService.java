package com.tcc.yago.ranqueamentoapi.domain.topico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final TopicoRepository topicoRepository;
    public List<Topico> listar() {
        return topicoRepository.findAll();
    }
}
