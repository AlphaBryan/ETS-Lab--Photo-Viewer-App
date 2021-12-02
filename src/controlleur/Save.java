package controlleur;
/**
 * constructeur de la classe Save  qui appel le constructeur de la classe mère
 */
public class Save extends  Command{

	/**
	 * Construteur de la classe Save qui hérite de la classe mère
	 *
	 */
	public Save() {
		super();

	}

	/**
	 * méthode qui éxécute la commande de sauvegarder  un fichier
	 **/
	@Override
	public void execute() {
		commandGestion.save();
		commandGestion.push(this);
	}



	
	
}
