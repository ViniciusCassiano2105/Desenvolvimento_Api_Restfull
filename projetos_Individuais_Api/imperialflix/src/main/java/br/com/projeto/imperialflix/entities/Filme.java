package br.com.projeto.imperialflix.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fil_cd_id")
    private Integer id;

    @Column(name = "fil_tx_nome")
    private String nome;

    @Column(name = "fil_int_genero")
    private Long genero;

    @Column(name = "fil_int_duracao")
    private Long duracao;

    @ManyToOne
    @JoinColumn(name = "fk_cinema", nullable = false)
    private Cinema cinema;

    public Filme() {
    }

    public Filme(Integer id, String nome, Long genero, Long duracao, Cinema cinema) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.cinema = cinema;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
		this.id = id;
	}

    public String getNome() {
        return nome;
    }

    public Long getGenero() {
        return genero;
    }

    public Long getDuracao() {
        return duracao;
    }

    public Cinema getCinema() {
        return cinema;
    }


	public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return "Filme [id=" + id + ", nome=" + nome + ", genero=" + genero + ", duracao=" + duracao + ", cinema=" + cinema + "]";
    }
}
