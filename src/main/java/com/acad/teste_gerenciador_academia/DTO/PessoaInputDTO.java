package com.acad.teste_gerenciador_academia.DTO;

import com.acad.teste_gerenciador_academia.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PessoaInputDTO(
        @NotBlank()
        String nome,

        @NotBlank(message = "O CPF não pode ser vazio")
        @Size(min = 11, max = 11, message = "O CPF tem que ter exatamente 11 caracteres")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números.")
        String cpf,

        @NotNull(message = "A data de nascimento não pode ser vazia")
        LocalDate dataNascimento
) {

    public Pessoa toEntity() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.nome);
        pessoa.setCpf(this.cpf());
        pessoa.setDataNascimento(this.dataNascimento());
        return pessoa;
    }


}
