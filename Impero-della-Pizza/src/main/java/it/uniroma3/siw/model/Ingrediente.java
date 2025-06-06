package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ingrediente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(nullable=false)
	private String nome;

	@NotNull
	@Column(nullable=false)
	private Float prezzo;

	@Column(nullable=false)
	private Boolean vegan;

	@Column(nullable=false)
	private Boolean celiaco;

	@ManyToMany(mappedBy="listaIngredienti")
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
	
	public List<Pizza> getListaPizze() {
		return listaPizze;
	}

	public void setListaPizze(List<Pizza> listaPizze) {
		this.listaPizze = listaPizze;
	}

	@Override
	public int hashCode() {
		return Objects.hash(celiaco, nome, prezzo, vegan);
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
		return Objects.equals(celiaco, other.celiaco) && Objects.equals(nome, other.nome)
				&& Objects.equals(prezzo, other.prezzo) && Objects.equals(vegan, other.vegan);
	}

	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nome=" + nome + ", prezzo=" + prezzo + ", vegan=" + vegan + ", celiaco="
				+ celiaco + ", listaPizze=" + listaPizze + "]";
	}
}
