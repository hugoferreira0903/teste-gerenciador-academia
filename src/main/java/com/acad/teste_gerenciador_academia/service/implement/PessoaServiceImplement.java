package com.acad.teste_gerenciador_academia.service.implement;


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
    public Pessoa findByCpf(String cpf) {
        return pessoaRepository.findById(cpf).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado"));
    }

    @Override
    public Pessoa create(Pessoa pessoaToCreate) {
        return pessoaRepository.save(pessoaToCreate);
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public void deleteByCpf(String cpf) {
        if(!pessoaRepository.existsByCpf(cpf)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro: Pessoa não encontrada!");
        }
        pessoaRepository.deleteById(cpf);
    }
}
