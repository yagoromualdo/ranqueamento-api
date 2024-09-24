package com.tcc.yago.ranqueamentoapi.domain.votos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VotoDTO {
    private Long id;
    private Long idTecnologia;
    private Long idTopico;
    private Long idUsuario;
}
