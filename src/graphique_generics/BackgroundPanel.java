package graphique_generics;


import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

//	private Image background;
	BufferedImage background;
	
	public BackgroundPanel() {
//		background = java.awt.Toolkit.getDefaultToolkit().getImage( "./images/background.jpg" );
		try {
			background = ImageIO.read(new File( "./images/background50.png" ));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		

//		final int width = background.getWidth();
//		int[] imgData = new int[width];
//		int[] maskData = new int[width];
//
//		for (int y = 0; y < background.getHeight(); y++) {
//		    // fetch a line of data from each image
//			background.getRGB(0, y, width, 1, imgData, 0, 1);
//		    mask.getRGB(0, y, width, 1, maskData, 0, 1);
//		    // apply the mask
//		    for (int x = 0; x < width; x++) {
//		        int color = imgData[x] & 0x00FFFFFF; // mask away any alpha present
//		        int maskColor = (maskData[x] & 0x00FF0000) << 8; // shift red into alpha bits
//		        color |= maskColor;
//		        imgData[x] = color;
//		    }
//		    // replace the data
//		    background.setRGB(0, y, width, 1, imgData, 0, 1);
//		}
		
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}

}
