package br.com.projeto.imperialflix.security.services;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.imperialflix.security.dto.CinemaRequestDTO;
import br.com.projeto.imperialflix.security.dto.CinemaResponseDTO;
import br.com.projeto.imperialflix.security.dto.EnderecoResponseDTO;
import br.com.projeto.imperialflix.security.entities.Cinema;
import br.com.projeto.imperialflix.security.entities.Endereco;
import br.com.projeto.imperialflix.security.repositories.CinemaRepository;
import br.com.projeto.imperialflix.security.repositories.EnderecoRepository;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Criar um novo cinema
    public CinemaResponseDTO salvarCinema(CinemaRequestDTO cinemaDTO) {
        Cinema cinema = new Cinema();
        
        cinema.setNome(cinemaDTO.getNome() != null ? cinemaDTO.getNome() : "Cinema Padrão");
        cinema.setSala(cinemaDTO.getSala() != null ? cinemaDTO.getSala() : 1);
        cinema.setValor(cinemaDTO.getValor() != null ? cinemaDTO.getValor() : 10.0);
        cinema.setHorario(cinemaDTO.getHorario() != null ? cinemaDTO.getHorario() : "00:00");

        // Verifica e associa o Endereco
        if (cinemaDTO.getEndereco() != null && cinemaDTO.getEndereco().getId() != null) {
            Optional<Endereco> optionalEndereco = enderecoRepository.findById(cinemaDTO.getEndereco().getId());
            optionalEndereco.ifPresent(cinema::setEndereco);
        } else {
            System.out.println("Endereço não especificado ou nulo");
        }

        Cinema cinemaSalvo = cinemaRepository.save(cinema);

        CinemaResponseDTO cinemaResponseDTO = new CinemaResponseDTO();
        cinemaResponseDTO.setId(cinemaSalvo.getId());
        cinemaResponseDTO.setNome(cinemaSalvo.getNome());
        cinemaResponseDTO.setSala(cinemaSalvo.getSala());
        cinemaResponseDTO.setValor(cinemaSalvo.getValor());
        cinemaResponseDTO.setHorario(cinemaSalvo.getHorario());
        cinemaResponseDTO.setEndereco(convertToEnderecoResponseDTO(cinemaSalvo.getEndereco()));

        return cinemaResponseDTO;
    }

    // Buscar um cinema por ID
    public CinemaResponseDTO buscarCinema(Integer id) {
        Optional<Cinema> cinemaOpt = cinemaRepository.findById(id);
        if (cinemaOpt.isPresent()) {
            Cinema cinema = cinemaOpt.get();

            CinemaResponseDTO cinemaResponseDTO = new CinemaResponseDTO();
            cinemaResponseDTO.setId(cinema.getId());
            cinemaResponseDTO.setNome(cinema.getNome());
            cinemaResponseDTO.setSala(cinema.getSala());
            cinemaResponseDTO.setValor(cinema.getValor());
            cinemaResponseDTO.setHorario(cinema.getHorario());
            cinemaResponseDTO.setEndereco(convertToEnderecoResponseDTO(cinema.getEndereco()));

            return cinemaResponseDTO;
        } else {
            return null;
        }
    }

    // Atualizar um cinema existente
    public CinemaResponseDTO atualizarCinema(Integer id, CinemaRequestDTO cinemaDTO) {
        Optional<Cinema> cinemaOpt = cinemaRepository.findById(id);
        if (cinemaOpt.isPresent()) {
            Cinema cinema = cinemaOpt.get();
            cinema.setNome(cinemaDTO.getNome() != null ? cinemaDTO.getNome() : cinema.getNome());
            cinema.setSala(cinemaDTO.getSala() != null ? cinemaDTO.getSala() : cinema.getSala());
            cinema.setValor(cinemaDTO.getValor() != null ? cinemaDTO.getValor() : cinema.getValor());
            cinema.setHorario(cinemaDTO.getHorario() != null ? cinemaDTO.getHorario() : cinema.getHorario());

            if (cinemaDTO.getEndereco() != null && cinemaDTO.getEndereco().getId() != null) {
                Optional<Endereco> optionalEndereco = enderecoRepository.findById(cinemaDTO.getEndereco().getId());
                optionalEndereco.ifPresent(cinema::setEndereco);
            }

            Cinema cinemaAtualizado = cinemaRepository.save(cinema);

            CinemaResponseDTO cinemaResponseDTO = new CinemaResponseDTO();
            cinemaResponseDTO.setId(cinemaAtualizado.getId());
            cinemaResponseDTO.setNome(cinemaAtualizado.getNome());
            cinemaResponseDTO.setSala(cinemaAtualizado.getSala());
            cinemaResponseDTO.setValor(cinemaAtualizado.getValor());
            cinemaResponseDTO.setHorario(cinemaAtualizado.getHorario());
            cinemaResponseDTO.setEndereco(convertToEnderecoResponseDTO(cinemaAtualizado.getEndereco()));

            return cinemaResponseDTO;
        } else {
            return null;
        }
    }

    // Deletar um cinema por ID
    public void deletarCinema(Integer id) {
        cinemaRepository.deleteById(id);
    }

    // Listar todos os cinemas
    public List<CinemaResponseDTO> listarCinemas() {
        List<Cinema> cinemas = cinemaRepository.findAll();
        List<CinemaResponseDTO> cinemaResponseList = new ArrayList<>();

        for (Cinema cinema : cinemas) {
            CinemaResponseDTO cinemaResponseDTO = new CinemaResponseDTO();
            cinemaResponseDTO.setId(cinema.getId());
            cinemaResponseDTO.setNome(cinema.getNome());
            cinemaResponseDTO.setSala(cinema.getSala());
            cinemaResponseDTO.setValor(cinema.getValor());
            cinemaResponseDTO.setHorario(cinema.getHorario());
            cinemaResponseDTO.setEndereco(convertToEnderecoResponseDTO(cinema.getEndereco()));
            cinemaResponseList.add(cinemaResponseDTO);
        }

        return cinemaResponseList;
    }

    // Converter Endereco para EnderecoResponseDTO
    private EnderecoResponseDTO convertToEnderecoResponseDTO(Endereco endereco) {
        if (endereco == null) {
            return null;
        }

        EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
        enderecoResponseDTO.setCep(endereco.getCep());
        enderecoResponseDTO.setBairro(endereco.getBairro());
        enderecoResponseDTO.setComplemento(endereco.getComplemento());
        enderecoResponseDTO.setEstado(endereco.getEstado());
        enderecoResponseDTO.setLocalidade(endereco.getLocalidade());
        enderecoResponseDTO.setLogradouro(endereco.getLogradouro());
        enderecoResponseDTO.setRegiao(endereco.getRegiao());
        enderecoResponseDTO.setUf(endereco.getUf());

        return enderecoResponseDTO;
    }
}
