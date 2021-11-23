package controlleur;

import vue.MainPanel;

public abstract class  Command {

	private MainPanel mainPanel ;
	protected CommandGestion commandGestion = CommandGestion.getInstance();
	
	/**
	 * Construteur de la classe Command.java
	 */
	public Command() {
		super();
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

		
	

}
