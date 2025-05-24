package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Ingrediente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String nome;

	@Column(nullable=false)
	private Float prezzo;

	@Column(nullable=false)
	private Boolean vegan;

	@Column(nullable=false)
	private Boolean celiaco;

	@ManyToMany
	private List<Pizza> listaPizze;

	public Ingrediente() {
		
	}

	public Ingrediente(String nome,Float prezzo,Boolean vegan,Boolean celiaco) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.vegan = vegan;
		this.celiaco = celiaco;
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

	public Boolean getVegan() {
		return this.vegan;
	}

	public void setVegan(Boolean vegan) {
		this.vegan = vegan;
	}

	public Boolean getCeliaco() {
		return this.celiaco;
	}

	public void setCiliaco(Boolean celiaco) {
		this.celiaco = celiaco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCeliaco(Boolean celiaco) {
		this.celiaco = celiaco;
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
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(nome, other.nome);
	}	
}
