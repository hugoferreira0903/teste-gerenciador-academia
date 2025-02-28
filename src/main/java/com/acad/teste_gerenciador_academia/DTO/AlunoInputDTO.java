package com.acad.teste_gerenciador_academia.DTO;

import com.acad.teste_gerenciador_academia.model.Aluno;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoInputDTO(

        @NotBlank
        String nome,

        @NotBlank
        @Size(min = 11, max = 11, message = "O CPF tem que ter exatamente 11 caracteres")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números.")
        String cpf,

        @NotNull
        LocalDate dataNascimento,

        @NotBlank(message = "plano nao pode ser nulo ou branco")
        String plano,

        @NotNull(message = "status_pagamento nao pode ser nulo")
        Boolean statusPagamento,

        @NotBlank(message = "modalidade nao pode ser nulo ou branco")
        String modalidade,

        @NotNull(message = "data_inicio nao pode ser nulo")
        LocalDate dataInicio



) {

    public Aluno toEntity(){
        Aluno aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.setCpf(this.cpf);
        aluno.setDataNascimento(this.dataNascimento);
        aluno.setPlano(this.plano);
        aluno.setStatusPagamento(this.statusPagamento != null ? this.statusPagamento : false);
        aluno.setModalidade(this.modalidade);
        aluno.setDataInicio(this.dataInicio);
        return aluno;
    }

}
