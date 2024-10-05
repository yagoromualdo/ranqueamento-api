package com.tcc.yago.ranqueamentoapi.domain.topico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcc.yago.ranqueamentoapi.domain.votos.Votos;
import com.tcc.yago.ranqueamentoapi.security.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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
    private Long categoria;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAlteracao;

    @JsonIgnore
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private Set<Votos> votos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

}
