package com.tcc.yago.ranqueamentoapi.domain.votos.dto;

import com.tcc.yago.ranqueamentoapi.domain.tecnologias.Tecnologias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TecnologiaQuantidadeVotos {
    private Tecnologias tecnologia;
    private Long qtdVotos;
}
