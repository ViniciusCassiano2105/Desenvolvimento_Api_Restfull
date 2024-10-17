package br.com.projeto.imperialflix.security.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.imperialflix.security.dto.EnderecoRequestDTO;
import br.com.projeto.imperialflix.security.dto.EnderecoResponseDTO;
import br.com.projeto.imperialflix.security.entities.Cinema;
import br.com.projeto.imperialflix.security.services.CinemaService;
import br.com.projeto.imperialflix.security.services.EnderecoService;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

	@Autowired
	EnderecoService enderecoService;
	
    @Autowired
    private CinemaService cinemaService;

    @GetMapping
    public List<Cinema> getAllCinemas() {
        return cinemaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cinema> getCinemaById(@PathVariable Integer id) {
        return cinemaService.findById(id);
    }

    @PostMapping
    public Cinema createCinema(@RequestBody Cinema cinema) {
        return cinemaService.save(cinema);
    }

    @PutMapping("/{id}")
    public Cinema updateCinema(@PathVariable Integer id, @RequestBody Cinema cinema) {
        cinema.setId(id); 
        return cinemaService.save(cinema);
    }

    @DeleteMapping("/{id}")
    public void deleteCinema(@PathVariable Integer id) {
        cinemaService.deleteById(id);
    }

    @GetMapping("/count")
    public long getCinemaCount() {
        return cinemaService.getCinemaCount();
    }
    
	/*
	 * @PostMapping("/teste-cep") public EnderecoResponseDTO
	 * testeEndereco(@RequestParam String cep) { return
	 * enderecoService.consultarEndereco(cep); }
	 */
    
    @PostMapping("/teste-cep")
    public EnderecoResponseDTO testeEndereco(@RequestBody EnderecoRequestDTO enderecoDTO) {
    	return enderecoService.consultarEndereco(enderecoDTO);
    }
}
