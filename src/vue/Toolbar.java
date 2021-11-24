package vue;

import controlleur.Charge;
import controlleur.Save;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import main.Application;

public class Toolbar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private static final String TOOLBAR_TITRE_FICHIER = "Fichier";
	private static final String TOOLBAR_NOUVELLEIMAGE = "Nouvelle Image";
	private static final String TOOLBAR_SAUVEGARDER = "Sauvegarder";
	private static final String TOOLBAR_CHARGER_FICHIER = "Charger";
	private static final String TOOLBAR_COMMAND = "Command";
	private static final String TOOLBAR_UNDO = "Undo";


	private JMenu fichier = new JMenu(TOOLBAR_TITRE_FICHIER);
	private JMenuItem nouvelleImage = new JMenuItem(TOOLBAR_NOUVELLEIMAGE);
	private JMenuItem sauvegarder = new JMenuItem(TOOLBAR_SAUVEGARDER);
	private JMenuItem charger = new JMenuItem(TOOLBAR_CHARGER_FICHIER);

	private JMenu command =  new JMenu(TOOLBAR_COMMAND);
	private JMenuItem undo = new JMenuItem(TOOLBAR_UNDO);

	public Toolbar() {
		fichier.add(nouvelleImage);
		fichier.add(charger) ;
		fichier.add(sauvegarder) ;
		add(fichier);
		ajouterMenuFichier();


	}

	/**
	 * TODO : 
	 *  Reparer nouvelle image qui stop le programme 
	 * 	Mettre nouvelle image dans une commande 
	 * */
	/**
	 * Creer le menu de Fichier
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

		charger.addActionListener((ActionEvent e) -> {
			/**
			 * TODO
			 */
		});
		fichier.add(charger) ;

		sauvegarder.addActionListener((ActionEvent e) -> {
			/**
			 * TODO
			 */
		});
		fichier.add(sauvegarder) ;


		add(fichier);

	}

	public void setUndo() {

		undo.addActionListener((ActionEvent e) -> {
			/**
			 * TODO
			 */
		});
		command.add(undo) ;
		add(command);
	}

	
	private void InitPanelsImages(String path) {
		System.out.println(" # Loading Image : " + path);
		Application.getMainFrame().setImgPath(path);
		System.out.println(" # Image succesfully Loaded ");

	}



	public void setAction(Charge command){
		charger.addActionListener((ActionEvent e) -> {
			command.execute();
		});
	}
	public void setAction(Save command){
		sauvegarder.addActionListener((ActionEvent e) -> {
			command.execute();
		});
	}

}
