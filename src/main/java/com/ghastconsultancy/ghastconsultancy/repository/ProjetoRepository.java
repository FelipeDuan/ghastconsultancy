package com.ghastconsultancy.ghastconsultancy.repository;


import com.ghastconsultancy.ghastconsultancy.enums.StatusProjeto;
import com.ghastconsultancy.ghastconsultancy.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findByStatusProjeto(StatusProjeto status);

    @Query("SELECT p FROM Projeto p WHERE YEAR(p.dataInicio) = :ano AND MONTH(p.dataInicio) = :mes")
    List<Projeto> findByMesEAno(@Param("ano") int ano, @Param("mes") int mes);
}
