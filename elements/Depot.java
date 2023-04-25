package elements;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Depot {
    private String dateDepot;
    private String heureDepot;
    private Menage menage;
    private int points;
    private Poubelle poubelle;
    
    HashMap<Dechet, Integer> listedechets=new HashMap<Dechet, Integer>();
    

    public Depot(String dateDepot, String heureDepot, Poubelle poubelle, Menage menage) {
        this.dateDepot = dateDepot;
        this.heureDepot = heureDepot;
        this.poubelle = poubelle;
        this.menage = menage;
        this.points = 0;
    }

    /*Ajouter un dechet a la map des dechets du depot*/
    public void ajouter_dechet(Dechet d, int qte) {
    
    	listedechets.put(d,qte);
    	
    	if(d.getTypePoubelle().equals(poubelle.getTypedechets())) {
    		points+=5;

    	}
    	
    	else {
    		points-=1;
    	}
    	
    	//on modifie point pck si c'est trop lourd on annule
    
    }
    
  

    /*Afficher nom dechet */
    public void aff_listedechets() {
    	for (Dechet dechet : listedechets.keySet()) {
            System.out.println("Nom : "+dechet.getNomDechet()+"\nQté : "+listedechets.get(dechet)+"\nPOIDS : "+dechet.getPoids());
        }
    }
    
    //Récupérer poids des dechets et on le met a la poubelle
    public double calculerPoidsDepot() {
        double poidsTotal = 0;
        for (Dechet dechet : listedechets.keySet()) {
        	poidsTotal +=dechet.getPoids()*listedechets.get(dechet);
        }
        return poidsTotal;
    }

      
    public void garderInfosDepot() {
        // Méthode pour stocker les informations du dépôt dans une base de données ou un fichier
    	
    	//La ça affiche que les détails du dépôt
    	System.out.println("Date depot : "+dateDepot+"\nHeure : "+heureDepot+"\nMenage :  "+menage.getNom()+"\nPoubelle : "+poubelle.getTypedechets());
    }

	public String getDateDepot() {
		return dateDepot;
	}

	public void setDateDepot(String dateDepot) {
		this.dateDepot = dateDepot;
	}

	public String getHeureDepot() {
		return heureDepot;
	}

	public void setHeureDepot(String heureDepot) {
		this.heureDepot = heureDepot;
	}

	public Menage getMenage() {
		return menage;
	}

	public void setMenage(Menage menage) {
		this.menage = menage;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Poubelle getPoubelle() {
		return poubelle;
	}

	public void setPoubelle(Poubelle poubelle) {
		this.poubelle = poubelle;
	}


    
    
 
}
