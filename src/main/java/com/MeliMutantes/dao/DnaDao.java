package com.MeliMutantes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MeliMutantes.entity.Dna;

@Repository
public interface DnaDao extends JpaRepository<Dna, Integer>{
	Dna findByDna(String dna);
	int countByIsMutant(boolean isMutant);
}
