package com.ghastconsultancy.ghastconsultancy.repository;


import com.ghastconsultancy.ghastconsultancy.enums.StatusProjeto;
import com.ghastconsultancy.ghastconsultancy.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findByStatusProjeto(StatusProjeto status);
}
