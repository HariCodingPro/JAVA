package elements;

public class DetailsDepot {
    private int quantite;
    private Dechet dechet;

    public DetailsDepot(int quantite, Dechet dechet, Depot depot) {
        this.quantite = quantite;
        this.dechet = dechet;
    }
    
    
    public int getQuantite() {
        return quantite;
    }
    
    
    public Dechet getDechet() {
        return dechet;
    }
    
    
    
    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
    public void setDechet(Dechet dechet) {
        this.dechet = dechet;
    }
    
    
  /*  public void setdpot(Depot depot) {
        this.depot = depot;
    }*/
}