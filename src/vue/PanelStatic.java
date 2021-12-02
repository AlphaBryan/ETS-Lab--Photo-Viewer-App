package vue;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import controlleur.CommandGestion;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import model.Images;

public class PanelStatic extends JPanel implements Observer {

	private CommandGestion commandGestion = CommandGestion.getInstance();
	private static final long serialVersionUID = 1L;
    private static final Point POS_INIT= new Point(50,50);


	/**
	 * Construteur de la classe PanelStatic.java
	 * @param Image : Instance de l'attribut de l'image du panel 
	 */
	public PanelStatic() {
		super();
		commandGestion.getPerspectiveStatic().addObserver(this);
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
        if(commandGestion.getPerspectiveStatic()!=null) {
			if (commandGestion.getPerspectiveStatic().getImagePerspective() != null) {
				g.drawImage(commandGestion.getPerspectiveStatic().getImagePerspective().getImg(), POS_INIT.x, POS_INIT.y,
						commandGestion.getPerspectiveStatic().getSizeInPerspective().x,
						commandGestion.getPerspectiveStatic().getSizeInPerspective().y, this);
			}
		}
	}

	/** Getter de l'attribut : Images
	 * @return Images : Instance de l'attribut this.image
	 */
	public Images getImage() {
		return commandGestion.getPerspectiveStatic().getImagePerspective();
	}

	/** Setter de l'attribtut : this.image
	 * @param image : Nouvelle valeur de l'attribut this.image 
	 */
	public void setImage(Images image) {
		commandGestion.getPerspectiveStatic().setImagePerspective(image);
	}

	/** Setter de l'attribtut : this.image
	 * @param imagePath : Nouveau Chemin absolue de l'attribut this.image 
	 */
	public void setImage(String imagePath) {
		commandGestion.getPerspectiveStatic().setImagePerspective(new Images(imagePath));
	}


	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
