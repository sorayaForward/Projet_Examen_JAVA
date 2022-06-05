package examen;


public class M�moire extends media implements bibliothecaire{
    
	//attributs
	public static int cpt;

	//*********
	
	//constructors
	public M�moire(String nom, String isbn) {
		super(isbn,nom,media_type.m�moire);
		cpt++;
	}
	public M�moire(String isbn) {
    	super(isbn,media_type.m�moire);
    }
	public M�moire() {
		super(media_type.m�moire);
	}
	//***********
	public media_type getL() {
		return l;
	}
	
	//methods
	//ajouter une m�moire ssi le max n'est pas atteint dans la matrice des mideas qui se trouve dans la classe bibliotheque_db
	public void enregistrer() {
		if(cpt<=bibliotheque_db.getMaxMem()) {	
			bibliotheque_db.getM()[1][cpt-1]= this;
			System.out.println(">>> M�moire bien inc�rer");
			}
		}

	//suprimer une memoire ssi elle existe
	public void Supprimer() {
		boolean b = false;
		if(cpt > 1) {
			for(int i = 0;i<cpt;i++) {
				if(bibliotheque_db.getM()[1][i] instanceof M�moire && 
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
			if(bibliotheque_db.getM()[1][0] instanceof M�moire && 
					this.isbn.equals(bibliotheque_db.getM()[1][0].isbn))
			{bibliotheque_db.getM()[1][0] = null;
			b = true;}
	}
		if(!b) {System.out.println(">>> La m�moire n'existe pas !");}
		else {System.out.println(">>> M�moire bien supprimer");cpt--;}	
	}

	
	//modifier une m�moire(soit nom soit isbn) ssi elle existe
	public void Modifier(String nom,String isbn) {
		boolean b = false;
		for(int i = 0;i<cpt;i++) {
			if(bibliotheque_db.getM()[1][i] instanceof M�moire && 
						this.isbn.equals(bibliotheque_db.getM()[1][i].isbn)) {
				b = true;
				if(isbn!="")bibliotheque_db.getM()[1][i].isbn = isbn;
				if(nom!="")bibliotheque_db.getM()[1][i].nom = nom;
				System.out.println(">>> Modification faite");
		}
	}	
		if(!b) System.out.println(">>> La m�moire n'existe pas !");
}

	//verifier esque une m�moire est dispo en fonction de son isbn
	public boolean mediaDispo() {
		int i = 1;
		if(this instanceof M�moire) {
			if(M�moire.cpt == 0) System.out.println(">>> Ya aucune m�moire dans la bibliotheque !");
				if(M�moire.cpt > 0) {
					for(media l:bibliotheque_db.getM()[1]) {
						if(this.isbn.equals(l.isbn)) 
							{return true;}
						i++;
						if( i > M�moire.cpt ) {
							System.out.println(">>> M�moire pas disponible !");
						return false;			
						}
					}
				}
			}
		return false;
	}

	
	//afficher tous les m�moires disponible dans la matrice media qui se trouve dans la bibliotheque_db
	public void afficher(){
		if(bibliotheque_db.getM()[1][0] != null) {
			System.out.println(cpt+" m�moires selectionn�");
		for (media i : bibliotheque_db.getM()[1]){
		if(i instanceof M�moire)
			System.out.println("M�moire [isbn=" + i.isbn + ", nom=" + i.nom + "]");
		    }
		}else System.out.println(">>> Ya aucune m�moire dans la bibliotheque !");
	}


}
