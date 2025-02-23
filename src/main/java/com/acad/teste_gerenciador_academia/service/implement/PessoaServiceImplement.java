package com.acad.teste_gerenciador_academia.service.implement;

import com.acad.teste_gerenciador_academia.model.Pessoa;
import com.acad.teste_gerenciador_academia.repository.PessoaRepository;
import com.acad.teste_gerenciador_academia.service.PessoaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Pessoa create(Pessoa pessoaToCreate) {
        if (pessoaRepository.existsByCpf(pessoaToCreate.getCpf())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O CPF já está registrado");
        }
        return pessoaRepository.save(pessoaToCreate);
    }


}
