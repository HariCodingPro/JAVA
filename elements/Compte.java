package elements;

public class Compte {
   private int id;
   private String nomUtilisateur;
   private String motDePasse;
   private int nombreDePoints;

   
   public Compte(int id, String nomUtilisateur, String motDePasse) {
      this.id = id;
      this.nomUtilisateur = nomUtilisateur;
      this.motDePasse = motDePasse;
      this.nombreDePoints = 0;
   
   }

   public int getId() {
      return id;
   }

   public String getNomUtilisateur() {
      return nomUtilisateur;
   }

   public void setNomUtilisateur(String nomUtilisateur) {
      this.nomUtilisateur = nomUtilisateur;
   }

   public String getMotDePasse() {
      return motDePasse;
   }

   public void setMotDePasse(String motDePasse) {
      this.motDePasse = motDePasse;
   }


   public int getNombreDePoints() {
      return nombreDePoints;
   }

   public void setNombreDePoints(int nombreDePoints) {
      this.nombreDePoints = nombreDePoints;
   }


   public void ajouterPoints(int points) {
      this.nombreDePoints += points;
    
   }


}
