package controlleur;
/**
 * classe qui implémente l'action de zoomer ou dézoomer  une image
 * et hérite de la classe command
 * attribut : inOrOut permet de la vérification si c'est pour zoomer ou dézoomer
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
     * méthode pour exécuter le zoomage ou le dézoomage d'une image
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
