package br.com.projeto.imperialflix.security.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class CinemaRequestDTO {
    @NotBlank
    private String nome;

    @NotNull
    private Integer sala;

    @NotNull
    private Double valor;

    @NotBlank
    private String horario;

    private EnderecoRequestDTO endereco;

    private List<Integer> filmesIds;

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

	public EnderecoRequestDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRequestDTO endereco) {
		this.endereco = endereco;
	}

	public List<Integer> getFilmesIds() {
		return filmesIds;
	}

	public void setFilmesIds(List<Integer> filmesIds) {
		this.filmesIds = filmesIds;
	}
    

}
