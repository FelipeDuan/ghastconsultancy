package com.ghastconsultancy.ghastconsultancy.model;

import jakarta.persistence.*;

@Entity
@Table(name ="projeto")
public class Projeto {

//    id : Long
//    nome : String
//    descricao : String
//    etapas : Relacionamento One-to-Many com  Etapa
//    Métodos de acesso e modificação.
//    Método para verificar o progresso das etapas

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

}
