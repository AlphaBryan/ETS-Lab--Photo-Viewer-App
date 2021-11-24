package main;

import controlleur.*;
import vue.MainFrame;

public class Application {


	/*
	 * TODO - Finir le lab Jeudi
	 * 1 : Régler les tailles de l'image 
	 * 2 : Patron Observateur
	 * 3 : finir Commande 
	 * 4 : Boire Vodka	
	 * 
	 **/
	
	
	
	private static MainFrame mainFrame ; 
	//private CommandGestion commandGestion =  CommandGestion.getInstance() ; 

	public static void main(String[] args) {
		AppInfo() ;
		run( );
	}
	
	/**
	 * Methode permettant : de lancer notre application 
	 */
	public static void run() {
		System.out.println(" # Lauching Application...");
		mainFrame = new MainFrame();
		System.out.println(" # Application Launched \n");
	}
	
	/**
	 * Methode permettant : d'imprimer des informations basique de notre application dans la console  
	 */
	public static void AppInfo() {
		System.out.println( "# Laboratoire 3 : LOG121 - Visionneuse d'Image" );
		System.out.println( "# Authors :" );
		System.out.println( " - Joudad Ali" );
		System.out.println( " - Lassoued Ali" );
		System.out.println( " - Mevo Bryan" );
		System.out.println( "" );
	}


	/** Getter de l'attribut : MainFrame
	 * @return MainFrame : Instance de l'attribut this.mainFrame
	 */
	public static MainFrame getMainFrame() {
		return mainFrame;
	}

	/** Setter de l'attribtut : this.mainFrame
	 * @param mainFrame : Nouvelle valeur de l'attribut this.mainFrame 
	 */
	public static void setMainFrame(MainFrame mainFrame) {
		Application.mainFrame = mainFrame;
	}


	
}
