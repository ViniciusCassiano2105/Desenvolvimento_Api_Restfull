package br.com.redeImperialFlix.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cinema")
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cin_cd_id")
	private Integer id;

	@Column(name = "cin_txt_nome")
	private String nome;

	@Column(name = "cin_txt_uf")
	private String uf;

	@Column(name = "cin_txt_cidade")
	private String cidade;

	@Column(name = "cin_txt_endereco")
	private String endereco;

	@Column(name = "cin_txt_numero")
	private String numero;

	@Column(name = "cin_txt_complemento")
	private String complemento;

	@Column(name = "cin_txt_sala")
	private String sala;

	@Column(name = "cin_int_valor")
	private Double valor;

	public Cinema(Integer id, String nome, String uf, String cidade, String endereco, String numero, String complemento,
			String sala, Double valor) {
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.cidade = cidade;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.sala = sala;
		this.valor = valor;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", nome=" + nome + ", uf=" + uf + ", cidade=" + cidade + ", endereco=" + endereco
				+ ", numero=" + numero + ", complemento=" + complemento + ", sala=" + sala + ", valor=" + valor + "]";
	}

}
