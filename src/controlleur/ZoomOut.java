package controlleur;

import main.Application;

public class ZoomOut extends Command{

    public ZoomOut() {
        super();
    }

    /**
     @see controlleur.Command#execute()
     **/
    @Override
    public void execute() {
        commandGestion.zoomOut();
		//mainPanel = Application.getMainFrame().getPanneauPrincipal() ; 
        commandGestion.push(this);
    }

}
