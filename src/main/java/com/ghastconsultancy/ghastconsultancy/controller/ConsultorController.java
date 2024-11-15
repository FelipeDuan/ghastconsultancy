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
@RequestMapping("/consultores")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class ConsultorController {

    private ConsultorRepository consultorRepository;

    @PostMapping("/cadastrar") // @ResquestBody -> Anotação para converter o Json em um objeto to tipo Consultor
    public ResponseEntity<String> cadastrarConsultor(@RequestBody Consultor consultor) {

        if(consultorRepository.findByCpf(consultor.getCpf()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Consultor já cadastrado");
                // HttpStatus.CONFLICT ->, 409, ou seja, o recurso já existe
        }
        consultorRepository.save(consultor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Consultor cadastrado com sucesso");
        // HttpStatus.CREATED -> 201, ou seja, o recurso foi criado
    }

    @GetMapping("/consultar/todos")
    public ResponseEntity<List<Consultor>> consultarTodos() {
        return ResponseEntity.ok(consultorRepository.findAll());
        // ok = 200, ou seja, a requisição foi bem sucedida
    }

    @GetMapping("/consultar/especializacao/{especializacao}")
    public ResponseEntity<List<Consultor>> consultarPorEspecializacao(@PathVariable Integer especializacao) {
        return ResponseEntity.ok(consultorRepository.findByEspecializacao(especializacao));
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<Consultor> consultarPorId(@PathVariable Long id) {
        Optional<Consultor> consultor = consultorRepository.findById(id);
        // Erro 404 o usuário nao foi encontrado
        // ok -> 200 deu tudo certo
        return consultor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> atualizarConsultor(@PathVariable Long id, @RequestBody Consultor consultorParam) {

        Optional<Consultor> consultor = consultorRepository.findById(id);
        //Optional é uma classe genérica que permite manipular objetos vazios

        if (consultor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        else{
            consultor.get().setNome(consultorParam.getNome());
            consultor.get().setEmail(consultorParam.getEmail());
            consultor.get().setTelefone(consultorParam.getTelefone());
            consultor.get().setEspecializacao(consultorParam.getEspecializacao());
            consultor.get().setTipoAtendimento(consultorParam.getTipoAtendimento());
            consultorRepository.save(consultor.get());
            return ResponseEntity.ok("Consultor atualizado com sucesso");
        }
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarConsultor(@PathVariable Long id) {
        Optional<Consultor> consultor = consultorRepository.findById(id);


        if(consultor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consultor não encontrado");
            // HttpStatus.NOT_FOUND -> 404, ou seja, o recurso não foi encontrado
        }
        else{
            consultorRepository.deleteById(id);
            return ResponseEntity.ok("Consultor deletado com sucesso"); // OK -> Recurso encontrado e deletado
        }

    }

    



}
