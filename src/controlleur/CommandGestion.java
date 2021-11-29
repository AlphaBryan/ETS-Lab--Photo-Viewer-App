package controlleur;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import main.Application;
import model.Perspective;
import vue.MainPanel;
import vue.PanelTranslation;

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
	
	/**
	 * Methode pour récuperer le MainPanel de la derniere commande sauvegarder et la supprimer 
	 * @return MainPanel : le MainPanel de la derniere instance de commande sauvegardee 
	 **/
	public MainPanel undo() {
		Command lastCommand = pop() ; 
		MainPanel lastMainPanel = lastCommand.undo() ; 
		return lastMainPanel ; 
	}
	
	/**
	 * Methode pour executer la commande Charge
	 **/
	public void charge() {
		System.out.println("CHARGED");
	}
	
	/**
	 * Methode pour executer la commande Zoom
	 **/
	public void zoomIn() {
		int x=perspectiveZoom.getSizeInPerspective().x;
		int y=perspectiveZoom.getSizeInPerspective().y;
		x=x+10;
		y=y+10;
		perspectiveZoom.setSizeInPerspective(new Point(x,y));
		perspectiveZoom.notifyObservers();
	}

	public void zoomOut() {
		int x=perspectiveZoom.getSizeInPerspective().x;
		int y=perspectiveZoom.getSizeInPerspective().y;
		x=x-10;
		y=y-10;
		if(x>0 && y>0) {
			perspectiveZoom.setSizeInPerspective(new Point(x, y));
			perspectiveZoom.notifyObservers();
		}
	}
	/**
	 * Methode pour executer la commande Translation
	 **/
	public void translation() {
		perspectiveTranslation.notifyObservers();
	}

	public void save() {
		System.out.println("SAVE");

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
