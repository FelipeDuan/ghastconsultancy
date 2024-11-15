package com.ghastconsultancy.ghastconsultancy.controller;

import com.ghastconsultancy.ghastconsultancy.enums.TipoCliente;
import com.ghastconsultancy.ghastconsultancy.model.Cliente;
import com.ghastconsultancy.ghastconsultancy.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {


    private final ClienteService clienteService;

    // Injeção de dependência via construtor
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Métodos omitidos:
    // Method de criação de cliente
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
    }

    // Method de atualização de cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            return ResponseEntity.ok(clienteService.atualizar(id, cliente));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    } // de 13 pra 1 para ir dormir feliz, By: M & A.

    // Method de exclusão de cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> excluirClientePorId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.excluir(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Method de busca de cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clienteService.obterPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Method de listar de todos os clientes
    @GetMapping
    public List<Cliente> listarTodosClientes() {
        return clienteService.obterTodos();
    }

    // Method de promoção de cliente para VIP
    @PutMapping("/{id}/promover")
    public ResponseEntity<Cliente> promoverClienteParaVip(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clienteService.promoverParaVip(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Method de busca de clientes VIP
    @GetMapping("/vip")
    public ResponseEntity<List<Cliente>> buscarClientesVip() {
        return ResponseEntity.ok(clienteService.obterClientesVips());
    }

}
