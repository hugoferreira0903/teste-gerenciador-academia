package com.acad.teste_gerenciador_academia.service;

import com.acad.teste_gerenciador_academia.model.Aluno;

import java.util.List;

public interface AlunoService {

    Aluno findById(Long id);

    Aluno create(Aluno alunoToCreate);

    List<Aluno> findAll();

    void deleteById(Long id);
}
