package vue;

import controlleur.Charge;
import controlleur.Redo;
import controlleur.Save;
import controlleur.Undo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import main.Application;

/**
 * classe représentant la barre de menu située en haut de l'application
 * qui hérite de la classe JMenuBar
 *
 */
public class Toolbar extends JMenuBar {
	/**
	 * attributs qui permets d'avoir les noms des éléments des menus
	 */
	private static final long serialVersionUID = 1L;
	private static final String TOOLBAR_TITRE_FICHIER = "Fichier";
	private static final String TOOLBAR_NOUVELLEIMAGE = "Nouvelle Image";
	private static final String TOOLBAR_SAUVEGARDER = "Sauvegarder";
	private static final String TOOLBAR_CHARGER_FICHIER = "Charger";
	private static final String TOOLBAR_COMMAND = "Command";
	private static final String TOOLBAR_UNDO = "Undo";
	private static final String TOOLBAR_REDO = "Redo";

	/**
	 * attributs qui définissent éléments  du menu
	 */
	private JMenu fichier = new JMenu(TOOLBAR_TITRE_FICHIER);
	private JMenuItem nouvelleImage = new JMenuItem(TOOLBAR_NOUVELLEIMAGE);
	private static JMenuItem sauvegarder = new JMenuItem(TOOLBAR_SAUVEGARDER);
	private static JMenuItem charger = new JMenuItem(TOOLBAR_CHARGER_FICHIER);


	private JMenu command =  new JMenu(TOOLBAR_COMMAND);
	private static JMenuItem undo = new JMenuItem(TOOLBAR_UNDO);
	private static JMenuItem redo = new JMenuItem(TOOLBAR_REDO);

	/**
	 * méthode qui permet d'ajouter les imtes  dans la barre de menu
	 */
	public Toolbar() {
		fichier.add(nouvelleImage);
		fichier.add(charger) ;
		fichier.add(sauvegarder) ;
		command.add(undo) ;
		command.add(redo) ;

		add(fichier);
		add(command);
		ajouterMenuFichier();


	}

	/**
	 * méthode qui permet de configurer le sous menu fichier et d'implémenter la commande nouvelleImage
	 */

	private void ajouterMenuFichier() {

	
		nouvelleImage.addActionListener((ActionEvent e) -> {  
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Selectionnez une  image  : ");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Creer un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".png", "png");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				
				
				File selectedFile = fileChooser.getSelectedFile();

				
				InitPanelsImages(selectedFile.getAbsolutePath()) ;
			}
		});



	}

	/**
	 * Méthode pour charger l'image statique
	 * @param path :le chemin absolu de l'image
	 */
	private void InitPanelsImages(String path) {
		System.out.println(" # Loading Image : " + path);
		Application.getMainFrame().setImgPath(path);
		System.out.println(" # Image succesfully Loaded \n");

	}

	/**
	 * méthode pour initer la commande undo
	 * @param command
	 */
	public static void setAction(Undo command) {
		undo.addActionListener((ActionEvent e) -> {
			command.execute() ; 			
		});
	}

	/**
	 * méthode pour initier la commande redo
	 * @param command
	 */
	public static void setAction(Redo command) {
		redo.addActionListener((ActionEvent e) -> {
			command.execute() ; 			
		});
	}


	/**
	 * méthode pour initier la commande charger
	 * @param command
	 */
	public static void setAction(Charge command){
		charger.addActionListener((ActionEvent e) -> {

				command.execute();

		});
	}

	/**
	 * méthode pour initier la commande sauvegarder
	 * @param command
	 */
	public static void setAction(Save command){
		sauvegarder.addActionListener((ActionEvent e) -> {
			command.execute();
		});
	}

}
