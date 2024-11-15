package com.ghastconsultancy.ghastconsultancy.model;

import com.ghastconsultancy.ghastconsultancy.enums.Especializacao;
import com.ghastconsultancy.ghastconsultancy.enums.TipoDeAtendimento;
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

    @Getter(AccessLevel.NONE) // proibe que o @Getter crie um get para esse atributo
    @Setter(AccessLevel.NONE) // proibe que o @Setter crie um set para esse atributo
    @Column(name = "tipo_de_atendimento",length = 10, nullable = false)
    private Integer tipoAtendimento;

    @Getter(AccessLevel.NONE) // proibe que o @Getter crie um get para esse atributo
    @Setter(AccessLevel.NONE) // proibe que o @Setter crie um set para esse atributo
    @Column(name = "especializacao",length = 10, nullable = false)
    private Integer especializacao;

    public Consultor(String nome, String cpf, String email, String telefone, TipoDeAtendimento tipoAtendimento,
                     Especializacao especializacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        setTipoAtendimento(tipoAtendimento);
        setEspecializacao(especializacao);
    }

    public TipoDeAtendimento getTipoAtendimento() {
        return TipoDeAtendimento.valueOf(tipoAtendimento);
    }

    public void setTipoAtendimento(TipoDeAtendimento tipoAtendimento) {
        if(tipoAtendimento != null){
            this.tipoAtendimento = tipoAtendimento.getCode();
        }
    }

    public Especializacao getEspecializacao() {
        return Especializacao.valueOf(especializacao);
    }

    public void setEspecializacao(Especializacao especializacao) {
        if(especializacao != null){
            this.especializacao = especializacao.getCode();
        }
    }
}

