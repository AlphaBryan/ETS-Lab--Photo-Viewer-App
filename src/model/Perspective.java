package model;



import java.awt.Point ;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class Perspective extends Observable   implements Serializable {

	private Images imagePerspective ;
	private Point sizeInPerspective ;
	private Point positionInPerspective ;
	private boolean focus = true ; 

	private Observer observer;


	public Perspective(){
		this.sizeInPerspective = new Point(-1,-1) ;
		this.positionInPerspective = new Point(-1,-1) ;
	}

	public Images getImagePerspective() {
		return imagePerspective;
	}


	public void setImagePerspective(Images imagePerspective) {
		initPositionAndSize();
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
	@Override
	public void addObserver(Observer o){
		this.observer=o;
	}

	@Override
	public void notifyObservers(){
		observer.update(this, null);
	}

	/** Getter de l'attribut : boolean
	 * @return boolean : Instance de l'attribut this.focus
	 */
	public boolean isFocus() {
		return focus;
	}

	/** Setter de l'attribtut : this.focus
	 * @param focus : Nouvelle valeur de l'attribut this.focus 
	 */
	public void setFocus(boolean focus) {
		this.focus = focus;
	}

	
	public void initPositionAndSize() {
		this.sizeInPerspective = new Point(200,200) ;
		this.positionInPerspective = new Point(150,150) ;
	}

	/**
	@see java.lang.Object#toString()
	**/
	@Override
	public String toString() {
		return this.getClass() + "[sizeInPerspective=" + sizeInPerspective + ", positionInPerspective="
				+ positionInPerspective + "]";
	}


	
}
