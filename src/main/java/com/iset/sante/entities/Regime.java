package com.iset.sante.entities;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
@Entity
public class Regime {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idregime")
	private int idregime;
	
	 @ElementCollection
	    private List<String> descriptions;
	 public List<String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	@Enumerated(EnumType.STRING)
	    private TypeRegime typeregime;
	public Regime() {}

	public int getIdregime() {
		return idregime;
	}
	public void setIdregime(int idregime) {
		this.idregime = idregime;
	}
	
	@ManyToMany(mappedBy = "regimes")
    private Set<Profil> Profil = new HashSet<>();
	public TypeRegime getTyperegime() {
		return typeregime;
	}

	public void setTyperegime(TypeRegime typeregime) {
		this.typeregime = typeregime;
	}
	
}
