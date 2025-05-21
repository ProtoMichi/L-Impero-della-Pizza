package it.uniroma3.siw.model;

import java.time.LocalDate;

public class Recensione {
	
	private String codice;
	private String descrizione;
	private LocalDate dataCreazione;
	private Float stelle;
	
	public Recensione(String codice, String descrizione, LocalDate dataCreazione, Float stelle) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.dataCreazione = dataCreazione;
		this.stelle = stelle;
	}
	
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
		return this.getCodice().equals(that.getCodice());
	}
	
	public String toString() {
		return this.getCreazione() + "\n\n" + this.getDescrizione() + "\n\n" + this.getStelle();
	}
	
	
}
