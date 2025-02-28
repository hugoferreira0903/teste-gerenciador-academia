package com.acad.teste_gerenciador_academia.DTO;

import com.acad.teste_gerenciador_academia.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PessoaInputDTO(


        @NotBlank(message = "O CPF não pode ser vazio")
        @Size(min = 11, max = 11, message = "O CPF tem que ter exatamente 11 caracteres")
        String cpf,

        @NotBlank()
        String nome,

        @NotNull(message = "A data de nascimento não pode ser vazia")
        LocalDate dataNascimento

) {

    public Pessoa toEntity() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(this.cpf());
        pessoa.setNome(this.nome);
        pessoa.setDataNascimento(this.dataNascimento());
        return pessoa;
    }

}
