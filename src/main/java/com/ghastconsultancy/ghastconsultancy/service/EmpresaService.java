package com.ghastconsultancy.ghastconsultancy.service;

import com.ghastconsultancy.ghastconsultancy.enums.SetorAtuacao;
import com.ghastconsultancy.ghastconsultancy.model.Cliente;
import com.ghastconsultancy.ghastconsultancy.model.Empresa;
import com.ghastconsultancy.ghastconsultancy.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final ClienteService clienteService;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository, ClienteService clienteService) {
        this.empresaRepository = empresaRepository;
        this.clienteService = clienteService;

    }

    public Empresa criarEmpresa(Empresa empresa) {
        Cliente cliente = clienteService.obterPorId(empresa.getRepresentanteLegal().getId());
        empresa.setRepresentanteLegal(cliente);
        clienteService.addEmpresa(cliente.getId(), empresa);
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

        clienteService.obterPorId(empresaAtualizada.getRepresentanteLegal().getId());

        empresaAtualizada.setId(id); // Garante que o ID permanece o mesmo para atualizar
        return empresaRepository.save(empresaAtualizada);
    }

    public void excluirEmpresa(Long id) {
        if (!empresaRepository.existsById(id)) {
            throw new RuntimeException("Empresa não encontrada");
        }
        empresaRepository.deleteById(id);
    }

}
