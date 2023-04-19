package elements;
import java.util.*;

public class CentreTri {
	private int id;
	private String nom;
	private String adresse;
	private String ville;
	private int codePost;
	
	private ArrayList<Poubelle> listePoubelles = new ArrayList<Poubelle>();
	
	private Scanner lect = new Scanner(System.in);

	public CentreTri(int id, String nom, String adresse, String ville, int codePost) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePost = codePost;
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
		return listePoubelles.size();
	}

	
	public Poubelle getPoubelle(int idx) {
		return listePoubelles.get(idx);
	}

	
	public void ajouterPoubelles() {
		
		//Créer id
		
		System.out.println("Veuillez rentrer le type de déchets :");
		String type = lect.next();

		System.out.println("Veuillez rentrer le quartier :");
		String emplac = lect.next();

		System.out.println("Veuillez rentrer la quantité max :");
		int qte = lect.nextInt();

		Poubelle newPoub=new Poubelle(12, this,type, emplac,this.ville,  qte, 0);
		listePoubelles.add(newPoub);
	}
	
	public void ajouterPoubellesExistante(Poubelle p) {
		listePoubelles.add(p);
	}
	
	public void afficherPoubelles() {
	
		for(Poubelle d:listePoubelles) {
			System.out.println(d.getId()+"/ "+d.getTypedechets()+" ("+d.getEmplacement()+")");

		}
	}
	
	void retirerPoubelles(String[] quartiers) {
		/*for (String q:quartiers) {
			this.quartiers.remove(q);
		}*///Supprimer poubs
	}
	
	void stats() {
		
	}
	
	void collecter() {
		/*for (String q:quartiers.keySet()){
			for (int i=0;i<4;i++) {
				quartiers.get(q)[i] = 0;
			}
		}*///Vider hahsmap depot
	}
	
	void vente() {
		/*for (int i=0;i<4;i++) {
			quantites[i] = 0;
		}*///Hashmap vider
	}
}