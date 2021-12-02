package controlleur;
/**
 * classe qui implemente la commande  de defaire une action
 * et herite de la classe command
 */
public class Undo extends Command {

	
	
	/**
	 * Construteur de la classe Undo.java
	 */
	public Undo() {
		super();
		
	}

	/**
	 * methode qui execute la commande de defaire une action
	 **/
	@Override
	public void execute() {
		commandGestion.undo();
	}

	

}
