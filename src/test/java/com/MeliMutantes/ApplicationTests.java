package com.MeliMutantes;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.MeliMutantes.service.MutantService;
import com.MeliMutantes.service.StatService;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private MutantService mutantService;	

	@Test
	public void isMutantTrue() {
		
		List<String[]> mutantTestTrue = makeMutanTestTrue();
		
		for( String[] dna : mutantTestTrue ) {
			assertTrue(mutantService.analyzeDna(dna));
		}			
				
	}
	
	@Test
	public void isMutantFalse() {
		List<String[]> mutantTestFalse = makeMutanTestFalse();

		for (String[] dna : mutantTestFalse) {
			assertFalse(mutantService.analyzeDna(dna));
		}
	}
	
	@Test
	public void isFormatDnaRowWrong() {
		String [] dna = new String[]  {"ATGATCTA",
									   "CTATGGGG",
									   "CTAGCAAT"} ;

		assertThatThrownBy(() -> mutantService.analyzeDna(dna)).isInstanceOf(IllegalArgumentException.class)
		.hasMessage("Invalid dna. The length and height must be bigger than 3 and equals.");
	}
		
	@Test
	public void isFormatDnaColWrong() {
		String [] dna = new String[]  {"ATG",
									   "CTAT",
									   "CTAG",
									   "ATGA"} ;

		assertThatThrownBy(() -> mutantService.analyzeDna(dna)).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Invalid dna. The length and height must be bigger than 3 and equals.");
	}	
	
	@Test
	public void rowsAndColumnsNoEquals() {
		String [] dna = new String[]  {"ATGA",
									   "CTATGGGG",
									   "CTAGCAAT",
									   "ATGATCTA"} ;

		assertThatThrownBy(() -> mutantService.analyzeDna(dna)).isInstanceOf(IllegalArgumentException.class)
		.hasMessage("Invalid dna. The length and height must be bigger than 3 and equals.");
	}	
	
	@Test
	public void dnaErrorNumber() {
		String [] dna = new String[]  {"ATGAAA12",
									   "CTATGGGG",
									   "CTAGCAAT",
									   "ATGATCTA"} ;

		assertThatThrownBy(() -> mutantService.analyzeDna(dna)).isInstanceOf(IllegalArgumentException.class)
		.hasMessage("Invalid dna. The DNA sequence must be conformed by the values A, T, C or G only.");
	}	
	
	@Test
	public void dnaNull() {
		assertThatThrownBy(() -> mutantService.analyzeDna(null)).isInstanceOf(IllegalArgumentException.class)
		.hasMessage("Dna null.");
	}	
	
	
	private List<String[]> makeMutanTestTrue(){
		List<String[]> mutantTest = new ArrayList<String[]>();
		
		//8x8
		mutantTest.add( new String[]  {"ATGATCTA",
									   "CTATGGGG",
									   "CTAGCAAT",
									   "CTAATGCT",
									   "GAAGTAGC",
									   "AGGGTTAT",
									   "ATGGGTAA",
									   "ACAGGTAA"} );
		
		//7x7
		mutantTest.add( new String[]  {"ATGATCTA",
									   "CTATGGGG",
									   "CTAGCAAT",
									   "CTAATGCT",
									   "GAAGTAGC",
									   "AGGGTTAT",
									   "ATGGGTAA",
									   "ACAGGTAA"} );
		
		//4x4
		mutantTest.add( new String[]  {"ATGA",
									   "CAAT",
									   "CAAG",
									   "ATAA"} );
		
		return mutantTest;
	}
	
	private List<String[]> makeMutanTestFalse() {
		List<String[]> mutantTest = new ArrayList<String[]>();
		
		//7x7
		mutantTest.add( new String[]  {"ATCGATC",
									   "TGCATGC",
									   "ATCGATA",
									   "TGCATGC",
									   "ATCGATA",
									   "TGCATGC",
									   "ATCGATC"} );
		//8x8
		mutantTest.add( new String[]  {"ATCGATCG",
									   "TGCATGAA",
									   "ATAGATCG",
									   "TGCATGAA",
									   "ATCGATCG",
									   "TGAATGAA",
									   "ATCGATCG",
									   "TGCATGCA"} );
		

		
		//4x4
		mutantTest.add( new String[]  {"ATGA",
									   "CATT",
									   "CAAG",
									   "ATAA"} );		

		return mutantTest;
			
	}
}
