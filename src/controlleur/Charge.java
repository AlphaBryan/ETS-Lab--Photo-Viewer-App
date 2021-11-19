package controlleur;

public class Charge  extends Command{
	
	
	
	public Charge() {
		super();
	}
	
	/**
	@see controlleur.Command#execute()
	**/
	@Override
	public void execute() {
		System.out.println("# Command Charge execution");
	}
}
