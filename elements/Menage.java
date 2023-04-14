package elements;

import java.util.ArrayList;

public class Menage extends Personne{

	/*Le ménage a accès à la liste de ses dépôts*/
	private ArrayList<Depot> mesDepots=new ArrayList<Depot>();


	public Menage(int id, String prenom, String nom, String ddn, String adresse, Compte compte) {
		super(id, prenom, nom, ddn, adresse, compte);

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
	
	public void afficherDepots() {
        for(Depot d:mesDepots) {
        	System.out.println("==================================");
        	System.out.println("Date depot : "+d.getDateDepot()+"\nHeure : "+d.getHeureDepot()+"\nPoubelle : "+d.getPoubelle().getTypedechets());
        	System.out.println("==================================");
        }
}

}
