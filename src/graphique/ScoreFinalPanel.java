package graphique;

import graphique_generics.BackgroundPanel;
import graphique_generics.MyLabel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import datas.Joueur;

public class ScoreFinalPanel extends BackgroundPanel {

	private boolean termine;
	
	public boolean getTermine() {
		return termine;
	}

	public void setTermine(boolean termine) {
		this.termine = termine;
	}

	public ScoreFinalPanel(Joueur j1, Joueur j2, int s1, int s2) {
		// definition des reglages du Panel
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[]{0, 53, 0, 51, 0, 51, 0};
		setLayout(gridBagLayout);
		setTermine(false);
		
		// definition des elements
			// Label Resultat
		MyLabel lblResultat = new MyLabel("Resultats:");
			// Label J1
		MyLabel lblJ1 = new MyLabel(j1.getPrenom() + " " + s1);
			// Label J2
		MyLabel lblJ2 = new MyLabel(j2.getPrenom() + " " + s2);
			// Label Vainqueur
		String vainqueur = "Félicitations " + j1.getPrenom();
		if (s2>s1){
			vainqueur = "Félicitations " + j2.getPrenom();
		}else if (s2==s1){
			vainqueur = "Vous etes a égalité ";
		}
		MyLabel lblVainqueur = new MyLabel(vainqueur);

			// Button Suivant
		JButton btnSuivant = new JButton("suivant");
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTermine(true);
			}
		});

		// definitions des contraintes
			// Label Resultat
		GridBagConstraints gbc_lblResultat = new GridBagConstraints();
		gbc_lblResultat.insets = new Insets(0, 0, 5, 5);
		gbc_lblResultat.gridx = 1;
		gbc_lblResultat.gridy = 0;
								
		add(lblResultat, gbc_lblResultat);
		
			// Label J1
		GridBagConstraints gbc_lblJ1 = new GridBagConstraints();
		gbc_lblJ1.insets = new Insets(0, 0, 5, 5);
		gbc_lblJ1.gridx = 0;
		gbc_lblJ1.gridy = 2;
								
		add(lblJ1, gbc_lblJ1);
		
			// Label J2
		GridBagConstraints gbc_lblJ2 = new GridBagConstraints();
		gbc_lblJ2.insets = new Insets(0, 0, 5, 0);
		gbc_lblJ2.gridx = 2;
		gbc_lblJ2.gridy = 2;
								
		add(lblJ2, gbc_lblJ2);
		
			// Label Vainqueur
		GridBagConstraints gbc_lblVainqueur = new GridBagConstraints();
		gbc_lblVainqueur.insets = new Insets(0, 0, 5, 5);
		gbc_lblVainqueur.gridx = 1;
		gbc_lblVainqueur.gridy = 4;
								
		add(lblVainqueur, gbc_lblVainqueur);
			
			// Button Suivant
		GridBagConstraints gbc_btnSuivant = new GridBagConstraints();
		gbc_btnSuivant.insets = new Insets(0, 0, 0, 5);
		gbc_btnSuivant.gridx = 1;
		gbc_btnSuivant.gridy = 6;
								
		add(btnSuivant, gbc_btnSuivant);
	}
}
