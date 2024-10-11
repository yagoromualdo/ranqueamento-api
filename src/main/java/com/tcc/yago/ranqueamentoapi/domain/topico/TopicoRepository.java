package com.tcc.yago.ranqueamentoapi.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT T FROM Topico T WHERE T.categoria = 1 ORDER BY T.dataCriacao DESC")
    List<Topico> listarTopicosPorVotacao();


    @Query("SELECT T.id FROM Topico T WHERE T.usuario.id  = :idUsuario")
    List<Long> listarTopicosPorIdUsuario(Long idUsuario);
}
