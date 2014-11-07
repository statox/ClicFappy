package graphique;

import graphique_generics.BackgroundPanel;
import graphique_generics.MyLabel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JTable;

import datas.Joueur;
import datas.Joueurs;

public class HighScoresPanel extends BackgroundPanel {


	private Joueurs js;
	private Joueur j1, j2;
	
	private boolean termine;
	
	public boolean getTermine() {
		return termine;
	}
	public void setTermine(boolean termine) {
		this.termine = termine;
	}
	
	public HighScoresPanel(Joueurs joueurs, Joueur joueur1, Joueur joueur2) {
		// definition des reglages du Panel
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[]{0, 60, 0, 43, 0, 0, 0, 0, 49, 0};
		setLayout(gridBagLayout);
		setTermine(false);
		this.js = joueurs;
		this.j1 = joueur1;
		this.j2 = joueur2;
		
		// definition des elements
			// Label Titre
		MyLabel lblTitre = new MyLabel("Classement général");
			// Label J1
		MyLabel lblJ1 = new MyLabel(j1.getPrenom());
			// Label J2
		MyLabel lblJ2 = new MyLabel(j2.getPrenom());
			
			// Button Suivant
		JButton btnSuivant = new JButton("suivant");
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTermine(true);
			}
		});
		
			// Table TopTen
		JTable tableTopTen = new JTable(11, 5);
		tableTopTen.setShowGrid(false);
		tableTopTen.setShowVerticalLines(false);
		tableTopTen.setShowHorizontalLines(false);
		tableTopTen.setFillsViewportHeight(true);
		
		topTen(tableTopTen);

			// Table J1
		JTable tableJ1 = new JTable(3, 5);
		tableJ1.setShowVerticalLines(false);
		tableJ1.setShowGrid(false);
		tableJ1.setShowHorizontalLines(false);
		
		placeJoueur(tableJ1, j1);
		
			// Table J2
		JTable tableJ2 = new JTable(3, 5);
		tableJ2.setShowGrid(false);
		tableJ2.setShowHorizontalLines(false);
		tableJ2.setShowVerticalLines(false);
		
		placeJoueur(tableJ2, j2);
		
		// definition des contraintes
			// Label Titre 
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitre.gridx = 0;
		gbc_lblTitre.gridy = 0;
								
		add(lblTitre, gbc_lblTitre);
			
			// Label J1 
		GridBagConstraints gbc_lblJ1 = new GridBagConstraints();
		gbc_lblJ1.insets = new Insets(0, 0, 5, 0);
		gbc_lblJ1.gridx = 0;
		gbc_lblJ1.gridy = 4;
								
		add(lblJ1, gbc_lblJ1);
		
			// Label J2 
		GridBagConstraints gbc_lblJ2 = new GridBagConstraints();
		gbc_lblJ2.insets = new Insets(0, 0, 5, 0);
		gbc_lblJ2.gridx = 0;
		gbc_lblJ2.gridy = 6;
								
		add(lblJ2, gbc_lblJ2);
		
			// Table TopTen 
		GridBagConstraints gbc_TableTopTen = new GridBagConstraints();
		gbc_TableTopTen.insets = new Insets(0, 0, 5, 0);
		gbc_TableTopTen.gridx = 0;
		gbc_TableTopTen.gridy = 2;
								
		add(tableTopTen, gbc_TableTopTen);
		
			// Table J1
		GridBagConstraints gbc_TableJ1 = new GridBagConstraints();
		gbc_TableJ1.insets = new Insets(0, 0, 5, 0);
		gbc_TableJ1.gridx = 0;
		gbc_TableJ1.gridy = 5;
								
		add(tableJ1, gbc_TableJ1);

			// Table J2 
		GridBagConstraints gbc_TableJ2 = new GridBagConstraints();
		gbc_TableJ2.insets = new Insets(0, 0, 5, 0);
		gbc_TableJ2.gridx = 0;
		gbc_TableJ2.gridy = 7;
								
		add(tableJ2, gbc_TableJ2);
		
			// Button Suivant 
		GridBagConstraints gbc_btnSuivant = new GridBagConstraints();
		gbc_btnSuivant.gridx = 0;
		gbc_btnSuivant.gridy = 9;
								
		add(btnSuivant, gbc_btnSuivant);

	}
	
	public void placeJoueur (JTable t, Joueur j){
		int place = js.getJoueurs().indexOf(j);
		Joueur prec = null;
		Joueur suiv = null;
		
		if (place > 0){
			prec = js.getJoueurs().get(place-1);	
		}
		if (place < js.getJoueurs().size()-1){
			suiv = js.getJoueurs().get(place+1);
		}
		
		if (prec != null){
			t.setValueAt(place , 0, 0);
			t.setValueAt(prec.getBestScore(), 	0, 1);
			t.setValueAt(prec.getPrenom(), 		0, 2);
			t.setValueAt(prec.getNom(), 		0, 3);
			t.setValueAt(prec.getPromo(), 		0, 4);
		}
		
		t.setValueAt(place+1, 			1, 0);
		t.setValueAt(j.getBestScore(), 	1, 1);
		t.setValueAt(j.getPrenom(), 	1, 2);
		t.setValueAt(j.getNom(), 		1, 3);
		t.setValueAt(j.getPromo(), 		1, 4);
		
		if (suiv != null){
			t.setValueAt(place+2, 				2, 0);
			t.setValueAt(suiv.getBestScore(), 	2, 1);
			t.setValueAt(suiv.getPrenom(), 		2, 2);
			t.setValueAt(suiv.getNom(), 		2, 3);
			t.setValueAt(suiv.getPromo(), 		2, 4);
		}
	}
	
	public void topTen(JTable t){	
		
		js.sortByScore();
		
		Iterator<Joueur> it = js.getJoueurs().iterator();
		int cpt=0;
		
		t.setValueAt("Place", 	0, 0);
		t.setValueAt("Score", 	0, 1);
		t.setValueAt("Prénom", 	0, 2);
		t.setValueAt("Nom", 	0, 3);
		t.setValueAt("Promo", 	0, 4);
		
		while (it.hasNext() && cpt<10){
			Joueur j = it.next();
			cpt++;
	
			t.setValueAt(cpt, 				cpt, 0);
			t.setValueAt(j.getBestScore(), 	cpt, 1);
			t.setValueAt(j.getPrenom(), 	cpt, 2);
			t.setValueAt(j.getNom(), 		cpt, 3);
			t.setValueAt(j.getPromo(), 		cpt, 4);
			
		}
	}
}
