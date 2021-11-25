package model;



import java.awt.Point ;
import java.util.Observable;
import java.util.Observer;

public class Perspective extends Observable{

	private Images imagePerspective ;
	private Point sizeInPerspective ;
	private Point positionInPerspective ;
	private Observer observer;
	
	public Perspective(Images imagePerspective){
		this.imagePerspective= imagePerspective;
		this.sizeInPerspective = new Point(-1,-1) ;
		this.positionInPerspective = new Point(-1,-1) ; 
	}

	public Perspective(){
		this.sizeInPerspective = new Point(0,0) ;
		this.positionInPerspective = new Point(0,0) ;
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

	public void addObsrvr(Observer o){
		this.observer=o;
	}

	public void notifyObserver(){
		observer.update(this, null);
	}

	
}
