package examen;
import java.time.LocalDate;
import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		/*difinition du scanner*/
		Scanner sc = new Scanner(System.in);
	
		/*declaration variables*/
		bibliothecaire b;
		int bo,choix1;
		String s,k,newn,newi;
		boolean x = true;
		//*******************
		
		/*Bienvenu et demande d'introduire les infos général sur la bibliotheque(quota des mideas / maxAdherents)*/
		System.out.println("\t\n~BIENVENU AU SYSTEME DE GESTION DE VOTRE BIBLIOTHEQUE~\n");
		System.out.println("RULES : ");
		System.out.println("1 - Un midea peut etre manipuler ssi il existait\n"
					+ "2 - Un midea peut etre empreinter ssi il est disponible\n"
					+ "3 - Un midea peut etre ajouter ssi il ya de l'espace\n"
					+ "4 - Un adherent peut etre ajouter ssi il n'existe pas dans la base de données\n"
					+ "5 - Un adherent ne peut pas etre ajouter si son matricule existe déja, car il doit etre unique\n"
					+ "7 - Un adherent peut etre ajouter ssi ilya de l'espace\n"
					+ "8 - Un adherent peut etre manipuler ssi il existait\n"
					+ "9 - Un adherent peut empreinter un nombre maximal d'empreintes définit par la bibliothecaire\n"
					+ "10 - Un adherent peut empreinter ssi l'empreinte est disponible\n"
					+ "11 - La reincertion du media aprés restitution est automatique\n"
					+ "12 - La suppresion du média aprés empreinte est automatique\n"
					+ "13 - Vous allez introduire quelque informations générale sur votre bib ensuite vous aurai la main sur le menu\n"
					+"\n\tProjet realiser par Soraya Khene & Wissam Meliouh -2022-\n"
					+ "\n***************************************************************************************\n"
					
					);
		
		System.out.println("Veuillez introduire les 5 info général sur votre bibliotheque");
			//set max adherents
		System.out.println("1 - Donner Le max d'adherents");
		choix1 = sc.nextInt();
		bibliotheque_db.setMaxA(choix1);
		
		System.out.println("1 - Donner Le max d'empreintes pour un seul adherent");
		choix1 = sc.nextInt();
		bibliotheque_db.setMaxE(choix1);
			//set max Livres
		System.out.println("2 - Donner Le max de livres");
		choix1 = sc.nextInt();
		bibliotheque_db.setMaxL(choix1);
		
			//set max mémoires
		System.out.println("3 - Donner Le max de mémoires");
		choix1 = sc.nextInt();
		bibliotheque_db.setMaxMem(choix1);
			
			//set max Cd
		System.out.println("4 - Donner Le max de cd");
		choix1 = sc.nextInt();
		bibliotheque_db.setMaxC(choix1);
			
			//set max medias
		bibliotheque_db.setMaxM(bibliotheque_db.getMaxC()+bibliotheque_db.getMaxL()+bibliotheque_db.getMaxM());
			
			//set table d'Adherents
		bibliotheque_db.setA(new adherent [bibliotheque_db.getMaxA()]);
			
			//set matrice des mideas
		media [][] mi = {new Livre[bibliotheque_db.getMaxL()], new Mémoire[bibliotheque_db.getMaxMem()],new Cd[bibliotheque_db.getMaxC()]};
		bibliotheque_db.setM(mi);
			
			//success message
		System.out.println(">>> Toute est bien mis a jour avec succés! maintenant vous pouvez utiliser les fonctionnalitées dans le menu ci-dessus\n");
		/***************************************************************************/
		do {
		    /*Menu*/
			
			//choisir soit Media soit Adherent
			System.out.println("\t\tMenu\n" +
			                   "1 - Media" +
					           "\n2 - Adherent");
			choix1 = sc.nextInt();
			switch (choix1) {
				
				//si midea alors choisir soit livre soit mémoire soit cd
				case 1: System.out.println(
		                   "1 - Livre" + //10
				           "\n2 - Mémoire"+//20
		                   "\n3 - Cd"//30
		                   );
				choix1 = sc.nextInt();
			
				//quelque soit le midea choisir soit enregi / supp / modi / affich 
				System.out.println(
		                   "1 - Enregistrer" +
				           "\n2 - Supprimer"+
						   "\n3 - Modifier"+
						   "\n4 - Afficher");
					int choix2 = sc.nextInt();
					
					//si choix = Enregistrer demander le nbr de mideas a enregistrer tous dépend le type de midea
					if (choix2 == 1) {choix2 = 10;
						if(choix1 == 1)
							System.out.println("Combien de livre ? MaxLivre possible = "+(bibliotheque_db.getMaxL() - Livre.cpt));
						if(choix1 == 2)
							System.out.println("Combien de mémoire ? MaxMémoire possible = "+(bibliotheque_db.getMaxMem() - Mémoire.cpt));
						if(choix1 == 3) 
							System.out.println("Combien de cd ? MaxCd possible = "+(bibliotheque_db.getMaxC() - Cd.cpt));
						
					}
					
					//si choix = Supprimer demander le nbr de mideas a supprimer tous dépend le type de midea
					if (choix2 == 2) {choix2 = 20;
						if(choix1 == 1)
							System.out.println("Combien de livre ? MaxLivre possible = "+Livre.cpt);
						if(choix1 == 2)
							System.out.println("Combien de mémoire ? MaxMémoire possible = "+Mémoire.cpt);
						if(choix1 == 3) 
							System.out.println("Combien de cd ? MaxCd possible = "+Cd.cpt);
					}
			
					//si choix = Modifier demander le nbr de mideas a modifier tous dépend le type de midea			
					if (choix2 == 3) {choix2 = 30;
						if(choix1 == 1)
							System.out.println("Combien de livre ? MaxLivre possible = "+Livre.cpt);
						if(choix1 == 2)
							System.out.println("Combien de mémoire ? MaxMémoire possible = "+Mémoire.cpt);
						if(choix1 == 3)
							System.out.println("Combien de cd ? MaxCd possible = "+Cd.cpt);
				   }
					
					//diriger l'affichage
	                int n;
					if (!(choix2 == 4)) n = sc.nextInt();
						else { choix2 = 40; n = 0;}
					
					//traitement tous dépend les choix avec un grand switch case
					switch(choix1+choix2){
					case 11 ://enregistrer un livre
						for(int i = 0;i<n;i++) {
							if(Livre.cpt < bibliotheque_db.getMaxL()) {
							   System.out.println("Donner le nom du livre "+i);
					 		   s = sc.next();
					 		   System.out.println("Donner le isbn du livre "+i);
					 		   k = sc.next();
					 		   b = new Livre(s,k);
					 		   b.enregistrer();
					 		   b=null;
				 		   }else {System.out.println(">>> MaX des livres est atteint !"); break;}
					}
					break;
				 	case 12 ://enregistrer une mémoire
				 			for(int i = 0;i<n;i++) {
				 				if(Mémoire.cpt < bibliotheque_db.getMaxMem()) {
							 	   System.out.println("Donner le nom du Memoire "+i);
						 		   s = sc.next();
						 		   System.out.println("Donner le isbn du Memoire "+i);
						 		   k = sc.next();
						 		   b = new Mémoire(s,k);
						 		   b.enregistrer();
						 		   b=null;
				 				}else {System.out.println(">>> MaX des Mémoires est atteint !");break;}
				 	}
				 	break;
				 	case 13 ://enregistrer un cd
				 		for(int i = 0;i<n;i++) {
				 			if(Cd.cpt < bibliotheque_db.getMaxC()) {
						 	   System.out.println("Donner le nom du CD "+i);
					 		   s = sc.next();
					 		   System.out.println("Donner le isbn du CD "+i);
					 		   k = sc.next();
					 		   b = new Cd(s,k);
					 		   b.enregistrer();	
					 		   b=null;
				 			}else {System.out.println(">>> MaX des cd est atteint !");break;}
				 		}
				 	break;//supprimer un livre
				 	case 21 : if(Livre.cpt!=0) { 
				 		if(Livre.cpt < n) {System.out.println(">>> Vous pouvez supprimer que "+Livre.cpt);
				 							n = Livre.cpt;}
				 		for(int i = 0;i<n;i++) {
				 		   System.out.println("Donner le isbn du livre "+i);
				 		   s = sc.next();
				 		   b = new Livre(s); 
				 		   b.Supprimer();
				 		   b=null;
				 		   }
				 		} else System.out.println(">>> Ya aucun livre dans la bibliotheque !, veuillez enregistrer d'abord");
				 	break;//supprimer une mémoire
				 	case 22 : if(Mémoire.cpt!=0) { 
				 		if(Mémoire.cpt < n) {System.out.println(">>> Vous pouvez supprimer que "+Mémoire.cpt);
							n = Mémoire.cpt;}
				 		for(int i = 0;i<n;i++) {
					 		   System.out.println("Donner le isbn de la mémoire "+i);
					 		   s = sc.next();
					 		   b = new Mémoire(s); 
					 		   b.Supprimer();
					 		   b=null;
				 		   }
				 		}else System.out.println(">>> Ya aucune Mémoire dans la bibliotheque !");
				 	break;//supprimer un cd
				 	case 23 : if(Cd.cpt!=0) { 
				 		if(Cd.cpt < n) {System.out.println(">>> Vous pouvez supprimer que "+Cd.cpt);
							n = Cd.cpt;}
				 			for(int i = 0;i<n;i++) {
					 		   System.out.println("Donner le isbn du cd "+i);
					 		   s = sc.next();
					 		   b = new Cd(s); 
					 		   b.Supprimer();
					 		   b=null;
				 			}
				 		}else System.out.println(">>> Ya aucun cd dans la bibliotheque !");
				    break;
				 	case 31://modifier un livre consiste a changer soit son nom soit son isbn
				 		if(Livre.cpt != 0) {
				 			/*si l'utilisateur donne un nombre > le nbr de livre existant dans la biblio alors 
				 			on lui dit qu'il peut modifier que le nbr de livre existant*/
					 		if(Livre.cpt < n) {System.out.println(">>> Vous pouvez modiffier que "+Livre.cpt);
								n = Livre.cpt;}
					 			for(int i = 0;i<n;i++) {
						 		   System.out.println("Donner le isbn du livre a modifier "+i);
						 		   s = sc.next();
						 		   b = new Livre(s);
						 		   System.out.println("Voulez vous changer le : "+
						 		   "\n1 - nom"+"\n2 - isbn");
						 		   choix1 = sc.nextInt();
					 		   switch (choix1) {		 		   
					 		   case 1 : //cas de nom
						 		   System.out.println("Donner le nouveau nom du livre a modifier "+i);
						 		   newn = sc.next();
						 		   b.Modifier(newn,"");
					 		    break;
					 		    case 2 : //cas de isbn
					 			   System.out.println("Donner le nouveau isbn du livre a modifier "+i);
					 			   newi = sc.next();
					 			   b.Modifier("",newi);
					 		    break;
					 		   }
					 		   b=null;
					 			 }
					 	}else System.out.println(">>> Ya aucune Livre dans la bibliotheque !");
					break;
				 	case 32://modifier une mémoire consiste a changer soit son nom soit son isbn
				 		if(Mémoire.cpt != 0) {
					 		/*si l'utilisateur donne un nombre > le nbr de mémoires existant dans la biblio alors 
					 		on lui dit qu'il peut modifier que le nbr de mémoires existant*/
					 		if(Mémoire.cpt < n) {System.out.println(">>> Vous pouvez modiffier que "+Mémoire.cpt);
								n = Mémoire.cpt;}
					 			for(int i = 0;i<n;i++) {
						 		   System.out.println("Donner le isbn de la mémoire a modifier "+i);
						 		   s= sc.next();
						 		   b = new Mémoire(s);
						 		   System.out.println("Voulez vous changer le : "+
						 		   "\n1 - nom"+"\n2 - isbn");
						 		   int choix3 = sc.nextInt();
						 		   switch (choix3) {
						 		   case 1 ://cas de nom 
							 		   System.out.println("Donner le nouveau nom de la mémoire a modifier "+i);
							 		   newn = sc.next();
							 		   b.Modifier(newn,"");
						 		   break;
						 		   case 2 : //cas de isbn
						 			   System.out.println("Donner le nouveau isbn de la mémoire a modifier "+i);
						 			   newi = sc.next();
						 			   b.Modifier("",newi);
						 		   break;
						 		   }
					 		   b=null;
					 			}
					 		}else System.out.println(">>> Ya aucune mémoire dans la bibliotheque !");
				    break;
				 		
				 	case 33://modifier un cd consiste a changer soit son nom soit son isbn
				 		if(Cd.cpt != 0) {
					 		/*si l'utilisateur donne un nombre > le nbr de livre existant dans la biblio alors 
				 			on lui dit qu'il peut modifier que le nbr de livre existant*/
					 		if(Cd.cpt < n) {System.out.println(">>> Vous pouvez modiffier que "+Cd.cpt);
							n = Cd.cpt;}
					 		   for(int i = 0;i<n;i++) {
						 		   System.out.println("Donner le isbn du cd a modifier "+i);
						 		   s= sc.next();
						 		   b = new Cd(s);
						 		   System.out.println("Voulez vous changer le : "+
						 		   "\n1 - nom"+"\n2 - isbn");
						 		   choix1 = sc.nextInt();
						 		   switch (choix1) {		 		   
						 		   case 1 ://cas d'un nom
							 		   System.out.println("Donner le nouveau nom du cd a modifier "+i);
							 		   newn = sc.next();
							 		   b.Modifier(newn,"");
						 		   break;
						 		   case 2 ://cas d'un isbn
						 			   System.out.println("Donner le nouveau isbn du cd a modifier "+i);
						 			   newi = sc.next();
						 			   b.Modifier("",newi);
						 		   break;
						 		   }
					 		   b=null;
					 		   }
				 		   }else System.out.println("Ya aucune cd dans la bibliotheque !");
			        break;
				 
				 	case 41://Affichage livre
				 	Livre a = new Livre();
				 	a.afficher();			 
				 	break;
				 	case 42://Affichage mémoire
				 	Mémoire m = new Mémoire();
				 	m.afficher();
				 	break;
				 	case 43://Affichage cd
				 	Cd c = new Cd();
				 	c.afficher();
				 	break;	   
				}	
				break;
				
	//PARTIE ADHERENT	
				//choisir l'option
				case 2 : System.out.println(
		                   "1 - Enregistrer" +
				           "\n2 - Supprimer"+
						   "\n3 - Modifier"+
				           "\n4 - Afficher la liste noir"+
						   "\n5 - Emprunter"+
				           "\n6 - Consulter une emprunte"+
						   "\n7 - Restituer une emprunte"
						   + "\n8 - Afficher liste d'adherents"
						    );
				 n = sc.nextInt();
				
				switch (n) {			
				case 1 ://saisir combien d'adherents a ajouter 
					System.out.println("Combien d'adherents ? max = "+(bibliotheque_db.getMaxA() - adherent.cpt));
					n = sc.nextInt();
					for(int i = 0;i<n;i++) {//vérifier si l'adherent existe déja si il existe msg erreur sinon incerer
					 	   System.out.println("Donner le nom de l'adherent "+i);
				 		   s = sc.next();
				 		   System.out.println("Donner le prenom de l'adherent "+i);
				 		   k = sc.next();
				 		   System.out.println("Donner le mat de l'adherent "+i);
				 		   int mat = sc.nextInt();
				 		   b = new adherent(s,k,mat);//cpt++
				 		   if(!adherent.adherentDispo(mat,s,k)){ //enregistrer ssi adherent n'existe pas
				 			   if(!adherent.adherentDispo(mat)) {
				 			   b.enregistrer();
				 			   }else {
				 				   System.out.println(">>> Ce Matricule existe déja ! le mat doit etre unique");
				 			    adherent.cpt--;}
				 		   }
				 		   else {
				 			   System.out.println(">>> Adherent existe déja !");
				 			   adherent.cpt--;
				 		   }
					}
				break;
				case 2 ://supprimer un adherent
					if(adherent.cpt!= 0) {
						//saisir combien d'adherents a supprimer
						System.out.println("Combien d'adherents ? max = "+adherent.cpt);
						n = sc.nextInt();
						for(int i = 0;i<n;i++) {
					 		   System.out.println("Donner le mat de l'adherent "+i);
					 		   int mat = sc.nextInt();
					 		   b = new adherent(mat);
					 		   if(adherent.adherentDispo(mat)){
					 			   b.Supprimer();//supprimer ssi l'adherent existe
					 			   System.out.println(">>> Suppression avec succée");
					 		   }
					 		   else System.out.println(">>>Ya aucun adheretn avec ce matricule !");
					 		   b = null; 
						}
					} else System.out.println(">>> Ya aucun adherent enregistrer !");
				break;
				case 3 ://modifier un adherent, soit changer son nom soit son prenom
						if(adherent.cpt != 0) {
							System.out.println("Combien d'adherents ? max = "+adherent.cpt);
							n = sc.nextInt();
								if(adherent.cpt < n) {System.out.println(">>> Vous pouvez modifier seulement "+adherent.cpt);
														n = adherent.cpt;}
								for(int i = 0 ;i<n; i++) {
						 		  System.out.println("Donner le mat de l'adherent "+i);
						 		   int mat = sc.nextInt();
						 		   if(adherent.adherentDispo(mat)){//modifier l'empreinte ssi l'adherent existe
							 		   b = new adherent(mat);//sa incrémente pas le cpt
							 		   System.out.println("Voulez vous changer le : "+
							 		   "\n1 - nom"+"\n2 - prenom");
							 		   int choix3 = sc.nextInt();
							 		   switch (choix3) {
								 		   case 1 : 
									 		   System.out.println("Donner le nouveau nom de l'adherent "+i);
									 		   newn = sc.next();
									 		   b.Modifier(newn,"");
									 		   System.out.println(">>> Modification avec succée");
								 		   break;
								 		   case 2 : 
								 			   System.out.println("Donner le nouveau prenom de l'adherent "+i);
								 			   String newp = sc.next();
								 			   b.Modifier("",newp);
								 			   System.out.println(">>> Modification avec succée");
								 			break;
							 		   }
						 		   } else System.out.println(">>> Ya aucun adherent avec ce matricule !");
						 		   b=null;
								}
						}else System.out.println(">>> Ya aucun adherent enregistrer !");
				break;
				case 4 ://afficher la liste noire
						if(adherent.cpt > 0) {
							bibliothecaire_ad a = new adherent();
							a.afficherListeNoir();	
						}else System.out.println(">>> Ya aucun adherent enregistrer !");
				break;
				case 5 ://ajouter emprunte
						if(adherent.cpt!=0) {
							System.out.println("Combien d'adherents ? max = "+adherent.cpt);
							n = sc.nextInt();
							if(adherent.cpt < n) {System.out.println(">>> Ya que "+adherent.cpt+" adherent(s) dans la bibliotheque");
								n = adherent.cpt;}
							for(int i = 0;i<n;i++) {
						 		   System.out.println("Donner le mat de l'adherent "+i);
						 		   int mat = sc.nextInt();
						 		   if(adherent.adherentDispo(mat)){//emreinter ssi l'adherent existe
							 		   System.out.println("voulez emprunter un : "+
							 		   "\n1 - Livre"+
							 		   "\n2 - Mémoire"+
							 		   "\n3 - Cd");				 		
							 		   choix2 = sc.nextInt();
							 		   adherent ad = new adherent(mat);
							 		   emprunt em1 = null;
							 		   switch (choix2) {			 		   
								 		   case 1: 
								 			   if(Livre.cpt>0) {
								 		   		System.out.println("Donner Le isbn du livre");
									 		    k = sc.next();
								 			    em1 = new emprunt(new Livre(k),LocalDate.now());
								 			   }else { x = false;
								 				   System.out.println(">>> Ya aucun livre dans la biblio !");
								 			   }
								 		   break;
								 		   case 2:
								 			   if(Mémoire.cpt >0) {
								 		   		 System.out.println("Donner Le isbn de la mémoire");
									 		     k = sc.next();
								 			     em1 = new emprunt(new Mémoire(k),LocalDate.now());
								 			   }
								 			   else { x = false;
								 			   		System.out.println(">>> Ya aucune mémoire dans la biblio !");
								 			   }
								 			break;
								 		   	case 3:
									 			if(Cd.cpt >0) {
								 		   	     System.out.println("Donner Le isbn du cd");
									 		     k = sc.next();
								 			     em1 = new emprunt(new Cd(k),LocalDate.now());
									 			} else  { x = false;
									 				System.out.println(">>> Ya aucun Cd dans la biblio !");
									 			}

								 			break;
							 		   }
							 		   if(x) ad.emprunter(em1);
						 		   }else System.out.println(">>> Ya aucun adherent avec ce matricule !");
							}
						} else System.out.println(">>> Ya aucun adherent enregistrer !");
					break;
				case 6 ://consulter une empreinte
						if(adherent.cpt != 0) {
						    System.out.println("Combien d'Adherent ? max = "+adherent.cpt);
							n = sc.nextInt();
							if(adherent.cpt < n) {System.out.println("Ya que "+adherent.cpt+" adherent(s) dans la bibliotheque");
													n = adherent.cpt;}
							for(int i= 0 ;i<n;i++) {
							System.out.println("Donner le matricule de l'adherent a consulter ses empreintes "+i);
					 		int m = sc.nextInt();
						 		if(adherent.adherentDispo(m)){ 
						 		    adherent ad = new adherent(m);
									System.out.println("Donner le type du media "+i+
						 		    		"\n1 - livre"+
						 		    		"\n2 - mémoire"+
						 		    		"\n3 - cd");
						 			int type = sc.nextInt();
						 			System.out.println("Donner le isbn du media "+i);
									k = sc.next();
									emprunt e = null;
						 			switch (type) {
							 			case 1 :e = new emprunt(new Livre(k));//there's no cpt++
							 			break;
							 			case 2 :e = new emprunt(new Mémoire(k)); 
							 			break;
							 			case 3 : e = new emprunt(new Cd(k));
							 			break;
						 			}
									m = ad.consulter(e);
									switch (m) {
										case -8:
											System.out.println(">>> L'adherent est en retard!");
										break;
										case -9:	
											System.out.println(">>> Le delait de l'emprunt est aujourd'hui");
										break;
										case -5:
											System.out.println(">>> Cette empreinte n'existe pas !");
										break;
										default:
											System.out.println(">>> Le delai qui lui reste "+m+" Jours");
										break;
									}
						 		} else System.out.println(">>> Ya aucun adherent avec ce matricule !");
							}
						} else System.out.println(">>> Ya aucun adherent enregistrer !");
				break;
				case 7 ://restituer une empreinte
						if(adherent.cpt != 0) {
						    System.out.println("Combien d'Adherent ? max = "+adherent.cpt);
							n = sc.nextInt();
							if(adherent.cpt < n) {System.out.println("Ya que "+adherent.cpt+" adherent(s) dans la bibliotheque");
								n = adherent.cpt;}
							for(int i= 0 ;i<n;i++) {
								System.out.println("Donner le matricule de l'adherent a restituer ses empreintes "+i);
						 		int m = sc.nextInt();
						 		if(adherent.adherentDispo(m)){ 
						 		    adherent ad = new adherent(m);
						 		    System.out.println("Donner le type du media "+i+
						 		    		"\n1 - livre"+
						 		    		"\n2 - mémoire"+
						 		    		"\n3 - cd");
						 			int type = sc.nextInt();
						 			System.out.println("Donner le isbn du media "+i);
									k = sc.next();
									System.out.println("Donner le nom du media "+i);
									s = sc.next();
									emprunt e = null;
						 			switch (type) {
							 			case 1 :e = new emprunt(new Livre(s,k));//cpt++
							 			break;
							 			case 2 :e = new emprunt(new Mémoire(s,k)); 
							 			break;
							 			case 3 : e = new emprunt(new Cd(s,k));
							 			break;
						 			}
									ad.restituer(e);
						 		} else System.out.println(">>> Ya aucun adherent avec ce matricule !");
							}
						}else System.out.println(">>> Ya aucun adherent enregistrer !");
					break;
					case 8: if(adherent.cpt > 0) {
								adherent.affichageAd();
							}else System.out.println(">>> Ya aucun adherent enregistrer !");
					break;
				
				}break;
			}
			System.out.println("Revenir au menu pricipale ? no 0 | yes 1");
			bo = sc.nextInt();
		}while(bo==1);
		sc.close();//fermiture du canal
	}
}
