package com.acad.teste_gerenciador_academia.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PessoaDTO {

    @NotBlank(message = "o nome nao pode ser vazio")
    private String nome;
    @NotBlank(message = "o cpf nao pode ser vazio")
    @Size(min = 11, max = 11, message = "o cpf tem que ter exatamente 11 caracteres")
    private String cpf;
    @NotNull(message = "a data nao pode ser vazio")
    private LocalDate dataNascimento;

    public @NotBlank @Size(max = 11) String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank @Size(max = 11) String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotBlank LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }
}
