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
import model.Perspective;

public class PanelStatic extends JPanel {
	
    private static final long serialVersionUID = 1L;
    private Perspective perspective;
	private static final Point POS_INIT= new Point(50,50);


	/**
	 * Construteur de la classe PanelStatic.java
	 * @param Image : Instance de l'attribut de l'image du panel 
	 */
	public PanelStatic(Perspective perspective) {
		super();
		this.perspective= perspective;
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
        if(perspective!=null) {
			if (perspective.getImagePerspective() != null) {
				g.drawImage(perspective.getImagePerspective().getImg(), POS_INIT.x, POS_INIT.y, this); // see javadoc for more info on the parameters
			}
		}


	}

	/** Getter de l'attribut : Images
	 * @return Images : Instance de l'attribut this.image
	 */
	public Images getImage() {
		return perspective.getImagePerspective();
	}

	/** Setter de l'attribtut : this.image
	 * @param image : Nouvelle valeur de l'attribut this.image 
	 */
	public void setImage(Images image) {
		perspective.setImagePerspective(image);
	}

	/** Setter de l'attribtut : this.image
	 * @param imagePath : Nouveau Chemin absolue de l'attribut this.image 
	 */
	public void setImage(String imagePath) {
		perspective.setImagePerspective(new Images(imagePath));
	}


}
