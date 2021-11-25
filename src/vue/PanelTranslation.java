package vue;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controlleur.CommandGestion;
import model.Images;
import model.Perspective;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PanelTranslation  extends JPanel implements Observer {

	private CommandGestion commandGestion = CommandGestion.getInstance();
    private static final long serialVersionUID = 1L;
	public static final Point POS_INIT= new Point(50,50);

	/**
	 * Construteur de la classe PanelStatic.java
	 * @param XXX : ___
	 */
	public PanelTranslation() {
		super();
		commandGestion.getPerspectiveTranslation().addObserver(this);
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
		if(commandGestion.getPerspectiveTranslation()!=null) {
			if (commandGestion.getPerspectiveTranslation().getImagePerspective() != null) {
				g.drawImage(commandGestion.getPerspectiveTranslation().getImagePerspective().getImg(), POS_INIT.x, POS_INIT.y, this); // see javadoc for more info on the parameters
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
		return commandGestion.getPerspectiveTranslation().getImagePerspective();
	}

	/** Setter de l'attribtut : this.image
	 * @param image : Nouvelle valeur de l'attribut this.image
	 */
	public void setImage(Images image) {
		commandGestion.getPerspectiveTranslation().setImagePerspective(image);
	}

	/** Setter de l'attribtut : this.image
	 * @param imagePath : Nouveau Chemin absolue de l'attribut this.image
	 */
	public void setImage(String imagePath) {
		commandGestion.getPerspectiveTranslation().setImagePerspective(new Images(imagePath));
	}



	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
