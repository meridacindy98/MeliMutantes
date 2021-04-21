package com.MeliMutantes;

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

	   assertFalse(mutantService.analyzeDna(dna));
	}
		
	@Test
	public void isFormatDnaColWrong() {
		String [] dna = new String[]  {"ATG",
									   "CTATGGGG",
									   "CTAGCAAT",
									   "ATGATCTA"} ;

	   assertFalse(mutantService.analyzeDna(dna));
	}	
	
	@Test
	public void rowsAndColumnsNoEquals() {
		String [] dna = new String[]  {"ATGA",
									   "CTATGGGG",
									   "CTAGCAAT",
									   "ATGATCTA"} ;

	   assertFalse(mutantService.analyzeDna(dna));
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
