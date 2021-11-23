package vue;

import model.Images;
import javax.swing.*;
import java.awt.*;

public class PanelZoom extends JPanel{

    private static final long serialVersionUID = 2L;
	private Images image;
    
	/**
	 * Construteur de la classe PanelStatic.java
	 * @param XXX : ___
	 */
	public PanelZoom(Images image) {
		super();
		this.image = image;
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
            g.drawRect(20, 20, 250, 250);
            g.drawString("Zoom", 125, 10);
		}
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
