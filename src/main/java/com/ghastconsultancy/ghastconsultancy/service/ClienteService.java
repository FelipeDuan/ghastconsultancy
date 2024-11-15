package com.ghastconsultancy.ghastconsultancy.service;

import com.ghastconsultancy.ghastconsultancy.enums.TipoCliente;
import com.ghastconsultancy.ghastconsultancy.model.Cliente;
import com.ghastconsultancy.ghastconsultancy.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado ){
        Cliente cliente  = obterPorId(id);
        return clienteRepository.save(cliente.atualizar(clienteAtualizado));
    }

    public Cliente excluir(Long id){
        Cliente cliente = obterPorId(id);
        clienteRepository.delete(cliente);
        return cliente;
    }

    public Cliente obterPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o cliente referente ao ID: " + id));
    }

    public List<Cliente> obterClientesVips() {
        return clienteRepository.findByTipoCliente(TipoCliente.VIP);
    }

    public List<Cliente> obterTodos() {
        return clienteRepository.findAll();
    }

    public Cliente promoverParaVip(Long id) {
        Cliente cliente = obterPorId(id);
        cliente.promoverParaVip();
        return clienteRepository.save(cliente);
    }

}
