package controlleur;

import java.util.Hashtable;

import model.Perspective;
import vue.MainPanel;

public abstract class  Command {

	protected MainPanel mainPanel ; // Cant be that 
	
	protected Perspective perspectiveTranslation ;
	protected Perspective perspectiveZoom ;
	
	private boolean enable ; 
	
	protected Hashtable<String, Perspective> perspectives = new Hashtable<String, Perspective>();

	
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
	public abstract void execute();


	
	/**
	 * Methode permettant : de sauvegarder un MainPanel  
	 * @param mainPanel : le mainPanel a changer 
	 */
	public void saveMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	/**
	 * Methode permettant : de retourner notre  mainPanel  
	 * @return MainPanel
	 */
	public MainPanel undo() {
		return mainPanel;
	}


	/** Getter de l'attribut : Perspective
	 * @return Perspective : Instance de l'attribut this.perspectiveTranslation
	 */
	public Perspective getPerspectiveTranslation() {
		return perspectives.get("Translate");
	}

	/** Setter de l'attribtut : this.perspectiveTranslation
	 * @param perspectiveTranslation : Nouvelle valeur de l'attribut this.perspectiveTranslation 
	 */
	public void savePerspectiveTranslation(Perspective perspectiveTranslation) {
		perspectives.put("Translate", perspectiveTranslation) ; 
	}

	/** Getter de l'attribut : Perspective
	 * @return Perspective : Instance de l'attribut this.perspectiveZoom
	 */
	public Perspective getPerspectiveZoom() {
		return perspectives.get("Zoom");
	}

	/** Setter de l'attribtut : this.perspectiveZoom
	 * @param perspectiveZoom : Nouvelle valeur de l'attribut this.perspectiveZoom 
	 */
	public void savePerspectiveZoom(Perspective perspectiveZoom) {
		perspectives.put("Zoom", perspectiveZoom) ; 

	}

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
	
	
	
		
	

}
