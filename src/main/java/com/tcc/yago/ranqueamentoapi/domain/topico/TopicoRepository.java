package com.tcc.yago.ranqueamentoapi.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("SELECT T FROM Topico T ORDER BY T.dataCriacao DESC")
    List<Topico> listarTopicos();
}
