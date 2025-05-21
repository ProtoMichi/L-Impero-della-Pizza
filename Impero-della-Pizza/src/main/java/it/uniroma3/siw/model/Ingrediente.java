package it.uniroma3.siw.model;

import java.util.Objects;


public class Ingrediente {

    private Long id;
	
	private String nome;
	private Integer codice;
	private Float prezzo;
	private Boolean vegan;
	private Boolean ciliaco;
	
	public Ingrediente(String nome,Integer codice,Float prezzo,Boolean Vegan,Boolean Ciliaco) {
		this.nome = nome;
		this.codice = codice;
		this.prezzo = prezzo;
		this.vegan = vegan;
		this.ciliaco = ciliaco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getCodice() {
		return codice;
	}
	
	public void setCodice(Integer codice) {
		this.codice = codice;
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
	
	public Boolean getCiliaco() {
		return this.ciliaco;
	}
	
	public void setCiliaco(Boolean ciliaco) {
		this.ciliaco = ciliaco;
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
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(codice, other.codice);
	}

	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nome=" + nome + ", codice=" + codice + ", prezzo=" + prezzo + ", vegan="
				+ vegan + ", ciliaco=" + ciliaco + "]";
	}
	
	
	
	
	
	
	
	
}
