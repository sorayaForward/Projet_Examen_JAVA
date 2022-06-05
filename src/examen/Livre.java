package examen;

public class Livre extends media implements bibliothecaire{
     
   //attributs
	public static int cpt;
   //*********
	
	//constructors
	public Livre(String nom, String isbn) {
		super(isbn,nom,media_type.livre);
		cpt++;
	}
	public Livre(String isbn) {
		super(isbn,media_type.livre);
	}
	public Livre() {
		super(media_type.livre);
	}
   //***********
	
	public media_type getL() {
		return l;
	}

	//Methods
	//enregistrer un livre ssi le max n'est pas atteint  dans la matrice des mideas qui se trouve dans la classe bibliotheque_db
	public void enregistrer() {//nom,isbn,cpt++
		if(cpt<=bibliotheque_db.getMaxL()) {	
		bibliotheque_db.getM()[0][cpt-1] = this;
		System.out.println(">>> Livre bien incerer");
		}
	}

	
	//supprimer un livre ssi il existe
	public void Supprimer() {//nom,isbn
		boolean b = false;
		if(cpt > 1) {
			for(int i = 0;i<cpt;i++) {
				if(bibliotheque_db.getM()[0][i] instanceof Livre && 
							this.isbn.equals(bibliotheque_db.getM()[0][i].isbn)) {
					b = true;
					if(!(i+1 == cpt)) {
						for(int j = i;j<cpt-1;j++) {
							bibliotheque_db.getM()[0][j] = bibliotheque_db.getM()[0][j+1];
							bibliotheque_db.getM()[0][j+1] = null;
						}
					} else bibliotheque_db.getM()[0][i] = null;
					break;
				}
			}
		} else {//cas de la premiere case seul
			if(bibliotheque_db.getM()[0][0] instanceof Livre && 
					this.isbn.equals(bibliotheque_db.getM()[0][0].isbn))
			{bibliotheque_db.getM()[0][0] = null;
			b = true;}
		}
	
		if(!b) {System.out.println(">>> Le Livre n'existe pas !");}
		else {System.out.println(">>> Livre bien supprimer");cpt--;}
		}

  
	//modiffier un livre  ssi il existe
	public void Modifier(String name,String isbn) {
		boolean b = false;
		for(int i = 0;i<cpt;i++) {
			if(bibliotheque_db.getM()[0][i] instanceof Livre && 
						this.isbn.equals(bibliotheque_db.getM()[0][i].isbn)) {
				b = true;
				if(isbn!="")bibliotheque_db.getM()[0][i].isbn = isbn;
				if(name!="")bibliotheque_db.getM()[0][i].nom = name;
				System.out.println(">>> Modification faite");
				break;
		}
	  }
		if(!b) System.out.println(">>> Le Livre n'existe pas !");
	}
    
	//verifier esque un livre est dispo en fonction de son isbn
	public boolean mediaDispo() {
		int i = 1;
		if(this instanceof Livre) {
			if(Livre.cpt == 0) System.out.println(">>> Ya aucun livre dans la bibliotheque !");
				if(Livre.cpt > 0) {
					for(media l:bibliotheque_db.getM()[0]) {
						if(this.isbn.equals(l.isbn)) 
							{return true;}
						i++;
						if( i > Livre.cpt ) {
							System.out.println(">>> Livre pas disponible ou enexistant !");
						return false;			
						}
					}
				}
			}
		return false;
	}
   
	
	//afficher tous les livres dans la bd
	public void afficher() {
		if(bibliotheque_db.getM()[0][0] != null) {
			System.out.println(cpt+" livres selectionné");
		for (media i : bibliotheque_db.getM()[0]){
			if(i instanceof Livre)
				System.out.println("Livre [isbn=" + i.isbn + ", nom=" + i.nom + "]");
		}		
			} else System.out.println(">>> Ya aucun Livre dans la bibliotheque !");

		}
	
	

}