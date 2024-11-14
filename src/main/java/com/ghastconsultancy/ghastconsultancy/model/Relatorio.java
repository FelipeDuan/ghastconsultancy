package com.ghastconsultancy.ghastconsultancy.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


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

    @Column(name= "dataInicio",length = 10, nullable = false)
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="dataFim",length = 10, nullable = false)
    private LocalDate dataFim;

    @Column(name ="descicao", nullable = false)
    private String descricao;

    @OneToOne(mappedBy = "relatorio", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Projeto projeto;

    public Relatorio(Long id, LocalDate dataFim, LocalDate dataInicio, Projeto projeto) {
        this.id = id;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.projeto = projeto;
    }
}
