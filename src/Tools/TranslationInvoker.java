package Tools;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import controlleur.CommandGestion;

public class TranslationInvoker extends Timer    {
	boolean dragANDdrop = false ; 

	private Point mousePosition ;
	private CommandGestion commandGestion = CommandGestion.getInstance();
	private ScheduledExecutorService dataTimer = Executors.newScheduledThreadPool(1);
	private Runnable r = new Runnable() {

		int i = 0 ; 
        public void run() 
        {       
        	i++;
        	if (commandGestion.getPerspectiveTranslation().isFocus()) {
        		System.out.println("In run dragging to : "+ mousePosition); 
        		System.out.println("dragging is : "+ commandGestion.getPerspectiveTranslation().isFocus()); 
    			commandGestion.getPerspectiveTranslation().setPositionInPerspective(mousePosition) ;
        	}
	    	
		}
    };
	
	/**
	 * Construteur de la classe TranslationInvoker.java
	 * @param XXX : ___
	 */
	public TranslationInvoker(Point mousePosition) {
		super();
		this.mousePosition = mousePosition;
	}


	
	public void drag() {
	    if(dragANDdrop) {
		    dataTimer.scheduleAtFixedRate(r, 0L, 1000, TimeUnit.MILLISECONDS);
	    }
	    else {
	        dataTimer.submit(r);

	    }
	}


	/** Getter de l'attribut : boolean
	 * @return boolean : Instance de l'attribut this.dragging
	 */
	public boolean isDragging() {
		return commandGestion.getPerspectiveTranslation().isFocus();
	}




	/** Setter de l'attribtut : this.dragging
	 * @param dragging : Nouvelle valeur de l'attribut this.dragging 
	 */
	public void drop() {
		this.commandGestion.getPerspectiveTranslation().setFocus(false);;
	}




	/**
	 * Methode permettant : de
	 * @param XXX : ___
	 * @return void
	 */
	public void setDragging(boolean dragging2) {
	}




	/** Getter de l'attribut : Point
	 * @return Point : Instance de l'attribut this.mousePosition
	 */
	public Point getMousePosition() {
		return mousePosition;
	}




	/** Setter de l'attribtut : this.mousePosition
	 * @param mousePosition : Nouvelle valeur de l'attribut this.mousePosition 
	 */
	public void setMousePosition(Point mousePosition) {
		this.mousePosition = mousePosition;
	}

	
	



	
}
