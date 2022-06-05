package examen;
import java.lang.String;
import java.time.LocalDate;
import java.time.Period;

public class adherent implements bibliothecaire_ad {
	
	//attributs
	private String nom,prenom;
	private int mat;
	private emprunt e [] =  new emprunt[bibliotheque_db.getMaxE()]; //un adherent peut avoir plusieurs emprunts
	public static int cpt;//compteur des adherents
	private int cpt_emp;//compteur des empreinte d'un adherent
	//**********
	 
	//constructors
	public adherent(String nom,String prenom,int mat) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom.toLowerCase();
		this.mat = mat;
		cpt++;
	}
	public adherent(int mat){
		this.mat = mat;
	}
	public adherent() {
	}
   //*************
	
	
	
   //getters & setters
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public emprunt[] getE() {
		return e;
	}
	public void setE(emprunt[] e) {
		this.e = e;
	}
	//************
	
	//methods
	/*verification si un certain adherent est disponible ou pas, je l'ai utilisé pour vérifier l'existance avant 
	l'ajout(si adherent n'existe pas alors j'ajoute sinon j'ajoute pas)/ 
	suppression(si adherent n'existe pas donc je supprime pas )
	modification(si adherent n'existe pas donc je modifie pas )
	meme dans restituer/consulter/empreinter 
	je l'ai appelé dans le main et non pas dans les methodes */
	public static boolean adherentDispo(int mat,String nom,String prenom) {
		int i = 1;			
		if(cpt > 1) {
			for(adherent a : bibliotheque_db.getA())
				{			
					if(a.mat == mat && a.nom.equals(nom.toUpperCase()) && a.prenom.equals(prenom.toLowerCase())) {
						return true;
					}
					i++;
					if(i == cpt) {break;}
				} 
		}
		return false;
	}
	
	
	//redifinition de la méthode précedente la difference est dans les arguments et le corp
	//ici recherche en fonction du matricule
	public static boolean adherentDispo(int mat) {
		int i = 1;	
		if(cpt > 1) {
		for(adherent a : bibliotheque_db.getA())
			{		
				if(a.mat == mat) {
					return true;
				}
				i++;
				if(bibliotheque_db.getA()[cpt-1]==null) {
					if(i == cpt) {break;}
				}else {
					if(bibliotheque_db.getA()[cpt-1]!=null) {
						if(i > cpt) {break;}
					}
				}
			} 
		}else {
		if(bibliotheque_db.getA()[0] != null) { 
			if(bibliotheque_db.getA()[0].mat == mat) return true;
			}
		}
		return false;
	}
	
	/*affichage des adherents, pour appliquer la methode on est sur que ya des adherents qui existent
	cas de non existance est manipuler dans l main*/
	public static void affichageAd() {
		int i = 0;
		System.out.println("\n"+cpt+" adherents");
			for(adherent a : bibliotheque_db.getA())
				{i++;
				System.out.println("Nom = "+ a.nom+"\nPrenom = "+a.prenom+"\nMatricule ="+a.mat);
				System.out.println("**************************\n");
				if(i == cpt) break;
				}
	}
	
	@Override
	//enregistrer un adherent dans le tableau adherent qui se trouve dans la class bibliotheque_db
	public void enregistrer() {
		if(cpt<=bibliotheque_db.getMaxA()) {
		bibliotheque_db.getA()[cpt-1] = this;
		System.out.println(">>> Adherent bien incerer");
		}
	}
	
	
	@Override
	//supprimer un adherent dans le tableau adherent qui se trouve dans la class bibliotheque_db
	//pour appliquer la methode on est sur que l'adherent existe
	public void Supprimer() {
		if(cpt > 1) {
			for(int i = 0;i<cpt;i++) {
				if(this.mat == bibliotheque_db.getA()[i].mat) {
					for(int j = i;j<bibliotheque_db.getMaxA()-1;j++) {
						bibliotheque_db.getA()[j] = bibliotheque_db.getA()[j+1];
						bibliotheque_db.getA()[j+1] = null;
					}
					break;
				}
			}
		} else { bibliotheque_db.getA()[0]= null;}
	cpt--;
	}
	
	
	@Override
	//modifier soit le nom ou bien prenom d'un adherent dans le tableau adherent qui se trouve dans la class bibliotheque_db
	//pour appliquer la methode on est sur que l'adherent existe
	public void Modifier(String nom,String prenom) {
		
		for(adherent a:bibliotheque_db.getA()) {
			if(this.mat == a.mat) {
				if(nom!="")a.nom = nom.toUpperCase();
				if(prenom!="")a.prenom = prenom;
				break;
			}
		}
	}
	

	@Override
	//afficher la liste noir des adherents qui ont dépasser le delai de leurs empreintes
	public void afficherListeNoir() {//black list
		int i,j = 1,k=0;
		boolean x = true;
			System.out.println("\tLa Liste Noir");
		for(adherent a: bibliotheque_db.getA()) { i = 0;
			if( a.cpt_emp > 0 ){//we can find an adherent that has no emprunt 
				x = true;
			  for(emprunt e : a.e) { i++; 
				if((e.getD().plusDays(10)).isAfter(LocalDate.now()))
					System.out.println("\nNom : "+a.nom+"\nPrenom : "+a.prenom +"\ntype emprunte : "+a.e[i-1].getM().getL()+"\nisbn : "+a.e[i-1].getM().isbn);
					System.out.println("******************");
					if(i == a.cpt_emp) {
						break;
					}
			  }
			}else { x = false;k++; }
			j++;
			if(j > cpt)break;
		}
		if(x == false && k == cpt) System.out.println(">>> Ya aucun adherent qui a emprinter");
	}
	
	
	//ajouter une empreinte pour un adherent + suppression du midea de la matrice des mideas
	 public void emprunter(emprunt em) {
		if(em.getM().mediaDispo()) {	//if and only if media is disponible
			for(adherent a:bibliotheque_db.getA()) {//je cherche l'adherent
				 if(this.mat == a.mat) {					
					 if(a.cpt_emp< bibliotheque_db.getMaxE()) {
						a.e[a.cpt_emp] = new emprunt(em.getM(),em.getD());a.cpt_emp++;
						System.out.println(">>> L'empreinte incerer, adherent mat : "+this.mat+" - isbn d'emprunt : "+a.e[a.cpt_emp-1].getM().isbn);
						em.getM().Supprimer();//je supprime le midea de la bibliotheque car il est pris
					 } else System.out.println(">>> Cette ecmpreinte ne peut pas etre effectuer car max empreinte pour l'adherent est atteint !");
					 break;
				 }
			} 
		}
	 }
	
	 
	 //consulter l'empreinte d'un adherent + affichage du delai si il n'a pas dépasser
	 public int consulter(emprunt em) {
		 int i = 1,j = 1;
		 for(adherent a:bibliotheque_db.getA()) {
			 if(this.mat == a.mat) {
					  for(emprunt emp :a.e) {
						  if(!(emp == null)) {
							  if(emp.getM().isbn.equals(em.getM().isbn)){//pour tous les empreinte de l'adheretn a on cherche l'empreint ayant le meme midéa
								  if(!emp.getD().equals(LocalDate.now().plusDays(4))) {
									  if(emp.getD().plusDays(10).isAfter(LocalDate.now())) {
										 Period diff =  Period.between(LocalDate.now(),emp.getD().plusDays(10));
										 	return diff.getDays();//positive number
											 }else return -8;//dépasser
								 }else {
									 return -9;//equal
								 }
							  }
						  }
						     i++;
							 if(i > a.cpt_emp) break;
					  }
			 }
			 j++;
			 if(j > cpt )break;
		 }
		 return -5;
	 }
	 

	//restituer une empreinte d'un adherent donner + remise du media emprainter dans la matrice des midea ssi empreinte existe
	public void restituer(emprunt em) {
		int x = 1;boolean d = false;
		for(adherent a:bibliotheque_db.getA()) {
			if( this.mat == a.mat ) {
		       for(int i = 0;i<a.cpt_emp;i++) {
		    	   if(a.e[i]!= null) {
			   	     if(a.e[i].getM().isbn.equals(em.getM().isbn)) {
						for(int j = i;j<a.cpt_emp-1;j++) {
							a.e[j] = a.e[j+1];
							a.e[j+1] = null;
						}
						a.cpt_emp--;
						d = true;
						em.getM().enregistrer();//je remet le midea dans la bibliotheque 
						System.out.println(">>> Emprunte restituer avec succes !");break;
					  }	    	   
		    	   }
		       }
		       if(!d) {System.out.println(">>> Empreinte n'existe pas !");       
		       		switch (em.getM().l)	{
		       		case mémoire: Mémoire.cpt--;
		       		break;
		       		case livre: Livre.cpt--;
			       		break;
		       		case cd: Cd.cpt--;
			       		break;
		       		}
		       }
		       break;
			}
			x++;
			if(x > cpt) break;
		}
	}
	

	


}

