package controlleur;
/**
 * classe qui implemente l'action de redo une action
 * et herite de la classe command
 */
public class Redo extends  Command {

	/**
	 * constructeur de la classe Redo  qui appel le constructeur de la classe mere
	 */
	@Override
	public void execute() {
		commandGestion.redo();
		commandGestion.push(this);
	}

}
