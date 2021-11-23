package controlleur;

public class Undo extends Command{

    public Undo() {
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
