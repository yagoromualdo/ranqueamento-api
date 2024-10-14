package com.tcc.yago.ranqueamentoapi.domain.tecnologias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcc.yago.ranqueamentoapi.domain.comentario.Comentario;
import com.tcc.yago.ranqueamentoapi.domain.votos.Votos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

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

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAlteracao;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnologias", cascade = CascadeType.ALL)
    private Set<Votos> votos;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnologias", cascade = CascadeType.ALL)
    private Set<Comentario> comentario;
}
