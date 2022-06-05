package examen;


public class Mémoire extends media implements bibliothecaire{
    
	//attributs
	public static int cpt;

	//*********
	
	//constructors
	public Mémoire(String nom, String isbn) {
		super(isbn,nom,media_type.mémoire);
		cpt++;
	}
	public Mémoire(String isbn) {
    	super(isbn,media_type.mémoire);
    }
	public Mémoire() {
		super(media_type.mémoire);
	}
	//***********
	public media_type getL() {
		return l;
	}
	
	//methods
	//ajouter une mémoire ssi le max n'est pas atteint dans la matrice des mideas qui se trouve dans la classe bibliotheque_db
	public void enregistrer() {
		if(cpt<=bibliotheque_db.getMaxMem()) {	
			bibliotheque_db.getM()[1][cpt-1]= this;
			System.out.println(">>> Mémoire bien incérer");
			}
		}

	//suprimer une memoire ssi elle existe
	public void Supprimer() {
		boolean b = false;
		if(cpt > 1) {
			for(int i = 0;i<cpt;i++) {
				if(bibliotheque_db.getM()[1][i] instanceof Mémoire && 
							this.isbn.equals(bibliotheque_db.getM()[1][i].isbn)) {
					b = true;
					if(!(i+1 == cpt)) {
						for(int j = i;j<cpt-1;j++) {
							bibliotheque_db.getM()[1][j] = bibliotheque_db.getM()[1][j+1];
							bibliotheque_db.getM()[1][j+1] = null;
						}
					}
					else bibliotheque_db.getM()[1][i] = null;
					break;
				}
			}
		}
		else {
			if(bibliotheque_db.getM()[1][0] instanceof Mémoire && 
					this.isbn.equals(bibliotheque_db.getM()[1][0].isbn))
			{bibliotheque_db.getM()[1][0] = null;
			b = true;}
	}
		if(!b) {System.out.println(">>> La mémoire n'existe pas !");}
		else {System.out.println(">>> Mémoire bien supprimer");cpt--;}	
	}

	
	//modifier une mémoire(soit nom soit isbn) ssi elle existe
	public void Modifier(String nom,String isbn) {
		boolean b = false;
		for(int i = 0;i<cpt;i++) {
			if(bibliotheque_db.getM()[1][i] instanceof Mémoire && 
						this.isbn.equals(bibliotheque_db.getM()[1][i].isbn)) {
				b = true;
				if(isbn!="")bibliotheque_db.getM()[1][i].isbn = isbn;
				if(nom!="")bibliotheque_db.getM()[1][i].nom = nom;
				System.out.println(">>> Modification faite");
		}
	}	
		if(!b) System.out.println(">>> La mémoire n'existe pas !");
}

	//verifier esque une mémoire est dispo en fonction de son isbn
	public boolean mediaDispo() {
		int i = 1;
		if(this instanceof Mémoire) {
			if(Mémoire.cpt == 0) System.out.println(">>> Ya aucune mémoire dans la bibliotheque !");
				if(Mémoire.cpt > 0) {
					for(media l:bibliotheque_db.getM()[1]) {
						if(this.isbn.equals(l.isbn)) 
							{return true;}
						i++;
						if( i > Mémoire.cpt ) {
							System.out.println(">>> Mémoire pas disponible !");
						return false;			
						}
					}
				}
			}
		return false;
	}

	
	//afficher tous les mémoires disponible dans la matrice media qui se trouve dans la bibliotheque_db
	public void afficher(){
		if(bibliotheque_db.getM()[1][0] != null) {
			System.out.println(cpt+" mémoires selectionné");
		for (media i : bibliotheque_db.getM()[1]){
		if(i instanceof Mémoire)
			System.out.println("Mémoire [isbn=" + i.isbn + ", nom=" + i.nom + "]");
		    }
		}else System.out.println(">>> Ya aucune mémoire dans la bibliotheque !");
	}


}
