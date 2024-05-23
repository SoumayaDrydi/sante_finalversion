package com.iset.sante.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Profil {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int idprofil; 
	private String nom; 
	private String prenom;
	private int age;
	private String sexe; 
	private float taille ;
	private float poids ;
	private String description ;
	private String password;
    public Profil(int idprofil, String nom, String prenom, int age, String sexe, float taille, float poids, String description) {
        this.idprofil = idprofil;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
        this.taille = taille;
        this.poids = poids;
        this.description = description;
    }
    
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdprofil() {
		return idprofil;
	}

	public void setIdprofil(int idprofil) {
		this.idprofil = idprofil;
	}

	public Profil() {} 

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public float getTaille() {
		return taille;
	}
	public void setTaille(float taille) {
		this.taille = taille;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPoids() {
		return poids;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	 public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}
	@OneToMany(mappedBy = "profil")
	    private List<Activite> activites;
	@ManyToMany
    @JoinTable(
        name = "user_profile_regime",
        joinColumns = @JoinColumn(name = "user_profile_id"),
        inverseJoinColumns = @JoinColumn(name = "regime_id")
    )
    private Set<Regime> regimes = new HashSet<>();
	
	@ManyToMany(mappedBy="profil")

	Collection<Activite> activite;
	public Set<Regime> getRegimes() {
		return regimes;
	}

	public void setRegimes(Set<Regime> regimes) {
		this.regimes = regimes;
	}
	

}

	
	

