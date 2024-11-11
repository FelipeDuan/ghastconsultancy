package com.ghastconsultancy.ghastconsultancy.controller;

import com.ghastconsultancy.ghastconsultancy.model.Etapa;
import com.ghastconsultancy.ghastconsultancy.repository.EtapaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(("/etapa"))
public class EtapaController {

    private EtapaRepository etapaRepository;

    @GetMapping("/consultar/todos")
    public List<Etapa> cosultarTodos(){
        return etapaRepository.findAll();
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<Etapa> consultar(@PathVariable Long id){
        Optional<Etapa> etapa = etapaRepository.findById(id);
        if(etapa.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(etapa.get());
    }

    @GetMapping("/consultar/status/{status}")
    public ResponseEntity<List<Etapa>> consultarStatus(@PathVariable Integer status){
        List<Etapa> etapas = etapaRepository.findAll();
        return ResponseEntity.ok(etapas);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarEtapa(@PathVariable Long id, @RequestBody Etapa etapaParam){
        Optional<Etapa> etapa = etapaRepository.findById(id);

        if(etapa.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A etapa especificada não foi encontrada");
        }
        else{
            etapa.get().setNome(etapaParam.getNome());
            etapa.get().setDescricao(etapaParam.getDescricao());
            etapa.get().setStatus(etapaParam.getStatus());
            etapaRepository.save(etapa.get());
            return ResponseEntity.status(HttpStatus.OK).body("Etapa atualizada com sucesso!");
        }
    }


    @DeleteMapping("/deleter/{id}")
    public ResponseEntity<String> deleterEtapa(@PathVariable Long id){
        Optional<Etapa> etapa =etapaRepository.findById(id);
        if(etapa.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A etapa especificada não foi encontrada");
        }
        else{
            etapaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Etapa deletada!");
        }
    }




}
