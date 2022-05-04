package com.epsi;

public class Compte {
	public double identifiant;
	public double solde;
	public double depMax;
	public double decMax;
	public String nom;
	public String prenom;
	
	public Compte(double identifiant, double solde, double depMax, double decMax, String prenom, String nom) {
		super();
		this.identifiant = identifiant; //Identifiant Unique
		this.solde = solde; //Solde du compte
		this.depMax = depMax; //Depôt max
		this.decMax = decMax; //Découvert Max
		this.nom = nom; //Nom du client
		this.prenom = prenom; //Prénom du client
	}
	
	public double getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(double identifiant) {
		this.identifiant = identifiant;
	}
	
	public double getsolde() {
		return solde;
	}
	
	public void setsolde(double solde) {
		this.solde =solde;
	}
	
	public double getdepMax() {
		return depMax;
	}
		
	public void setdepMax(double depMax) {
		this.depMax = depMax;
	}
	
	public double getdecMax() {
		return decMax;
	}
	
	public void setdecMax(double decMax) {
		this.decMax = decMax;
	}
	
	public String getnom() {
		return nom;
	}
	
	public void setnom(String nom) {
		this.nom = nom;
	}
	
	public String getprenom() {
		return prenom;
	}
	
	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
}
