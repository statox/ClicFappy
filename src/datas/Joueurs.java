package datas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Joueurs {

	private ArrayList<Joueur> joueurs;

	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	public Joueurs() {
		joueurs = new ArrayList<Joueur>();
	}
	
	// ajoute un Joueur au conteneur a condition qu'il n''y soit pas déjà présent
	// retourne	null si on ajoute le nouveau joueur
	//			Le joueur déjà existant sinon
	public Joueur addJoueur(Joueur j){
		Joueur alreadyExists = getJoueur(j);
		if ( alreadyExists == null){
			joueurs.add(j);
			System.out.println("joueur ajouté: " + j);
			return null;
		}else{
			System.out.println("joueur déjà existant: " + j);
			return alreadyExists;
		}
	}
	
	public Joueur getJoueur(Joueur j){
		for (Joueur i : joueurs){
			if (i.equals(j)){
				return i;
			}
		}
		
		return null;
	}
	
	public Joueur getJoueur(String nom, String prenom){
		
		for (Joueur j : joueurs){
			if (j.getPrenom().equals(prenom) && j.getNom().equals(nom)){
				return j;
			}
		}
		
		return null;
	}
	
	public void sortByScore(){
		class comparatorJoueursScore implements Comparator<Joueur> {
		    public int compare(Joueur j1, Joueur j2) {
		        return j2.getBestScore() - j1.getBestScore();
		    }
		}
		Collections.sort(joueurs, new comparatorJoueursScore());
	}
	
	public void sortByName(){
		class comparatorJoueursName implements Comparator<Joueur> {
		    public int compare(Joueur j1, Joueur j2) {
		        return j1.getNom().compareTo(j2.getNom());
		    }
		}
		Collections.sort(joueurs, new comparatorJoueursName());
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "";
		
		for (Joueur j : joueurs){
			s = s+"\n"+j.toString();
		}
		
		return s;
	}
	
	public void sauvegardeTexte (String dossier){
				
		// sauvegarde ordonnée par scores
		sortByScore();
		String chemin = dossier + "_sorted_by_scores.txt";
		
		String saveJoueurs = "";
		for (Joueur j : joueurs){
			saveJoueurs = saveJoueurs 
							+ j.getBestScore() 
							+ "\t" + j.getNom() 
							+ "\t" + j.getPrenom() 
							+ "\t" + j.getPromo() 
							+ "\t" + j.getEmail() 
							+ "\n"; 
		}
		
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(chemin)));
			writer.append("============================================\n");
			writer.append(new Date().toGMTString());
			writer.append("\n\n");
			writer.append(saveJoueurs);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// sauvegarde ordonnée par Noms
		sortByName();
		chemin = dossier + "_sorted_by_names.txt";
		
		saveJoueurs = "";
		for (Joueur j : joueurs){
			saveJoueurs = saveJoueurs  
					+ j.getNom() 
					+ "\t" + j.getPrenom() 
					+ "\t" + j.getPromo() 
					+ "\t" + j.getEmail()
					+ "\t" + + j.getBestScore()
					+ "\n";
		}
		
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(chemin)));
			writer.append("============================================\n");
			writer.append(new Date().toGMTString());
			writer.append("\n\n");
			writer.append(saveJoueurs);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
