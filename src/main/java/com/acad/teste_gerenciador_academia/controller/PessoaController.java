package com.acad.teste_gerenciador_academia.controller;

import com.acad.teste_gerenciador_academia.DTO.PessoaDTO;
import com.acad.teste_gerenciador_academia.model.Pessoa;
import com.acad.teste_gerenciador_academia.service.PessoaService;
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
    public ResponseEntity<List<Pessoa>> findAll() {
        var pessoas = pessoaService.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable(value = "id") Long id){
        var pessoa = pessoaService.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody PessoaDTO pessoaDTO){
        Pessoa pessoaToCreate = toEntity(pessoaDTO);
        var pessoaCreated = pessoaService.create(pessoaToCreate);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pessoaCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(pessoaCreated);
    }

    private Pessoa toEntity(PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        pessoa.setDataNascimento(dto.getDataNascimento());
        return pessoa;
    }

}
