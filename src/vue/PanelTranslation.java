package vue;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Images;
import model.Perspective;

import java.awt.*;

public class PanelTranslation  extends JPanel {

    private static Perspective perspective;
    private static final long serialVersionUID = 1L;
	private Images image;
    private Images imageTest = new Images ("./test/TestedImage.png") ; 

	/**
	 * Construteur de la classe PanelStatic.java
	 * @param XXX : ___
	 */
	public PanelTranslation(Images image) {
		super();
		this.image = image;
		initBorder("Translation");
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
	
    private void testImage() {
        String MettreImageTest = "./test/TestedImage.png" ; 
		this.image = new Images(MettreImageTest);
    }

    public void Translate(int x , int y ){

    }

    /**
    @see java.awt.Component#getMousePosition()
    **/
    @Override
    public Point getMousePosition()  {
        return super.getMousePosition();
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
