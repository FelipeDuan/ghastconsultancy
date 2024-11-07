package com.ghastconsultancy.ghastconsultancy.controller;


import com.ghastconsultancy.ghastconsultancy.model.Consultor;
import com.ghastconsultancy.ghastconsultancy.repository.ConsultorRepository;
import com.ghastconsultancy.ghastconsultancy.service.ConsultorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultor")

@AllArgsConstructor
public class ConsultorController {

    private ConsultorService consultorService;

    @PostMapping("/cadastrar") // @ResquestBody  -> Anotação para converter o Json em um objeto to tipo Consultor
    public ResponseEntity<String> cadastrarConsultor(@RequestBody Consultor consultor) {
        if(consultorService.findByCpf(consultor.getCpf()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Consultor já cadastrado");
            // HttpStatus.CONFLICT ->, 409 ou seja, o recurso já existe
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Consultor cadastrado com sucesso");
        // HttpStatus.CREATED -> 201, ou seja, o recurso foi criado
    }

    @GetMapping("/consultar/todos")
    public ResponseEntity<List<Consultor>> consultarTodos() {
        return ResponseEntity.ok(consultorService.findAll());
        // ok = 200, ou seja, a requisição foi bem sucedida
    }



}
