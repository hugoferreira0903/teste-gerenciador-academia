package com.acad.teste_gerenciador_academia.service;


import com.acad.teste_gerenciador_academia.model.Pessoa;


import java.util.List;

public interface PessoaService {

    Pessoa findByCpf(String cpf);

    Pessoa create(Pessoa pessoaToCreate);

    List<Pessoa> findAll();

    void deleteByCpf(String cpf);

}
