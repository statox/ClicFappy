package controleurs;

import graphique.ClicPanel;
import graphique_generics.Fenetre;
import datas.Joueur;
import datas.Joueurs;

public class Tests {
	
	
	
	public static void main(String[] args) {
		
		
		
		
		Fenetre fen = new Fenetre();
		Joueur joueur1 = new Joueur("Bizmut", "Paul", "2015", "Paul.bizmut@efrei.net");
		ClicPanel clicPanel = new ClicPanel(joueur1);
		fen.setContentPane(clicPanel);
		fen.revalidate();
		
			
	}
	
	public void caca(){
		Joueurs joueurs = new Joueurs();
		Joueur j1 = new Joueur ("Dugenou", "Marcel", "2019", "marcel.dugenou@efrei.net");
		j1.setBestScore(12);
		Joueur j2 = new Joueur ("Tapedur", "Germaine", "2016", "germaine.tapedur@efrei.net");
		j2.setBestScore(45);
		Joueur j3 = new Joueur ("Dugland", "Fernand", "2015", "germaine.tapedur@efrei.net");
		j3.setBestScore(65);
		Joueur j4 = new Joueur ("Troudouc", "Francis", "2015", "germaine.tapedur@efrei.net");
		j4.setBestScore(32);
		Joueur j5 = new Joueur ("Lasticot", "Coco", "2017", "germaine.tapedur@efrei.net");
		j5.setBestScore(41);
		Joueur j6 = new Joueur ("Woman", "Pretty", "2019", "germaine.tapedur@efrei.net");
		j6.setBestScore(10);
		Joueur j7 = new Joueur ("Toung", "Angus", "2018", "germaine.tapedur@efrei.net");
		j7.setBestScore(56);
		Joueur j8 = new Joueur ("Sious", "Sylvie", "2016", "germaine.tapedur@efrei.net");
		j8.setBestScore(45);
		Joueur j9 = new Joueur ("Netter", "Arnold", "2015", "germaine.tapedur@efrei.net");
		j9.setBestScore(78);
		Joueur j10 = new Joueur ("Kéramzi", "Eric", "2019", "germaine.tapedur@efrei.net");
		j10.setBestScore(98);
		Joueur j11 = new Joueur ("Lébil", "Boul", "2018", "germaine.tapedur@efrei.net");
		j11.setBestScore(65);
		Joueur j12 = new Joueur ("Pinpin", "Perlin", "2019", "germaine.tapedur@efrei.net");
		j12.setBestScore(36);
		
		joueurs.addJoueur(j1);
		joueurs.addJoueur(j2);
		joueurs.addJoueur(j3);
		joueurs.addJoueur(j4);
		joueurs.addJoueur(j5);
		joueurs.addJoueur(j6);
		joueurs.addJoueur(j7);
		joueurs.addJoueur(j8);
		joueurs.addJoueur(j9);
		joueurs.addJoueur(j10);
		joueurs.addJoueur(j11);
		joueurs.addJoueur(j12);
	}
}
