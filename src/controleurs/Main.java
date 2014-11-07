package controleurs;

import graphique.AccueilPanel;
import graphique.ClicPanel;
import graphique.HighScoresPanel;
import graphique.NouveauJoueurPanel;
import graphique.ScoreFinalPanel;
import graphique.ScorePanel;
import graphique_generics.Fenetre;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import datas.Joueur;
import datas.Joueurs;

public class Main {
	
	
	
	public static void main(String[] args) {
		// objets pour le jeu
		Joueurs joueurs = new Joueurs();
		Joueur joueur1;
		Joueur joueur2;
			
		// création du dossier de sauvegardes
		File saveDir = new File("./sauvegardes_clicFappy");
		if (!saveDir.exists()) {
			System.out.println("creating directory: " + "./sauvegardes_clicFappy");
			boolean result = false;
		
			try{
				saveDir.mkdir();
				result = true;
			} catch(SecurityException se){
				System.out.println("ERROR: Impossible de créer le dossier de sauvegarde!");
			}        
			if(result) {    
				System.out.println("dossier de sauvegarde créé");  
			}
		}
		
		// création des fichiers de sauvegarde
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy-HH_mm_ss");
		Date today = Calendar.getInstance().getTime();        
		String date = df.format(today);

		String cheminSauvegarde = "./sauvegardes_clicFappy/" + date ;
		File file = new File(cheminSauvegarde);
		joueurs.sauvegardeTexte(cheminSauvegarde);
		
		
		// objets graphiques
		Fenetre fen 				= new Fenetre();
		ScorePanel scorePanel		= null;
		AccueilPanel accueilPanel	= null;
		ClicPanel clicPanel 		= null;
		ScoreFinalPanel	scoreFinalPanel		= null;
		NouveauJoueurPanel newPlayerPanel 	= null;
		HighScoresPanel highScoresPanel		= null;
		
		int tour=0;
		while (true){
			tour++;
		
			
			// affichage de la page d'accueil
			accueilPanel	= new AccueilPanel();
			fen.setContentPane(accueilPanel);
			fen.revalidate();
			accueilPanel.attendreAction();
			
			
			// inscription joueur 1
			newPlayerPanel = new NouveauJoueurPanel(1, joueurs);
			fen.setContentPane(newPlayerPanel);
			fen.revalidate();
			newPlayerPanel.setJoueurCree(false);
			boolean next = false;
	
			// attente du nouveau joueur 1
			while (!newPlayerPanel.getJoueurCree()){		
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			newPlayerPanel.setJoueurCree(false);
			joueur1 = newPlayerPanel.getNouveauJoueur();
	
			
			// inscription joueur 2
			newPlayerPanel = new NouveauJoueurPanel(2, joueurs);
			fen.setContentPane(newPlayerPanel);	
			fen.revalidate();
			newPlayerPanel.setJoueurCree(false);
			// attente du nouveau joueur 2
			while (!newPlayerPanel.getJoueurCree()){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			newPlayerPanel.setJoueurCree(false);
			joueur2 = newPlayerPanel.getNouveauJoueur();
								
			// tour Joueur 1
			clicPanel = new ClicPanel(joueur1);
			fen.setContentPane(clicPanel);
			fen.revalidate();
					
			int score1 = clicPanel.tour();
			System.out.println("score: " + score1);
			
			// score joueur 1
			scorePanel = new ScorePanel(joueur1, score1);
			fen.setContentPane(scorePanel);
			fen.revalidate();
			
			// attente appui bouton
			while (!scorePanel.getTermine()){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// tour Joueur 2
			clicPanel = new ClicPanel(joueur2);		
			fen.setContentPane(clicPanel);
			fen.revalidate();
			int score2 = clicPanel.tour();
			System.out.println("score: " + score2);
			
			// score joueur 2
			scorePanel = new ScorePanel(joueur2, score2);
			fen.setContentPane(scorePanel);
			fen.revalidate();
			
			// attente appui bouton
			while (!scorePanel.getTermine()){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// resultats de la partie
			scoreFinalPanel = new ScoreFinalPanel(joueur1, joueur2, score1, score2);
			fen.setContentPane(scoreFinalPanel);
			fen.revalidate();
			
			// attente appui bouton
			while (!scoreFinalPanel.getTermine()){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// gestion des hiscrores
			if (score1 > joueur1.getBestScore()){
				joueur1.setBestScore(score1);
			}
			if (score2 > joueur2.getBestScore()){
				joueur2.setBestScore(score2);
			}
			
			// affichage des highscores
			highScoresPanel = new HighScoresPanel(joueurs, joueur1, joueur2);
			fen.setContentPane(highScoresPanel);
			fen.revalidate();
			
			// sauvegarde des joueurs dans un fichier texte
			joueurs.sauvegardeTexte(cheminSauvegarde);
			
			// attente appui bouton
			while (!highScoresPanel.getTermine()){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
		}	
	}
}
