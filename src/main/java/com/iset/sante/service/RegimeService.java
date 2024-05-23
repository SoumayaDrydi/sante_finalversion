package com.iset.sante.service;

import java.util.List;

import com.iset.sante.entities.Profil;
import com.iset.sante.entities.Regime;
import com.iset.sante.entities.TypeRegime;

public interface RegimeService {
	Regime saveRegime(Regime r); 
	 Regime updateRegime(Regime  r); 
	void deleteRegime(Regime  r); 
	void deleteRegimeById(Integer id); 
	 Regime getRegime(Integer id); 
	 List<Regime> getAllRegimes();
	 

	     
	  
	 List<Regime> getRegimesByType(TypeRegime type);
	 Profil addUserRegime(int userProfileId, int regimeId);
}