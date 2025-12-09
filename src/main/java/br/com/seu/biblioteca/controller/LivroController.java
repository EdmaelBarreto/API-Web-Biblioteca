package br.com.seu.biblioteca.controller;

import br.com.seu.biblioteca.entity.Livro;
import br.com.seu.biblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody @Valid Livro livro) {
        Livro criado = service.criar(livro);
        return ResponseEntity.created(URI.create("/api/livros/" + criado.getId())).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> substituir(@PathVariable Long id, @RequestBody @Valid Livro dados) {
        Livro atualizado = service.atualizar(id, dados);
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Livro> atualizarParcial(@PathVariable Long id, @RequestBody Livro dadosParciais) {
        Livro atualizado = service.atualizar(id, dadosParciais);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
