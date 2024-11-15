package com.ghastconsultancy.ghastconsultancy.controller;


import com.ghastconsultancy.ghastconsultancy.model.Relatorio;
import com.ghastconsultancy.ghastconsultancy.repository.RelatorioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioRepository relatorioRepository;

    public RelatorioController(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    @PostMapping
    public ResponseEntity<Relatorio> criarRelatorio(@RequestBody Relatorio relatorio) {
        relatorioRepository.save(relatorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(relatorio);
    }

    @GetMapping
    public ResponseEntity<List<Relatorio>> listarRelatorios() {
        List<Relatorio> relatorios = relatorioRepository.findAll();
        return relatorios.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(relatorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relatorio> buscarRelatorio(@PathVariable Long id) {
        Optional<Relatorio> relatorio = relatorioRepository.findById(id);
        return relatorio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
