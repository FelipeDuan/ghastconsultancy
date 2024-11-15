package com.ghastconsultancy.ghastconsultancy.service;

import com.ghastconsultancy.ghastconsultancy.model.Etapa;
import com.ghastconsultancy.ghastconsultancy.model.Projeto;
import com.ghastconsultancy.ghastconsultancy.repository.EtapaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtapaService {

    private final EtapaRepository etapaRepository;
    private final ProjetoService projetoService;

    public EtapaService(EtapaRepository etapaRepository, ProjetoService projetoService) {
        this.etapaRepository = etapaRepository;
        this.projetoService = projetoService;
    }

    // POST -> ETAPA || ProjetoId
    public Etapa SaveEtapa(Long projetoId,Etapa etapa) {
        Projeto projeto = projetoService.findProjetoById(projetoId);
        etapa.setProjeto(projeto);
        projeto.addEtapas(etapa);
        return etapaRepository.save(etapa);
    }

    public List<Etapa> findAllEtapas() {
        return etapaRepository.findAll();
    }

    // GET -> ID
    public Etapa findEtapaById(Long id) {
        return etapaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar a etapa referente ao ID: " + id));
    }

    // PUT -> ID
    public Etapa updateEtapa(Long id, Etapa etapaUpdate) {
        Etapa etapa = findEtapaById(id);
        etapa.setNome(etapaUpdate.getNome());
        etapa.setDescricao(etapaUpdate.getDescricao());
        etapa.setStatusEtapa(etapaUpdate.getStatusEtapa());
       etapaRepository.save(etapa);
       return etapa;
    }


    // DELEETE  -> ID
    public void deleteEtapa(Long id) {
        etapaRepository.deleteById(id);
    }

}
