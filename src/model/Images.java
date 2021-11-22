package model;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

public class Images {
	
	String path ;
	Image img ;
	
	/**
	 * Construteur de la classe Images.java
	 *
	 */
	public Images(String path) {
		super();
		this.path = path;
		this.img = buildImage(path) ; 
	}
	
	/**
	 * Methode permettant : d'assurer l'existance de notre ficher Image et de l'encapsuler dans une objet Image.java 
	 * @param path : Chemin absolue du Ficher image
	 * @return Image
	 */
	public Image buildImage(String path) {
		Image img = null ;
		File tempFile = new File(path);
		if (tempFile.exists() && !tempFile.isDirectory() ) {
			img = Toolkit.getDefaultToolkit().createImage(path);
		}
		else {
			System.out.println("# Error : File not found");
		}
		return img ;
	}

	/** Getter de l'attribut : String
	 * @return String : Instance de l'attribut this.path
	 */
	public String getPath() {
		return path;
	}

	/** Setter de l'attribtut : this.path
	 * @param path : Nouvelle valeur de l'attribut this.path 
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/** Getter de l'attribut : Image
	 * @return Image : Instance de l'attribut this.img
	 */
	public Image getImg() {
		return img;
	}

	/** Setter de l'attribtut : this.img
	 * @param img : Nouvelle valeur de l'attribut this.img 
	 */
	public void setImg(Image img) {
		this.img = img;
	}



	
}
