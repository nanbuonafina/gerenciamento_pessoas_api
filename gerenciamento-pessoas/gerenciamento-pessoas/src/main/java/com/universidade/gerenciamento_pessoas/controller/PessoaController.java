package com.universidade.gerenciamento_pessoas.controller;

import com.universidade.gerenciamento_pessoas.dto.PessoaDTO;
import com.universidade.gerenciamento_pessoas.entity.Pessoa;
import com.universidade.gerenciamento_pessoas.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .cpf(pessoaDTO.getCpf())
                .idade(pessoaDTO.getIdade())
                .build();

        return ResponseEntity.ok(pessoaRepository.save(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
