package com.ghastconsultancy.ghastconsultancy.controller;

import com.ghastconsultancy.ghastconsultancy.enums.StatusProjeto;
import com.ghastconsultancy.ghastconsultancy.model.Projeto;
import com.ghastconsultancy.ghastconsultancy.service.ProjetoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/projetos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }


    // POST
    @PostMapping
    public ResponseEntity<Projeto> CriarProjeto(@RequestBody Projeto projetoRequest){
        Projeto projeto = projetoService.saveProjeto(projetoRequest);
        return ResponseEntity.status(HttpStatus.OK).body(projeto);
    }

    // GET -> ALL
    @GetMapping
    public ResponseEntity<List<Projeto>> ListarProjetos(){
        List<Projeto> projetos = projetoService.findAll();

        return projetos.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(projetos);
    }
    // GET -> ID
    @GetMapping("/{id}")
    public ResponseEntity<Projeto> ListarProjetoPorId(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(projetoService.findProjetoById(id));
        }
        catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    // GET -> StatusProjeto
    @GetMapping("/filtrar/{statusProjeto}")
    public ResponseEntity<List<Projeto>> ListarProjetoPorStatus(@PathVariable StatusProjeto statusProjeto){
        List<Projeto> projetos = projetoService.findProjetoByStatus(statusProjeto);
        return projetos.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(projetos);
    }

    // GET -> MES ANO DA DATA DE INICIO
    @GetMapping("/filtrar/{ano}/{mes}")
    public ResponseEntity<List<Projeto>> buscarProjetosPorMesEAno(@PathVariable int ano, @PathVariable int mes) {
        List<Projeto> projetos = projetoService.findProjetosPorMesEAno(ano, mes);
        return projetos.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(projetos);
    }

    // PUT -> ID
    @PutMapping("/{id}")
    public ResponseEntity<Projeto> AtualizarProjeto(@PathVariable Long id,@RequestBody Projeto projetoUpdate){
        try {
            projetoService.updateProjeto(id, projetoUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(projetoService.findProjetoById(id));
        }
        catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    // DELETE -> ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Projeto> DeletarProjeto(@PathVariable Long id){
        try{
            projetoService.removeProjeto(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }


    }
}