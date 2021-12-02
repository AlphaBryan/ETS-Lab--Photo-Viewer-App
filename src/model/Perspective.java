package model;



import java.awt.Point ;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe perspective representant les perspectives (translation et zoom) de l'image
 * Attributs  :
 * image : representant la perspective
 * sizeInPerspective : pour avoir le zoom de l'image
 * positionInPerspective : pour avoir la position de l'image translatee
 * observer : representant l'observateur qui met à jour les perspectives
 */
public class Perspective extends Observable   implements Serializable {

	private Images imagePerspective ;
	private Point sizeInPerspective ;
	private Point positionInPerspective ;

	private Observer observer;

	/**
	 * constructeur de la classe perspective
	 */
	public Perspective(){
		this.sizeInPerspective = new Point(200,200) ;
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
		return sizeInPerspective ; 
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

	/**
	 * methode qui permet d'ajouter un observer qui est transmis en parametres
	 * @param o
	 */
	@Override
	public void addObserver(Observer o){
		this.observer=o;
	}

	/**
	 * methode qui permet de faire la mise à jour de l'affichage
	 */
	@Override
	public void notifyObservers(){
		observer.update(this, null);
	}

	/**
	 * permet d'etablir la position de la perspective de translation et la taille de la perspective de zoom
	 */
	public void initPositionAndSize() {
		this.sizeInPerspective = new Point(200,200) ;
		this.positionInPerspective = new Point(150,150) ;
	}

	/**
	*faire l'affichage en chaîne de caracteres d'un objet perspective
	**/
	@Override
	public String toString() {
		return this.getClass() + "[sizeInPerspective=" + sizeInPerspective + ", positionInPerspective="
				+ positionInPerspective + "]";
	}

	
}
