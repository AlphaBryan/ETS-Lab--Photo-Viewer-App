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
	
	
	/** Constructeur de notre classe Image
	 *  @param path : Chemin menant a notre Image
	 **/
	public Image(String path) {
		super();
		this.path = path;
		this.img = buildImage(path) ; 
	}
	
	/** BuildImage : Encapsule une image à partir d'un chemin
	 *  @param path : Chemin menant a notre Image
	 *  @return Image : Image encapsulee
	 **/
	public ImageIcon buildImage(String path) {
		System.out.println("Path : "+path);
		BufferedImage img = null;
		File file = null ; 
		
		try {
			file = new File(path) ;
			System.out.println("File : " +file.exists() );

	        //img = new BufferedImage(BufferedImage.TYPE_INT_ARGB, 0, 0);
			img = ImageIO.read(file); //NULL WTF
			//System.out.println("img : " +img );

		} catch (IOException e) {
			System.out.println("## The Given path for image is invalid");
		}
		ImageIcon image = new ImageIcon(img);
		return image ;
	}
		
}
