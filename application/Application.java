package application;
import elements.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Application {
	public static void main(String [ ]args) {
		
		Menage C1;
		Menage C2;
		Depot D1;
		Depot D2;
		Compte Compte;
		Poubelle P1, P2,P3;

		
		 Scanner read = new Scanner(System.in);
		 String valstr;
		 int valint;
		
		Dechet d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;
		d1 = new Dechet("carton", 0.4, "enveloppe");
		d2 = new Dechet("carton", 5, "emballage");
		d3 = new Dechet("plastique", 8, "bouteille");
		d4 = new Dechet("plastique", 1, "gobelet");
		d5 = new Dechet("plastique", 12, "yaourt");
		d6 = new Dechet("verre", 14, "vodka");
		d7 = new Dechet("verre", 6, "bière");
		d8 = new Dechet("verre", 0.7, "moutarde");
		d9 = new Dechet("metal", 4.5, "cannette");
		d10 = new Dechet("metal", 9, "conserve");
		
		
		
		//Création d'un ménage lié à un compte
		Compte=new Compte(12, "Gazou?", "password");
		C1= new Menage(12, "Henri", "Durand", "12-10-2021", "15 rue lachette", Compte);
		C2= new Menage(17, "Didier", "Bg", "12-08-2021", "15 rue lavend", Compte);
		

		CentreTri Ct[]=new CentreTri[3];
		
		Ct[0]=new CentreTri(12,"Tri Center", "5 rue dijon","Paris",75000);
		Ct[1]=new CentreTri(14,"Palace Tri", "5 rue pouillon","Marseille",15000);
		Ct[2]=new CentreTri(120,"The Place to Tri", "5 rue cergy?","Lyon",23000);
		
		P1=new Poubelle(1, Ct[0],"verre", "La musareigne","Paris",  0, 2000);
		P2=new Poubelle(2, Ct[0],"carton", "La musareigne","Paris",  0, 2000);
		P3=new Poubelle(3, Ct[0],"carton", "Porto","Paris",  0, 1000);
		
		Ct[0].ajouterPoubellesExistante(P1);
		Ct[0].ajouterPoubellesExistante(P2);
		Ct[0].ajouterPoubellesExistante(P3);

		int quit=1;

		
		//=============================== MAIN LOOP ===============================
		while(quit != 0) {
			System.out.println("==== BIENVENUE SUR CY POUBELLE  ====\n");
			System.out.println("Où êtes-vous ?");
			for(int i=0;i<Ct.length;i++) {
				System.out.println(i+"/ "+Ct[i].getVille()+" ("+Ct[i].getNom()+")");
			}
			
			System.out.print("Choix (num) : ");
			valint=read.nextInt(); //CHOIX Cdt
			
			
			
			//Faire requette de poubelle s????
			if(Ct[valint].getNbPoubelles()==0) {
				boolean free=true;
				while(free) {
					System.out.println("Création d'une poubelle : ");
					Ct[valint].ajouterPoubelles();
					
					System.out.println("Fin de la création ? O/n: ");
					valstr=read.next();
					System.out.println(valstr+"\n");
					
					if(valstr.equals("O")) {
						free=false;
						break;
					}

				}
				
			}
			
			
			System.out.println("\n=== Choix de la poubelle ===");
			Ct[valint].afficherPoubelles();
			System.out.print("Choix : ");
			int valpb=read.nextInt();
			
			System.out.println("Vous avez choisi : "+Ct[valint].getPoubelle(valpb-1).getTypedechets()+" à "+Ct[valint].getPoubelle(valpb-1).getEmplacement());

			
			//FAIRE UN DEPOT, verifier poids, ajouter points etc.
			
			

			System.out.println("Quitter ? O/n");
			valstr=read.next();
			if(valstr.equals("O")) {
				quit=0;
			
			}
		}






		/*
		//Création de 2 dépots différents
		D1 = new Depot("2020/10/10", "15:01",P1,  C1);
		D2 = new Depot("2027/10/10", "15:01",P1,  C2);
		
		//Demander cb de dechet à mettre
		//Ajout de 2 déchets au 1er dépot
		D1.ajouter_dechet(d2,120);
		D1.ajouter_dechet(d7, 150);
		
	
		//Ajout du dépot au ménage
		C1.ajouterDepot(D1);
	
		C2.ajouterDepot(D2);
		
		//Ajout du dépot à la poubelle
		P1.ajouterDepot(D1);
		P1.ajouterDepot(D2);
		
		///D1.garderInfosDepot();
		//D1.aff_listedechets();*/

		
		

		/*if(D1.calculerPoidsDepot()+P1.getPoidsActuel() > P1.getQteMax()) {
			System.out.print("TROP lourd");
		}
		
		else {
		
			P1.setPoidsActuel(D1.calculerPoidsDepot()+P1.getPoidsActuel() );
			
		}*/
		
	

	}

}
