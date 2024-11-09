package com.ghastconsultancy.ghastconsultancy.model;

import com.ghastconsultancy.ghastconsultancy.enums.TipoDeServico;
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
    @Column(name = "id")
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
    @Column(name = "tipo_de_serviço",length = 10, nullable = false)
    private Integer tipoServico;

    public Consultor(String nome, String cpf, String email, String telefone, TipoDeAtendimento tipoAtendimento,
                     TipoDeServico tipoServico) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        setTipoAtendimento(tipoAtendimento);
        setTipoServico(tipoServico);
    }

    public TipoDeAtendimento getTipoAtendimento() {
        return TipoDeAtendimento.valueOf(tipoAtendimento);
    }

    public void setTipoAtendimento(TipoDeAtendimento tipoAtendimento) {
        if(tipoAtendimento != null){
            this.tipoAtendimento = tipoAtendimento.getCode();
        }
    }

    public TipoDeServico getTipoServico() {
        return TipoDeServico.valueOf(tipoServico);
    }

    public void setTipoServico(TipoDeServico tipoServico) {
        if(tipoServico != null){
            this.tipoServico = tipoServico.getCode();
        }
    }
}

