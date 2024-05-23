// Activite.java
package com.iset.sante.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActivite;
    private String typeActivite;
    String description;
   


   

    public Activite(int idActivite, String typeActivite, String description) {
		super();
		this.idActivite = idActivite;
		this.typeActivite = typeActivite;
		this.description = description;
	}
    

	public Activite() {
		super();
	}
	public int getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public String getTypeActivite() {
        return typeActivite;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
    }

   
    public Profil getProfil1() {
		return profil1;
	}


	public void setProfil1(Profil profil1) {
		this.profil1 = profil1;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@ManyToOne
    @JoinColumn(name = "profil_id")
    private Profil profil1;
    
	@ManyToMany
    @JoinTable(
            name = "profil_Activite",
            joinColumns = @JoinColumn(name = "idActivite"),
            inverseJoinColumns = @JoinColumn(name = "idprofil")
    )
    Collection<Profil> profil;


}
