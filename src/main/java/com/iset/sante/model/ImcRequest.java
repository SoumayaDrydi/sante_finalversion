package com.iset.sante.model;


	public class ImcRequest {

	    private double poids;
	    private double taille;

	    public  ImcRequest() {}

	    public  ImcRequest(double poids, double taille) {
	        this.poids = poids ;
	        this.taille= taille;
	    }

	    public double getpoids () {
	        return poids ;
	    }

	    public void setpoids (double poids ) {
	        this.poids  = poids ;
	    }

	    public double gettaille() {
	        return taille;
	    }

	    public void settaille(double taille) {
	        this.taille = taille;
	    }
	}


