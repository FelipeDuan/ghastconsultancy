package com.ghastconsultancy.ghastconsultancy.controller;

import com.ghastconsultancy.ghastconsultancy.enums.SetorAtuacao;
import com.ghastconsultancy.ghastconsultancy.model.Empresa;
import com.ghastconsultancy.ghastconsultancy.service.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<?> criarEmpresa(@RequestBody Empresa empresa) {
        try {
            Empresa novaEmpresa = empresaService.criarEmpresa(empresa);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar empresa: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        List<Empresa> empresas = empresaService.listarEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/setor/{setor}")
    public ResponseEntity<List<Empresa>> listarEmpresasPorSetor(@PathVariable SetorAtuacao setor) {
        List<Empresa> empresas = empresaService.listarEmpresasPorSetor(setor);
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEmpresaPorId(@PathVariable Long id) {
        try {
            Empresa empresa = empresaService.buscarEmpresaPorId(id);
            return ResponseEntity.ok(empresa);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresaAtualizada) {
        try {
            Empresa empresaSalva = empresaService.atualizarEmpresa(id, empresaAtualizada);
            return ResponseEntity.ok(empresaSalva);
        } catch (RuntimeException e) {
            if (e.getMessage().contains("não encontrada")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: " + e.getMessage());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar empresa: " + e.getMessage());
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirEmpresa(@PathVariable Long id) {
        try {
            empresaService.excluirEmpresa(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Empresa excluída com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: " + e.getMessage());
        }
    }
}
