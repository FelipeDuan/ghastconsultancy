package com.ghastconsultancy.ghastconsultancy.service;

import com.ghastconsultancy.ghastconsultancy.model.Cliente;
import com.ghastconsultancy.ghastconsultancy.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente atualizar(Long id, Cliente clienteAtualizado ){
        Cliente cliente  = obterPorId(id);
        return clienteRepository.save(cliente.atualizar(clienteAtualizado));
    }

    public Cliente obterPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o cliente referente ao ID: " + id));
    }

}
