package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private Float prezzo;
	private Float mediaStelle = 0.0f;
	private String URLImmagine;
	
	public Pizza(String nome, Float prezzo, String URLImmagine) {
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
		return Objects.hash(nome);
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
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", nome=" + nome + ", prezzo=" + prezzo + ", mediaStelle="
				+ mediaStelle + ", URLImmagine=" + URLImmagine + "]";
	}
	
	
	
}
