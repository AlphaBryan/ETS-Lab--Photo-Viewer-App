package controlleur;

public class Redo extends  Command {

	/**
	@see controlleur.Command#execute()
	**/
	@Override
	public void execute() {
		commandGestion.redo();
		commandGestion.push(this);
	}

}
