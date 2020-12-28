package com.banco.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
public class Conta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true) @Email
    private String email;

    @Column(nullable = false, length = 11, unique = true) @CPF// Deve se usar String ou Integer
    private String cpf;

    @Temporal(TemporalType.DATE) @Column(nullable = false)
    private Date dataNascimento;

    public Conta() {
    }

    public Conta(String nome, String email, String CPF, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = CPF;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCPF() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
