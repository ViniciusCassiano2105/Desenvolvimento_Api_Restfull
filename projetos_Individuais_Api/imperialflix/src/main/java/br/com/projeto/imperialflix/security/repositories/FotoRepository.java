package br.com.projeto.imperialflix.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projeto.imperialflix.security.entities.Foto;

@Repository ("foto")
public interface FotoRepository extends JpaRepository<Foto, Integer> {
    @Query(value="SELECT * FROM foto WHERE user_id=:idUsuario", nativeQuery = true)
    public Foto buscarFotoPorIdUsuario(Integer idUsuario);
}
