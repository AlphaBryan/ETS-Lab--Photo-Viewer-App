package vue;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Images;
import model.Perspective;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PanelTranslation  extends JPanel implements Observer {

    public static Perspective perspective;
    private static final long serialVersionUID = 1L;
	private static final Point POS_INIT= new Point(50,50);

	/**
	 * Construteur de la classe PanelStatic.java
	 * @param XXX : ___
	 */
	public PanelTranslation(Perspective perspective) {
		super();
		this.perspective= perspective;
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
		if(perspective!=null) {
			if (perspective.getImagePerspective() != null) {
				g.drawImage(perspective.getImagePerspective().getImg(), POS_INIT.x+perspective.getPositionInPerspective().x, POS_INIT.y+perspective.getPositionInPerspective().y, this); // see javadoc for more info on the parameters
			}
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



	@Override
	public void update(Observable o, Object arg) {

	}
}
