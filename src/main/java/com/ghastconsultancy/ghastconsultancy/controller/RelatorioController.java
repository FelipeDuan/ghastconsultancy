package com.ghastconsultancy.ghastconsultancy.controller;


import com.ghastconsultancy.ghastconsultancy.model.Relatorio;
import com.ghastconsultancy.ghastconsultancy.repository.RelatorioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
