package application;
import elements.*;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.*;


public class Application {
	public static void main(String [ ]args) {
		
		Menage C1;
		Menage C2;
		
		Compte Compte;
		Compte Compte1;
		Poubelle P1, P2,P3;
		
		 Scanner read = new Scanner(System.in);
		 String valstr;
		 String login;
		 String mdp;
		 int valint;
		 

		//Création d'un compte
		Compte=new Compte(12, "Gazou", "password");
		Compte1=new Compte(14, "Koba", "grr");
		C1= new Menage(12, "Henri", "Durand", "12-10-2021", "15 rue lachette", Compte);
		C2= new Menage(17, "Didier", "Bg", "12-08-2021", "15 rue lavend", Compte1);

		
	    HashMap<Compte,Menage> users=new HashMap<Compte,Menage > ();
		
		users.put(Compte, C1);
		users.put(Compte1, C2);
		CentreTri Ct[]=new CentreTri[4];
		
		Ct[0]=new CentreTri(12,"Tri Center", "5 rue dijon","Paris",75000);
		Ct[1]=new CentreTri(14,"Palace Tri", "5 rue pouillon","Marseille",15000);
		Ct[2]=new CentreTri(120,"The Place to Tri", "5 rue cergy?","Lyon",23000);
		Ct[3]=new CentreTri(144,"Try not to Tri", "5 rue Paris","Dijon",24000);

		
		P1=new Poubelle(1, Ct[0],"verre", "La musareigne","Paris",  2000, 0);
		P2=new Poubelle(2, Ct[0],"carton", "La musareigne","Paris",  2000, 0);
		P3=new Poubelle(3, Ct[0],"carton", "Porto","Paris",  1000, 0);
		
		Ct[0].ajouterPoubellesExistante(P1);
		Ct[0].ajouterPoubellesExistante(P2);
		Ct[0].ajouterPoubellesExistante(P3);

		int quit=1;
		int err=0;
		int connectado=0;
		Poubelle pb_actuelle;
		Compte cpt_actu=Compte;
		Menage connecter=C1;
		Menage nouv;
		Compte nouv_cpt;
		
		//=============================== MAIN LOOP ===============================
		while(quit != 0) {
			
			System.out.println("==== BIENVENUE SUR CY POUBELLE  ====\n");
			
			try {
				System.out.println("1/ Je me connecte");
				System.out.println("2/ Je crée un compte");
				System.out.print("Choix : ");
				valint=Integer.parseInt(read.nextLine());
				if(valint != 2 && valint !=1) {
					throw new Exception("Faux");
				}

			}
			
			catch (Exception e) { //if an exception appears prints message below
			    System.err.println("\nVeuillez mettre 1 ou 2\n" );
			//   input.next(); // clear scanner wrong input
			    continue; // continues to loop if exception is found
			}
			
			
			
			connectado=1;

			switch(valint) {
				case 1:
					while(err!=1) {
						
						System.out.print("\n=== Connexion ===\n");
						System.out.print("Login : ");
						login=read.nextLine();			
						System.out.print("Password : ");
						mdp=read.nextLine();
						
						for(Compte c : users.keySet()){
							if(c.getNomUtilisateur().equals(login)) {
								if(c.getMotDePasse().equals(mdp)) {
									
									connecter=users.get(c);
									cpt_actu=c;
									connectado=1;
									System.out.println("\nBonjour, "+connecter.getPrenom()+" :)\n");
									err=1;
								}
							}
						}
						
						if(err==0) {
							System.out.println("Login ou mdp erroné");
						}
						
					}
										
					break;
				case 2:
					//Création compte
					System.out.print("\n=== Création du compte ===\n");
					System.out.print("Nom : ");
					String nom=read.nextLine();
					System.out.print("Prenom : ");
					String prenom=read.nextLine();
					System.out.print("Date de naissance : ");
					String ddna=read.nextLine();
					System.out.print("Adresse : ");
					String addy=read.nextLine();
					System.out.print("Login : ");
					String new_login=read.nextLine();
					System.out.print("Password : ");
					String new_pass=read.nextLine();
					
					nouv_cpt=new Compte(200, new_login, new_pass);
					nouv=new Menage(100, prenom, nom, ddna, addy, nouv_cpt);

					users.put(nouv_cpt,nouv);
					
					connecter=users.get(nouv_cpt);
					cpt_actu=nouv_cpt;
					connectado=1;
					break;
				default:
					System.out.println("non");
			}

			err=0;
			int valdbt=0;
			while(connectado !=0) {
				
		
		try {
			System.out.println("Quelle action voulez-vous réaliser :");
			System.out.println("0/ Faire un dépôt");
			System.out.println("1/ Consulter votre solde de points ");
			System.out.println("2/ Voir historique dépots ");
			System.out.println("3/ Se deconnecter ");
			 valdbt = Integer.parseInt(read.nextLine());
			 if(valdbt != 0 && valdbt !=1 && valdbt !=2 && valdbt !=3) {
				 throw new Exception();
			 }
			
		}
		
		catch(Exception e) {
			System.err.println("\nVeuillez mettre un des chiffres proposés\n" );
			continue;
		}
			Depot depot;
			LocalDate date = LocalDate.now();
		    String str_date = date.toString();
		    LocalTime time = LocalTime.now();
		    String heure = time.toString();
			
			
			if (valdbt==0){
				
				try {
					System.out.println("Où êtes-vous ?");
					for(int i=0;i<Ct.length;i++) {
						System.out.println(i+"/ "+Ct[i].getVille()+" ("+Ct[i].getNom()+")");
					}
					
					
					System.out.print("Choix (num) : ");
					valint=Integer.parseInt(read.nextLine()); //CHOIX centre de tri
					if(valint >Ct.length) {
						throw new Exception();
					}
				}
				
				catch(Exception e) {
					System.err.println("\n:/ Veuillez rentrer un des chiffres svp \n");
					continue;
				}
				
					if(Ct[valint].getNbPoubelles()==0) {
						boolean free=true;
						while(free) {
							System.out.println("Création d'une poubelle : ");
							Ct[valint].ajouterPoubelles();
							
							System.out.println("Fin de la création ? O/n: "); //creer poubs??
							valstr=read.nextLine();
				
							
							if(valstr.equals("O")) {
								free=false;
								break;
							}
		
						}
						
					}
					
					int valpb=0;
					System.out.println("\n=== Choix de la poubelle ===");
					try {
						Ct[valint].afficherPoubelles();
						System.out.print("Choix : ");
						valpb=Integer.parseInt(read.nextLine());
						if(valpb > Ct.length) {
							throw new Exception();
						}
					}
					catch(Exception e) {
						System.err.println("Veuillez mettre un numero présenté");
						continue;
					}
											
					//Création du dépôt
					pb_actuelle=Ct[valint].getPoubelle(valpb-1);
					depot = new Depot(str_date,heure, pb_actuelle, connecter);
					
					System.out.println("Vous avez choisi : "+pb_actuelle.getTypedechets()+" à "+pb_actuelle.getEmplacement());
					System.out.println("Il y a actuellement "+pb_actuelle.getPoidsActuel()+"kg  sur "+pb_actuelle.getQteMax()+" de déchet dans cette poubelle \n");
					
			
					int end=1;
					
					while (end!=0){
						
						Dechet nouveau;
						String typedechets="";
						while(!typedechets.toLowerCase().equals("carton") && !typedechets.toLowerCase().equals("verre") && !typedechets.toLowerCase().equals("plastique")  && !typedechets.toLowerCase().equals("metal") && !typedechets.toLowerCase().equals("autre")  ) {
							System.out.println("Entrer le type de déchet (verre, carton, plastique, ou autre) : ");
							typedechets=read.nextLine();			
							
						}
								
						System.out.println("Le poids unitaire du déchet : ");
						double poidsdechet=Double.parseDouble(read.nextLine());
						System.out.println("Entrer la quantité du déchet : ");
						int quantite=Integer.parseInt(read.nextLine());
				
						System.out.println("Entrer le nom du déchet : ");
						String nomdechet=read.nextLine();
						
						
						
						nouveau=new Dechet(typedechets.toLowerCase(),poidsdechet, nomdechet);
						depot.ajouter_dechet(nouveau, quantite);
						
						System.out.println("Ajouter un autre déchet : O/N");
						
						valstr=read.nextLine();
						if(valstr.equals("N")) {
							end=0;
						}
						
					}
					
				
					if(depot.calculerPoidsDepot()+pb_actuelle.getPoidsActuel() > pb_actuelle.getQteMax()) {
						
						System.out.print("Il n'y a pas de place dans cette poubelle pour votre dépôt :(\n");
					}
					
					else {
						pb_actuelle.ajouterDepot(depot);
						connecter.ajouterDepot(depot);
						pb_actuelle.setPoidsActuel( depot.calculerPoidsDepot()+pb_actuelle.getPoidsActuel() );
						//System.out.println(Compte.getNombreDePoints() + depot.getPoints());
						if (cpt_actu.getNombreDePoints() + depot.getPoints() >= 0) {
							
							cpt_actu.setNombreDePoints(cpt_actu.getNombreDePoints() + depot.getPoints());
							//System.out.println(Compte.getNombreDePoints()+"|"+depot.getPoints());
							
							
						}else {
							cpt_actu.setNombreDePoints(0);
						}
						
					}
					
					
					
				}
			
			
		
			//Consulter points
			
			else if(valdbt==1){
					int nombre_points = cpt_actu.getNombreDePoints();
					if(nombre_points > 10) {
						System.out.println("\nWow :o Votre solde de points est de : "+nombre_points+" points\n\n");
					}
					else {
						System.out.println("\nVotre solde de points est de : "+nombre_points+" points\n");
					}
						
					}
			else if(valdbt==3) {
				connectado=0;
			}
			
			else if(valdbt==2) {
				if(connecter.sizedepot()>0) {
					connecter.afficherDepots();
				}
				
				else {
					System.out.println("\nVide :( \n");
				}
				
			}
			
			}
			System.out.println("\nQuitter ? O/N");
			valstr=read.nextLine();
			if(valstr.equals("O")) {
				quit=0;
			
			}
			
		
			

	}//fin while
		
		
		
		
		
		
		
		
		
		

	}
}