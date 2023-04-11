package application;
import elements.*;

import java.util.ArrayList;

public class Application {
	public static void main(String [ ]args) {
		
		Menage C1;
		Dechet De;
		Dechet De2;
		Depot D1;
		Compte Compte;
		
		Compte=new Compte(12, "Gazou?", "password");
		
		De=new Dechet("jaune", 15, "Boite carton");
		De2=new Dechet("verte", 40, "Vodka");
		
		C1= new Menage(12, "Henri", "Durand", "12-10-2021", "15 rue lachette", Compte);
		D1 = new Depot("hier", "15:01", C1);
		
		D1.ajouter(De,120);
		D1.ajouter(De2, 150);
		
		D1.aff_listedechets();
		
		C1.ajouterDepot(D1);


	}
}
