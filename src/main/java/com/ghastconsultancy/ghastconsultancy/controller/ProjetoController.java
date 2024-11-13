package com.ghastconsultancy.ghastconsultancy.controller;

import com.ghastconsultancy.ghastconsultancy.enums.StatusProjeto;
import com.ghastconsultancy.ghastconsultancy.model.Etapa;
import com.ghastconsultancy.ghastconsultancy.model.Projeto;
import com.ghastconsultancy.ghastconsultancy.repository.ProjetoRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoRepository projetoRepository;

    public ProjetoController(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    @PostMapping
    public ResponseEntity<Projeto> CriarProjeto(@RequestBody Projeto projeto){
        projetoRepository.save(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(projeto);
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> ListarProjetos(){
        return ResponseEntity.status(HttpStatus.OK).body(projetoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> ListarProjetoPorId(@PathVariable Long id){
        Optional<Projeto> projeto = projetoRepository.findById(id);
        return  projeto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{statusProjeto}")
    public ResponseEntity<List<Projeto>> ListarProjetoPorStatus(@PathVariable StatusProjeto statusProjeto){
        List<Projeto> projetos = projetoRepository.findByStatusProjeto(statusProjeto);
        return ResponseEntity.status(HttpStatus.OK).body(projetos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> AtualizarProjeto(@PathVariable Long id,@RequestBody Projeto projetoParam){
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent()){
            projeto.get().setNome(projetoParam.getNome());
            projeto.get().setDescricao(projetoParam.getDescricao());
            projetoRepository.save(projeto.get());
            return ResponseEntity.status(HttpStatus.OK).body(projeto.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}/etapas")
    public ResponseEntity<Projeto> AdicionarEtapa(@PathVariable Long id, @RequestBody Etapa etapa){

        Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent()){
            projeto.get().addEtapas(etapa);
            etapa.setProjeto(projeto.get());
            projetoRepository.save(projeto.get());
            return ResponseEntity.status(HttpStatus.OK).body(projeto.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}/etapas/{etapasId}")
    public ResponseEntity<Projeto> DeletarEtapa(@PathVariable Long id,@PathVariable Long etapasId){
        Optional<Projeto> projetoOptional = projetoRepository.findById(id);
        if(projetoOptional.isPresent()){

            Projeto projeto = projetoOptional.get();

            for (Etapa etapa : projeto.getEtapas()){
                if(etapa.getId().equals(etapasId)){
                    projeto.removerEtapas(etapa);
                    projetoRepository.save(projeto);
                    return ResponseEntity.status(HttpStatus.OK).body(projeto);
                }
            }
            // se não encontrar Nenhuma etapa com esse id
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        //se não encontrar nenhum Projeto com esse id
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Projeto> DeletarProjeto(@PathVariable Long id){
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent()){
            projetoRepository.delete(projeto.get());
            return ResponseEntity.status(HttpStatus.OK).body(projeto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}