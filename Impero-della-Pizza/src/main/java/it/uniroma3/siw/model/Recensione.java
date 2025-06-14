package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Recensione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descrizione;
	
	@Column(name = "data_di_creazione", length = 2000)
	private LocalDate dataCreazione;
	
	@Column(nullable = false)
	@Min(0)
	@Max(5)
	@NotNull
	private Float stelle;
	@ManyToOne()
	private Pizza pizza;
	@ManyToOne
    private Credentials autore;

	
	public Recensione() {
		
	}
	
	public Recensione(Long id, String descrizione, LocalDate dataCreazione, Float stelle) {
		this.id = id;
		this.descrizione = descrizione;
		this.dataCreazione = dataCreazione;
		this.stelle = stelle;
	}
	
	public LocalDate getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Float getStelle() {
		return stelle;
	}
	public void setStelle(Float stelle) {
		this.stelle = stelle;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Credentials getAutore() {
		return autore;
	}

	public void setAutore(Credentials autore) {
		this.autore = autore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDataCreazione(), descrizione);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recensione other = (Recensione) obj;
		return Objects.equals(getDataCreazione(), other.getDataCreazione()) && Objects.equals(descrizione, other.descrizione);
	}

	@Override
	public String toString() {
		return "Recensione [id=" + id + ", descrizione=" + descrizione + ", dataCreazione=" + getDataCreazione()
				+ ", stelle=" + stelle + "]";
	}
	
	
	
}
