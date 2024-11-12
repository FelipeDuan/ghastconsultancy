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

    @Column(name = "telefone", length = 15)
    private SetorAtuacao setorAtuacao;


}
