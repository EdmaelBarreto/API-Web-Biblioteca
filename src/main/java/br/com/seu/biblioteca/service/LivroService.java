package br.com.seu.biblioteca.service;

import br.com.seu.biblioteca.entity.Livro;
import br.com.seu.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository repo;

    public LivroService(LivroRepository repo) {
        this.repo = repo;
    }

    public Livro criar(Livro livro) {
        if (repo.existsByIsbn(livro.getIsbn())) {
            throw new IllegalArgumentException("ISBN já cadastrado");
        }
        return repo.save(livro);
    }

    public List<Livro> listarTodos() {
        return repo.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Transactional
    public Livro atualizar(Long id, Livro dados) {
        Livro existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        // checar ISBN caso tenha mudado
        if (dados.getIsbn() != null && !dados.getIsbn().equals(existente.getIsbn())) {
            if (repo.existsByIsbn(dados.getIsbn())) {
                throw new IllegalArgumentException("ISBN já cadastrado");
            }
            existente.setIsbn(dados.getIsbn());
        }
        existente.setTitulo(dados.getTitulo() != null ? dados.getTitulo() : existente.getTitulo());
        existente.setAutor(dados.getAutor() != null ? dados.getAutor() : existente.getAutor());
        existente.setAnoPublicacao(dados.getAnoPublicacao() != null ? dados.getAnoPublicacao() : existente.getAnoPublicacao());
        existente.setDisponivel(dados.getDisponivel() != null ? dados.getDisponivel() : existente.getDisponivel());
        return repo.save(existente);
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) throw new RuntimeException("Livro não encontrado");
        repo.deleteById(id);
    }
}
