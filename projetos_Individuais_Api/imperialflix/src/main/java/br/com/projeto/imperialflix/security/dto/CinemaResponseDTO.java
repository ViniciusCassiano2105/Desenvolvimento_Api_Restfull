package br.com.projeto.imperialflix.security.dto;

import java.util.List;

public class CinemaResponseDTO {
    private Integer id;
    private String nome;
    private Integer sala;
    private Double valor;
    private String horario;
    private EnderecoResponseDTO endereco;
    private List<FilmeResponseDTO> filmes;
	
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
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public EnderecoResponseDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoResponseDTO endereco) {
		this.endereco = endereco;
	}
	public List<FilmeResponseDTO> getFilmes() {
		return filmes;
	}
	public void setFilmes(List<FilmeResponseDTO> filmes) {
		this.filmes = filmes;
	}


}
