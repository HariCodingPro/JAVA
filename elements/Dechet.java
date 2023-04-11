package elements;


public class Dechet {
    private String typePoubelle;
    private double poids;
    private String nomDechet;

    public Dechet(String typePoubelle, double poids, String nomDechet) {
        this.typePoubelle = typePoubelle;
        this.poids = poids;
        this.nomDechet = nomDechet;
    }

    
    public String getTypePoubelle() {
        return typePoubelle;
    }

    
    public double getPoids() {
        return poids;
    }

  
    public String getNomDechet() {
        return nomDechet;
    }

    
    public void setTypePoubelle(String typePoubelle) {
        this.typePoubelle = typePoubelle;
    }

    
    public void setPoids(double poids) {
        this.poids = poids;
    }

    
    public void setNomDechet(String nomDechet) {
        this.nomDechet = nomDechet;
    }
    
    
}
