package controlleur;
/**
 * classe qui implemente l'action de zoomer ou dezoomer  une image
 * et herite de la classe command
 * attribut : inOrOut permet de la verification si c'est pour zoomer ou dezoomer
 */
public class Zoom extends Command {

    private String inOrOut ="";

    /**
     * Construteur de la classe Undo.java
     */
    public Zoom() {
        super();

    }

    /**
     * methode pour executer le zoomage ou le dezoomage d'une image
     **/
    @Override
    public void execute() {
        commandGestion.zoom(inOrOut);
        commandGestion.push(this);
    }

    public void setAttribute(String attribute) {
        this.inOrOut = attribute;
    }
    
    
	@Override
	public String toString() {
		return "Zoom[From {"+ this.oldPerspective.getSizeInPerspective().x +";"+ this.oldPerspective.getSizeInPerspective().y+ "}]" ; 		
	}

}
