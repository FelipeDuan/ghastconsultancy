package com.ghastconsultancy.ghastconsultancy.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name ="descicao", nullable = false)
    private String descricao;

    @Column(name= "insight", length = 100)
    private String insightVip;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name= "dataInicio",length = 10, nullable = false)
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="dataFim",length = 10, nullable = false)
    private LocalDate dataFim;

    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="projeto",nullable = false)
    private Projeto projeto;

    public Relatorio(Projeto projeto) {
        this.projeto = projeto;
        setDataInicio(projeto.getDataInicio());
        setDataFim(projeto.getDataFim());
    }


}
