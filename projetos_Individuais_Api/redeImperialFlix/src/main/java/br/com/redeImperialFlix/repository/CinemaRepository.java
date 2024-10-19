package br.com.redeImperialFlix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.redeImperialFlix.entities.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
}
