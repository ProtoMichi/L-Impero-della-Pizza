package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(dataCreazione, descrizione);
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
		return Objects.equals(dataCreazione, other.dataCreazione) && Objects.equals(descrizione, other.descrizione);
	}

	@Override
	public String toString() {
		return "Recensione [id=" + id + ", descrizione=" + descrizione + ", dataCreazione=" + dataCreazione
				+ ", stelle=" + stelle + "]";
	}
	
	
}
