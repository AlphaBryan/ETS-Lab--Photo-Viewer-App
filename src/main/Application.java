package main;
import vue.MainFrame;

/**
 * classe qui représente l'application
 */
public class Application {

	public static int x;
	public static int y;
	
	private static MainFrame mainFrame ;

	/**
	 * méthode main qui permet d'exécuter l'application
	 * @param args
	 */
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



	
}
