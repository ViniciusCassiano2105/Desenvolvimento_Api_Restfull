package br.com.projeto.imperialflix.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.imperialflix.security.entities.Filme;
import br.com.projeto.imperialflix.security.repositories.FilmeRepository;


@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Transactional
    public Filme save(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Optional<Filme> findById(Integer id) {
        return filmeRepository.findById(id);
    }

    public List<Filme> findAll() {
        return filmeRepository.findAll();
    }

    @Transactional
    public void deleteById(Integer id) {
        filmeRepository.deleteById(id);
    }

    public long getFilmeCount() {
        return filmeRepository.count();
    }
}
