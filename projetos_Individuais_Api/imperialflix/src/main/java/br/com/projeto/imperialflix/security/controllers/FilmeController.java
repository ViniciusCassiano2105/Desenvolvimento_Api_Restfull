package br.com.projeto.imperialflix.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.projeto.imperialflix.security.entities.Filme;
import br.com.projeto.imperialflix.security.services.FilmeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> getAllFilmes() {
        return filmeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Filme> getFilmeById(@PathVariable Integer id) {
        return filmeService.findById(id);
    }

    @PostMapping
    public Filme createFilme(@RequestBody Filme filme) {
        return filmeService.save(filme);
    }

    @PutMapping("/{id}")
    public Filme updateFilme(@PathVariable Integer id, @RequestBody Filme filme) {
        filme.setId(id); 
        return filmeService.save(filme);
    }

    @DeleteMapping("/{id}")
    public void deleteFilme(@PathVariable Integer id) {
        filmeService.deleteById(id);
    }

    @GetMapping("/count")
    public long getFilmeCount() {
        return filmeService.getFilmeCount();
    }
}
