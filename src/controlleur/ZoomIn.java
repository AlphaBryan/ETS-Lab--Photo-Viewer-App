
package controlleur;

import main.Application;

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
		//mainPanel = Application.getMainFrame().getPanneauPrincipal() ; 
		commandGestion.push(this);
	}

}
