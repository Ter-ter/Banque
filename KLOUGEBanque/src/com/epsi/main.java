package com.epsi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	public static void main(String[] args){
	int recommencer = 0; /*Boucle pour recommencer (0 = recommencer & 1 = quitter) */
	int i= 0;
	int k= 0;
	
	//Liste Compte
	List<Compte> listeCompte = new ArrayList<Compte>();
	
	Compte c1 = null;
	Client t1 = null;
	
	int choix = 0; /*Choix Créditer, Débiter, Virer, Afficher le compte*/
	int choix1 = 0; //Crée un compte
	int choix2 = 0; //Créditer
	int choix3 = 0; //Débiter
	int choix4 = 0; //Virer
	int choix5 = 0; //Afficher le solde
	
	double debit = 0;
	
	String nom;
	String prenom;
	int id = 0;
	
	double decMax = 0;
	double depMax = 0;
	double solde = 0;
	
	double sommeCred = 0.0;
	double sommeDeb = 0.0;
	int nbop = 0;
	
	System.out.println("Bienvenue sur l'application de gestion des opérations bancaires");
	
	while(recommencer == 0)
	
	{
		System.out.println("\nTaper 1 pour créer un nouveau compte \n"
	 			+ "Taper 2 pour créditer un compte \n"
	 			+ "Taper 3 pour débiter un compte \n"
	 			+ "Taper 4 pour virer un montant d'un compte vers un autre compte \n"
	 			+ "Taper 5 pour afficher le solde d'un compte \n");
		
		Scanner scanc = new Scanner(System.in);
		choix = scanc.nextInt();
		System.out.println("Vous avez choisi le choix numéro " + choix + "\n");
		
		switch (choix) 
		{
			case 1: // Création d'un compte
			{
				id = id + 1;
				System.out.println("Vous avez choisi de créer un compte \n");
				System.out.println("Vous avez choisi le numéro d'identifiant n°" + id
						  		   + " comme numéro d'identifiant pour ce compte ");
				
				Scanner scanC = new Scanner(System.in);					
				System.out.println("\nSaisir le solde du compte : ");
				solde = scanC.nextDouble();
				System.out.println("\nSaisir le dépôt maximum");
				depMax = scanC.nextDouble();
				System.out.println("\nSaisir la valeur du découvert maximal :");
				decMax = scanC.nextDouble();
				System.out.println("Saisir le nom : ");
				nom = scanC.next();
				System.out.println("\nSaisir le prénom : ");
				prenom = scanC.next();
							
				System.out.println("\n\nRécapitulatif de la création du compte : \n \n" 
							        + "le numéro d'identifiant : " + id + "\n"
							        + "le solde : " + solde + "€ \n"
							        + "Valeur du dépot maximum : " + depMax + "€ \n"
							        + "Valeur du découvert maximum : " + decMax + "€ \n"
							        + "le prénom : " + prenom + "\n" 
							        + "le nom : " + nom + "\n");
				
				System.out.println("Le compte de " + nom + " " + prenom + "1a bien était crée");
				c1 = new Compte(id, solde, depMax, decMax, nom, prenom);
				listeCompte.add(c1);
			}
			break;
			
			case 2: // Créditer un compte
			{
				System.out.println("Vous avez choisi de créditer un compte \n");
				
				for(i = 0; i < listeCompte.size() ; i++) 
				{
					System.out.println("Voici les comptes présent dans la base :");
					System.out.println("\n ID du compte : " + listeCompte.get(i).identifiant
									  + "\n Nom du compte : " + listeCompte.get(i).nom
									  + "\n Prénom du compte : " + listeCompte.get(i).prenom
									  + "\n Solde du compte actuel : " + listeCompte.get(i).solde + "€");
					
					System.out.println("\n Voulez-vous utiliser ce compte ?"
							   + "(Taper 1 pour utiliser ce compte ou autre pour passer au compte suivant)");
					Scanner scanZ = new Scanner(System.in);
					choix1 = scanZ.nextInt();
					
					if(choix1 == 1) 
					{
						System.out.println("Vous avez choisi ce compte");
						System.out.println("\n\nVeuillez taper la somme à créditer : ");
						Scanner scanD = new Scanner(System.in);
						sommeCred = scanD.nextDouble();
						listeCompte.get(i).solde = solde = solde + sommeCred;
						System.out.println("La somme d'argent relié à votre compte est de : " + solde + "€ \n");
					}
					
					nbop = nbop + 1;
				}
			}
			break;
			
			case 3: // Débiter un compte
			{
				System.out.println("Vous avez choisi de débiter un compte \n");
				for(i = 0; i < listeCompte.size() ; i++) 
				{
					System.out.println("Voici les comptes présent dans la base : \n \n");
					System.out.println("ID du compte : " + listeCompte.get(i).identifiant
									  + "\nNom du compte : " + listeCompte.get(i).nom
									  + "\nPrénom du compte : " + listeCompte.get(i).prenom
									  + "\nSolde du compte actuel : " + listeCompte.get(i).solde + "€");
					System.out.println("Voulez-vous utiliser ce compte ???"
									+ "(Taper 1 pour utiliser ce compte ou autre pour passer au compte suivant)");
					
					Scanner scanZ = new Scanner(System.in);
					choix2 = scanZ.nextInt();
		
					if(choix2 == 1)
					{
						System.out.println("\nVeuillez taper la somme à débiter : ");
						Scanner scanO = new Scanner(System.in);
						sommeDeb = scanO.nextDouble();
						
						if(sommeDeb < depMax) 
						{
							listeCompte.get(i).solde = solde = solde - sommeDeb;
							System.out.println("La somme d'argent relié à votre compte est de : " + solde + "€ \n");
						}
						else
						{
							System.out.println("La somme de débit du compte a été dépassé... "
									+ "la somme accepté est de : " + depMax + "€");
						}
					}
					nbop = nbop + 1;
				}
			}
			break;
			
			case 4: // Virer le montant d'un compte vers un autre compte
			{
				
				System.out.println("Vous avez choisi de virer le montant d'un compte vers un autre \n");
				for(i = 0; i < listeCompte.size() ; i++) 
				{
					System.out.println("Voici les comptes présent dans la base : \n");
					System.out.println("ID du compte : " + listeCompte.get(i).identifiant
									  + "\nNom du compte : " + listeCompte.get(i).nom
									  + "\nPrénom du compte : " + listeCompte.get(i).prenom
									  + "\nSolde du compte actuel : " + listeCompte.get(i).solde);
					
					System.out.println("\nVoulez-vous utiliser ce compte ???"
									   + "(Taper 1 pour utiliser ce compte ou autre pour passer au compte suivant)");
					Scanner scanG = new Scanner(System.in);
					choix3 = scanG.nextInt();
					
					if(choix3 == 1) 
					{
						System.out.println("Vous avez choisi de virer le montant du compte n°" 
										   + listeCompte.get(i).identifiant + "\n");
						
						for(k = 0; k < listeCompte.size() ; k++) 
						{
							System.out.println("\n\nVoici les autres comptes présent dans la base : \n");
							System.out.println("ID du compte : " + listeCompte.get(k).identifiant
											  + "\nNom du compte : " + listeCompte.get(k).nom
											  + "\nPrénom du compte : " + listeCompte.get(k).prenom
											  + "\nSolde du compte actuel : " + listeCompte.get(k).solde);
							
							System.out.println("\nVoulez-vous utiliser ce 2ème compte ???"
								   + "(Taper 1 pour utiliser ce compte ou autre pour passer au compte suivant)");
							Scanner scanV = new Scanner(System.in);
							choix3 = scanV.nextInt();
							
							System.out.println("\nLes deux comptes choisi sont les comptes n°" + listeCompte.get(i).identifiant 
											+ "et le compte n°" + listeCompte.get(k).identifiant);
							
							System.out.println("Leurs solde respectif est de : " + listeCompte.get(i).solde 
									+ "€\nPour le compte de : " + listeCompte.get(i).nom + listeCompte.get(i).prenom
									+ "\nEt de : " + listeCompte.get(k).solde 
									+ "€\nPour le compte de :" + listeCompte.get(k).nom + listeCompte.get(k).prenom);
							
							System.out.println("Saisir le montant à virer du 1er au second compte :");
							Scanner scanH = new Scanner(System.in);
							sommeCred = scanH.nextDouble();
							System.out.println("\nLe montant à créditer est de : " + sommeCred + "€" 
												+ "\nSur le compte de :" + listeCompte.get(k).prenom);
							
							listeCompte.get(k).solde = solde = solde + sommeCred;
							
							System.out.println("La somme d'argent relié dorénavant à votre compte est de : " 
												+ listeCompte.get(k).solde + "€ \n");
							
							System.out.println("Le solde du compte de : " + listeCompte.get(i).nom 
												+ "est de :" + listeCompte.get(k).solde + "€");
						}					
					} // Passage à un autre compte  
				}
			}
			break;
			
			case 5 : // Affiche le solde d'un compte (titulaire, nb ope (dep et retrait)
			{
				System.out.println("Vous avez choisi d'afficher le solde d'un compte \n");
				
				for(int j = 0 ;  j < listeCompte.size() ; j++) 
				{
					System.out.println("Voici les comptes présent dans la base :");
					System.out.println("ID du compte : " + listeCompte.get(j).identifiant);
					System.out.println("Voulez-vous voir le solde de ce compte ???"
								   + "(Taper 1 pour utiliser ce compte ou autre pour passer au compte suivant)");
					Scanner scanG = new Scanner(System.in);
					choix5 = scanG.nextInt();
						
					if(choix5 == 1)
					{	
						System.out.println("Voici les différentes informations à afficher :\n");
						System.out.println("Son titulaire : " + listeCompte.get(j).nom);
						System.out.println("Son solde actuel : " + listeCompte.get(j).solde);
						System.out.println("Le nombre d'opération effectué : " + nbop + "(s)");
					}
				}
			}
			break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choix);
		}
		System.out.println("\n Pour recommencer taper 0 sinon taper 1");
		Scanner scanrec = new Scanner(System.in);
		recommencer = scanrec.nextInt();
		}		
	}
}
