package com.ghastconsultancy.ghastconsultancy.controller;


import com.ghastconsultancy.ghastconsultancy.model.Etapa;
import com.ghastconsultancy.ghastconsultancy.service.EtapaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping(("/etapas"))
public class EtapaController {

    private final EtapaService etapaService;

    public EtapaController(EtapaService etapaService) {
        this.etapaService = etapaService;
    }

    // POST -> ETAPA ID
    @PostMapping("/projetos/{projetoId}")
    public ResponseEntity<Etapa> createEtapa(@PathVariable Long projetoId,@RequestBody Etapa etapa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(etapaService.SaveEtapa(projetoId, etapa));
    }

    // GET -> ID
    @GetMapping("/{id}")
    public ResponseEntity<Etapa> findEtapaById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(etapaService.findEtapaById(id));
        }
        catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // GET -> ALL
    @GetMapping
    public ResponseEntity<List<Etapa>> findAllEtapas() {
        List<Etapa> etapas = etapaService.findAllEtapas();
        return etapas.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(etapas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etapa> editarEtapa(@PathVariable Long id, @RequestBody Etapa etapaUpdate){
        try {

            return ResponseEntity.status(HttpStatus.OK).body(etapaService.updateEtapa(id, etapaUpdate));
        }
        catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Etapa> removeEtapa(@PathVariable Long id){
        try {
            etapaService.deleteEtapa(id);
            return ResponseEntity.status(HttpStatus.OK).body(etapaService.findEtapaById(id));
        }
        catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




}
