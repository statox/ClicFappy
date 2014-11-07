package graphique_generics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JLabel;

public class MyButtonFappy extends JLabel {

	private Image background;
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyButtonFappy() {
		set();
	}

	public MyButtonFappy(String text) {
		super(text);
		set();
	}

	public MyButtonFappy(Icon image) {
		super(image);
		set();
	}

	public MyButtonFappy(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		set();
	}

	public MyButtonFappy(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		set();
	}

	public MyButtonFappy(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		set();
	}
		
	private void set(){
		this.setFont(new Font("Serif", Font.BOLD, 20));
//		background = java.awt.Toolkit.getDefaultToolkit().getImage( "./images/souris_btn.jpg" );
		try {
			background = ImageIO.read(new File("./images/souris_btn2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
	    GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
	    g2d.setPaint(gp);
	    g2d.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
	    g2d.setColor(Color.black);
	   
	    //Objet permettant de connaître les propriétés d'une police, dont la taille
	    FontMetrics fm = g2d.getFontMetrics();
	    //Hauteur de la police d'écriture
	    int height = fm.getHeight();
	    //Largeur totale de la chaîne passée en paramètre
	    if (this.name==null){
	    	this.name="";
	    }
	    int width = fm.stringWidth(this.name);
	    //On calcule alors la position du texte, et le tour est joué
	    g2d.drawString(this.name, this.getWidth() / 2 - (width / 2), (this.getHeight() / 2) + (height / 4));
	  }    
}
