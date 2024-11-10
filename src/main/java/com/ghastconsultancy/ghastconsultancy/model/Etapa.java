package com.ghastconsultancy.ghastconsultancy.model;


import com.ghastconsultancy.ghastconsultancy.enums.Status;
import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@Table(name="etapa")
@NoArgsConstructor
public class Etapa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome",length = 20,nullable = false)
    private String nome;

    @Column(name="descricao",length = 100)
    private String descricao;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @Column(name= "status",length = 20,nullable = false)
    private Integer status;

    public Etapa(String nome,String descricao,Status status) {
        this.nome = nome;
        this.descricao = descricao;
        setStatus(status);
    }

    public Status getStatus(){
        return Status.valueOf(status);
    }

    public void setStatus(Status status){
        if(status != null){
            this.status = status.getCode();
        }
    }
}
