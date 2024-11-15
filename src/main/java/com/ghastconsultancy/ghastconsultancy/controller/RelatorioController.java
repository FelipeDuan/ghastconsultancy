package com.ghastconsultancy.ghastconsultancy.controller;


import com.ghastconsultancy.ghastconsultancy.model.Relatorio;
import com.ghastconsultancy.ghastconsultancy.service.RelatorioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @PostMapping("/{projetoId}")
    public ResponseEntity<Relatorio> criarRelatorio(@PathVariable Long projetoId,@RequestBody Relatorio relatorio) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(relatorioService.saveRelatorio(projetoId,relatorio));
        }
        catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Relatorio>> listarRelatorios() {
        List<Relatorio> relatorios = relatorioService.findAllRelatorios();
        return relatorios.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(relatorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relatorio> buscarRelatorio(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(relatorioService.findRelatorioById(id));
        }
        catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Relatorio> atualizarRelatorio(@PathVariable Long id, @RequestBody Relatorio relatorioUpdate) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(relatorioService.updateRelatorio(id,relatorioUpdate));
        }
        catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Relatorio> removerRelatorio(@PathVariable Long id) {
        relatorioService.deleteRelatorio(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
