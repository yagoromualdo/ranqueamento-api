package com.tcc.yago.ranqueamentoapi.domain.votos;

import com.tcc.yago.ranqueamentoapi.domain.tecnologias.Tecnologias;
import com.tcc.yago.ranqueamentoapi.domain.tecnologias.dto.TecnologiaDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotosRepository extends JpaRepository<Votos, Long> {

    @Query("SELECT t  FROM Tecnologias t             " +
            "JOIN Votos v ON v.tecnologias.id = t.id " +
            "WHERE v.topico.id = :idTopico           " +
            "GROUP BY t.id                           " +
            "ORDER BY COUNT(v.id) DESC               ")
    List<Tecnologias> obterTecnologiasOrdenadasPorVotos(@Param("idTopico") Long idTopico, Pageable pageable);

    @Query("SELECT COUNT(v.id) FROM Votos v WHERE v.topico.id = :idTopico")
    Long obterQtdVotosPorTopico(@Param("idTopico") Long idTopico);

    @Query("SELECT new com.tcc.yago.ranqueamentoapi.domain.tecnologias.dto.TecnologiaDTO(" +
            "t.id, t.nome, t.icon, COUNT(v.id))      " +
            "FROM Tecnologias t                      " +
            "JOIN Votos v ON v.tecnologias.id = t.id " +
            "WHERE v.topico.id = :idTopico           " +
            "GROUP BY t.id                           " +
            "ORDER BY COUNT(v.id) DESC               ")
    List<TecnologiaDTO> obterTecnologiasPorTopico(@Param("idTopico") Long idTopico, Pageable pageable);

    @Query("SELECT v FROM Votos v " +
            "WHERE v.topico.id = :idTopico " +
            "AND v.usuario.id = :idUsuario")
    Votos obterVotoPorTopicoEUsuario(Long idTopico, Long idUsuario);

}
