package examen;

/*interface spécial au type adherent,car la bibliothecaire affiche la liste noir des adherents seulement
elle herite tous les methodes de l'interface bibliothecaire*/
public interface bibliothecaire_ad extends bibliothecaire {

	void afficherListeNoir();
	
}

