package com.ghastconsultancy.ghastconsultancy.service;

import com.ghastconsultancy.ghastconsultancy.enums.SetorAtuacao;
import com.ghastconsultancy.ghastconsultancy.model.Empresa;
import com.ghastconsultancy.ghastconsultancy.repository.ClienteRepository;
import com.ghastconsultancy.ghastconsultancy.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository, ClienteRepository clienteRepository) {
        this.empresaRepository = empresaRepository;
        this.clienteRepository = clienteRepository;
    }

    public Empresa criarEmpresa(Empresa empresa) {
        validarRepresentanteLegal(empresa.getRepresentanteLegal().getId());

        return empresaRepository.save(empresa);
    }

    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    public List<Empresa> listarEmpresasPorSetor(SetorAtuacao setor) {
        return empresaRepository.findBySetorAtuacao(setor);
    }

    public Empresa buscarEmpresaPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
    }

    public Empresa atualizarEmpresa(Long id, Empresa empresaAtualizada) {
        if (!empresaRepository.existsById(id)) {
            throw new RuntimeException("Empresa não encontrada");
        }

        validarRepresentanteLegal(empresaAtualizada.getRepresentanteLegal().getId());

        empresaAtualizada.setId(id); // Garante que o ID permanece o mesmo para atualizar
        return empresaRepository.save(empresaAtualizada);
    }

    public void excluirEmpresa(Long id) {
        if (!empresaRepository.existsById(id)) {
            throw new RuntimeException("Empresa não encontrada");
        }
        empresaRepository.deleteById(id);
    }

    private void validarRepresentanteLegal(Long representanteId) {
        if (!clienteRepository.existsById(representanteId)) {
            throw new RuntimeException("Representante legal não encontrado");
        }
    }
}
