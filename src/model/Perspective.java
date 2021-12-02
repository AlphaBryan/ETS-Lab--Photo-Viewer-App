package model;



import java.awt.Point ;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe perspective représentant les perspectives (translation et zoom) de l'image
 * Attributs  :
 * image : représentant la perspective
 * sizeInPerspective : pour avoir le zoom de l'image
 * positionInPerspective : pour avoir la position de l'image translatée
 * observer : représentant l'observateur qui met à jour les perspectives
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
		if(sizeInPerspective == new Point(-1,-1) ) {
			return sizeInPerspective ; 
		}
		else {
			return new Point(200,200) ; 
		}
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
	 * méthode qui permet d'ajouter un observer qui est transmis en paramètres
	 * @param o
	 */
	@Override
	public void addObserver(Observer o){
		this.observer=o;
	}

	/**
	 * méthode qui permet de faire la mise à jour de l'affichage
	 */
	@Override
	public void notifyObservers(){
		observer.update(this, null);
	}

	/**
	 * permet d'établir la position de la perspective de translation et la taille de la perspective de zoom
	 */
	public void initPositionAndSize() {
		this.sizeInPerspective = new Point(200,200) ;
		this.positionInPerspective = new Point(150,150) ;
	}

	/**
	*faire l'affichage en chaîne de caractères d'un objet perspective
	**/
	@Override
	public String toString() {
		return this.getClass() + "[sizeInPerspective=" + sizeInPerspective + ", positionInPerspective="
				+ positionInPerspective + "]";
	}

	
}
