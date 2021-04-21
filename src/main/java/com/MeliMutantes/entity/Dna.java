package com.MeliMutantes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "dna")
public class Dna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dna;
	
	//@Column(name="is_mutant")
	private boolean isMutant;

	public Dna() {}

	public Dna(String dna, boolean isMutant) {
		this.dna = dna;
		this.isMutant = isMutant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDna() {
		return dna;
	}

	public void setDna(String dna) {
		this.dna = dna;
	}

	public boolean isMutant() {
		return isMutant;
	}

	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}

}
