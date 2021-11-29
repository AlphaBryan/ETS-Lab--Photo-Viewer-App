package vue;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import controlleur.Charge;
import controlleur.CommandGestion;
import controlleur.Translate;
import model.Images;
import model.Perspective;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.TimerTask;
import java.util.Timer;

public class PanelTranslation extends JPanel implements Observer {

	private CommandGestion commandGestion = CommandGestion.getInstance();
	private static final long serialVersionUID = 1L;

	/**
	 * Construteur de la classe PanelStatic.java
	 * 
	 */
	public PanelTranslation() {
		super();
		commandGestion.getPerspectiveTranslation().addObserver(this);
		initBorder("Translation");
	}

	/**
	 * Methode permettant : d'encadre nos panel
	 * 
	 * @param panelType : Type de panel
	 */
	private void initBorder(String panelType) {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder title = BorderFactory.createTitledBorder(blackline, panelType);
		title.setTitleJustification(TitledBorder.CENTER);
		setBorder(title);
	}

	/**
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 **/
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (commandGestion.getPerspectiveTranslation() != null) {
			if (commandGestion.getPerspectiveTranslation().getImagePerspective() != null) {
				g.drawImage(commandGestion.getPerspectiveTranslation().getImagePerspective().getImg(),
						commandGestion.getPerspectiveTranslation().getPositionInPerspective().x - 100,
						commandGestion.getPerspectiveTranslation().getPositionInPerspective().y - 100,
						commandGestion.getPerspectiveTranslation().getSizeInPerspective().x,
						commandGestion.getPerspectiveTranslation().getSizeInPerspective().y, this);
			}
		}

	}

	/**
	 * @see java.awt.Component#getMousePosition()
	 **/
	@Override
	public Point getMousePosition() {
		return super.getMousePosition();
	}

	/**
	 * Getter de l'attribut : Images
	 * 
	 * @return Images : Instance de l'attribut this.image
	 */
	public Images getImage() {
		return commandGestion.getPerspectiveTranslation().getImagePerspective();
	}

	/**
	 * Setter de l'attribtut : this.image
	 * 
	 * @param image : Nouvelle valeur de l'attribut this.image
	 */
	public void setImage(Images image) {
		commandGestion.getPerspectiveTranslation().setImagePerspective(image);
	}

	/**
	 * Setter de l'attribtut : this.image
	 * 
	 * @param imagePath : Nouveau Chemin absolue de l'attribut this.image
	 */
	public void setImage(String imagePath) {
		commandGestion.getPerspectiveTranslation().setImagePerspective(new Images(imagePath));
	}

	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 **/
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	/**
	 * Methode permettant : configurer l'action de la commande Translate
	 * 
	 * @param command : instance d'une commande de type Translate
	 * @return void 
	 */
	public void setAction(Translate command) {
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				command.setON();
				command.setX(e.getPoint().x);
				command.setY(e.getPoint().y);
				command.execute();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}

		});

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				command.setOFF();
				command.execute();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});
	}

}
