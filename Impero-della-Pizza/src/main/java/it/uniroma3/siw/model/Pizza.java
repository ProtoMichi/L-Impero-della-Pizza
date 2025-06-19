package it.uniroma3.siw.model;

import java.util.LinkedList;
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
import jakarta.persistence.ManyToOne;
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
	private Float prezzo;
	private String URLImmagine;
	@ManyToOne(fetch = FetchType.EAGER)
	private Ingrediente tipoFarina;
	//@NotEmpty
	@ManyToMany(fetch= FetchType.EAGER)
	private List<Ingrediente> listaIngredienti;
	@OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL)
	private List<Recensione> listaRecensioni;
	
	
	
	
	public Pizza() {
		this.listaIngredienti = new LinkedList<>();
	}
	
	public Pizza(String nome, Float prezzo, String URLImmagine) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.URLImmagine = URLImmagine;
	}
	
	public Float calcolaMediaStelle() {
		Float mediaStelle = 0.f;
		Float contatore = 0.f;
		if(this.listaRecensioni.isEmpty()) {
			return mediaStelle;
		}
		for(Recensione rec : this.listaRecensioni) {
			mediaStelle += rec.getStelle();
			contatore++;
		}
		return mediaStelle/contatore;
	}

	public boolean isCeliaco() {
		if(!tipoFarina.getCeliaco())
			return false;
		for(Ingrediente ingrediente: this.listaIngredienti) {
			if(!ingrediente.getCeliaco())
				return false;
		}
		return true;
	}
	
	public boolean isVegan() {
		if(!tipoFarina.getVegan())
			return false;
		for(Ingrediente ingrediente: this.listaIngredienti) {
			if(!ingrediente.getVegan())
				return false;
		}
		return true;
	}
	
	public void calcolaPrezzo() {
	    float somma = 0f;

	    if (tipoFarina != null && tipoFarina.getPrezzo() != null) {
	        somma += tipoFarina.getPrezzo();
	    }

	    if (listaIngredienti != null) {
	        for (Ingrediente ingrediente : listaIngredienti) {
	            if (ingrediente != null && ingrediente.getPrezzo() != null) {
	                somma += ingrediente.getPrezzo();
	            }
	        }
	    }

	    this.setPrezzo(somma);
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

	public String getURLImmagine() {
		return URLImmagine;
	}

	public void setURLImmagine(String uRLImmagine) {
		URLImmagine = uRLImmagine;
	}

	public Ingrediente getTipoFarina() {
		return tipoFarina;
	}

	public void setTipoFarina(Ingrediente tipoFarina) {
		this.tipoFarina = tipoFarina;
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

	public Ingrediente getFarina() {
		return tipoFarina;
	}

	public void setFarina(Ingrediente farina) {
		this.tipoFarina = farina;
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
		return "Pizza [id=" + id + ", nome=" + nome + ", prezzo=" + prezzo
				+ ", URLImmagine=" + URLImmagine + ", listaIngredienti=" + listaIngredienti + ", listaRecensioni="
				+ listaRecensioni + ", farina=" + tipoFarina + "]";
	}

	
	
}
