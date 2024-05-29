package com.tcc.yago.ranqueamentoapi.domain.topico;

import com.tcc.yago.ranqueamentoapi.domain.votos.Votos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "topico")
@NoArgsConstructor
@Getter
@Setter
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long idTipo;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private Set<Votos> votos;

}
