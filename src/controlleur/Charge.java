package controlleur;


import main.Application;

import java.io.IOException;

/**
 * classe qui implémente l'action de charger un fichier
 * et hérite de la classe command
 */

public class Charge  extends Command{


	/**
	 * constructeur de la classe charger  qui appel le constructeur de la classe mère
	 */
	public Charge() {
		super();
	}
	
	/**
	* méthode qui éxécute la commande de charger un fichier
	**/
	@Override
	public void execute() {
		commandGestion.charge();
		//savePerspectiveZoom(commandGestion.getPerspectiveZoom());
		//savePerspectiveTranslation(commandGestion.getPerspectiveTranslation());
		commandGestion.push(this);
	}


}
