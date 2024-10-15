package com.tcc.yago.ranqueamentoapi.domain.comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    @Query("SELECT C FROM Comentario C WHERE C.topico.id = :idTopico ORDER BY C.dataCriacao ASC")
    List<Comentario> listarPorTopico(Long idTopico);

}
