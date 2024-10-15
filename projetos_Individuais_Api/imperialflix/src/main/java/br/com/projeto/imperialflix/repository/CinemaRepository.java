package br.com.projeto.imperialflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.imperialflix.entities.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer>{

}
