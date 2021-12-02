package controlleur;
/**
 * classe qui implémente la commande  de défaire une action
 * et hérite de la classe command
 */
public class Undo extends Command {

	
	
	/**
	 * Construteur de la classe Undo.java
	 */
	public Undo() {
		super();
		
	}

	/**
	 * méthode qui éxécute la commande de défaire une action
	 **/
	@Override
	public void execute() {
		commandGestion.undo();
	}

	

}
