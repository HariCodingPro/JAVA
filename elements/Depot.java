package elements;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Depot {
    private String dateDepot;
    private String heureDepot;
    private Menage menage;
    private int points;
      //private Poubelle poubelle;
    
    HashMap<Dechet, Integer> listedechets=new HashMap<Dechet, Integer>();
    

    public Depot(String dateDepot, String heureDepot, /*Poubelle poubelle, */Menage menage) {
        this.dateDepot = dateDepot;
        this.heureDepot = heureDepot;
        //this.poubelle = poubelle;
        this.menage = menage;
        this.points = 0;
    }

    /*Ajouter un dechet a la map des dechets du depot*/
    public void ajouter(Dechet d, int qte) {
    	listedechets.put(d,qte);
    }
    
    public void modifierPoints(int points) {
        this.points += points;
    }

    /*Afficher nom dechet!!*/
    public void aff_listedechets() {
    	for (Map.Entry mapentry  : listedechets.entrySet()) {
    		System.out.println("Dechet : "+mapentry.getKey()+"\nQte : "+mapentry.getValue());
    	}
    }
    
   /* public double calculerPoidsDepot() {
        double poidsTotal = 0;
        for (Map.Entry mapentry  : listedechets.entrySet())) {
            poidsTotal += mapentry.getKey()* mapentry.getValue(); //CALCULER POIDS
        }
        return poidsTotal;
    }

    */
    /*public boolean verifierNatureDechets() {
        for (DetailsDepot d:ddepot) {
            if (!poubelle.getTypePoubelle().equals(d.getDechet().getTypePoubelle())) {
                return false;
            }
        }
        return true;
    }
*/
    
    public void garderInfosDepot() {
        // Méthode pour stocker les informations du dépôt dans une base de données ou un fichier
    }
}
