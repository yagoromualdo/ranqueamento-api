package com.tcc.yago.ranqueamentoapi.domain.comentario;

import com.tcc.yago.ranqueamentoapi.domain.comentario.dto.ComentarioParaSalvarDTO;
import com.tcc.yago.ranqueamentoapi.domain.tecnologias.Tecnologias;
import com.tcc.yago.ranqueamentoapi.domain.tecnologias.TecnologiasService;
import com.tcc.yago.ranqueamentoapi.domain.topico.Topico;
import com.tcc.yago.ranqueamentoapi.domain.topico.TopicoService;
import com.tcc.yago.ranqueamentoapi.security.user.User;
import com.tcc.yago.ranqueamentoapi.security.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    private final UserService userService;

    private final TopicoService topicoService;

    private final TecnologiasService tecnologiasService;

    public Comentario salvarComentario(ComentarioParaSalvarDTO comentario) {
        try {
            User usuario = userService.findById(comentario.getIdUsuario());
            Topico topico = topicoService.findById(Long.parseLong(comentario.getIdTopico()));
            Tecnologias tecnologia = null;
            if (comentario.getIdTecnologia() != null && comentario.getIdTecnologia() != "" && comentario.getIdTecnologia() != " ") {
                tecnologia = tecnologiasService.findById(Long.parseLong(comentario.getIdTecnologia()));
            }
            if (usuario != null && topico != null
                    && (Objects.equals(comentario.getTipoDeComentario(), "Comum") || tecnologia != null)) {
                Comentario novoComentario = new Comentario();
                novoComentario.setUsuario(usuario);
                novoComentario.setTopico(topico);
                novoComentario.setComentario(comentario.getComentario());
                novoComentario.setTipoDeComentario(comentario.getTipoDeComentario());
                novoComentario.setTecnologias(tecnologia);

                return comentarioRepository.save(novoComentario);
            }
            return null;
        } catch (Exception e) {
            System.err.println("Erro ao tentar salvar o comentário: " + e.getMessage());
            throw e;
        }
    }
}
