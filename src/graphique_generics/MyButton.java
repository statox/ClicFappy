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
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MyButton extends JButton {
	private Image background;
	private String name;
	
	public MyButton() {
		set("");
	}

	public MyButton(Icon arg0) {
		super(arg0);
		set("");
	}

	public MyButton(String arg0) {
		super(arg0);
		set(arg0);
	}

	public MyButton(Action arg0) {
		super(arg0);
		set("");
	}

	public MyButton(String arg0, Icon arg1) {
		super(arg0, arg1);
		set(arg0);
	}
	
	private void set(String text){
		try {
			background = ImageIO.read(new File("./images/btn.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name=text;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;

		g2d.setBackground(Color.gray);
	    g2d.setColor(Color.white);
	    

	   
	    FontMetrics fm = g2d.getFontMetrics();
	    int height = fm.getHeight();
	    int width = fm.stringWidth(this.name);
	    g2d.drawString(this.name, this.getWidth() / 2 - (width / 2) , (this.getHeight() / 2) + (height / 4));
	  }    
}

