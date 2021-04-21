package com.MeliMutantes.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MeliMutantes.dao.DnaDao;
import com.MeliMutantes.entity.Dna;
import com.MeliMutantes.service.MutantService;

@Service
public class MutantServiceImpl implements MutantService {

	private static final Logger log = LoggerFactory.getLogger(MutantService.class);
	private static final List<String> DNA = Arrays.asList("AAAA", "CCCC", "GGGG", "TTTT");
	
	@Autowired
	private DnaDao dnaDao;
	
	public boolean analyzeDna(String[] dna) {

			boolean isMutant = isMutant(dna);		
			String stringDna = Arrays.stream(dna).collect(Collectors.joining(""));
			
			if (dnaDao.findByDna(stringDna) == null) {
				dnaDao.save( new Dna(stringDna, isMutant) );
				log.info("Saved dna" );
			} else {
	            log.info("Dna already exist in the data base");
			}		

			return isMutant;
		
	}
	
	public boolean validateDna(String[] dna) {

		long rows = Arrays.stream(dna).count();
		boolean columns = Arrays.stream(dna).allMatch(row -> row.length() >= 4 && row.length() == rows);
		
		if (rows >= 4 && columns) {
			return true;
		}
		
		log.info("Error Dna format. The length and height must be bigger than 3.");
		return false;
	}

	private boolean isMutant(String[] dna) {
		
		int countDnaMutant = 0;

		for (String iteamDNA : DNA) {

			countDnaMutant += Arrays.asList(dna).stream().filter(word -> word.contains(iteamDNA))
					.collect(Collectors.toList()).size();
			if (countDnaMutant > 1)
				return true;

			countDnaMutant += GetWordsVertical(dna).stream().filter(word -> word.contains(iteamDNA))
					.collect(Collectors.toList()).size();
			if (countDnaMutant > 1)
				return true;

			countDnaMutant += GetWordsDiagonalTopLeftRight(dna).stream().filter(word -> word.contains(iteamDNA))
					.collect(Collectors.toList()).size();
			if (countDnaMutant > 1)
				return true;

			countDnaMutant += GetWordsDiagonalBottomLeftRight(dna).stream().filter(word -> word.contains(iteamDNA))
					.collect(Collectors.toList()).size();
			if (countDnaMutant > 1)
				return true;

		}

		return countDnaMutant > 1;
	}

	private List<String> GetWordsVertical(String[] dna) {

		List<String> wordsVertical = new ArrayList<String>();

		for (int row = 0; row < dna.length; row++) {

			StringBuilder word = new StringBuilder(dna.length);

			for (int column = 0; column < dna.length; column++) {
				word.append(dna[column].charAt(row));
			}

			wordsVertical.add(word.toString());
		}
		return wordsVertical;

	}

	private List<String> GetWordsDiagonalTopLeftRight(String[] dna) {

		List<String> wordsDiagonal = new ArrayList<String>();

		for (int i = 0; i < dna.length; i++) {
			StringBuilder wordOblique1 = new StringBuilder(dna.length);
			StringBuilder wordOblique2 = new StringBuilder(dna.length);

			for (int j = 0; j < dna.length - i; j++) {
				wordOblique1.append(dna[j].charAt(j + i));

				if (i != 0) {
					wordOblique2.append(dna[i + j].charAt(j));
				}
			}

			if (wordOblique1.toString().length() > 3 || wordOblique2.toString().length() > 3) {
				if (wordOblique1.length() > 0) {
					wordsDiagonal.add(wordOblique1.toString());
				}

				if (wordOblique2.length() > 0) {
					wordsDiagonal.add(wordOblique2.toString());
				}
			}

		}
		return wordsDiagonal;

	}

	private List<String> GetWordsDiagonalBottomLeftRight(String[] dna) {

		List<String> wordsDiagonal = new ArrayList<String>();

		for (int i = 0; i < dna.length; i++) {
			StringBuilder wordOblique1 = new StringBuilder(dna.length);
			StringBuilder wordOblique2 = new StringBuilder(dna.length);

			for (int j = dna.length - 1; j >= i; j--) {
				wordOblique1.append(dna[j].charAt(i + dna.length - 1 - j));

				if (i != 0) {
					wordOblique2.append(dna[j - 1].charAt(dna.length - 1 - j));
				}
			}

			if (wordOblique1.toString().length() > 3 || wordOblique2.toString().length() > 3) {
				if (wordOblique1.length() > 0) {
					wordsDiagonal.add(wordOblique1.toString());
				}

				if (wordOblique2.length() > 0) {
					wordsDiagonal.add(wordOblique2.toString());
				}
			}

		}
		return wordsDiagonal;

	}

}
