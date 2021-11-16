package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Image {
	
	String path ;
	ImageIcon img ;
	Double[] size = new Double[2] ;
	int[] position = new int[2] ;
	
	/*
	 * TODO 
	 * Repair Build Image
	 * Implement Notify
	 * Implement Test
	 * Java Doc
	 * 
	 * */
	
	public Image(String path) {
		super();
		this.path = path;
		this.img = buildImage(path) ; 
		this.size = new Double[] {0.0 , 0.0} ;
		this.position = new int[] {0 , 0} ; //x,y
	}
	
	public ImageIcon buildImage(String path) {
		String path1 = "modelTest\\TestedImage.png" ; 

		InputStream imgStream = getClass().getResourceAsStream(path1);
		BufferedImage img = null;
		try {
			img = ImageIO.read(imgStream); //NULL WTF
		} catch (IOException e) {
			System.out.println("## The Given path for image is invalid");
		}
		ImageIcon image = new ImageIcon(img);
		return image ;
	}
	
	public void zoom(Double factor) {
		this.size[0] *= factor ;
		this.size[1] *= factor ;
		notifyChangement();
	}
	
	public void translateTo(int[] newPosition) {
		this.position[0] = newPosition[0] ;
		this.position[1] = newPosition[1] ;
		notifyChangement();
	}
	
	public void translateHorizontally(String direction) {
		if(direction.equals("right")) {
			this.position[0] ++ ;
			notifyChangement();
		}
		else if(direction.equals("left")) {
			this.position[0] -- ;
			notifyChangement();
		}
		else {
			System.out.println("## Horizontal translation Command is invalid");

		}
	}
	
	public void translateVerticaly(String direction) {
		if(direction.equals("down")) {
			this.position[1] ++ ;
			notifyChangement();
		}
		else if(direction.equals("up")) {
			this.position[1] -- ;
			notifyChangement();
		}
		else {
			System.out.println("## Vertical translation Command is invalid");
		}
	}
	
	public void notifyChangement() {
		//String type ?
		System.out.println("Image State changed");
	}
}
