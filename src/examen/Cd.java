package examen;


public class Cd extends media implements bibliothecaire {

    //attributs
	public static int cpt;
	//*********
 
	//constructors
	public Cd(String nom, String isbn) {
		super(isbn,nom,media_type.cd);
		cpt++;
	}
    public Cd(String isbn) {
    	super(isbn,media_type.cd);
    }
	public Cd() {
		super(media_type.cd);
	}
   //***********
   //getter
	public media_type getL() {
		return l;
	}
	
	//methods
	//ajouter un cd ssi le max n'est pas atteint dans la matrice des mideas qui se trouve dans la classe bibliotheque_db
	public void enregistrer() {
		if(cpt<=bibliotheque_db.getMaxC()) {	
			bibliotheque_db.getM()[2][cpt-1]= this;
			System.out.println(">>> Cd bien incérer");
			}
	}


	//supprimer un cd ssi il existe 
	public void Supprimer() {
		boolean b = false;
		if(cpt > 1) {
		for(int i = 0;i<cpt;i++) {
			if(bibliotheque_db.getM()[2][i] instanceof Cd && 
						this.isbn.equals(bibliotheque_db.getM()[2][i].isbn)) {
				b = true;
				if(!(i+1 == cpt)) {
					for(int j = i;j<cpt-1;j++) {
						bibliotheque_db.getM()[2][j] = bibliotheque_db.getM()[2][j+1];
						bibliotheque_db.getM()[2][j+1] = null;
					}
				} else bibliotheque_db.getM()[2][i] = null;
				break;
		}

	}
		} else {
			if(bibliotheque_db.getM()[2][0] instanceof Cd && 
					this.isbn.equals(bibliotheque_db.getM()[2][0].isbn))
			{bibliotheque_db.getM()[2][0] = null;
			b = true;}
			}
		if(!b) {System.out.println(">>> Le Cd n'existe pas !");}
		else {System.out.println(">>> Cd bien supprimer");cpt--;}
	}
	
	//modifier un cd soit nom soit isbn ssi il existe
	public void Modifier(String nom,String isbn) {
		boolean b = false;
		for(int i = 0;i<cpt;i++) {
			if(bibliotheque_db.getM()[2][i] instanceof Cd && 
						this.isbn.equals(bibliotheque_db.getM()[2][i].isbn)) {
				b = true;
				if(isbn!="")bibliotheque_db.getM()[2][i].isbn = isbn;
				if(nom!="")bibliotheque_db.getM()[2][i].nom = nom;
				System.out.println(">>> Modification faite");
			}
	}
		if(!b) System.out.println(">>> Le Cd n'existe pas !");
	}

	
	//verifier la disponibilité d'un cd dans la matrice des mideas qui se trouve dans la classe bibliotheque_db
	public boolean mediaDispo() {
		int i = 1;
		if(this instanceof Cd) {
			if(Cd.cpt == 0) System.out.println(">>> Ya aucun cd dans la bibliotheque !");
				if(Cd.cpt > 0) {
					for(media l:bibliotheque_db.getM()[2]) {
						if(this.isbn.equals(l.isbn)) 
							{return true;}
						i++;
						if( i > Cd.cpt ) {
							System.out.println(">>> Cd pas disponible !");
						return false;			
						}
					}
				}
			}
		return false;
	}
	
	
	//afficher tous les cd disponible dans la matrice media qui se trouve dans la bibliotheque_db + leurs nombres
	public void afficher(){
		if(bibliotheque_db.getM()[2][0] != null) {
			System.out.println(cpt+" cd selectionné");
			for (media i : bibliotheque_db.getM()[2]){
				if(i instanceof Cd)
					System.out.println("Cd [isbn=" + i.isbn + ", nom=" + i.nom + "]");
				    }
		}else System.out.println(">>> Ya aucun Cd dans la bibliotheque !");

	}

}