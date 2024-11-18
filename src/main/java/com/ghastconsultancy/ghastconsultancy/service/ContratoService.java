package com.ghastconsultancy.ghastconsultancy.service;

import com.ghastconsultancy.ghastconsultancy.model.Contrato;
import com.ghastconsultancy.ghastconsultancy.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoService {

    private ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    // Cadastrar um novo contrato
    public Contrato cadastrarContrato(Contrato contrato) {
        if (contrato.getDataInicio().isAfter(contrato.getDataFim())) {
            throw new IllegalArgumentException("Data de início deve ser antes da data de fim.");
        }
        return contratoRepository.save(contrato);
    }

    // Buscar todos os contratos
    public List<Contrato> buscarContratos() {
        return contratoRepository.findAll();
    }

    // Buscar contrato por id
    public Contrato buscarContratoPorId(Long id) {
        return contratoRepository.findById(id).orElse(null);
    }

    // Buscar por cliente, consultor ou empresa
    public List<Contrato> buscarPorClienteId(Long clienteId) {
        return contratoRepository.findByClienteId(clienteId);
    }

    public List<Contrato> buscarPorEmpresaId(Long empresaId) {
        return contratoRepository.findByEmpresaId(empresaId);
    }

    public List<Contrato> buscarPorConsultorId(Long consultorId) {
        return contratoRepository.findByConsultorId(consultorId);
    }

    // Deletar contrato por id
    public void deletarContrato(Long id) {
        contratoRepository.deleteById(id);
    }
}
