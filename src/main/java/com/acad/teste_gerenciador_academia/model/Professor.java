package com.acad.teste_gerenciador_academia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tb_professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 200)
    private String nome;

    @NotBlank
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @NotNull
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @NotBlank(message = "especialidade não pode ser nula ou vazia")
    @Column(nullable = false, length = 100)
    private String especialidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @NotNull LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotBlank(message = "especialidade não pode ser nula ou vazia") String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(@NotBlank(message = "especialidade não pode ser nula ou vazia") String especialidade) {
        this.especialidade = especialidade;
    }
}
