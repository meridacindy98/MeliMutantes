package com.MeliMutantes.model;

public class DnaSequence {

	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	@Override
	public String toString() {
		return "DnaSequence [ dna = " + dna + " ]";
	}

}
