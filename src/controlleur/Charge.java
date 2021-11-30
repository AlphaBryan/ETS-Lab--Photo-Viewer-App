package controlleur;


import main.Application;

import java.io.IOException;


public class Charge  extends Command{
	
	
	
	public Charge() {
		super();
	}
	
	/**
	@see controlleur.Command#execute()
	**/
	@Override
	public void execute() {
		commandGestion.charge();
		//savePerspectiveZoom(commandGestion.getPerspectiveZoom());
		//savePerspectiveTranslation(commandGestion.getPerspectiveTranslation());
		commandGestion.push(this);
	}


}
