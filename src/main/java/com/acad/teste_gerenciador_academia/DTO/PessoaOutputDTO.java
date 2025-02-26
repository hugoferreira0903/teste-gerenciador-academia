package com.acad.teste_gerenciador_academia.DTO;

import com.acad.teste_gerenciador_academia.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PessoaOutputDTO(

        Long id,

        @NotBlank(message = "o nome nao pode ser vazio")
        String nome,

        @NotBlank(message = "o cpf nao pode ser vazio")
        @Size(min = 11, max = 11, message = "o cpf tem que ter exatamente 11 caracteres")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números.")
        String cpf,

        @NotNull(message = "a data nao pode ser vazio")
        LocalDate dataNascimento) {

    public static PessoaOutputDTO fromEntity(Pessoa pessoa) {
        return new PessoaOutputDTO(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getDataNascimento());
    }


}