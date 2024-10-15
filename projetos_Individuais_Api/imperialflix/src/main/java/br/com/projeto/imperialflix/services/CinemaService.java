package br.com.projeto.imperialflix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.imperialflix.entities.Cinema;
import br.com.projeto.imperialflix.repository.CinemaRepository;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Transactional
    public Cinema save(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public Optional<Cinema> findById(Integer id) {
        return cinemaRepository.findById(id);
    }

    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    @Transactional
    public void deleteById(Integer id) {
        cinemaRepository.deleteById(id);
    }

    public long getCinemaCount() {
        return cinemaRepository.count();
    }
}
