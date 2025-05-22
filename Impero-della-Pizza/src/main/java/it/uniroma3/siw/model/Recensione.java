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
	private String codice;
	private String descrizione;
	private LocalDate creazione;
	private Float stelle;
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public LocalDate getCreazione() {
		return creazione;
	}
	public void setCreazione(LocalDate creazione) {
		this.creazione = creazione;
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
		return this.getCodice().equals(that.getCodice());
	}
	
	public String toString() {
		return this.getCreazione() + "\n\n" + this.getDescrizione() + "\n\n" + this.getStelle();
	}
	
	
}
