package com.tcc.yago.ranqueamentoapi.domain.topico.dto;

import com.tcc.yago.ranqueamentoapi.domain.tecnologias.dto.TecnologiaDTO;
import com.tcc.yago.ranqueamentoapi.domain.topico.Topico;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TopicoDTO {
    private Topico topico;
    private List<TecnologiaDTO> tecnologias;
    private Long qtdVotos;
}
