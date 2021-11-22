
package controlleur;

public class Zoom extends Command {

	public Zoom() {
		super();
	}

	/**
	@see controlleur.Command#execute()
	**/
	@Override
	public void execute() {
		commandGestion.zoom();
		commandGestion.push(this);
	}

}
