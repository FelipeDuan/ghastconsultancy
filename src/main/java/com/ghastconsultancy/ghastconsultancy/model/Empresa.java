package com.ghastconsultancy.ghastconsultancy.model;

import com.ghastconsultancy.ghastconsultancy.enums.SetorAtuacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "cnpj", length = 30, nullable = false, unique = true)
    private String cnpj;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "setor_atuacao", length = 15)
    private SetorAtuacao setorAtuacao;

    @ManyToOne
    @JoinColumn(name = "representante_legal_id", nullable = false)
    private Cliente representanteLegal;

    @Column(name = "telefone", length = 15)
    private String telefone;

    // Construtor
    public Empresa(String nome, String cnpj, String email, String telefone , SetorAtuacao setorAtuacao, Cliente representanteLegal) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.setorAtuacao = setorAtuacao;
        this.representanteLegal = representanteLegal;
    }

}
