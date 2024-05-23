package com.iset.sante.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iset.sante.entities.Profil;

public interface ProfilRepository extends JpaRepository<Profil, Integer> {
	 Profil findByNom(String nom);
}
