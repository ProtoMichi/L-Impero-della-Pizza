package it.uniroma3.siw.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recensione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private LocalDate dataCreazione;
	private Float stelle;
	
	public Recensione(Long id, String descrizione, LocalDate dataCreazione, Float stelle) {
		this.id = id;
		this.descrizione = descrizione;
		this.dataCreazione = dataCreazione;
		this.stelle = stelle;
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
	public LocalDate getCreazione() {
		return dataCreazione;
	}
	public void setCreazione(LocalDate creazione) {
		this.dataCreazione = creazione;
	}
	public Float getStelle() {
		return stelle;
	}
	public void setStelle(Float stelle) {
		this.stelle = stelle;
	}
	
	public boolean equals(Object o) {
		if(o == null) return false;
		Recensione that = (Recensione)o;
		return this.getId().equals(that.getId());
	}
	
	public String toString() {
		return this.getCreazione() + "\n\n" + this.getDescrizione() + "\n\n" + this.getStelle();
	}
	
	
}
