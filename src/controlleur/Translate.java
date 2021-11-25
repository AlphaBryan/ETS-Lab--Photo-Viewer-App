package controlleur;

public class Translate extends Command {

	
	
	/**
	 * Construteur de la classe Translate.java
	 */
	public Translate() {
		super();
		
	}

	/**
	@see controlleur.Command#execute()
	**/
	@Override
	public void execute() {
		commandGestion.translation();
		commandGestion.push(this);

	}
}
