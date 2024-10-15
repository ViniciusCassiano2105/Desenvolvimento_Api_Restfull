package br.com.projeto.imperialflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.projeto.imperialflix.entities.Cinema;
import br.com.projeto.imperialflix.services.CinemaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

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
}
