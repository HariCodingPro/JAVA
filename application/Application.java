package application;
import elements.*;

import java.util.ArrayList;

public class Application {
	public static void main(String [ ]args) {
		
		Menage C1;
		Menage C2;
		Dechet De;
		Dechet De2;
		Depot D1;
		Depot D2;
		Compte Compte;
		Poubelle P1;
		Poubelle.TypeDechet dechet=Poubelle.TypeDechet.Verre;
		

		//Création d'un compte
		Compte=new Compte(12, "Gazou?", "password");
		
		//Création de 2 déchets
		De=new Dechet("carton", 15, "Boite carton");
		De2=new Dechet("verre", 40, "Vodka");
		
		//Création d'un ménage
		C1= new Menage(12, "Henri", "Durand", "12-10-2021", "15 rue lachette", Compte);
		C2= new Menage(17, "Didier", "Bg", "12-08-2021", "15 rue lavend", Compte);
		
		P1=new Poubelle(1, "Pas loin",dechet, "Place de la poubelle", 100);
		
		//Création de 2 dépots différents
		D1 = new Depot("2020/10/10", "15:01",P1,  C1);
		D2 = new Depot("2027/10/10", "15:01",P1,  C2);
		
		//Ajout de 2 déchets au 1er dépot
		D1.ajouter(De,120);
		D1.ajouter(De2, 150);
		
		//idem pour le 2e depot
		D2.ajouter(De,10);
		D2.ajouter(De2, 150);
		
		//Ajout du dépot au ménage
		C1.ajouterDepot(D1);
		C2.ajouterDepot(D2);
		
		//Ajout du dépot à la poubelle
		P1.ajouterDepot(D1);
		P1.ajouterDepot(D2);
		
		///D1.garderInfosDepot();
		//D1.aff_listedechets();

		P1.afficherDepots();
		
		D1.aff_listedechets();


	}
}
