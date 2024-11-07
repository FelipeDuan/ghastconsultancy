package com.ghastconsultancy.ghastconsultancy.service;


import com.ghastconsultancy.ghastconsultancy.model.Consultor;
import com.ghastconsultancy.ghastconsultancy.repository.ConsultorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultorService {

    private ConsultorRepository consultorRepository;

    public Optional<Consultor> findByCpf(String cpf) {
        return consultorRepository.findByCpf(cpf);
    }

    public List<Consultor> findAll() {
        return consultorRepository.findAll();
    }


}
