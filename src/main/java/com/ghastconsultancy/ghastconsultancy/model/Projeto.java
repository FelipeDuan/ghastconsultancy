package com.ghastconsultancy.ghastconsultancy.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.ghastconsultancy.ghastconsultancy.enums.StatusProjeto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name ="projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "nome", length = 20, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    @Column(name= "dataInicio",length = 10, nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @Column(name= "dataFim",length = 10, nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 10, nullable = false)
    private StatusProjeto statusProjeto = StatusProjeto.EM_ESPERA;

    @Setter(AccessLevel.NONE)
    @Column (name = "etapas")
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true) //
    // garante que não haverá etapas sem projetos
    private List<Etapa> etapas = new ArrayList<>();


    public Projeto(String nome, String descricao, LocalDate dataInicio, LocalDate dataFim) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public void addEtapas(Etapa etapa) {
        if(etapas.size() < 3){
            etapas.add(etapa);
            this.statusProjeto = StatusProjeto.EM_CURSO;
        }
    }

    public void removerEtapas(Etapa etapa) {
        if (!etapas.isEmpty()) {
            etapas.remove(etapa);
            if (etapas.isEmpty()) {
                this.statusProjeto = StatusProjeto.EM_ESPERA;
            }
        }
    }

}