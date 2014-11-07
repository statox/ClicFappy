package graphique;

import graphique_generics.BackgroundPanel;
import graphique_generics.MyButtonFappy;
import graphique_generics.MyLabel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import datas.Joueur;

public class ClicPanel extends BackgroundPanel {

	private int cptClics;
	private int debut;
	private boolean started;
	private MyButtonFappy btnClicMe;
	private MyButtonFappy btnStart;
	private MyLabel lblNbClics;
	private MyLabel lblTime;


	public ClicPanel(Joueur j) {
		// definition des reglages du Panel
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{104, 42, 0, 118};
		gridBagLayout.rowHeights = new int[]{0, 51, 0, 56, 79, 44, 132};
		setLayout(gridBagLayout);
		cptClics=0;
		started=false;
		
		// definition des elements
			// Label Joueur
		MyLabel lblJoueur = new MyLabel("Au tour de " + j.getPrenom());
			// Label NbClics
		lblNbClics = new MyLabel(" 0 clics");
		lblNbClics.setVisible(false);
		
		// Button ClicMe
		btnClicMe = new MyButtonFappy();
		btnClicMe.setName("start");
		btnClicMe.setVisible(true);
		btnClicMe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!started){
					lblNbClics.setVisible(true);
					lblTime.setVisible(true);
					btnClicMe.setName("Clic me!");
					btnClicMe.repaint();
					setDebut(1);
					started=true;
				}else{
					if (arg0.getButton()==1){
						cptClics++;
						lblNbClics.setText(cptClics + " clics");
					}
				}
			}
		});
		
		// definitions des contraintes
			// Label Joueur
		GridBagConstraints gbc_lblJoueur = new GridBagConstraints();
		gbc_lblJoueur.insets = new Insets(0, 0, 5, 5);
		gbc_lblJoueur.gridx = 2;
		gbc_lblJoueur.gridy = 0;
		
		add(lblJoueur, gbc_lblJoueur);

				
			// Label NbClics 
		GridBagConstraints gbc_lblNbClics = new GridBagConstraints();
		gbc_lblNbClics.insets = new Insets(0, 0, 5, 5);
		gbc_lblNbClics.gridx = 0;
		gbc_lblNbClics.gridy = 4;
		
		add(lblNbClics, gbc_lblNbClics);
		
		
				// Label Time
		lblTime = new MyLabel("10 secondes");
		lblTime.setVisible(false);
		
			// Label Time 
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.insets = new Insets(0, 0, 5, 0);
		gbc_lblTime.gridx = 3;
		gbc_lblTime.gridy = 4;
		
		add(lblTime, gbc_lblTime);
		
			// Button ClicMe 
		GridBagConstraints gbc_btnClicMe = new GridBagConstraints();
		gbc_btnClicMe.insets = new Insets(0, 0, 0, 5);
		gbc_btnClicMe.fill = GridBagConstraints.BOTH;
		gbc_btnClicMe.gridx = 2;
		gbc_btnClicMe.gridy = 6;
		
		add(btnClicMe, gbc_btnClicMe);
	}
	
	public int getDebut() {
		return debut;
	}
	
	public void setDebut(int debut) {
		this.debut = debut;
	}

	public int tour (){
		System.out.println("Début du tour");
		
		cptClics=0;
		setDebut(0);
		
		while (getDebut()==0){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("CLICK NAAOOWW");
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() < startTime+10*1000){
			long time = 10 - ((System.currentTimeMillis() - startTime) / 1000);
			String stringTime = "" + time + " secondes";
			lblTime.setText(stringTime);
		}
		
		System.out.println("Fin du tour!");
		return cptClics;
	}
}
