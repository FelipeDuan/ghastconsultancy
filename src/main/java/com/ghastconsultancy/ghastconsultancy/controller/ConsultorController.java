package com.ghastconsultancy.ghastconsultancy.controller;


import com.ghastconsultancy.ghastconsultancy.model.Consultor;
import com.ghastconsultancy.ghastconsultancy.repository.ConsultorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultor")

@AllArgsConstructor
public class ConsultorController {

    private ConsultorRepository consultorRepository;

    @PostMapping("/cadastrar") // @ResquestBody  -> Anotação para converter o Json em um objeto to tipo Consultor
    public ResponseEntity<String> cadastrarConsultor(@RequestBody Consultor consultor) {

        if(consultorRepository.findByCpf(consultor.getCpf()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Consultor já cadastrado");
                // HttpStatus.CONFLICT ->, 409, ou seja, o recurso já existe
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Consultor cadastrado com sucesso");
        // HttpStatus.CREATED -> 201, ou seja, o recurso foi criado
    }

    @GetMapping("/consultar/todos")
    public ResponseEntity<List<Consultor>> consultarTodos() {
        return ResponseEntity.ok(consultorRepository.findAll());
        // ok = 200, ou seja, a requisição foi bem sucedida
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<Consultor> consultarPorId(@PathVariable Long id) {
        Optional<Consultor> consultor = consultorRepository.findById(id);
        if (consultor.isPresent()) {
            return ResponseEntity.ok(consultor.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        // Erro 404 o usuário nao foi encontrado


    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarConsultor(@PathVariable Long id) {
        if(consultorRepository.findById(id).isPresent()) {
            consultorRepository.deleteById(id);
            return ResponseEntity.ok("Consultor deletado com sucesso"); // OK -> Recurso encontrado e deletado
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consultor não encontrado");
        // HttpStatus.NOT_FOUND -> 404, ou seja, o recurso não foi encontrado
    }

    



}
