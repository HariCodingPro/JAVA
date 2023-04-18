package elements;
import java.util.*;

public class CentreTri {
	private int id;
	private String nom;
	private String adresse;
	private String ville;
	private int codePost;
	private int nbPoubelles;
	private int quantites[] = new int[4];
	private ArrayList<Poubelle> Poubelles = new ArrayList<Poubelle>();
	private Scanner lect = new Scanner(System.in);
	

	public CentreTri(int id, String nom, String adresse, String ville, int codePost, int nbPoubelles, int[] quantites, ArrayList<Poubelle> Poubelles) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePost = codePost;
		this.nbPoubelles = nbPoubelles;
		this.quantites = quantites;
		this.Poubelles = Poubelles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePost() {
		return codePost;
	}

	public void setCodePost(int codePost) {
		this.codePost = codePost;
	}

	public int getNbPoubelles() {
		return nbPoubelles;
	}

	public void setNbPoubelles(int nbPoubelles) {
		this.nbPoubelles = nbPoubelles;
	}

	public int[] getQuantites() {
		return quantites;
	}

	public void setQuantites(int[] quantites) {
		this.quantites = quantites;
	}

	public ArrayList<Poubelle> getPoubelles() {
		return Poubelles;
	}

	public void setQuartiers(ArrayList<Poubelle> Poubelles) {
		this.Poubelles = Poubelles;
	}

	
	void ajouterPoubelles(Poubelle nbPoubelles) {
		System.out.println("Veuillez rentrer le nom du centre de tri :");
		String centreTri = lect.next();
		Poubelles.get(Poubelles.size()).centreTriProche = centreTri;
		System.out.println("Veuillez rentrer le type de déchets :");
		String type = lect.next();
		Poubelles.get(Poubelles.size()).typedechets = type;
		System.out.println("Veuillez rentrer l'emplacement :");
		String emplac = lect.next();
		Poubelles.get(Poubelles.size()).emplacement = emplac;
		System.out.println("Veuillez rentrer la quantité max :");
		int qte = lect.nextInt();
		Poubelles.get(Poubelles.size()).qteMax = qte;
	}
	
	void retirerPoubelles(String[] quartiers) {
		
	}
	
	void stats() {
		
	}
	
	void collecter() {
		
	}
	
	void vente() {
		for (int i=0;i<4;i++) {
			quantites[i] = 0;
		}
	}
	
	void afficher() {
		
	}
}
