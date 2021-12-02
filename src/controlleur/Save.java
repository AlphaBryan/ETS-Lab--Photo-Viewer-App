package controlleur;
/**
 * constructeur de la classe Save  qui appel le constructeur de la classe mere
 */
public class Save extends  Command{

	/**
	 * Construteur de la classe Save qui herite de la classe mere
	 *
	 */
	public Save() {
		super();

	}

	/**
	 * methode qui execute la commande de sauvegarder  un fichier
	 **/
	@Override
	public void execute() {
		commandGestion.save();
		commandGestion.push(this);
	}



	
	
}
