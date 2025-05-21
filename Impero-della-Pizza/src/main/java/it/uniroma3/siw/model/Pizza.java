package it.uniroma3.siw.model;

import java.util.Objects;

public class Pizza {

	private Long id;
	private Integer codice;
	private String nome;
	private Float prezzo;
	private Float mediaStelle = 0.0f;
	private String URLImmagine;
	
	public Pizza(Integer codice, String nome, Float prezzo, String URLImmagine) {
		this.codice = codice;
		this.nome = nome;
		this.prezzo = prezzo;
		this.URLImmagine = URLImmagine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Float getMediaStelle() {
		return mediaStelle;
	}

	public void setMediaStelle(Float mediaStelle) {
		this.mediaStelle = mediaStelle;
	}

	public String getURLImmagine() {
		return URLImmagine;
	}

	public void setURLImmagine(String uRLImmagine) {
		URLImmagine = uRLImmagine;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return Objects.equals(codice, other.codice);
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", codice=" + codice + ", nome=" + nome + ", prezzo=" + prezzo + ", mediaStelle="
				+ mediaStelle + ", URLImmagine=" + URLImmagine + "]";
	}
	
	
	
}
