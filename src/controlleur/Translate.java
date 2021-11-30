package controlleur;

public class Translate extends Command {


	private int newX = -1 ;
	private int newY = -1 ;
	
	/**
	 * Construteur de la classe Translate.java
	 */
	public Translate() {
		super();
		
	}

	/**
	@see controlleur.Command#execute()
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

	/**
	@see controlleur.Command#clone()
	**/
	@Override
	public Command clone() {
		Translate t = new Translate() ;
		t.setSnapshot(oldPerspective);
		return t;
	}
}
