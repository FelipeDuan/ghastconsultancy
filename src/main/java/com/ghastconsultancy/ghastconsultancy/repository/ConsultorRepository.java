package com.ghastconsultancy.ghastconsultancy.repository;

import com.ghastconsultancy.ghastconsultancy.model.Consultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ConsultorRepository extends JpaRepository<Consultor, Long> {

    Optional<Consultor> findByCpf(String cpf);
}
