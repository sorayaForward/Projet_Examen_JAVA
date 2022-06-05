package examen;

/*Cette classe représente la base de donnée de toute la bibliotheque, elle est abstract car j'ai pas besoin de
 déclarer plusieurs bibliotheques, elle contient :
 1 - un tableau des Adherents 
 2 - une matrice midea avec trois lignes,
 1er ligne ilya le tableau des livres
 2eme ligne ilya le tableau des mémoires
 3eme ligne ilya le tableau des Cds
 3 - les maximums(adherents,livres,cds,mémoires,medias,empreintes) que la bibliotheque peut gérer, se sont
 définit par la bibliothecaire l'ors de la premiere utilisation */
public abstract class bibliotheque_db {
	
	/*attributs statitcs pour acceder directement au données apartir du nom de la classe 
	sans instancier des objets car la classe est déja abstract*/
	private static int maxA,maxE,maxL,maxMem,maxC,maxM;
	private static adherent[] a;
	private static media [][] m;
	
	
	
	//Getters & Setters
	public static int getMaxA() {
		return maxA;
	}
	public static int getMaxE() {
		return maxE;
	}
	public static int getMaxM() {
		return maxM;
	}
	public static adherent[] getA() {
		return a;
	}
	public static int getMaxL() {
		return maxL;
	}
	public static int getMaxMem() {
		return maxMem;
	}
	public static int getMaxC() {
		return maxC;
	}
	public static void setA(adherent[] a) {
		bibliotheque_db.a = a;
	}
	public static media[][] getM() {
		return m;
	}
	public static void setM(media[][] m) {
		bibliotheque_db.m = m;
	}
	public static void setMaxA(int maxA) {
		bibliotheque_db.maxA = maxA;
	}
	public static void setMaxE(int maxE) {
		bibliotheque_db.maxE = maxE;
	}
	public static void setMaxL(int maxL) {
		bibliotheque_db.maxL = maxL;
	}
	public static void setMaxMem(int maxMem) {
		bibliotheque_db.maxMem = maxMem;
	}
	public static void setMaxC(int maxC) {
		bibliotheque_db.maxC = maxC;
	}
	public static void setMaxM(int maxM) {
		bibliotheque_db.maxM = maxM;
	}

}