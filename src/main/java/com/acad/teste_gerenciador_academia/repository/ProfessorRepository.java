package com.acad.teste_gerenciador_academia.repository;

import com.acad.teste_gerenciador_academia.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    boolean existsByCpf(String cpf);

}
