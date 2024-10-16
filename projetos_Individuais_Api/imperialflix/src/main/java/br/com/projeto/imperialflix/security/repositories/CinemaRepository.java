package br.com.projeto.imperialflix.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.imperialflix.security.entities.Cinema;


@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer>{

}
