package com.acad.teste_gerenciador_academia.service.implement;

import com.acad.teste_gerenciador_academia.controller.exception.AlunoException;
import com.acad.teste_gerenciador_academia.controller.exception.ProfessorException;
import com.acad.teste_gerenciador_academia.model.Professor;
import com.acad.teste_gerenciador_academia.repository.PessoaRepository;
import com.acad.teste_gerenciador_academia.repository.ProfessorRepository;
import com.acad.teste_gerenciador_academia.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ProfessorServiceImplement implements ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorServiceImplement(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


    @Override
    public Professor findById(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado"));
    }

    @Override
    public Professor create(Professor professorToCreate) {

        if (professorRepository.existsByCpf(professorToCreate.getCpf())) {
            throw new ProfessorException("O CPF já está registrado");
        }

        return professorRepository.save(professorToCreate);
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if(!professorRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro: Pessoa não encontrada!");
        }
        professorRepository.deleteById(id);
    }
}
