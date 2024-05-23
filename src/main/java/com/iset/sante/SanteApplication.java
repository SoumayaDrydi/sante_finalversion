package com.iset.sante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iset.sante.entities.Activite;
import com.iset.sante.entities.Profil;
import com.iset.sante.service.ActiviteServiceImpl;
import com.iset.sante.service.ProfilServiceImpl;
import com.iset.sante.service.RegimeServiceImpl;

@SpringBootApplication

public class SanteApplication implements CommandLineRunner{
	@Autowired
	private ProfilServiceImpl profilServiceImpl;
	private RegimeServiceImpl regime; 
	public static void main(String[] args) {
		SpringApplication.run(SanteApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception { 
	 // TODO Auto-generated method stub
		//Profil pro1=new Profil(1,"guedda","feriel",23,"femme",165.0f,55.0f,"je cherche une régime");
		//profilServiceImpl.saveProfil(pro1);
		// Regime reg  = new Regime(1,"saladde"); 
		// regime.saveRegime(reg);
	
}
}
