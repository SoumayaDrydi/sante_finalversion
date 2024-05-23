package com.iset.sante.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.iset.sante.entities.Profil;

@Service
public interface ProfilService {
	Profil saveProfil(Profil p);
	Profil updateProfil(Profil p); 
	void deleteProfil(Profil p); 
	void deleteProfilById(int id); 
	Profil getProfil(int id); 
	 List<Profil> getAllProfils();
	 Profil findById(int id);
	 Profil findByNom(String nom);
}
