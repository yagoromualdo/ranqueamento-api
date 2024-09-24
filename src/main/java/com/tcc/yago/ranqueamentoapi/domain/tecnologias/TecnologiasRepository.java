package com.tcc.yago.ranqueamentoapi.domain.tecnologias;

import com.tcc.yago.ranqueamentoapi.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecnologiasRepository  extends JpaRepository<Tecnologias, Long> {
    @Query("SELECT T FROM Tecnologias T WHERE T.idTipo = :idTipo ORDER BY T.nome")
    List<Tecnologias> listarPorTipo(Long idTipo);
}
