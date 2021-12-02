package vue;

import controlleur.CommandGestion;
import controlleur.Zoom;
import model.Images;

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




	/**
	 * Construteur de la classe PanelStatic.java
	 */
	public PanelZoom( ) {
		super();
		commandGestion.getPerspectiveZoom().addObserver(this);
		initBorder("Zoom") ;

	}

	/**
	 * Methode permettant d'initialiser la bordure du panneau
	 *
	 */
	private void initBorder(String panelType) {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder title = BorderFactory.createTitledBorder( blackline, panelType);
		title.setTitleJustification(TitledBorder.CENTER);
		setBorder(title);
	}

	/**
	 *Méthode qui permet d'afficher les éléments graphique dans le panneau
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
	 * Méthode qui permet d'obtenir la positiond de la souris
	 * et qui retourne un point déterminant les coordonnées du pointeur de la souris
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

	/**
	 * méthode qui permet de faire la mise  à jour de l'affichage dans la vue
	 * @param o : observateur qui va faire la mise à jour de l'affichage dans la vue
	 * @param arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	/**
	 * Méthode qui permet d'implémenter l'action de zoomer
	 * @param command
	 */
	public void setAction(Zoom command){
		addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				command.snapshotPerspesctives();
				if(e.getWheelRotation()<0){
					command.setAttribute("in");
				}else{
					command.setAttribute("out");
				}
				command.execute();
			}
		});
	}

}
