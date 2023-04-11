package elements;

public abstract class Personne {
	private int id;
	private String nom;
	private String prenom;
	private String ddn;
	private String adresse;
	
	public Personne() {
		
	}
	
	public Personne(int id, String prenom, String nom, String ddn, String adresse) {
		this.id=id;
		this.prenom=prenom;
		this.nom=nom;
		this.ddn=ddn;
		this.adresse=adresse;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDdn() {
		return ddn;
	}

	public void setDdn(String ddn) {
		this.ddn = ddn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "ID : "+id+"\nNom : "+nom+"\nPrenom : "+prenom+"\nDate de naissance : "+ddn+"\nAdresse : "+adresse;
	}
	
	/*Methode pour jeter une poubelle ??*/
	
}
