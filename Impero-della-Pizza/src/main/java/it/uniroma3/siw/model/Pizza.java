package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	@NotBlank
	private String nome;
	@Column(nullable = false)
	@NotNull
	@Min(1)
	private Float prezzo;
	private Float mediaStelle;
	private String URLImmagine;
	//@NotEmpty
	@ManyToMany(fetch= FetchType.EAGER, mappedBy = "listaPizze")
	private List<Ingrediente> listaIngredienti = new ArrayList<>();
	@OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL)
	private List<Recensione> listaRecensioni;
	
	public Pizza() {
		
	}
	
	public Pizza(String nome, Float prezzo, String URLImmagine, Float mediaStelle) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.URLImmagine = URLImmagine;
		this.mediaStelle = mediaStelle != null ? mediaStelle : 0.0f;
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

	public List<Ingrediente> getListaIngredienti() {
		return listaIngredienti;
	}

	public void setListaIngredienti(List<Ingrediente> listaIngredienti) {
		this.listaIngredienti = listaIngredienti;
	}

	public List<Recensione> getListaRecensioni() {
		return listaRecensioni;
	}

	public void setListaRecensioni(List<Recensione> listaRecensioni) {
		this.listaRecensioni = listaRecensioni;
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
		return "Pizza [id=" + id + ", nome=" + nome + ", prezzo=" + prezzo + ", mediaStelle=" + mediaStelle
				+ ", URLImmagine=" + URLImmagine + ", listaIngredienti=" + listaIngredienti + ", listaRecensioni="
				+ listaRecensioni + "]";
	}
	
	
	
}
