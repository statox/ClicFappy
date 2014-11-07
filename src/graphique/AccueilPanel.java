package graphique;

import graphique_generics.BackgroundPanel;
import graphique_generics.MyLabel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AccueilPanel extends BackgroundPanel {

	// cette variable est utilisée pour savoir dans la classe Main quel bouton est cliqué ici
	private int action;
	
	
	/**
	 * Création du panneau d'acceuil contenant le texte de bienvenur
	 */
	public AccueilPanel() {
		// definition des reglages du Panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[]{0, 349, 0};
		setLayout(gridBagLayout);
		
		
		
		// definition des elements
			// Label Bienvenue
		MyLabel lblBienvenue = new MyLabel("Bienvenue dans ClicFappy");
		lblBienvenue.setFont(new Font("Serif", Font.BOLD, 50));
		
		
			// Image souris
		JLabel imgSouris = new JLabel( new ImageIcon("./images/souris.jpg", "image de souris") );

		
			// Bouton Nouvelle Partie
		JButton btnNewPartie = new JButton("D\u00E9marrer la partie");
		btnNewPartie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Lancement nouvelle partie");
				setAction(1);
			}
		});
			
			
		// definition des contraintes
			// Label Bienvenue
		GridBagConstraints gbc_lblBienvenue = new GridBagConstraints();
		gbc_lblBienvenue.gridx = 0;
		gbc_lblBienvenue.gridy = 0;		// On se positionne sur la premiere ligne
				
		gbc_lblBienvenue.gridwidth 	= 1;
		gbc_lblBienvenue.gridheight	= 1;
				
		add(lblBienvenue, gbc_lblBienvenue);
		
			// Image souris
		GridBagConstraints gbc_imgSouris = new GridBagConstraints();
		gbc_imgSouris.gridx = 0;
		gbc_imgSouris.gridy = 1;		// deuxieme ligne
	
		gbc_imgSouris.gridwidth 	= 1;
		gbc_imgSouris.gridheight	= 1;
		
		gbc_imgSouris.insets = new Insets(5, 5, 5, 5);	// marge de 5 entre l'image et les autres composants et les bords
		
//		add(imgSouris, gbc_imgSouris);
	
			// Bouton Nouvelle Partie
		GridBagConstraints gbc_btnNewPartie = new GridBagConstraints();
		gbc_btnNewPartie.gridx = 0;
		gbc_btnNewPartie.gridy = 2;		// troisieme ligne

		gbc_btnNewPartie.gridwidth 	= 1;
		gbc_btnNewPartie.gridheight	= 1;
		
		add(btnNewPartie, gbc_btnNewPartie);
	}
	
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}

	public void attendreAction(){
		setAction(0);
		int test;
		do{
			test=getAction();
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}while (test==0);
		return;
	}
}