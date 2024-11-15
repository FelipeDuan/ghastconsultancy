package com.ghastconsultancy.ghastconsultancy.repository;

import com.ghastconsultancy.ghastconsultancy.enums.TipoCliente;
import com.ghastconsultancy.ghastconsultancy.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Buscar clientes Vips
    List<Cliente> findByTipoCliente(TipoCliente tipoCliente);
}
