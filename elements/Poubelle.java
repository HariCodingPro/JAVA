package elements;

import java.util.ArrayList;

public class Poubelle {

	public enum TypeDechet {

        Verre, Plastique, Metal, Carton
       
	}

	private int id;
    private String centreTriProche;
    private TypeDechet typedechets;
    private String emplacement;
    private int qteMax; //en kg
    private ArrayList<Depot> Pb_Depots=new ArrayList<Depot>();//Pour savoir ce qu'il y a dans la poubelle et qui  a mis quoi 
    
				
    public Poubelle(int id, String centreTriProche, TypeDechet typedechets, String emplacement, int qteMax) {
		super();
		this.id = id;
		this.centreTriProche = centreTriProche;
		this.typedechets = typedechets;
		this.emplacement = emplacement;
		this.qteMax = qteMax;
	}

    	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCentreTriProche() {
		return centreTriProche;
	}

	public void setCentreTriProche(String centreTriProche) {
		this.centreTriProche = centreTriProche;
	}

	public TypeDechet getTypedechets() {
		return typedechets;
	}

	public void setTypedechets(TypeDechet typedechets) {
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

    private void signalerCentreTri(TypeDechet typeDechet) {
    	//Vérifier si qté max atteinte
        System.out.printf("Le centre de tri %s est informé que la poubelle %d a dépassé la quantité maximale pour le type de déchet %s.\n",centreTriProche, id, typeDechet.name());
    }
    
}