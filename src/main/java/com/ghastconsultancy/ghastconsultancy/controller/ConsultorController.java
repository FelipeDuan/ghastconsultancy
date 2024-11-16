package com.ghastconsultancy.ghastconsultancy.controller;

import com.ghastconsultancy.ghastconsultancy.enums.Especializacao;
import com.ghastconsultancy.ghastconsultancy.enums.TamanhoNegocio;
import com.ghastconsultancy.ghastconsultancy.model.Consultor;
import com.ghastconsultancy.ghastconsultancy.service.ConsultorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/consultores")
@CrossOrigin(origins = "http://localhost:3000")
public class ConsultorController {

    private final ConsultorService consultorService;

    public ConsultorController(ConsultorService consultorService) {
        this.consultorService = consultorService;
    }

    @PostMapping // @ResquestBody -> Anotação para converter o Json em um objeto to tipo Consultor
    public ResponseEntity<Consultor> cadastrarConsultor(@RequestBody Consultor consultor) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(consultorService.saveConsultor(consultor));
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(consultor);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Consultor>> consultarTodos() {
        List<Consultor> consultores = consultorService.findAllConsultor();
        return consultores.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(consultores);
    }

    @GetMapping("/especializacao/{especializacao}")
    public ResponseEntity<List<Consultor>> consultarPorEspecializacao(@PathVariable Especializacao especializacao) {
        List<Consultor> consultores = consultorService.findAllConsultorByEspecilizacao(especializacao);
        return consultores.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(consultores);
    }


    @GetMapping("/atendimento/{tamanhoNegocio}")
    public ResponseEntity<List<Consultor>> consultarPorTamanhoNegocio(@PathVariable TamanhoNegocio tamanhoNegocio) {
        List<Consultor> consultores = consultorService.findAllConsultoresByTamanhoNegocio(tamanhoNegocio);
        return consultores.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(consultores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultor> consultarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(consultorService.findConsultorById(id));
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultor> atualizarConsultor(@PathVariable Long id, @RequestBody Consultor consultorUpdate) {
        try {
            Consultor consultor = consultorService.updateConsultor(id, consultorUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(consultor);
        }
        catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Consultor> deletarConsultor(@PathVariable Long id) {
        consultorService.deleteConsultor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
