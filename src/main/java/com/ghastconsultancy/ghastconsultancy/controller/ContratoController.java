package com.ghastconsultancy.ghastconsultancy.controller;

import com.ghastconsultancy.ghastconsultancy.model.Contrato;
import com.ghastconsultancy.ghastconsultancy.service.ContratoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    /**
     * Cadastrar um novo contrato
     */
    @Operation(summary = "Cadastrar um novo contrato", description = "Cria um novo contrato com base nos dados fornecidos.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrato cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    public ResponseEntity<Contrato> cadastrarContrato(@Valid @RequestBody Contrato contrato) {
        Contrato contratoSalvo = contratoService.cadastrarContrato(contrato);
        return ResponseEntity.ok(contratoSalvo);
    }

    /**
     * Buscar todos os contratos
     */
    @Operation(summary = "Listar todos os contratos", description = "Retorna a lista de todos os contratos cadastrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de contratos retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<?> listarContratos() {
        List<Contrato> contratos = contratoService.buscarContratos();
        return ResponseEntity.ok(contratos);
    }

    /**
     * Buscar contrato por ID
     */
    @Operation(summary = "Buscar contrato por ID", description = "Retorna os detalhes de um contrato com base no ID fornecido.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrato encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Contrato não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Contrato contrato = contratoService.buscarContratoPorId(id);
        if (contrato == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Contrato com ID " + id + " não encontrado.");
        }
        return ResponseEntity.ok(contrato);
    }

    /**
     * Buscar contratos por cliente
     */
    @Operation(summary = "Buscar contratos por cliente", description = "Retorna os contratos associados a um cliente específico.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contratos encontrados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum contrato encontrado para o cliente especificado")
    })
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<?> buscarPorClienteId(@PathVariable Long clienteId) {
        List<Contrato> contratos = contratoService.buscarPorClienteId(clienteId);
        if (contratos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum contrato encontrado para o ID especificado.");
        }
        return ResponseEntity.ok(contratos);
    }

    /**
     * Buscar contratos por empresa
     */
    @Operation(summary = "Buscar contratos por empresa", description = "Retorna os contratos associados a uma empresa específica.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contratos encontrados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum contrato encontrado para a empresa especificada")
    })
    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<?> buscarPorEmpresaId(@PathVariable Long empresaId) {
        List<Contrato> contratos = contratoService.buscarPorEmpresaId(empresaId);
        if (contratos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum contrato encontrado para o ID especificado.");
        }
        return ResponseEntity.ok(contratos);
    }

    /**
     * Buscar contratos por consultor
     */
    @Operation(summary = "Buscar contratos por consultor", description = "Retorna os contratos associados a um consultor específico.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contratos encontrados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum contrato encontrado para o consultor especificado")
    })
    @GetMapping("/consultor/{consultorId}")
    public ResponseEntity<?> buscarPorConsultorId(@PathVariable Long consultorId) {
        List<Contrato> contratos = contratoService.buscarPorConsultorId(consultorId);
        if (contratos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum contrato encontrado para o ID especificado.");
        }
        return ResponseEntity.ok(contratos);
    }

    /**
     * Deletar contrato por ID
     */
    @Operation(summary = "Deletar contrato por ID", description = "Remove um contrato com base no ID fornecido.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Contrato deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Contrato não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarContrato(@PathVariable Long id) {
        contratoService.deletarContrato(id);
        return ResponseEntity.noContent().build();
    }
}
