package com.acad.teste_gerenciador_academia.service.implement;

import com.acad.teste_gerenciador_academia.controller.exception.AlunoException;
import com.acad.teste_gerenciador_academia.model.Aluno;
import com.acad.teste_gerenciador_academia.repository.AlunoRepository;
import com.acad.teste_gerenciador_academia.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoServiceImplement implements AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoServiceImplement(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    @Override
    public Aluno findById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado"));
    }

    @Override
    public Aluno create(Aluno alunoToCreate) {

        if (alunoRepository.existsByCpf(alunoToCreate.getCpf())) {
            throw new AlunoException("O CPF já está registrado");
        }

        return alunoRepository.save(alunoToCreate);
    }

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if(!alunoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro: Pessoa não encontrada!");
        }
        alunoRepository.deleteById(id);
    }
}
