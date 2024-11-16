package com.ghastconsultancy.ghastconsultancy.repository;

import com.ghastconsultancy.ghastconsultancy.enums.Especializacao;
import com.ghastconsultancy.ghastconsultancy.enums.TamanhoNegocio;
import com.ghastconsultancy.ghastconsultancy.model.Consultor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ConsultorRepository extends JpaRepository<Consultor, Long> {
    List<Consultor> findByEspecializacao(Especializacao especializacao);
    List<Consultor> findByTamanhoNegocio(TamanhoNegocio tamanhoNegocio);
    Optional<Consultor> findByCpf(String cpf);
}
