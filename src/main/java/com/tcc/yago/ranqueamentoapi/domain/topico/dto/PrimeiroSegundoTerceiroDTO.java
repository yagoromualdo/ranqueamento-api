package com.tcc.yago.ranqueamentoapi.domain.topico.dto;

import com.tcc.yago.ranqueamentoapi.domain.tecnologias.Tecnologias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrimeiroSegundoTerceiroDTO {
    private Tecnologias primeiro;
    private Tecnologias segundo;
    private Tecnologias terceiro;
}
