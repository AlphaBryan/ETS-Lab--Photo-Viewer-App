package vue;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Tools.TranslationInvoker;
import controlleur.CommandGestion;
import model.Images;
import model.Perspective;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import java.util.TimerTask;
import java.util.Timer ; 
public class PanelTranslation  extends JPanel implements Observer {

	private CommandGestion commandGestion = CommandGestion.getInstance();
	private static final long serialVersionUID = 1L;


	//public static final Point POS_INIT= new Point(50,50);

	/**
	 * TODO Fixer taille image avec perspective 
	 **
	 */

	/**
	 * Construteur de la classe PanelStatic.java
	 * @param XXX : ___
	 */
	public PanelTranslation() {
		super();
		commandGestion.getPerspectiveTranslation().addObserver(this);
		initBorder("Translation");

		addMouseListener(new MouseListener() {




			private TranslationInvoker dragger = new TranslationInvoker(null) ; 
	


			@Override
			public void mouseClicked(MouseEvent e) {

			}
 
			@Override
			public void mousePressed(MouseEvent e) {
				commandGestion.getPerspectiveTranslation().setFocus(true);
				System.out.println("\n- Translation:" + e.getPoint().x + " "+ e.getPoint().y );
				dragger.setMousePosition(new Point(e.getPoint().x, e.getPoint().y))  ; 
				dragger.drag();
				repaint() ; //Update ?
			}

			@Override
			public void mouseReleased(MouseEvent e) {		
				commandGestion.getPerspectiveTranslation().setFocus(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {


			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		}

				) ; 
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
				g.drawImage(commandGestion.getPerspectiveTranslation().getImagePerspective().getImg()
						, commandGestion.getPerspectiveTranslation().getPositionInPerspective().x-100
						, commandGestion.getPerspectiveTranslation().getPositionInPerspective().y-100,commandGestion.getPerspectiveTranslation().getSizeInPerspective().x,
						commandGestion.getPerspectiveTranslation().getSizeInPerspective().y, this);
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
