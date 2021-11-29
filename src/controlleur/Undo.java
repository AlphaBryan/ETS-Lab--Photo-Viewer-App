package controlleur;

public class Undo extends Command {

	
	
	/**
	 * Construteur de la classe Undo.java
	 */
	public Undo() {
		super();
		
	}

	/**
	@see controlleur.Command#execute()
	**/
	@Override
	public void execute() {
		commandGestion.undo();
		//commandGestion.push(this); Need this for the redo command
	}

}
