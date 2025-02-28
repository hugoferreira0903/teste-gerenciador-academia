package com.acad.teste_gerenciador_academia.controller;


import com.acad.teste_gerenciador_academia.DTO.AlunoInputDTO;
import com.acad.teste_gerenciador_academia.DTO.AlunoOutputDTO;
import com.acad.teste_gerenciador_academia.DTO.ProfessorInputDTO;
import com.acad.teste_gerenciador_academia.DTO.ProfessorOutputDTO;
import com.acad.teste_gerenciador_academia.model.Aluno;
import com.acad.teste_gerenciador_academia.model.Professor;
import com.acad.teste_gerenciador_academia.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;


    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<ProfessorOutputDTO> findById(@PathVariable(value = "id") Long id){
        var professor = professorService.findById(id);
        return ResponseEntity.ok(ProfessorOutputDTO.fromEntity(professor));
    }


    @GetMapping
    public ResponseEntity<List<ProfessorOutputDTO>> findAll(){
        var professors = professorService.findAll();
        var professorsDTO = professors.stream().map(ProfessorOutputDTO::fromEntity).toList();
        return ResponseEntity.ok(professorsDTO);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        professorService.deleteById(id);
        return ResponseEntity.ok("professor deletado com sucesso!");
    }

    @PostMapping
    public ResponseEntity<ProfessorOutputDTO> create(@RequestBody @Valid ProfessorInputDTO professorInputDTO){

        Professor professorToCreate = professorInputDTO.toEntity();

        Professor professorCreated = professorService.create(professorToCreate);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(professorCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(ProfessorOutputDTO.fromEntity(professorCreated));

    }


}
