package br.com.projeto.imperialflix.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.imperialflix.security.entities.Filme;


@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer>{

}
