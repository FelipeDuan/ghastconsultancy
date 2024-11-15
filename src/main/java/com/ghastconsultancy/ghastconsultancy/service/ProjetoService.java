package com.ghastconsultancy.ghastconsultancy.service;

import com.ghastconsultancy.ghastconsultancy.enums.StatusProjeto;
import com.ghastconsultancy.ghastconsultancy.model.Projeto;
import com.ghastconsultancy.ghastconsultancy.repository.ProjetoRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    // POST
    public Projeto saveProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    // GET -> ID
    public Projeto findProjetoById(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o projeto referente ao ID: " + id));
    }

    // GET -> ALL
    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    // GET -> ALL == StatusProjeto
    public List<Projeto> findProjetoByStatus(StatusProjeto status) {
        return projetoRepository.findByStatusProjeto(status);
    }

    // PUT -> ID
    public void updateProjeto(Long id,Projeto projetoUpdate) {
        Projeto projeto = findProjetoById(id);
        projeto.setNome(projetoUpdate.getNome());
        projeto.setDescricao(projetoUpdate.getDescricao());

        projetoRepository.save(projeto);
    }

    // REMOVE -> ID
    public void removeProjeto(Long id) {
        Projeto projeto = findProjetoById(id);
        projetoRepository.delete(projeto);
    }


    public List<Projeto> findProjetosPorMesEAno(int ano, int mes) {
        return projetoRepository.findByMesEAno(ano, mes);
    }

}
