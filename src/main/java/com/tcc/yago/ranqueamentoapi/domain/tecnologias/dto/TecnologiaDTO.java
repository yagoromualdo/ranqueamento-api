package com.tcc.yago.ranqueamentoapi.domain.tecnologias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TecnologiaDTO {
    private Integer posicao;
    private Long id;
    private String nome;
    private String icon;
    private Long qtdVotos;
    private String porcentagem;
    private Integer comentarioAFavor = 0;
    private Integer comentarioContra = 0;

    public TecnologiaDTO(Long id, String nome, String icon, Long qtdVotos) {
        this.id = id;
        this.nome = nome;
        this.icon = icon;
        this.qtdVotos = qtdVotos;
    }
}
