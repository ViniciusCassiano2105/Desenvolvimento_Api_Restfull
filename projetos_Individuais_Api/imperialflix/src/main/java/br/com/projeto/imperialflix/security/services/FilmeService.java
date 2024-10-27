package br.com.projeto.imperialflix.security.services;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.imperialflix.security.dto.FilmeRequestDTO;
import br.com.projeto.imperialflix.security.dto.FilmeResponseDTO;
import br.com.projeto.imperialflix.security.entities.Filme;
import br.com.projeto.imperialflix.security.entities.Cinema;
import br.com.projeto.imperialflix.security.repositories.FilmeRepository;
import br.com.projeto.imperialflix.security.repositories.CinemaRepository;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    // Criar um novo filme
    public FilmeResponseDTO salvarFilme(FilmeRequestDTO filmeDTO) {
        Filme filme = new Filme();
        filme.setNome(filmeDTO.getNome());
        filme.setGenero(filmeDTO.getGenero());
        filme.setDuracao(filmeDTO.getDuracao());

        Optional<Cinema> optionalCinema = cinemaRepository.findById(filmeDTO.getCinemaId());
        if (optionalCinema.isPresent()) {
            filme.setCinema(optionalCinema.get());
        } else {
            throw new RuntimeException("Cinema não encontrado com o ID: " + filmeDTO.getCinemaId());
        }

        Filme filmeSalvo = filmeRepository.save(filme);

        FilmeResponseDTO filmeResponseDTO = new FilmeResponseDTO();
        filmeResponseDTO.setId(filmeSalvo.getId());
        filmeResponseDTO.setNome(filmeSalvo.getNome());
        filmeResponseDTO.setGenero(filmeSalvo.getGenero());
        filmeResponseDTO.setDuracao(filmeSalvo.getDuracao());
        filmeResponseDTO.setCinemaId(filmeSalvo.getCinema().getId());

        return filmeResponseDTO;
    }

    // Buscar um filme por ID
    public FilmeResponseDTO buscarFilme(Integer id) {
        Optional<Filme> filmeOpt = filmeRepository.findById(id);
        if (filmeOpt.isPresent()) {
            Filme filme = filmeOpt.get();

            FilmeResponseDTO filmeResponseDTO = new FilmeResponseDTO();
            filmeResponseDTO.setId(filme.getId());
            filmeResponseDTO.setNome(filme.getNome());
            filmeResponseDTO.setGenero(filme.getGenero());
            filmeResponseDTO.setDuracao(filme.getDuracao());
            filmeResponseDTO.setCinemaId(filme.getCinema().getId());

            return filmeResponseDTO;
        } else {
            return null;
        }
    }

    // Atualizar um filme existente
    public FilmeResponseDTO atualizarFilme(Integer id, FilmeRequestDTO filmeDTO) {
        Optional<Filme> filmeOpt = filmeRepository.findById(id);
        if (filmeOpt.isPresent()) {
            Filme filme = filmeOpt.get();
            filme.setNome(filmeDTO.getNome());
            filme.setGenero(filmeDTO.getGenero());
            filme.setDuracao(filmeDTO.getDuracao());

            Optional<Cinema> optionalCinema = cinemaRepository.findById(filmeDTO.getCinemaId());
            if (optionalCinema.isPresent()) {
                filme.setCinema(optionalCinema.get());
            } else {
                throw new RuntimeException("Cinema não encontrado com o ID: " + filmeDTO.getCinemaId());
            }

            Filme filmeAtualizado = filmeRepository.save(filme);

            FilmeResponseDTO filmeResponseDTO = new FilmeResponseDTO();
            filmeResponseDTO.setId(filmeAtualizado.getId());
            filmeResponseDTO.setNome(filmeAtualizado.getNome());
            filmeResponseDTO.setGenero(filmeAtualizado.getGenero());
            filmeResponseDTO.setDuracao(filmeAtualizado.getDuracao());
            filmeResponseDTO.setCinemaId(filmeAtualizado.getCinema().getId());

            return filmeResponseDTO;
        } else {
            return null;
        }
    }

    // Deletar um filme por ID
    public void deletarFilme(Integer id) {
        filmeRepository.deleteById(id);
    }

    // Listar todos os filmes
    public List<FilmeResponseDTO> listarFilmes() {
        List<Filme> filmes = filmeRepository.findAll();
        List<FilmeResponseDTO> filmeResponseList = new ArrayList<>();

        for (Filme filme : filmes) {
            FilmeResponseDTO filmeResponseDTO = new FilmeResponseDTO();
            filmeResponseDTO.setId(filme.getId());
            filmeResponseDTO.setNome(filme.getNome());
            filmeResponseDTO.setGenero(filme.getGenero());
            filmeResponseDTO.setDuracao(filme.getDuracao());
            filmeResponseDTO.setCinemaId(filme.getCinema().getId());
            filmeResponseList.add(filmeResponseDTO);
        }

        return filmeResponseList;
    }
}
