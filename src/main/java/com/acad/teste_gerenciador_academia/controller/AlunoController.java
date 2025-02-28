package com.acad.teste_gerenciador_academia.controller;


import com.acad.teste_gerenciador_academia.DTO.AlunoInputDTO;
import com.acad.teste_gerenciador_academia.DTO.AlunoOutputDTO;
import com.acad.teste_gerenciador_academia.DTO.PessoaOutputDTO;
import com.acad.teste_gerenciador_academia.model.Aluno;
import com.acad.teste_gerenciador_academia.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<AlunoOutputDTO>> findAll(){
        var alunos = alunoService.findAll();
        var alunosDTO = alunos.stream().map(AlunoOutputDTO::fromEntity).toList();
        return ResponseEntity.ok(alunosDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoOutputDTO> findById(@PathVariable(value = "id") Long id){
        var aluno = alunoService.findById(id);
        return ResponseEntity.ok(AlunoOutputDTO.fromEntity(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        alunoService.deleteById(id);
        return ResponseEntity.ok("aluno deletado com sucesso!");
    }


    @PostMapping
    public ResponseEntity<AlunoOutputDTO> create(@RequestBody @Valid AlunoInputDTO alunoInputDTO){

        Aluno alunoToCreate = alunoInputDTO.toEntity();

        Aluno alunoCreated = alunoService.create(alunoToCreate);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(alunoCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(AlunoOutputDTO.fromEntity(alunoCreated));
    }


}
