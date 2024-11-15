package com.ghastconsultancy.ghastconsultancy.model;

import com.ghastconsultancy.ghastconsultancy.enums.Especializacao;
import com.ghastconsultancy.ghastconsultancy.enums.TamanhoNegocio;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "consultores")
public class Consultor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "nome",length = 50, nullable = false)
    private String nome;

    @Column(name = "cpf",length = 15, nullable = false, unique = true)
    private String cpf;

    @Column(name = "email",length = 30, nullable = false)
    private String email;

    @Column(name = "telefone",length = 15, nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "tamanho_do_negocio",length = 10, nullable = false)
    private TamanhoNegocio tamanhoNegocio;

    @Enumerated(EnumType.STRING)
    @Column(name = "especializacao",length = 10, nullable = false)
    private Especializacao especializacao;

    public Consultor(Especializacao especializacao, TamanhoNegocio tamanhoNegocio, String telefone, String cpf, String email, String nome) {
        this.especializacao = especializacao;
        this.tamanhoNegocio = tamanhoNegocio;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
    }
}

