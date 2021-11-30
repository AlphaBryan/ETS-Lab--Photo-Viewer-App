package controlleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.RenderedImage;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

import main.Application;
import model.Perspective;
import vue.MainFrame;
import vue.MainPanel;
import vue.PanelTranslation;
import vue.PanelZoom;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class CommandGestion {
	
	private static CommandGestion commandGestion ; 
	private static Deque<Command> savedCommands;

	private Perspective perspectiveStatic =new Perspective();
	private Perspective perspectiveTranslation =new Perspective();
	private Perspective perspectiveZoom =new Perspective();



	/**
	 * Constructeur de notre gestionnaire de commande
	 **/
	private CommandGestion() {
		this.savedCommands = new ArrayDeque<Command>() ;
	}

	/**
	 * Methode pour recuperer l'instance du gestionnaire de commande 
	 * @return instance du gestionnaire de commande 
	 **/
	public static CommandGestion getInstance() {
		if (commandGestion == null ) {
			commandGestion = new CommandGestion() ; 
		}
		return commandGestion ;
	}
	
	/**
	 * Methode pour ajouter une nouvelle commande dans notre sauvegarde de commande
	 * @param command : Nouvelle instance de Commande a rajouter a notre sauvegarde de commande  
	 **/
	public void push(Command command) {
		savedCommands.push(command);
	}
	
	/**
	 * Methode pour récuperer la derniere commande sauvegarder et la supprimer 
	 * @return Command : derniere instance de commande sauvegardee 
	 **/
	public Command pop() {
		return savedCommands.pop();
	}
	


	public void undo() {
		System.out.println("Undo launched");

		if (savedCommands.size()>0) {
			Command lastCommand = pop() ;
			System.out.println(lastCommand);

			Point lastPosition = new Point(lastCommand.getOldTX(),lastCommand.getOldTY());
			Point lastSize = new Point(lastCommand.getOldZX(),lastCommand.getOldZY()) ;

			System.out.println("Last Position : "+ lastPosition) ;
			System.out.println("Last Size : "+ lastSize);
			perspectiveZoom.setSizeInPerspective(lastSize);
			perspectiveTranslation.setPositionInPerspective(lastPosition);

			perspectiveZoom.notifyObservers();
			perspectiveTranslation.notifyObservers();
		}


	}
	
	/**
	 * Methode pour executer la commande Charge
	 **/
	public void charge() {

			JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Selectionnez une  image    : ");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Creer un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".png", "png");
			fileChooser.addChoosableFileFilter(filtre);

			int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {

				File selectedFile = fileChooser.getSelectedFile();
				Application.getMainFrame().setImgPath(selectedFile.getPath());
                this.pop();
                perspectiveTranslation.notifyObservers();
                perspectiveZoom.notifyObservers();

			}

	}
	/**
	 * Methode pour executer la commande Zoom
	 **/
	public void zoom(String inOrOut) {
		int x=perspectiveZoom.getSizeInPerspective().x;
		int y=perspectiveZoom.getSizeInPerspective().y;
		if(inOrOut.equals("in")) {
			x = x + 25;
			y = y + 25;
			perspectiveZoom.setSizeInPerspective(new Point(x, y));
			perspectiveZoom.notifyObservers();
		}
		else if(inOrOut.equals("out")){
			x=x-25;
			y=y-25;
			if(x>0 && y>0) {
				perspectiveZoom.setSizeInPerspective(new Point(x, y));
				perspectiveZoom.notifyObservers();
			}
		}
	}


	/**
	 * Methode pour executer la commande Translation
	 **/
	public void translation(int x, int y) {
		perspectiveTranslation.setPositionInPerspective(new Point(x,y)) ;
		perspectiveTranslation.notifyObservers();
	}

	public void save( ) {

         ArrayList <Perspective > listePerspective = new ArrayList<Perspective>();
		try {

            File fichierImage = new File(perspectiveStatic.getImagePerspective().getPath());
            listePerspective.add(perspectiveStatic);
            listePerspective.add(perspectiveZoom);
            listePerspective.add(perspectiveTranslation);
            BufferedImage image = ImageIO.read(fichierImage);
            BufferedImage imageTranslation = ImageIO.read(fichierImage);
            ImageIO.write(image, "png",fichierImage);




		} catch (IOException i) {
			i.printStackTrace();
		}
	}



	public Perspective getPerspectiveStatic() {
		return perspectiveStatic;
	}

	public Perspective getPerspectiveTranslation() {
		return perspectiveTranslation;
	}

	public Perspective getPerspectiveZoom() {
		return perspectiveZoom;
	}

}
