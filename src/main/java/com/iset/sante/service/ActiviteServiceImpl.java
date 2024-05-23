// ActiviteServiceImpl.java
package com.iset.sante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iset.sante.dao.ActiviteRepository;
import com.iset.sante.dao.ProfilRepository;
import com.iset.sante.entities.Activite;
import com.iset.sante.entities.Profil;

import jakarta.transaction.Transactional;

@Service
public class ActiviteServiceImpl implements ActiviteServices {
    @Autowired
    private ActiviteRepository activiteRepository;
	private ProfilRepository profilRepository;
	@Override
	public  Activite saveActivite( Activite  activite) {
		return activiteRepository.save(activite);
	}



    @Override
    @Transactional
    public void ajouterActivite(int profilId, Activite activite) {
        Profil profil = profilRepository.findById(profilId)
                .orElseThrow(() -> new IllegalArgumentException("Profil non trouvé avec l'ID: " + profilId));
        activite.setProfil1(profil);
        profil.getActivites().add(activite);

        activiteRepository.save(activite);
    }

   
    @Override
    public List<Activite> getAllActivites() {
        return activiteRepository.findAll();
    }
    @Override
	public Activite updateActivite(Activite p) { 
	 return activiteRepository.save(p); 
	 } 
	@Override
	public void deleteActivite(Activite p) { 
		activiteRepository.delete(p); 
	 
	 } 
	@Override
	public void deleteActiviteById(int id) { 
		activiteRepository.deleteById(id);}

	@Override
	public Activite getActivite(int id) { 
	 return activiteRepository.findById(id).get(); 
	 } 
	 @Override
	    public Activite findById(int id) {
	        return activiteRepository.findById(id).orElse(null);
	    }

  
}
