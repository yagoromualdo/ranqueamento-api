package com.tcc.yago.ranqueamentoapi.domain.tecnologias;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tecnologias")
@NoArgsConstructor
@Getter
@Setter
public class Tecnologias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String icon;
    private Long idTipo;
}
