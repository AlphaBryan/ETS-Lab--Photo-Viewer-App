package model;

import java.awt.Image;
import java.awt.Toolkit;

public class Images {
	
	String path ;
	Image img ;
	
	public Images(String path) {
		super();
		this.path = path;
		this.img = buildImage(path) ; 
	}
	
	public Image buildImage(String path) {
		Image img = Toolkit.getDefaultToolkit().createImage(path);
		return img ;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
}
