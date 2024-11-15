package com.ghastconsultancy.ghastconsultancy.controller;

import com.ghastconsultancy.ghastconsultancy.enums.SetorAtuacao;
import com.ghastconsultancy.ghastconsultancy.model.Cliente;
import com.ghastconsultancy.ghastconsultancy.model.Empresa;
import com.ghastconsultancy.ghastconsultancy.repository.ClienteRepository;
import com.ghastconsultancy.ghastconsultancy.repository.EmpresaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final ClienteRepository clienteRepository;
    private final EmpresaRepository empresaRepository;

    public EmpresaController(EmpresaRepository empresaRepository, ClienteRepository clienteRepository) {
        this.empresaRepository = empresaRepository;
        this.clienteRepository = clienteRepository;
    }

    // Method de Cadastro de Empresa
    @PostMapping
    public ResponseEntity<?> criarEmpresa(@RequestBody Empresa empresa) {
        if (!clienteRepository.existsById(empresa.getRepresentanteLegal().getId())) {
            return ResponseEntity.badRequest().body("Representante legal não encontrado.");
        }

        // Obter o telefone do representante legal
        String telefoneRepresentante = clienteRepository.findById(empresa.getRepresentanteLegal().getId())
                .map(Cliente::getTelefone)
                .orElse(null);

        // Definir o telefone da empresa com o telefone do representante
        empresa.setTelefone(telefoneRepresentante);

        Empresa novaEmpresa = empresaRepository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);
    }

    // Method de Listar todas as Empresas
    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        return ResponseEntity.ok(empresas);
    }

    // Method de Listar Empresas por Setor de Atuação
    @GetMapping("/setor/{setor}")
    public ResponseEntity<List<Empresa>> listarEmpresasPorSetor(@PathVariable SetorAtuacao setor) {
        List<Empresa> empresas = empresaRepository.findBySetorAtuacao(setor);
        return ResponseEntity.ok(empresas);
    }

    // Method de Buscar Empresa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarEmpresaPorId(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Method de Atualização de Empresa
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresaAtualizada) {
        if (!empresaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada.");
        }

        if (!clienteRepository.existsById(empresaAtualizada.getRepresentanteLegal().getId())) {
            return ResponseEntity.badRequest().body("Representante legal não encontrado.");
        }

        // Obter o telefone do representante legal
        String telefoneRepresentante = clienteRepository.findById(empresaAtualizada.getRepresentanteLegal().getId())
                .map(Cliente::getTelefone)
                .orElse(null);

        // Definir o telefone da empresa com o telefone do representante
        empresaAtualizada.setTelefone(telefoneRepresentante);

        empresaAtualizada.setId(id); // Garante que o ID permanece o mesmo para atualizar
        Empresa empresaSalva = empresaRepository.save(empresaAtualizada);
        return ResponseEntity.ok(empresaSalva);
    }

    // Method Exclusão de Empresa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEmpresa(@PathVariable Long id) {
        if (!empresaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        empresaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
