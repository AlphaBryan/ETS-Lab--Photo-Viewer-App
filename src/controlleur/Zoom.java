package controlleur;

public class Zoom extends Command {

    private String inOrOut ="";


    public Zoom() {
        super();

    }

    /**
     @see controlleur.Command#execute()
     **/
    @Override
    public void execute() {
        commandGestion.zoom(inOrOut);
        commandGestion.push(this);
    }

    public void setAttribute(String attribute) {
        this.inOrOut = attribute;
    }
}
