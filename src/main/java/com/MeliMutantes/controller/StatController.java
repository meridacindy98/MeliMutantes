package com.MeliMutantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MeliMutantes.model.Stat;
import com.MeliMutantes.service.StatService;

@RestController
public class StatController {
	
	@Autowired
	private StatService statService;
	
	@GetMapping("/stats")
	public ResponseEntity<Stat> getStats() {
		return new ResponseEntity<>(statService.calculateStat(), HttpStatus.OK);
	}
	
}
