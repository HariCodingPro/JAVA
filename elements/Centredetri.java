package elements;
import java.util.*;

public class CentreTri {
	private int id;
	private String nom;
	private String adresse;
	private String ville;
	private int codePost;
	private int nbPoubelles;
	private int[] quantites;
	private HashMap<String,int[]> quartiers = new HashMap<String,int[]>();
	

	public CentreTri(int id, String nom, String adresse, String ville, int codePost, int nbPoubelles, int[] quantites, HashMap<String, int[]> quartiers) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePost = codePost;
		this.nbPoubelles = nbPoubelles;
		this.quantites = quantites;
		this.quartiers = quartiers;
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

	public HashMap<String, int[]> getQuartiers() {
		return quartiers;
	}

	public void setQuartiers(HashMap<String, int[]> quartiers) {
		this.quartiers = quartiers;
	}
	

	void ajouterPoubelles(String[] quartiers) {
		int nvpb[] = {0,0,0,0};
		for (String q:quartiers) {
			this.quartiers.put(q,nvpb);
		}
	}
	
	void retirerPoubelles(String[] quartiers) {
		for (String q:quartiers) {
			this.quartiers.remove(q);
		}
	}
	
	void stats() {
		
	}
	
	void collecter() {
		for (String q:quartiers.keySet()){
			for (int i=0;i<4;i++) {
				quartiers.get(q)[i] = 0;
			}
		}
	}
	
	void vente() {
		for (int i=0;i<4;i++) {
			quantites[i] = 0;
		}
	}
}
