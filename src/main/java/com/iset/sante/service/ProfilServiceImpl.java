package com.iset.sante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.iset.sante.dao.ProfilRepository;
import com.iset.sante.entities.Profil;
@Service
public class ProfilServiceImpl  implements ProfilService{
	@Autowired
	ProfilRepository  profilRepository ;
	@Override
	public Profil saveProfil(Profil p) {
		return profilRepository.save(p);
	}
	@Override
	public Profil updateProfil(Profil p) { 
	 return profilRepository.save(p); 
	 } 
	@Override
	public void deleteProfil(Profil p) { 
		profilRepository.delete(p); 
	 
	 } 
	@Override
	public void deleteProfilById(int id) { 
		profilRepository.deleteById(id);
}
	@Override
	public Profil getProfil(int id) { 
	 return profilRepository.findById(id).get(); 
	 } 
	@Override
	public List<Profil> getAllProfils() { 
	 
	 return profilRepository.findAll(); 
	 }
	 @Override
	    public Profil findById(int id) {
	        return profilRepository.findById(id).orElse(null);
	    }
	 @Override
	    public Profil findByNom(String nom) {
	        return profilRepository.findByNom(nom);
	    }
}
