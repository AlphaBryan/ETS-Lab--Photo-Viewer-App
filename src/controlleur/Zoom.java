
package controlleur;

public class Zoom extends Command {

	public Zoom() {
		super();
	}

	/**
	@see controlleur.Command#execute()
	**/
	@Override
	public void execute() {
		System.out.println("# Command Zoom execution");
	}

}
