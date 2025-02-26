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

    public PessoaController (PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaOutputDTO>> findAll() {
        var pessoas = pessoaService.findAll();
        var pessoasDTO = pessoas.stream().map(PessoaOutputDTO::fromEntity).toList();
        return ResponseEntity.ok(pessoasDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        pessoaService.deleteById(id);
        return ResponseEntity.ok("pessoa deletada com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaOutputDTO> findById(@PathVariable(value = "id") Long id){
        var pessoa = pessoaService.findById(id);
        return ResponseEntity.ok(PessoaOutputDTO.fromEntity(pessoa));
    }

    @PostMapping
    public ResponseEntity<PessoaOutputDTO> create(@RequestBody @Valid PessoaInputDTO PessoaInputDTO) {

        Pessoa pessoaToCreate = PessoaInputDTO.toEntity();

        Pessoa pessoaCreated = pessoaService.create(pessoaToCreate);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pessoaCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(PessoaOutputDTO.fromEntity(pessoaCreated));
    }


}
