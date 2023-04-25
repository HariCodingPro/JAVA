package elements;

import java.util.ArrayList;

public class Poubelle {



	private int id;
    private CentreTri centreTriProche;
    private String typedechets;
    private String emplacement;//le quartier
    private String ville;
    private int qteMax; 
    private double poidsActuel;
    private ArrayList<Depot> Pb_Depots=new ArrayList<Depot>();//Pour savoir ce qu'il y a dans la poubelle et qui  a mis quoi 
    //Rajouter code accès
				

    public Poubelle(int id, CentreTri centreTriProche, String typedechets, String emplacement, String ville, int qteMax, double poidsActuel) {
			super();
			this.id = id;
			this.centreTriProche = centreTriProche;
			this.typedechets = typedechets;
			this.emplacement = emplacement;
			this.ville = ville;
			this.qteMax = qteMax;
			this.poidsActuel = poidsActuel;
		}
    	
     	public double getPoidsActuel() {
    		return poidsActuel;
    	}

		public void setPoidsActuel(double poidsActuel) {
		this.poidsActuel = poidsActuel;
	}


		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CentreTri getCentreTriProche() {
		return centreTriProche;
	}

	public void setCentreTriProche(CentreTri centreTriProche) {
		this.centreTriProche = centreTriProche;
	}

	public String getTypedechets() {
		return typedechets;
	}

	public void setTypedechets(String typedechets) {
		this.typedechets = typedechets;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public int getQteMax() {
		return qteMax;
	}

	public void setQteMax(int qteMax) {
		this.qteMax = qteMax;
	}

	//Calculer le poids actuel dans la poubelle

	public void ajouterDepot(Depot d) {
		Pb_Depots.add(d);
    }
	
	public void afficherDepots() {
	        for(Depot d:Pb_Depots) {
	        	System.out.println("==================================");
	        	System.out.println("Date depot : "+d.getDateDepot()+"\nHeure : "+d.getHeureDepot()+"\nMenage :  "+d.getMenage().getNom()+"\nPoubelle : "+d.getPoubelle().getTypedechets());
	        	System.out.println("==================================");
	        }
	}

    private void signalerCentreTri(String typeDechet) {
    	//Vérifier si qté max atteinte
        System.out.printf("Le centre de tri %s est informé que la poubelle %d a dépassé la quantité maximale pour le type de déchet %s.\n",centreTriProche, id, typedechets);
    }
    
}