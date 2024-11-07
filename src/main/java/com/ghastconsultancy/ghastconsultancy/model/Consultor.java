package com.ghastconsultancy.ghastconsultancy.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "consultores")
public class Consultor {

    @EqualsAndHashCode.Include // gera um equal e hashcode apenas para o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome",length = 50, nullable = false)
    private String nome;

    @EqualsAndHashCode.Include // gera um equal e hashcode apenas para o cpf
    @Column(name = "cpf",length = 15, nullable = false, unique = true)
    private String cpf;

    @Column(name = "email",length = 30, nullable = false)
    private String email;

    @Column(name = "telefone",length = 15, nullable = false)
    private String telefone;





}

