package com.acad.teste_gerenciador_academia.service;

import com.acad.teste_gerenciador_academia.model.Aluno;
import com.acad.teste_gerenciador_academia.model.Professor;

import java.util.List;

public interface ProfessorService {

    Professor findById(Long id);

    Professor create(Professor professorToCreate);

    List<Professor> findAll();

    void deleteById(Long id);

}
