package com.acad.teste_gerenciador_academia.DTO;

import com.acad.teste_gerenciador_academia.model.Professor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record ProfessorInputDTO(

        @NotBlank
        String nome,

        @NotBlank
        @Size(min = 11, max = 11, message = "O CPF tem que ter exatamente 11 caracteres")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números.")
        String cpf,

        @NotNull
        LocalDate dataNascimento,

        @NotBlank(message = "Especialidade não pode ser nula ou vazia")
        String especialidade

) {

    public Professor toEntity(){
        Professor professor = new Professor();
        professor.setNome(this.nome);
        professor.setCpf(this.cpf);
        professor.setDataNascimento(this.dataNascimento);
        professor.setEspecialidade(this.especialidade);
        return professor;
    }
}
