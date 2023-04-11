package elements;

import java.util.ArrayList;

public class Menage extends Personne{
	
	private ArrayList<Depot> mesDepots=new ArrayList<Depot>();

	
	public Menage() {
		super();
	}


	public Menage(int id, String prenom, String nom, String ddn, String adresse, Compte compte) {
		super(id, prenom, nom, ddn, adresse, compte);
		// TODO Auto-generated constructor stub
	}

	public void ajouterDepot(Depot d) {
		mesDepots.add(d);
	}
	
	public void supprimerDepot(Depot d) {
		if(mesDepots.contains(d)) {
			mesDepots.remove(d);
		}
		
		else {
			System.out.println("Ce depot est inexistant");
		}
	}
	
	public void affDepot() {
		for(Depot d:mesDepots) {
			System.out.println(d);
		}
	}
}
