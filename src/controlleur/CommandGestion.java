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
	/**
	 * Repair bug : quand on click sur translate on part a -1 -1 */
	
	private static CommandGestion commandGestion ; 
	
	private Stack<Perspective> historic = new Stack<Perspective>() ;
	private Stack<Perspective> future = new Stack<Perspective>() ;


	private Perspective perspectiveStatic =new Perspective();
	private Perspective perspectiveTranslation =new Perspective();
	private Perspective perspectiveZoom =new Perspective();



	/**
	 * Constructeur de notre gestionnaire de commande
	 **/
	private CommandGestion() {
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
		Perspective p = new Perspective() ; 
		p.setPositionInPerspective(command.getSnapshot().getPositionInPerspective());
		p.setSizeInPerspective(command.getSnapshot().getSizeInPerspective());
		historic.add(p) ; 
	}

	public void pushRedo() {
		Perspective futureRedo = new Perspective() ; 
		futureRedo.setSizeInPerspective(perspectiveZoom.getSizeInPerspective()); //Problem redo
//		futureRedo.setSizeInPerspective(new Point(100,100));
		futureRedo.setPositionInPerspective(perspectiveTranslation.getPositionInPerspective());
		future.add(futureRedo) ;    
		System.out.println("f :" + future);
	}
	
	/**  
	 * Methode pour récuperer les derniers parametre de notre vue
	 * @return Command : derniere instance de commande sauvegardee 
	 **/
	public Perspective pop() {
		Perspective popped = historic.pop(); 
		return popped ;
	}


	public void undo() {
		if (historic.size()>0) {
			Perspective snapshot = pop(); 
			pushRedo() ; 
			perspectiveZoom.setSizeInPerspective(snapshot.getSizeInPerspective()); //Probleme redo
		//	perspectiveZoom.setSizeInPerspective(new Point(100,100));
			perspectiveTranslation.setPositionInPerspective(snapshot.getPositionInPerspective());		
			perspectiveZoom.notifyObservers();
			perspectiveTranslation.notifyObservers();
		}
	}
	
	/**
	 * Methode permettant : de
	 * @param XXX : ___
	 * @return void
	 */
	public void redo() {
		System.out.println("ggg");
		if (future.size()>0) {
			System.out.println("not empty");
			Perspective snapshot = future.pop();
			System.out.println("s :"+snapshot);
			perspectiveZoom.setSizeInPerspective(snapshot.getSizeInPerspective());
			perspectiveTranslation.setPositionInPerspective(snapshot.getPositionInPerspective());
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
