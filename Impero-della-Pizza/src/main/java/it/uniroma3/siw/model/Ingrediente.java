package it.uniroma3.siw.model;

import java.util.Objects;


public class Ingrediente {

    private Long id;
	
	private String nome;
	private Float prezzo;
	private Boolean vegan;
	private Boolean celiaco;
	
	public Ingrediente(String nome,Float prezzo,Boolean Vegan,Boolean Ciliaco) {
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
