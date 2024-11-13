package com.ghastconsultancy.ghastconsultancy.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ghastconsultancy.ghastconsultancy.enums.StatusEtapa;
import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="etapas")
public class Etapa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome",length = 20,nullable = false)
    private String nome;

    @Column(name="descricao",length = 100)
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    @Column(name= "status",nullable = false)
    private StatusEtapa statusEtapa = StatusEtapa.EM_ANDAMENTO;

    @JsonIgnore
    @JoinColumn(name= "projeto",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Projeto projeto;

    public Etapa(String nome, String descricao, Projeto projeto) {
        this.nome = nome;
        this.descricao = descricao;
        this.projeto = projeto;
    }

}
