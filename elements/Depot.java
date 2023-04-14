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
    public void ajouter(Dechet d, int qte) {
    	listedechets.put(d,qte);
    }
    
  

    /*Afficher nom dechet */
    public void aff_listedechets() {
    	for (Map.Entry mapentry  : listedechets.entrySet()) {
    		System.out.println("Dechet : "+mapentry.getKey()+"\nQte : "+mapentry.getValue());
    	}
    }
    
    //Récupérer poids du déchet
    public double calculerPoidsDepot() {
        double poidsTotal = 0;
        for (Map.Entry mapentry  : listedechets.entrySet()) {
           // poidsTotal += mapentry.getKey()* mapentry.getValue(); //CALCULER POIDS
        }
        return poidsTotal;
    }

    
    //Parcourir la Hashmap comme au dessus et vérifier que le type de déchet correspond à  la poubelle, sinon enlever des points et vice versa
    /*
    	public boolean verifierNatureDechets() {
        for (DetailsDepot d:ddepot) {
            if (!poubelle.getTypePoubelle().equals(d.getDechet().getTypePoubelle())) {
                return false;
            }
        }
        return true;
    }*/

    
    //Accéder au points du ménage
     public void modifierPoints(int points,Menage menage) {
        this.points += points;
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
