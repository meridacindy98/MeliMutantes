package com.MeliMutantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MeliMutantes.model.DnaSequence;
import com.MeliMutantes.service.MutantService;

@RestController
public class MutantController {

	@Autowired
	private MutantService mutantService;

	@PostMapping(path = "/mutant", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> isMutant(@RequestBody DnaSequence dna) {

		try {
			if (mutantService.analyzeDna(dna.getDna())) {
				return ResponseEntity.ok("OK");
			} else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			}
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}		
	
	}

}
