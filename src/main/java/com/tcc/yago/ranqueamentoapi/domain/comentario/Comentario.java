package com.tcc.yago.ranqueamentoapi.domain.comentario;

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
@Table(name = "comentario")
@NoArgsConstructor
@Getter
@Setter
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentario;

    private String tipoDeComentario;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    private LocalDateTime dataAlteracao;

    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "tecnologia_id")
    private Tecnologias tecnologias;

}
