package br.com.veiculo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vei_cd_id")
    private Integer id;

    @Column(name = "vei_tx_marca")
    private String nome;

    @Column(name = "vei_tx_modelo")
    private String modelo;

    public Veiculo() {
    }

    public Veiculo(Integer id, String nome, String modelo) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", nome=" + nome + ", modelo=" + modelo + "]";
    }
}
