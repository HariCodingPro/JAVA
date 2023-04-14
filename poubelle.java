package element;

public class Poubelle {

    private int id;
    private String centreTriProche;
    private int[] qteDiffDechets = new int[TypeDechet.values().length];


    public enum TypeDechet {

        Verre(/*MaxQuantite n°1*/),
        Plastique(/*MaxQuantite n°2*/),
        Carton(/*MaxQuantite n°3*/)
        Metal(/*MaxQuantite n°4*/);

        private final int maxQuantite;

        TypeDechet(int maxQuantite) {
            this.maxQuantite = maxQuantite;
        }

        public int getMaxQuantite() {
            return maxQuantite;
        }
    }

    public Poubelle(int id, String centreTriProche) {
        this.id = id;
        this.centreTriProche = centreTriProche;
    }

    public void ajouterDechet(TypeDechet nomType, int quantite) {
        int numDechet = nomType.ordinal();
        qteDiffDechets[numDechet] += quantite;
        
        if (qteTypeDechets[numDechet] >= nomType.getMaxQuantite()) {
            signalerCentreTri(nomType);
        }

    }

    private void signalerCentreTri(TypeDechet typeDechet) {
        System.out.printf("Le centre de tri %s est informé que la poubelle %d a dépassé la quantité maximale pour le type de déchet %s.\n",centreTriProche, id, typeDechet.name());
    }
    
}