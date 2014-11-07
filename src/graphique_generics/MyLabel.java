package graphique_generics;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MyLabel extends JLabel {

	private static Color color = Color.black;
	
	
	public static Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}
	
	public MyLabel() {
		this.set();
	}

	public MyLabel(String arg0) {
		super(arg0);
		this.set();
	}

	public MyLabel(Icon arg0) {
		super(arg0);
		this.set();
	}

	public MyLabel(String arg0, int arg1) {
		super(arg0, arg1);
		this.set();
	}

	public MyLabel(Icon arg0, int arg1) {
		super(arg0, arg1);
		this.set();
	}

	public MyLabel(String arg0, Icon arg1, int arg2) {
		super(arg0, arg1, arg2);
		this.set();
	}
	
	private void set(){
		this.setFont(new Font("Serif", Font.BOLD, 30));
		this.setForeground(color);
	}

}
