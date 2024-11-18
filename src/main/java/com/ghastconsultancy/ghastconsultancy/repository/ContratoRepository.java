package com.ghastconsultancy.ghastconsultancy.repository;


import com.ghastconsultancy.ghastconsultancy.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    // Buscar por cliente, consultor ou empresa
    List<Contrato> findByClienteId(Long clienteId);
    List<Contrato> findByEmpresaId(Long empresaId);
    List<Contrato> findByConsultorId(Long consultorId);
}
