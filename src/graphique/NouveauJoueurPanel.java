package graphique;

import graphique_generics.BackgroundPanel;
import graphique_generics.MyLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

import datas.Joueur;
import datas.Joueurs;

public class NouveauJoueurPanel extends BackgroundPanel {
	
	private MyLabel 	lblSaisieIncorrecte;
	private MyLabel 	lblInstruction;
	private MyLabel 	lblPrenom;
	private MyLabel 	lblNom;
	private MyLabel 	lblEmail;
	private MyLabel 	lblPromo;
	private JTextField 	textFieldPrenom;
	private JTextField 	textFieldNom;
	private JTextField 	textFieldEmail;
	private JList 		listPromo;
	
	private Joueur nouveauJoueur;	
	private boolean joueurCree;
	
	
	public Joueur getNouveauJoueur() {
		return nouveauJoueur;
	}
	public void setNouveauJoueur(Joueur nouveauJoueur) {
		this.nouveauJoueur = nouveauJoueur;
	}
	public boolean getJoueurCree() {
		return joueurCree;
	}
	public void setJoueurCree(boolean joueurCree) {
		this.joueurCree = joueurCree;
	}


	public NouveauJoueurPanel(int numeroJoueur, final Joueurs joueurs) {
		// definition des reglages du Panel
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowHeights = new int[]{0, 58, 0, 0, 0, 0, 98, 0};
		gridBagLayout.columnWidths = new int[]{155, 134, 0, 84, 279, 67, 38, 138, 98};
		setLayout(gridBagLayout);
		
		// definition des elements
			// Label Instructions
		lblInstruction = new MyLabel("Joueur " + numeroJoueur + " identifiez vous");
			// Label SaisieIncorrecte
		lblSaisieIncorrecte = new MyLabel("* Votre saisie est incorrecte, merci de recommencer");
		lblSaisieIncorrecte.setFont(new Font("Serif", Font.ITALIC, 15));
		lblSaisieIncorrecte.setForeground(Color.red);
		lblSaisieIncorrecte.setVisible(false);
		
			// TextField Prenom
		textFieldPrenom = new JTextField();
		
		// definition des contraintes
			// Label Instructions
		GridBagConstraints gbc_lblInstructions = new GridBagConstraints();
		gbc_lblInstructions.gridwidth = 5;
		gbc_lblInstructions.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstructions.gridx = 2;
		gbc_lblInstructions.gridy = 0;
							
		add(lblInstruction, gbc_lblInstructions);
		// Label Prenom
		lblPrenom = new MyLabel("Pr\u00E9nom");
		
			//  Label Prenom
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 0;
		gbc_lblPrenom.gridy = 2;
		
		add(lblPrenom, gbc_lblPrenom);
		// Label Nom
		lblNom = new MyLabel("Nom");
		
			// Label Nom  
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 3;
		gbc_lblNom.gridy = 2;
				
		add(lblNom, gbc_lblNom);
		// TextField Nom
		textFieldNom = new JTextField();
		
			// TextField nom  
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.gridx = 4;
		gbc_textFieldNom.gridy = 2;
		
		add(textFieldNom, gbc_textFieldNom);
		// Label Email
		lblEmail = new MyLabel("email");
		
			// Label Email  
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 6;
		gbc_lblEmail.gridy = 2;
		
		add(lblEmail, gbc_lblEmail);
		// TextField Email
		textFieldEmail = new JTextField();
		
			// TextField Email  
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 7;
		gbc_textFieldEmail.gridy = 2;
		
		add(textFieldEmail, gbc_textFieldEmail);
		// Label Promo
		lblPromo = new MyLabel("Promo");
		
			// Label Promo  
		GridBagConstraints gbc_lblPromo = new GridBagConstraints();
		gbc_lblPromo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPromo.gridx = 3;
		gbc_lblPromo.gridy = 3;
		
		add(lblPromo, gbc_lblPromo);
		
			// List Promo
		listPromo = new JList();
		listPromo.setListData(new Object[] {"2015", "2016", "2017", "2018", "2019", "ancien"});
		
			// List Promo
		GridBagConstraints gbc_ListPromo = new GridBagConstraints();
		gbc_ListPromo.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListPromo.insets = new Insets(0, 0, 5, 5);
		gbc_ListPromo.gridx = 4;
		gbc_ListPromo.gridy = 3;
		
		add(listPromo, gbc_ListPromo);
		
			// Label SaisieIncorrecte
		GridBagConstraints gbc_lblSaisieIncorrect = new GridBagConstraints();
		gbc_lblSaisieIncorrect.gridwidth = 5;
		gbc_lblSaisieIncorrect.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaisieIncorrect.gridx = 2;
		gbc_lblSaisieIncorrect.gridy = 5;
		
		add(lblSaisieIncorrecte, gbc_lblSaisieIncorrect);
		
			// TextField Prenom  
		GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
		gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenom.gridx = 1;
		gbc_textFieldPrenom.gridy = 2;
							
		add(textFieldPrenom, gbc_textFieldPrenom);
		
			// Button valider
		JButton btnValider = new JButton("valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblNom.setForeground(MyLabel.getColor());
				lblPrenom.setForeground(MyLabel.getColor());
				lblEmail.setForeground(MyLabel.getColor());
				lblPromo.setForeground(MyLabel.getColor());
				
				lblSaisieIncorrecte.setVisible(false);
				
				creerJoueur(joueurs);
			}
		});
		
			// Button valider  
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.gridwidth = 5;
		gbc_btnValider.insets = new Insets(0, 0, 0, 5);
		gbc_btnValider.gridx = 2;
		gbc_btnValider.gridy = 7;
		
		add(btnValider, gbc_btnValider);		
	}
	
	public void creerJoueur(Joueurs joueurs){
		boolean saisieCorrecte = true;
		
		String nom 		= null;
		String prenom 	= null;
		String email	= null;
		String promo	= null;
		
		try{
			nom		=	textFieldNom.getText().toString();
			nom 	= 	nom.toLowerCase();
								
			if (nom==null || nom.isEmpty() || ! nom.matches ("[a-zA-Z]+\\.?") ){
				throw (new NullPointerException());
			}
									
			nom = Character.toUpperCase(nom.charAt(0)) + nom.substring(1);
		}catch(NullPointerException e){
			lblSaisieIncorrecte.setVisible(true);
			lblNom.setForeground(Color.red);
			saisieCorrecte = false;
		}
		
		try{
			prenom	=	textFieldPrenom.getText().toString();
			prenom 	= 	prenom.toLowerCase();
			
			if (prenom==null || prenom.isEmpty() || ! prenom.matches ("[a-zA-Z]+\\.?") ){
				throw (new NullPointerException());
			}
						
			prenom = Character.toUpperCase(prenom.charAt(0)) + prenom.substring(1);
			
		}catch(NullPointerException e){
			lblSaisieIncorrecte.setVisible(true);
			lblPrenom.setForeground(Color.red);
			saisieCorrecte = false;
		}
		
		try{
			email 	=	textFieldEmail.getText().toString();
			
			String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
									+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if (email==null || email.isEmpty() || ! email.matches (EMAIL_PATTERN) ){
				throw (new NullPointerException());
			}
			
		}catch(NullPointerException e){
			lblSaisieIncorrecte.setVisible(true);
			lblEmail.setForeground(Color.red);
			saisieCorrecte = false;
		}
		try{
			promo	= 	listPromo.getSelectedValue().toString();
		
		}catch(NullPointerException e){
			lblSaisieIncorrecte.setVisible(true);
			lblPromo.setForeground(Color.red);
			saisieCorrecte = false;
		}
		
		this.revalidate();
		
		if (saisieCorrecte){
			Joueur j = new Joueur(nom, prenom, promo, email);
			Joueur creation = joueurs.addJoueur(j);
			
			if (creation == null){
				setJoueurCree(true);
				setNouveauJoueur(j);
			}else{
				setJoueurCree(true);
				setNouveauJoueur(creation);
			}
		}
	}
}
