package com.banco.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateContaDTO {
    @NotNull
    private String nome;
    @NotNull @Email
    private String email;
    @NotNull @CPF
    private String cpf;
    @NotNull
    private Date dataNascimento;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
}
