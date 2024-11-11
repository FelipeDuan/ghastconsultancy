package com.ghastconsultancy.ghastconsultancy.repository;

import com.ghastconsultancy.ghastconsultancy.model.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Long> {
    List<Etapa> findByStatus(Integer status);
}
