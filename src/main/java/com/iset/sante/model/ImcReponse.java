package com.iset.sante.model;

public class ImcReponse {
	 private String category;
	    private double imc;

	    public ImcReponse() {}

	    public ImcReponse(String category, double imc) {
	        this.category = category;
	        this.imc= imc;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public double getimc() {
	        return imc;
	    }

	    public void setimc(double imc) {
	        this.imc = imc;
	    }
	}


