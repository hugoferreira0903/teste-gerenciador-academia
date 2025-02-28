package com.acad.teste_gerenciador_academia.DTO;

import com.acad.teste_gerenciador_academia.model.Aluno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoOutputDTO(

        Long id,

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

    public static AlunoOutputDTO fromEntity(Aluno aluno) {
        return new AlunoOutputDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getDataNascimento(),
                aluno.getPlano(),
                aluno.getStatusPagamento(),
                aluno.getModalidade(),
                aluno.getDataInicio()
        );
    }


}
