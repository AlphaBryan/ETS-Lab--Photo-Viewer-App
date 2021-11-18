package vue;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Toolbar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private static final String TOOLBAR_TITRE_FICHIER = "Fichier";
	private static final String TOOLBAR_NOUVELLEIMAGE = "Nouvelle Image";
	private static final String TOOLBAR_SAUVEGARDER = "Sauvegarder";
	private static final String TOOLBAR_CHARGER_FICHIER = "Charger";
	private static final String TOOLBAR_COMMAND = "Command";
	private static final String TOOLBAR_UNDO = "Undo";



	public Toolbar() {
		ajouterMenuFichier();
		ajouterCommand();


	}

	/**
	 * Cr�er le menu de Fichier
	 */
	private void ajouterMenuFichier() {
		JMenu fichier = new JMenu(TOOLBAR_TITRE_FICHIER);
		JMenuItem nouvelleImage = new JMenuItem(TOOLBAR_NOUVELLEIMAGE);
		JMenuItem sauvegarder = new JMenuItem(TOOLBAR_SAUVEGARDER);
		JMenuItem charger = new JMenuItem(TOOLBAR_CHARGER_FICHIER);


		nouvelleImage.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("S�lectionnez une  image  : ");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Cr�er un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".png", "png");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				
				
				File selectedFile = fileChooser.getSelectedFile();
				
				System.out.println(selectedFile.getAbsolutePath());
			}
		});
		fichier.add(nouvelleImage);

		charger.addActionListener((ActionEvent e) -> {
			/**
			 * to do
			 */
		});
		fichier.add(charger) ;

		sauvegarder.addActionListener((ActionEvent e) -> {
			/**
			 * to do
			 */
		});
		fichier.add(sauvegarder) ;


		add(fichier);

	}

	private void ajouterCommand() {
		JMenu command =  new JMenu(TOOLBAR_COMMAND);
		JMenuItem undo = new JMenuItem(TOOLBAR_UNDO);
		undo.addActionListener((ActionEvent e) -> {
			/**
			 * to do
			 */
		});
		command.add(undo) ;

		add(command);
	}



}
