package controlleur;

public class Translate extends Command {

	
	private int x = -1 ; 
	private int y = -1 ; 
	
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
		commandGestion.translation(x,y);
		commandGestion.push(this);

	}

	/** Getter de l'attribut : int
	 * @return int : Instance de l'attribut this.x
	 */
	public int getX() {
		return x;
	}

	/** Setter de l'attribtut : this.x
	 * @param x : Nouvelle valeur de l'attribut this.x 
	 */
	public void setX(int x) {
		this.x = x;
	}

	/** Getter de l'attribut : int
	 * @return int : Instance de l'attribut this.y
	 */
	public int getY() {
		return y;
	}

	/** Setter de l'attribtut : this.y
	 * @param y : Nouvelle valeur de l'attribut this.y 
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
}
