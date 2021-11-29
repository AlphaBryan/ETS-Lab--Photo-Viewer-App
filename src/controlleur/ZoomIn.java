
package controlleur;

public class ZoomIn extends Command {

	public ZoomIn() {
		super();
	}

	/**
	@see controlleur.Command#execute()
	**/
	@Override
	public void execute() {
		commandGestion.zoomIn();
		commandGestion.push(this);
	}

}
