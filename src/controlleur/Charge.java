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
		commandGestion.charge();
		commandGestion.push(this);
	}
}
