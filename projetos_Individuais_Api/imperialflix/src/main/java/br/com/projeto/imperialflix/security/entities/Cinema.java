package br.com.projeto.imperialflix.security.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fil_cd_id")
    private Integer id;

    @Column(name = "cin_int_sala")
    private Integer sala;

    @Column(name = "cin_int_valor")
    private Double valor;

    @Column(name = "cin_int_nome")
    private String nome;

    @Column(name = "cin_int_horario")
    private String horario;

    @OneToOne
    @JoinColumn(name = "end_int_id") 
    private Endereco endereco; 

    @OneToMany(mappedBy = "cinema")
    private List<Filme> filmes;

    public Cinema() {
    }

    public Cinema(Integer id, Integer sala, Double valor, String nome, String horario, Endereco endereco, List<Filme> filmes) {
        this.id = id;
        this.sala = sala;
        this.valor = valor;
        this.nome = nome;
        this.horario = horario;
        this.endereco = endereco;
        this.filmes = filmes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @Override
    public String toString() {
        return "Cinema [id=" + id + ", sala=" + sala + ", valor=" + valor + ", nome=" + nome + ", horario=" + horario
                + ", endereco=" + endereco + "]";
    }
}
