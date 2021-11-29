package controlleur;

public class ZoomOut extends Command{

    public ZoomOut() {
        super();
    }

    /**
     @see controlleur.Command#execute()
     **/
    @Override
    public void execute() {
        commandGestion.zoomOut();
        commandGestion.push(this);
    }

}
