package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyChangeEvent;

import javax.swing.*;

import model.Images;

public class MainPanel extends JPanel{
	
	private PanelStatic pStatic ; 
	private PanelZoom pZoom ; 
	private PanelTranslation pTranslation ;
	
	/**
	 * Construteur de la classe MainPanel.java
	 */
	public MainPanel() {
		super();	

		pStatic = new PanelStatic(null);
		pStatic.setPreferredSize( new Dimension(300, 300) );
		
		pZoom = new PanelZoom(null);
		pZoom.setPreferredSize( new Dimension(300, 300) );

		pTranslation = new PanelTranslation(null);
		pTranslation.setPreferredSize( new Dimension(300, 300) );
		
	    add(pZoom) ; 
	    add(pTranslation) ; 
	    add(pStatic) ; 
	}
	
	/**
	 * Construteur de la classe MainPanel.java
	 * @param pStatic : Panneau statique de l'interface  
	 * @param pZoom : Panneau zoom de l'interface 
	 * @param pTranslation : Panneau translation de l'interface 
	 */
	public MainPanel(PanelStatic pStatic, PanelZoom pZoom, PanelTranslation pTranslation) {
		super();
		this.pStatic = pStatic;
		this.pZoom = pZoom;
		this.pTranslation = pTranslation;
		
		add(pStatic) ; 
		add(pZoom) ; 
		add(pTranslation) ; 
	}

	public void setPanelsImage(String path) {
		pStatic.setImage(path);
		pTranslation.setImage(path);
		pZoom.setImage(path);
	}
	
	/** Getter de l'attribut : PanelStatic
	 * @return PanelStatic : Instance de l'attribut this.pStatic
	 */
	public PanelStatic getpStatic() {
		return pStatic;
	}
	/** Setter de l'attribtut : this.pStatic
	 * @param pStatic : Nouvelle valeur de l'attribut this.pStatic 
	 */
	public void setpStatic(PanelStatic pStatic) {
		this.pStatic = pStatic;
	}
	/** Getter de l'attribut : PanelZoom
	 * @return PanelZoom : Instance de l'attribut this.pZoom
	 */
	public PanelZoom getpZoom() {
		return pZoom;
	}
	/** Setter de l'attribtut : this.pZoom
	 * @param pZoom : Nouvelle valeur de l'attribut this.pZoom 
	 */
	public void setpZoom(PanelZoom pZoom) {
		this.pZoom = pZoom;
	}
	/** Getter de l'attribut : PanelTranslation
	 * @return PanelTranslation : Instance de l'attribut this.pTranslation
	 */
	public PanelTranslation getpTranslation() {
		return pTranslation;
	}
	/** Setter de l'attribtut : this.pTranslation
	 * @param pTranslation : Nouvelle valeur de l'attribut this.pTranslation 
	 */
	public void setpTranslation(PanelTranslation pTranslation) {
		this.pTranslation = pTranslation;
	} 
	
	
}
