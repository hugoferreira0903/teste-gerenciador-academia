package com.acad.teste_gerenciador_academia.controller;


import com.acad.teste_gerenciador_academia.DTO.PessoaInputDTO;
import com.acad.teste_gerenciador_academia.DTO.PessoaOutputDTO;
import com.acad.teste_gerenciador_academia.model.Pessoa;
import com.acad.teste_gerenciador_academia.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaOutputDTO>> findAll() {
        var pessoas = pessoaService.findAll();
        var pessoasDTO = pessoas.stream().map(PessoaOutputDTO::fromEntity).toList();
        return ResponseEntity.ok(pessoasDTO);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> deleteById(@PathVariable String cpf) {
        pessoaService.deleteByCpf(cpf);
        return ResponseEntity.ok("pessoa deletada com sucesso!");
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PessoaOutputDTO> findById(@PathVariable(value = "cpf") String cpf){
        var pessoa = pessoaService.findByCpf(cpf);
        return ResponseEntity.ok(PessoaOutputDTO.fromEntity(pessoa));
    }

    @PostMapping
    public ResponseEntity<PessoaOutputDTO> create(@RequestBody @Valid PessoaInputDTO pessoaInputDTO) {

        Pessoa pessoaToCreate = pessoaInputDTO.toEntity();

        Pessoa pessoaCreated = pessoaService.create(pessoaToCreate);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{cpf}")
                .buildAndExpand(pessoaCreated.getCpf())
                .toUri();

        return ResponseEntity.created(location).body(PessoaOutputDTO.fromEntity(pessoaCreated));
    }
}
