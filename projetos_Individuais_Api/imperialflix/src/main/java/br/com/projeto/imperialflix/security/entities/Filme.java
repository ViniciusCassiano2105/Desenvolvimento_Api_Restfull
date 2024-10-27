package br.com.projeto.imperialflix.security.entities;

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

    @Column(name = "fil_tx_genero") 
    private String genero;

    @Column(name = "fil_int_duracao")
    private Long duracao;

    @ManyToOne
    @JoinColumn(name = "cin_cd_id", nullable = false)
    private Cinema cinema;

    public Filme() {
    }

    public Filme(Integer id, String nome, String genero, Long duracao, Cinema cinema) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getDuracao() {
        return duracao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
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
