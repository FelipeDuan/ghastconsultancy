package com.ghastconsultancy.ghastconsultancy.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name= "relatorios")
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="descicao", nullable = false)
    private String descricao;

    @Column(name= "insight", length = 100)
    private String insight;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name= "dataInicio",length = 10, nullable = false)
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="dataFim",length = 10, nullable = false)
    private LocalDate dataFim;

    @OneToOne
    @JoinColumn(name="projeto",nullable = false)
    private Projeto projeto;

    public Relatorio(LocalDate dataFim, LocalDate dataInicio, Projeto projeto) {
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.projeto = projeto;
    }
}
