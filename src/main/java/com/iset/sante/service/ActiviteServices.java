// ActiviteServices.java
package com.iset.sante.service;

import java.util.List;

import com.iset.sante.entities.Activite;


public interface ActiviteServices {
	Activite saveActivite(Activite activite);
  
   
    List<Activite> getAllActivites();
    Activite updateActivite(Activite p); 
	void deleteActivite(Activite p); 
	void deleteActiviteById(int id); 
	Activite getActivite(int id); 
	 
	Activite findById(int id);
	void ajouterActivite(int profilId, Activite activite);
}
