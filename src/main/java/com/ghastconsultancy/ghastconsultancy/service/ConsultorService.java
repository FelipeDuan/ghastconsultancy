package com.ghastconsultancy.ghastconsultancy.service;

import com.ghastconsultancy.ghastconsultancy.enums.Especializacao;
import com.ghastconsultancy.ghastconsultancy.enums.TamanhoNegocio;
import com.ghastconsultancy.ghastconsultancy.model.Consultor;
import com.ghastconsultancy.ghastconsultancy.repository.ConsultorRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsultorService {

    private final ConsultorRepository consultorRepository;


    public ConsultorService(ConsultorRepository consultorRepository) {
        this.consultorRepository = consultorRepository;
    }

    // POST
    public Consultor saveConsultor(Consultor consultor) {
        if(consultorRepository.findByCpf(consultor.getCpf()).isPresent()){
            throw new RuntimeException("Esse CPF já está cadastrado");
        }
        return consultorRepository.save(consultor);
    }

    // GET -> ALL
    public List<Consultor> findAllConsultor() {
        return consultorRepository.findAll();
    }

    // GET -> ID
    public Consultor findConsultorById(Long id) {
        return consultorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o consultor referente ao ID: " + id));
    }

    // GET -> ESPECIALIZAÇÃO
    public List<Consultor> findAllConsultorByEspecilizacao(Especializacao especializacao) {
        return consultorRepository.findByEspecializacao(especializacao);
    }

    // GET -> TAMANHO DO NEGOCIO
    public List<Consultor> findAllConsultoresByTamanhoNegocio(TamanhoNegocio tamanhoNegocio) {
        return  consultorRepository.findByTamanhoNegocio(tamanhoNegocio);
    }


    // PUT -> ID
    public Consultor updateConsultor(Long id,Consultor consultorUpdate) {
        Consultor consultor = findConsultorById(id);

        consultor.setCpf(consultorUpdate.getCpf());
        consultor.setNome(consultorUpdate.getNome());
        consultor.setEmail(consultorUpdate.getEmail());
        consultor.setTelefone(consultorUpdate.getTelefone());
        consultor.setEspecializacao(consultorUpdate.getEspecializacao());
        consultor.setTamanhoNegocio(consultorUpdate.getTamanhoNegocio());
        return consultorRepository.save(consultor);
    }

    // DELETE -> ID
    public void deleteConsultor(Long id) {
        Consultor consultor = findConsultorById(id);
        consultorRepository.delete(consultor);
    }













}
