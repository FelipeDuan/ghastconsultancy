package com.ghastconsultancy.ghastconsultancy.repository;

import com.ghastconsultancy.ghastconsultancy.enums.SetorAtuacao;
import com.ghastconsultancy.ghastconsultancy.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    // Method para buscar empresas por setor de atuação
    List<Empresa> findBySetorAtuacao(SetorAtuacao setorAtuacao);

    // Buscar por Cliente
    List<Empresa> findByRepresentanteLegalId(Long representanteLegalId);
}
