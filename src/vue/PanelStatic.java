package vue;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import main.Application;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;



import model.Images;

public class PanelStatic extends JPanel {
	
    private static final long serialVersionUID = 1L;
    private Images image;
    private Images imageTest = new Images ("./test/TestedImage.png") ; 
 
	/**
	 * Construteur de la classe PanelStatic.java
	 * @param Image : Instance de l'attribut de l'image du panel 
	 */
	public PanelStatic(Images image) {
		super();
		this.image = image;
		initBorder("Static");
	}
	
	/**
	 * Methode permettant : de
	 * @param XXX : ___
	 */
	private void initBorder(String panelType) {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder title = BorderFactory.createTitledBorder( blackline, panelType);
		title.setTitleJustification(TitledBorder.CENTER);
		setBorder(title);
	}
	
	/**
	@see javax.swing.JComponent#paint(java.awt.Graphics)
	**/
	@Override
	public void paint(Graphics g) {
        super.paint(g);
		if(image != null ) {
	        g.drawImage(image.getImg(), 0, 0, this); // see javadoc for more info on the parameters   
		}
		else{
	        g.drawImage(imageTest.getImg(), 15, 15, this);
		}
	}

	/** Getter de l'attribut : Images
	 * @return Images : Instance de l'attribut this.image
	 */
	public Images getImage() {
		return image;
	}

	/** Setter de l'attribtut : this.image
	 * @param image : Nouvelle valeur de l'attribut this.image 
	 */
	public void setImage(Images image) {
		this.image = image;
	}

	/** Setter de l'attribtut : this.image
	 * @param imagePath : Nouveau Chemin absolue de l'attribut this.image 
	 */
	public void setImage(String imagePath) {
		this.image = new Images(imagePath);
	}
	
}
