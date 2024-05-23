package com.iset.sante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iset.sante.dao.ProfilRepository;
import com.iset.sante.dao.RegimeRepository;
import com.iset.sante.entities.Profil;
import com.iset.sante.entities.Regime;
import com.iset.sante.entities.TypeRegime;
import com.iset.sante.service.RegimeService;


@Service
public class RegimeServiceImpl implements RegimeService {
	@Autowired
	 RegimeRepository regimeRepository; 
	ProfilRepository profilRepository;
	 @Override
	    public Profil addUserRegime(int userProfileId, int regimeId) {
	        Profil userProfile = profilRepository.findById(userProfileId)
	                .orElseThrow(() -> new RuntimeException("User profile not found"));
	        Regime regime = regimeRepository.findById(regimeId)
	                .orElseThrow(() -> new RuntimeException("Regime not found"));
	        userProfile.getRegimes().add(regime);
	        return profilRepository.save(userProfile);
	    }
	@Override
	public Regime saveRegime(Regime r) { 
	 return regimeRepository.save(r); 
	 } 
	@Override
	public Regime updateRegime(Regime r) { 
	 return regimeRepository.save(r); 
	 } 
	@Override
	public void deleteRegime(Regime r) { 
	 regimeRepository.delete(r); 
	 
	 
	 } 
	@Override
	public void deleteRegimeById(Integer id) { 
	 regimeRepository.deleteById(id);
}
	@Override
	public Regime getRegime(Integer id) { 
	 return regimeRepository.findById(id).get(); 
	 } 
	@Override
	public List<Regime> getAllRegimes() { 
	 
	 return regimeRepository.findAll(); 
	 }

	   
	 
	    
	    // Autres méthodes du service...

	    @Override
	    public List<Regime> getRegimesByType(TypeRegime type) {
	        return regimeRepository.findByTyperegime(type);
	    }
}
