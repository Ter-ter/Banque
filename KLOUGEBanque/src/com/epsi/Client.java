package com.epsi;

public class Client extends Compte{
	
	public String nomT;
	public String prenomT;
	public int numT;
	
	public Client(double identifiant, double solde, double depMax, double decMax,
	String prenom, String nom, String nomT, String prenomT, String numT) {
		super (identifiant, solde, depMax, decMax, prenom, nom);
		this.nomT = nomT;
		this.prenomT = prenomT;
	}
	
	public String getnomT() {
		return nomT;
	}
	
	public void setnomT(String nomT) {
		this.nomT = nomT;
	}
	
	public String getprenomT() {
		return prenomT;
	}
	
	public void setprenomT(String prenomT) {
		this.prenomT = prenomT;
	}
	
	public int getnumT() {
		return numT;
	}
	
	public void setnumT() {
	}
}
