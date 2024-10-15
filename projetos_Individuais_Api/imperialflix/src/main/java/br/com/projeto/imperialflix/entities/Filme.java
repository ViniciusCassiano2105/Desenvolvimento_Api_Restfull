package br.com.projeto.imperialflix.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="filme")
public class Filme{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fil_cd_id")
	private Integer id;
	
	@Column(name="cur_tx_nome_completo")
	private String nomeCompleto;
	
	@Column(name="cur_int_cpf")
	private Long cpf;

	public Filme(Integer id, String nomeCompleto, Long cpf) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", nomeCompleto=" + nomeCompleto + ", cpf=" + cpf + "]";
	}
	
}