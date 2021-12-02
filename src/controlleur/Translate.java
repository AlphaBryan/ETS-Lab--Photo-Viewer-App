package controlleur;
/**
 * méthode qui éxécute la commande de translater une image
 * newY : nouvelle coordonnée de l'image translatée
 * newX :  nouvelle abcisse  de l'image translatée
 **/
public class Translate extends Command {


	private int newX = -1 ;
	private int newY = -1 ;
	
	/**
	 * Construteur de la classe Translate qui hérite de la classe Commande
	 */
	public Translate() {
		super();
		
	}

	/**
	*méthode qui éxécute la commande de translater une image
	**/
	@Override
	public void execute() {

		commandGestion.translation(newX,newY);

		if(!isEnable()) {
			commandGestion.push(this);
		}

	}



	/** Setter de l'attribtut : this.x
	 * @param x : Nouvelle valeur de l'attribut this.x 
	 */
	public void setNewX(int x) {
		this.newX = x;
	}

	/** Setter de l'attribtut : this.y
	 * @param y : Nouvelle valeur de l'attribut this.y 
	 */
	public void setNewY(int y) {
		this.newY = y;
	}



	@Override
	public String toString() {
		return "Translate[ Old{"+ this.oldPerspective.getPositionInPerspective().x +";"+ this.oldPerspective.getPositionInPerspective().y+ "}->{" +newX + ";" + newY + "}]" ; 		
	}


}
