package model;

import java.awt.Point ; 
public class Perspective {

	Images imagePerspective ; 
	Point sizeInPerspective ; 
	Point positionInPerspective ; 
	
	
	Perspective(Images imagePerspective){
		this.sizeInPerspective = new Point(-1,-1) ; 
		this.positionInPerspective = new Point(-1,-1) ; 
	}


	public Images getImagePerspective() {
		return imagePerspective;
	}


	public void setImagePerspective(Images imagePerspective) {
		this.imagePerspective = imagePerspective;
	}


	public Point getSizeInPerspective() {
		return sizeInPerspective;
	}


	public void setSizeInPerspective(Point sizeInPerspective) {
		this.sizeInPerspective = sizeInPerspective;
	}


	public Point getPositionInPerspective() {
		return positionInPerspective;
	}


	public void setPositionInPerspective(Point positionInPerspective) {
		this.positionInPerspective = positionInPerspective;
	}
	
	
}
