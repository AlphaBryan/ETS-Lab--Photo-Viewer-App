package controlleur;


import main.Application;

import java.io.IOException;

/**
 * classe qui implemente l'action de charger un fichier
 * et herite de la classe command
 */

public class Charge  extends Command{


	/**
	 * constructeur de la classe charger  qui appel le constructeur de la classe mère
	 */
	public Charge() {
		super();
	}
	
	/**
	* methode qui execute la commande de charger un fichier
	**/
	@Override
	public void execute() {
		commandGestion.charge();
		commandGestion.push(this);
	}


}
