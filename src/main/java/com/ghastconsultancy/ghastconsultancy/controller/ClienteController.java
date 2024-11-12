package com.ghastconsultancy.ghastconsultancy.controller;

import com.ghastconsultancy.ghastconsultancy.enums.TipoCliente;
import com.ghastconsultancy.ghastconsultancy.model.Cliente;
import com.ghastconsultancy.ghastconsultancy.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    // Injeção de dependência via construtor
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Métodos omitidos:
    // Method de criação de cliente
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        cliente.setTipoCliente(TipoCliente.PADRAO);
        Cliente novoCliente = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    // Method de atualização de cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);

        if (clienteExistente.isPresent()) {
            Cliente clienteAtualizado = clienteExistente.get();
            clienteAtualizado.setNome(cliente.getNome());
            clienteAtualizado.setCpf(cliente.getCpf());
            clienteAtualizado.setEmail(cliente.getEmail());
            clienteAtualizado.setTelefone(cliente.getTelefone());
            clienteRepository.save(clienteAtualizado);
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Method de exclusão de cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirClientePorId(@PathVariable Long id) {
        // Verifica se o cliente existe
        if (!clienteRepository.existsById(id)) {
            // Retorna uma resposta de não encontrado
            return ResponseEntity.notFound().build();
        }

        // Exclui o cliente
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna uma resposta 201 sem conteúdo
    }

    // Method de busca de cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        // Retorna o cliente encontrado ou uma resposta de não encontrado
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Method de listar de todos os clientes
    @GetMapping
    public List<Cliente> listarTodosClientes() {
        // Retorna todos os clientes cadastrados
        return clienteRepository.findAll();
    }

    // Method de promoção de cliente para VIP
    @PutMapping("/{id}/promover")
    public ResponseEntity<Cliente> promoverClienteParaVip(@PathVariable Long id) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.promoverParaVip();
            clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Method de busca de clientes VIP
    @GetMapping("/vip")
    public ResponseEntity<List<Cliente>> buscarClientesVip() {
        List<Cliente> clientesVip = clienteRepository.findByTipoCliente(TipoCliente.VIP);
        if (clientesVip.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientesVip);
    }

}
