package main;

import controlleur.CommandGestion;
import vue.MainFrame;

public class Application {

	/*
	 * TODO - Bryan required Help
	 * Ask1 : L'application ne peut pas etre le client car elle ne crée pas les boutons et ne les connaits pas
	 * donc comment et ou faire des setsCommand ?
	 * 
	 * le client c'est surement MainFrame ?
	 * avec des setsCommandRecursif jusqu'aux sub-panels et toolbar ? 
	 * 
	 * Ask2 : by the way, a quelle moment on utilise commandGestion Here
	 **/
	
	
	
	private static MainFrame mainFrame ; 
	private CommandGestion commandGestion =  CommandGestion.getInstance() ; 

	public static void main(String[] args) {
		AppInfo() ;
		run( );
	}
	
	/**
	 * Methode permettant : de lancer notre application 
	 */
	public static void run() {
		System.out.println("• Lauching Application...");
		mainFrame = new MainFrame();  
		Environnement environnement = new Environnement();
		environnement.addPropertyChangeListener(mainFrame);
		environnement.execute();
		System.out.println("• Application Launched \n");
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
	
	/**
	 * Methode permettant : d'attribuer une commande de Chargement 
	 */
	public void setChargeCommand() {
		// TODO
	}
	
	/**
	 * Methode permettant : d'attribuer une commande de Translation
	 */
	public void setTranslationCommand() {
		// TODO
	}
	
	/**
	 * Methode permettant : d'attribuer une commande de Zoom
	 */
	public void setZoomCommand() {
		// TODO
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
