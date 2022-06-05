package examen;
import java.time.LocalDate;

public class emprunt{
	/*Une empreinte est définit par un midea et une date d'empreinte et un adherent
	 mais j'ai pas besoin de définir l'adherent car tous les methodes en relation avec empreintes sont définit 
	 dans la classe adherent*/
	//attributs
	private media m;
	private LocalDate d;
	
	//constructor
	public emprunt(media m, LocalDate d) {
		this.m = m;
		this.d = d;
	}
	public emprunt(media m) {
		this.m = m;
	}
   
	//getters & setters
	public media getM() {
		return m;
	}
	public void setM(media m) {
		this.m = m;
	}
	public LocalDate getD() {
		return d;
	}
	public void setD(LocalDate d) {
		this.d = d;
	}

	
}
