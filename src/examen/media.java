package examen;

public abstract class media implements bibliothecaire{
	
	/*c'est une classe qui ne peut pas etre instancier, elle contient les methodes & attributs commun entre livre,m�moire & cd*/
	//attributs
	//un midea est d�finit par un nom & un isbn
	protected String isbn,nom;
	protected media_type l;
	//constructors
	public media(String isbn,String nom,media_type l){
		this.isbn = isbn;
		this.nom = nom;
		this.l = l;
	}
	public media(String isbn,media_type l) {
		this.isbn = isbn;
		this.l = l;
	}
	 public media(media_type l) {
     this.l = l;
	 }
	 
	//methode qui retourne le type du media tous d�pend l'obj appelant
	public abstract media_type getL();
	
	//methode qui v�rifie la disponibilit� d'un midea, son corp est identifier dans les classes qui herite de cette classe
	public abstract boolean mediaDispo();
	
	//declaration des methodes que leurs corps est identifier dans les classes qui herite de cette classe
	@Override
	public abstract void enregistrer();
	@Override
	public abstract void Supprimer();
	@Override
	public abstract void Modifier(String x, String y);

}
