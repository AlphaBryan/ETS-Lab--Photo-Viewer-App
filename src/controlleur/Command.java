package controlleur;

import java.util.Hashtable;

import model.Perspective;
import vue.MainPanel;
import java.awt.Point;

import java.io.IOException;

public abstract class  Command {
	private boolean enable ;

	private int oldTX ;
	private int oldTY ;

	private int oldZX ;
	private int oldZY ;
	
	protected Perspective oldPerspective = new Perspective() ; 

	protected CommandGestion commandGestion = CommandGestion.getInstance();
	
	/**
	 * Construteur de la classe Command.java
	 */
	public Command() {
		super();
		enable = false ; 
	}

	/**
	 * Methode permettant : d'executer notre commande 
	 */
	public abstract void execute() ;


	/** Getter de l'attribut : boolean
	 * @return boolean : Instance de l'attribut this.enable
	 */
	public boolean isEnable() {
		return enable;
	}

	/** Setter ON de l'attribtut : this.enable
	 * @param enable : Nouvelle valeur de l'attribut this.enable 
	 */
	public void setON() {
		this.enable = true;
	}

	/** Setter OFF de l'attribtut : this.enable
	 * @param enable : Nouvelle valeur de l'attribut this.enable 
	 */
	public void setOFF() {
		this.enable = false;
	}

	public void setOldTX(int oldX) {
		this.oldTX = oldX;
	}
	public void setOldTY(int oldY) {
		this.oldTY = oldY;
	}

	public int getOldTX() {
		return oldTX;
	}

	public int getOldTY() {
		return oldTY;
	}

	public void setOldZX(int oldZX) {
		this.oldZX = oldZX;
	}

	public void setOldZY(int oldZY) {
		this.oldZY = oldZY;
	}

	public int getOldZX() {
		return oldZX;
	}

	public int getOldZY() {
		return oldZY;
	}
	
	/**
	 * Methode permettant : de
	 * @param XXX : ___
	 * @return void
	 */
	public void snapshotPerspesctives() {
		Point position = new Point( commandGestion.getPerspectiveTranslation().getPositionInPerspective().x ,
									commandGestion.getPerspectiveTranslation().getPositionInPerspective().y) ; 
		
		Point size = new Point( commandGestion.getPerspectiveZoom().getSizeInPerspective().x,
								commandGestion.getPerspectiveZoom().getSizeInPerspective().y) ; 
		
		oldPerspective.setPositionInPerspective(position);
		oldPerspective.setSizeInPerspective(size);
	}

	/** Getter de l'attribut : Perspective
	 * @return Perspective : Instance de l'attribut this.oldPerspective
	 */
	public Perspective getSnapshot() {
		return oldPerspective;
	}
	
	public void setSnapshot(Perspective snap) {
		this.oldPerspective = snap ;
	}
	
	
	
}
