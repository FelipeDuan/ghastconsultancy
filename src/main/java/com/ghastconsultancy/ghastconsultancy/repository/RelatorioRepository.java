package com.ghastconsultancy.ghastconsultancy.repository;

import com.ghastconsultancy.ghastconsultancy.model.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio,Long> {

}
