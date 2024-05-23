package com.iset.sante.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Communication {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int idcommunication;
	private String Acteur;
	private String avis_personnel;
	public Communication() {}
	
	
	
	public Communication(int idcommunication, String acteur, String avis_personnel) {
		super();
		this.idcommunication = idcommunication;
		Acteur = acteur;
		this.avis_personnel = avis_personnel;
	}



	public int getIdcommunication() {
		return idcommunication;
	}



	


	public void setIdcommunication(int idcommunication) {
		this.idcommunication = idcommunication;
	}



	public String getActeur() {
		return Acteur;
	}



	public void setActeur(String acteur) {
		Acteur = acteur;
	}



	public String getAvis_personnel() {
		return avis_personnel;
	}
	public void setAvis_personnel(String avis_personnel) {
		this.avis_personnel = avis_personnel;
	}
	
	

}
