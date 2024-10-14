package com.tcc.yago.ranqueamentoapi.domain.comentario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioParaSalvarDTO {

    private Long idUsuario;
    private String idTopico;
    private String tipoDeComentario;
    private String comentario;
    private String idTecnologia;

}
