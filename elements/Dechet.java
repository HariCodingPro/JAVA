package elements;


public class Dechet {
	
	
    private String typedechets; //Verre, carton etc.
    private double poids;
    private String nomDechet;

    public Dechet(String  typedechets, double poids, String nomDechet) {
        this.typedechets = typedechets;
        this.poids = poids;
        this.nomDechet = nomDechet;
    }

    
    public String getTypePoubelle() {
        return typedechets;
    }

    
    public double getPoids() {
        return poids;
    }

  
    public String getNomDechet() {
        return nomDechet;
    }

    
    public void setTypePoubelle(String typedechets) {
        this.typedechets = typedechets;
    }

    
    public void setPoids(double poids) {
        this.poids = poids;
    }

    
    public void setNomDechet(String nomDechet) {
        this.nomDechet = nomDechet;
    }
    
    
}
