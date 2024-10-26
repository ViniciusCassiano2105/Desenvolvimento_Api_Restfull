package br.com.projeto.imperialflix.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import br.com.projeto.imperialflix.security.dto.CinemaRequestDTO;
import br.com.projeto.imperialflix.security.dto.CinemaResponseDTO;
import br.com.projeto.imperialflix.security.dto.EnderecoRequestDTO;
import br.com.projeto.imperialflix.security.dto.EnderecoResponseDTO;
import br.com.projeto.imperialflix.security.services.CinemaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
	
    @Autowired
    private CinemaService cinemaService;

    // Buscar um cinema por ID
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public CinemaResponseDTO buscarCinema(@PathVariable Integer id) {
        return cinemaService.buscarCinema(id);
    }

    // Deletar um cinema por ID
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cinemaService.deletarCinema(id);
    }

    // Criar um novo cinema
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping
    public CinemaResponseDTO criarCinema(@RequestBody CinemaRequestDTO cinemaRequestDTO) {
        return cinemaService.salvarCinema(cinemaRequestDTO);
    }

    // Atualizar um cinema existente
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/{id}")
    public CinemaResponseDTO atualizarCinema(@PathVariable Integer id, @RequestBody CinemaRequestDTO cinemaRequestDTO) {
        return cinemaService.atualizarCinema(id, cinemaRequestDTO);
    }

    // Listar todos os cinemas
    @SecurityRequirement(name = "Bearer Auth")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public List<CinemaResponseDTO> listarCinemas() {
        return cinemaService.listarCinemas();
   
    }
}
    
