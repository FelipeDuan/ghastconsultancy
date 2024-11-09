package com.ghastconsultancy.ghastconsultancy.model;

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

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Column(name = "tipo_de_atendimento")
    private Integer tipoAtendimento;

    public Consultor(String nome, String cpf, String email, String telefone, TipoDeAtendimento tipoAtendimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        setTipoAtendimento(tipoAtendimento);
    }

    public TipoDeAtendimento getTipoAtendimento() {
        return TipoDeAtendimento.valueOf(tipoAtendimento);
    }

    public void setTipoAtendimento(TipoDeAtendimento tipoAtendimento) {
        if(tipoAtendimento != null){
            this.tipoAtendimento = tipoAtendimento.getCode();
        }
    }
}

