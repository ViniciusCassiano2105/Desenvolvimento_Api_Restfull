package br.com.projeto.imperialflix.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import br.com.projeto.imperialflix.security.dto.FilmeRequestDTO;
import br.com.projeto.imperialflix.security.dto.FilmeResponseDTO;
import br.com.projeto.imperialflix.security.services.FilmeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    // Buscar um filme por ID
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public FilmeResponseDTO buscarFilme(@PathVariable Integer id) {
        return filmeService.buscarFilme(id);
    }

    // Deletar um filme por ID
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Integer id) {
        filmeService.deletarFilme(id);
    }

    // Criar um novo filme
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping
    public FilmeResponseDTO criarFilme(@RequestBody FilmeRequestDTO filmeRequestDTO) {
        return filmeService.salvarFilme(filmeRequestDTO);
    }

    // Atualizar um filme existente
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/{id}")
    public FilmeResponseDTO atualizarFilme(@PathVariable Integer id, @RequestBody FilmeRequestDTO filmeRequestDTO) {
        return filmeService.atualizarFilme(id, filmeRequestDTO);
    }

    // Listar todos os filmes
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public List<FilmeResponseDTO> listarFilmes() {
        return filmeService.listarFilmes();
    }
}
