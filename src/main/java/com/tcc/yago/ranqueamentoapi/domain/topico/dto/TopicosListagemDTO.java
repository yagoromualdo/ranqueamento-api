package com.tcc.yago.ranqueamentoapi.domain.topico.dto;

import com.tcc.yago.ranqueamentoapi.domain.topico.Topico;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicosListagemDTO {
    private Topico topico;
    private PrimeiroSegundoTerceiroDTO primeiroSegundoTerceiro;
    private Long qtdVotos;
    private Long qtdComentarios;
}
