package com.tcc.yago.ranqueamentoapi.domain.topico.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoSalvarDTO {
    private String nome;
    private Long idTipo;
    private Long categoria;
    private Long idUsuario;
}
