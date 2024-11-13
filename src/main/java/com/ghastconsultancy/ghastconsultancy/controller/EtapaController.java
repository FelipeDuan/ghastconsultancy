package com.ghastconsultancy.ghastconsultancy.controller;

import com.ghastconsultancy.ghastconsultancy.enums.StatusEtapa;
import com.ghastconsultancy.ghastconsultancy.model.Etapa;
import com.ghastconsultancy.ghastconsultancy.repository.EtapaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/etapas"))
public class EtapaController {

    private final EtapaRepository etapaRepository;

    public EtapaController(EtapaRepository etapaRepository) {
        this.etapaRepository = etapaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Etapa>> cosultarTodos(){
        List<Etapa> etapas = etapaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(etapas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etapa> consultar(@PathVariable Long id){
        Optional<Etapa> etapa = etapaRepository.findById(id);
        return etapa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/status/{statusEtapa}")
    public ResponseEntity<List<Etapa>> consultarStatus(@PathVariable StatusEtapa statusEtapa){
        List<Etapa> etapas = etapaRepository.findByStatusEtapa(statusEtapa);
        return ResponseEntity.ok(etapas);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Etapa> editarEtapa(@PathVariable Long id, @RequestBody Etapa etapaParam){
        Optional<Etapa> etapaOptional = etapaRepository.findById(id);

        if(etapaOptional.isPresent()){
            Etapa etapa = etapaOptional.get();

            etapa.setNome(etapaParam.getNome());
            etapa.setDescricao(etapaParam.getDescricao());
            etapa.setStatusEtapa(etapaParam.getStatusEtapa());
            etapaRepository.save(etapa);

            return ResponseEntity.status(HttpStatus.OK).body(etapa);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Etapa> deleterEtapa(@PathVariable Long id){
        Optional<Etapa> etapa =etapaRepository.findById(id);
        if(etapa.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            etapaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(etapa.get());
        }
    }
}
