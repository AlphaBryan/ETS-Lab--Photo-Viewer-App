package controlleur;
/**
 * classe qui implémente l'action de redo une action
 * et hérite de la classe command
 */
public class Redo extends  Command {

	/**
	 * constructeur de la classe Redo  qui appel le constructeur de la classe mère
	 */
	@Override
	public void execute() {
		commandGestion.redo();
		commandGestion.push(this);
	}

}
