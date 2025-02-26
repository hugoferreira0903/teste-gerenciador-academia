package com.acad.teste_gerenciador_academia.service.implement;

import com.acad.teste_gerenciador_academia.controller.exception.PessoaException;
import com.acad.teste_gerenciador_academia.model.Pessoa;
import com.acad.teste_gerenciador_academia.repository.PessoaRepository;
import com.acad.teste_gerenciador_academia.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PessoaServiceImplement implements PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaServiceImplement(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado"));
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro: Pessoa não encontrada!");
        }
        pessoaRepository.deleteById(id);
    }

    @Override
    public Pessoa create(Pessoa pessoaToCreate) {

        if (pessoaToCreate.getCpf() == null || pessoaToCreate.getCpf().trim().isEmpty()) {
            throw new PessoaException("O CPF não pode ser nulo ou vazio");
        }

        if (pessoaToCreate.getCpf().length() != 11) {
            throw new PessoaException("O CPF deve conter exatamente 11 dígitos");
        }

        if (pessoaRepository.existsByCpf(pessoaToCreate.getCpf())) {
            throw new PessoaException("O CPF já está registrado");
        }

        return pessoaRepository.save(pessoaToCreate);
    }



}
