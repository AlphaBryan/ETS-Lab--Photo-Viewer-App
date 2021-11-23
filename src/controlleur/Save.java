package controlleur;

public class Save extends  Command{

	/**
	 * Construteur de la classe Save.java
	 *
	 */
	public Save() {
		super();

	}
	
	/**
	@see controlleur.Command#execute()
	**/
	@Override
	public void execute() {
		commandGestion.save();
		commandGestion.push(this);
	}


	
	
}
