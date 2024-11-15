package com.ghastconsultancy.ghastconsultancy.service;


import com.ghastconsultancy.ghastconsultancy.model.Projeto;
import com.ghastconsultancy.ghastconsultancy.model.Relatorio;
import com.ghastconsultancy.ghastconsultancy.repository.RelatorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    private final RelatorioRepository relatorioRepository;
    private final ProjetoService projetoService;

    public RelatorioService(RelatorioRepository relatorioRepository, ProjetoService projetoService) {
        this.relatorioRepository = relatorioRepository;
        this.projetoService = projetoService;
    }

    // POST -> ID
    public Relatorio saveRelatorio(Long projetoId,Relatorio relatorio) {
        Projeto projeto = projetoService.findProjetoById(projetoId);
        relatorio.setProjeto(projeto);
        relatorio.setDataInicio(projeto.getDataInicio());
        relatorio.setDataFim(projeto.getDataFim());
        projeto.addRelatorio(relatorio);
        return relatorioRepository.save(relatorio);
    }

    // GET -> ID
    public Relatorio findRelatorioById(Long id) {
        return relatorioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o relatório referente ao " +
                        "ID: " + id));
    }

    // GET -> ALL
    public List<Relatorio> findAllRelatorios() {
        return relatorioRepository.findAll();
    }


    // PUT -> ID
    public Relatorio updateRelatorio(Long id, Relatorio relatorioUpdate) {
        Relatorio relatorio = findRelatorioById(id);
        relatorio.setDescricao(relatorioUpdate.getDescricao());
        relatorio.setInsightVip(relatorioUpdate.getInsightVip());
        return relatorioRepository.save(relatorio);
    }


    // DELETE -> ID
    public void deleteRelatorio(Long id) {
        relatorioRepository.deleteById(id);
    }



}
