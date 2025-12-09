package br.com.seu.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LivroDTO {
    private Long id;

    @NotBlank(message = "titulo é obrigatório")
    private String titulo;

    @NotBlank(message = "autor é obrigatório")
    private String autor;

    @NotBlank(message = "isbn é obrigatório")
    @Size(max = 50)
    private String isbn;

    private Integer anoPublicacao;
    private Boolean disponivel;

    // getters e setters
    // ...
}
