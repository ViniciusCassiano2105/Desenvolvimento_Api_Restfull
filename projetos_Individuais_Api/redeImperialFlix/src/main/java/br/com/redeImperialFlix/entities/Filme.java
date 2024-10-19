package br.com.redeImperialFlix.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fil_cd_id")
	private Integer id;

	@Column(name = "fil_txt_nomefilme")
	private String nomeFilme;

	@Column(name = "fil_int_genero")
	private Long genero;

	@Column(name = "fil_int_duracao")
	private Long duracao;

	@Column(name = "fil_int_ano_lancamento")
	private Integer anoLancamento;

	@Column(name = "fil_txt_sinopse")
	private String sinopse;

	@Column(name = "fil_int_classificacao_indicativa")
	private Integer classificacaoIndicativa;

	public Filme(Integer id, String nomeFilme, Long genero, Long duracao, Integer anoLancamento, String sinopse,
			Integer classificacaoIndicativa) {
		this.id = id;
		this.nomeFilme = nomeFilme;
		this.genero = genero;
		this.duracao = duracao;
		this.anoLancamento = anoLancamento;
		this.sinopse = sinopse;
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public Long getGenero() {
		return genero;
	}

	public void setGenero(Long genero) {
		this.genero = genero;
	}

	public Long getDuracao() {
		return duracao;
	}

	public void setDuracao(Long duracao) {
		this.duracao = duracao;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Integer getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(Integer classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", nomeFilme=" + nomeFilme + ", genero=" + genero + ", duracao=" + duracao
				+ ", anoLancamento=" + anoLancamento + ", sinopse=" + sinopse + ", classificacaoIndicativa="
				+ classificacaoIndicativa + "]";
	}

}
