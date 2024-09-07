package com.tcc.yago.ranqueamentoapi.domain.votos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcc.yago.ranqueamentoapi.domain.tecnologias.Tecnologias;
import com.tcc.yago.ranqueamentoapi.domain.topico.Topico;
import com.tcc.yago.ranqueamentoapi.security.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "votos", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"usuario_id", "topico_id", "tecnologia_id"})
})
@NoArgsConstructor
@Getter
@Setter
public class Votos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tecnologia_id", nullable = false)
    private Tecnologias tecnologias;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAlteracao;
}
