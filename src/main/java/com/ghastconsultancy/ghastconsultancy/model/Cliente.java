package com.ghastconsultancy.ghastconsultancy.model;

import com.ghastconsultancy.ghastconsultancy.enums.TipoCliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 30, nullable = false, unique = true)
    private String cpf;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente", nullable = false)
    private TipoCliente tipoCliente = TipoCliente.PADRAO;

    public Cliente(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.tipoCliente = TipoCliente.PADRAO; // Define o tipo padrão ao criar o cliente
    }

    // Method para atualizar o cliente
    public Cliente atualizar(Cliente cliente){
        this.nome  = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        return this;
    }

    // Method para atualizar o tipo de cliente para VIP
    public void promoverParaVip() {
        this.tipoCliente = TipoCliente.VIP;
    }
}
