package com.MeliMutantes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MeliMutantes.dao.DnaDao;
import com.MeliMutantes.model.Stat;
import com.MeliMutantes.service.StatService;

@Service
public class StatServiceImpl implements StatService {

	@Autowired
	private DnaDao dnaDao;

	public Stat calculateStat() {		
		
		long dnaMutant = dnaDao.countByIsMutant(true);
		long dnaHuman = dnaDao.countByIsMutant(false);

		return new Stat(dnaMutant, dnaHuman, calculateRatio(dnaMutant, dnaHuman));
	}

	private float calculateRatio(long dnaMutant, long dnaHuman) {
		if (dnaMutant == 0 && dnaHuman == 0)
			return 0;
		if (dnaHuman == 0)
			return 1;
		return (float) dnaMutant / dnaHuman;
	}

}
