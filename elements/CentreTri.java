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

	


	
	public void ajouterPoubelles() {
		/*System.out.println("Veuillez rentrer le nom du centre de tri :");
		String centreTri = lect.next();*/
		//newPoubelle.setCentreTriProche(this);

	//	Poubelles.get(Poubelles.size()).centreTriProche = centreTri;
		System.out.println("Veuillez rentrer le type de déchets :");
		String type = lect.next();
		//newPoubelle.setTypedechets(type);
		//Poubelles.get(Poubelles.size()).typedechets = type;
		System.out.println("Veuillez rentrer l'emplacement :");
		String emplac = lect.next();
	//	newPoubelle.setTypedechets(emplac);
	//	Poubelles.get(Poubelles.size()).emplacement = emplac;
		System.out.println("Veuillez rentrer la quantité max :");
		int qte = lect.nextInt();
	//	newPoubelle.setQteMax(qte);
	//	newPoubelle.setPoidsActuel(0);
		//Poubelles.get(Poubelles.size()).qteMax = qte;
		
		Poubelle newPoub=new Poubelle(12, this,type, emplac, qte, 0);
		listePoubelles.add(newPoub);
	}
	
	public void afficherPoubelles() {
	
		for(Poubelle d:listePoubelles) {
			System.out.println(d.getTypedechets());
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