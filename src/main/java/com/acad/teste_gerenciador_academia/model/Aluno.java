package com.acad.teste_gerenciador_academia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
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
    @NotBlank(message = "plano nao pode ser nulo ou branco")
    private String plano;
    @NotNull(message = "status_pagamento nao pode ser nulo")
    @Column(name = "status_pagamento")
    private Boolean statusPagamento;
    @NotBlank(message = "modalidade nao pode ser nulo ou branco")
    private String modalidade;
    @NotNull(message = "data_inicio nao pode ser nulo")
    @Column(name = "data_inicio")
    private LocalDate dataInicio;


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

    public @NotBlank(message = "plano nao pode ser nulo ou branco") String getPlano() {
        return plano;
    }

    public void setPlano(@NotBlank(message = "plano nao pode ser nulo ou branco") String plano) {
        this.plano = plano;
    }

    public @NotNull(message = "status_pagamento nao pode ser nulo") Boolean getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(@NotNull(message = "status_pagamento nao pode ser nulo") Boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public @NotBlank(message = "modalidade nao pode ser nulo ou branco") String getModalidade() {
        return modalidade;
    }

    public void setModalidade(@NotBlank(message = "modalidade nao pode ser nulo ou branco") String modalidade) {
        this.modalidade = modalidade;
    }

    public @NotNull(message = "data_inicio nao pode ser nulo") LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(@NotNull(message = "data_inicio nao pode ser nulo") LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
}
