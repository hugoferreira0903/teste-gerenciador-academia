package com.acad.teste_gerenciador_academia.repository;

import com.acad.teste_gerenciador_academia.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
