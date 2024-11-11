package com.ghastconsultancy.ghastconsultancy.repository;


import com.ghastconsultancy.ghastconsultancy.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto,Long> {
}
