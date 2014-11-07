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

public class ScorePanel extends BackgroundPanel {

	private boolean termine;
	
	public boolean getTermine() {
		return termine;
	}
	public void setTermine(boolean termine) {
		this.termine = termine;
	}

	public ScorePanel(Joueur j, int score) {
		// definition des reglages du Panel
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 95};
		gridBagLayout.rowHeights = new int[]{0, 74, 0, 101, 0};
		setLayout(gridBagLayout);
		setTermine(false);
		
		// definitions des elements
			// Label Resultat
		MyLabel lblResultat = new MyLabel(j.getPrenom() + " ton score est de " + score);
		
			// Label Recrutement
		String txtRecrutement = "";
		switch (j.getPromo()){
		case "2016":
			txtRecrutement = "Volontariat sur CV, stage assuré! fap@efrei.fr";
			break;
		case "2017":
			txtRecrutement = "Pense à Fap pour valoriser ton CV! fap@efrei.fr ";
			break;
		case "2018":
			txtRecrutement = "Fap recherche un stagiaire L2, penses-y! fap@efrei.fr";
			break;
		case "2019":
			txtRecrutement = "Pour bien commencer à l'efrei, rejoins Fap Efrei! fap@efrei.fr";
			break;
		default:
			txtRecrutement = "Aller, viens t'faper!";
			break;
		}
		MyLabel lblRecrutement = new MyLabel(txtRecrutement);
	

		// definitions des contraintes
			// Label Resultat
		GridBagConstraints gbc_lblResultat = new GridBagConstraints();
		gbc_lblResultat.insets = new Insets(0, 0, 5, 5);
		gbc_lblResultat.gridx = 0;
		gbc_lblResultat.gridy = 0;
		
		add(lblResultat, gbc_lblResultat);
		gbc_lblResultat.gridx = 0;
		gbc_lblResultat.gridy = 2;
				
			// Label Recrutement
		GridBagConstraints gbc_lblRecrutement = new GridBagConstraints();
		gbc_lblRecrutement.insets = new Insets(0, 0, 5, 5);
		gbc_lblRecrutement.gridx = 0;
		gbc_lblRecrutement.gridy = 2;
		
		add(lblRecrutement, gbc_lblRecrutement);
		
		// Button Suivant
		JButton btnSuivant = new JButton("suivant");
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTermine(true);
			}
		});
		
			// Button Suivant
		GridBagConstraints gbc_btnSuivant = new GridBagConstraints();
		gbc_btnSuivant.gridx = 1;
		gbc_btnSuivant.gridy = 4;
		
		add(btnSuivant, gbc_btnSuivant);

	}
}
