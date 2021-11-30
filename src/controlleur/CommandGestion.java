package controlleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.RenderedImage;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

import Tools.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import model.Images;
import org.xml.sax.*;
import org.w3c.dom.*;


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
	public void charge()  {
		XmlFile xmlFile= new XmlFile();
		Hashtable <String, String > info = xmlFile.readXML(".\\test\\infos.xml");
		Images image = new Images(info.get("path"));
		perspectiveStatic.setImagePerspective(image);
		perspectiveTranslation.setImagePerspective(image);
		perspectiveZoom.setImagePerspective(image);
		Point lastPosition = new Point(Integer.parseInt(info.get("positionX")),Integer.parseInt(info.get("positionY")));
		Point lastSize = new Point(Integer.parseInt(info.get("sizeX")),Integer.parseInt(info.get("sizeY"))) ;

		System.out.println("Last Position : "+ lastPosition) ;
		System.out.println("Last Size : "+ lastSize);
		perspectiveZoom.setSizeInPerspective(lastSize);
		perspectiveTranslation.setPositionInPerspective(lastPosition);
        perspectiveStatic.notifyObservers();
		perspectiveZoom.notifyObservers();
		perspectiveTranslation.notifyObservers();


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


	public void save(){
		XmlFile xmlFile= new XmlFile();
		xmlFile.setPath(perspectiveStatic.getImagePerspective().getPath());
		xmlFile.setPositionX(String.valueOf(perspectiveTranslation.getPositionInPerspective().x));
		xmlFile.setPositionY(String.valueOf(perspectiveTranslation.getPositionInPerspective().y));
		xmlFile.setSizeX(String.valueOf(perspectiveZoom.getSizeInPerspective().x));
		xmlFile.setSizeY(String.valueOf(perspectiveZoom.getSizeInPerspective().y));
		xmlFile.saveToXML(".\\test\\infos.xml");
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
