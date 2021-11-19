package controlleur;

import java.util.ArrayDeque;
import java.util.Deque;

import vue.MainPanel;

public class CommandGestion {
	
	private static CommandGestion commandGestion ; 
	private Deque<Command> savedCommands;

	
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
	public void executeCharge() {
		Charge c = new Charge() ; // Not sure of that 
		c.execute();
	}
	
	/**
	 * Methode pour executer la commande Zoom
	 **/
	public void executeZoom() {
		Zoom z = new Zoom() ; 
		z.execute() ; 
	}
	
	/**
	 * Methode pour executer la commande Translation
	 **/
	public void executeTranslation() {
		
	}
	 
}
