package vue;

import controlleur.CommandGestion;
import controlleur.ZoomIn;
import controlleur.ZoomOut;
import model.Images;
import model.Perspective;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Observable;
import java.util.Observer;

public class PanelZoom extends JPanel implements Observer {

	private CommandGestion commandGestion = CommandGestion.getInstance();
	private static final long serialVersionUID = 1L;
	private static final Point POS_INIT= new Point(3,14);

	private ZoomIn zoomIn = new ZoomIn();
	private ZoomOut zoomOut = new ZoomOut();


	/**
	 * Construteur de la classe PanelStatic.java
	 * @param XXX : ___
	 */
	public PanelZoom( ) {
		super();
		commandGestion.getPerspectiveZoom().addObserver(this);
		addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(e.getWheelRotation()<0){
					commandGestion.zoomIn();
				}else{
					commandGestion.zoomOut();
				}
			}
		});
		initBorder("Zoom") ;
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
		if(commandGestion.getPerspectiveZoom()!=null) {
			if (commandGestion.getPerspectiveZoom().getImagePerspective() != null) {
				g.drawImage(commandGestion.getPerspectiveZoom().getImagePerspective().getImg(), POS_INIT.x, POS_INIT.y,
						commandGestion.getPerspectiveZoom().getSizeInPerspective().x,
						commandGestion.getPerspectiveZoom().getSizeInPerspective().y,this);
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
		return commandGestion.getPerspectiveZoom().getImagePerspective();
	}

	/** Setter de l'attribtut : this.image
	 * @param image : Nouvelle valeur de l'attribut this.image
	 */
	public void setImage(Images image) {
		commandGestion.getPerspectiveZoom().setImagePerspective(image);
	}

	/** Setter de l'attribtut : this.image
	 * @param imagePath : Nouveau Chemin absolue de l'attribut this.image
	 */
	public void setImage(String imagePath) {
		commandGestion.getPerspectiveZoom().setImagePerspective(new Images(imagePath));
	}


	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
