package vue;

import controlleur.Charge;
import controlleur.Save;
import controlleur.Translate;
import controlleur.Zoom;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame  {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121 - Image";
	private static final Dimension DIMENSION = new Dimension(700, 700);
	
	private String ImgPath = " "; 
	public static MainPanel panneauPrincipal ;


	private MainPanel panneauPrincipal = new MainPanel();
	private Toolbar toolbar = new Toolbar();

	private Save save = new Save();
	private Charge charge = new Charge();

	public MainFrame() {
		panneauPrincipal = new MainPanel();
		Toolbar toolbar = new Toolbar();
		setUpCommandToolbar();
		add(panneauPrincipal);
		add(toolbar, BorderLayout.NORTH);
		// Faire en sorte que le X de la fenetre ferme la fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		// Rendre la fenetre visible
		setVisible(true);
		// Mettre la fenetre au centre de l'ecran
		setLocationRelativeTo(null);
		// Empecher la redimension de la fenetre
		setResizable(false);
	}



	public void setUpCommandToolbar(){
		toolbar.setAction(save);
		toolbar.setAction(charge);
		toolbar.setUndo();
	}

	/** Getter de l'attribut : String
	 * @return String : Instance de l'attribut this.imgPath
	 */
	public String getImgPath() {
		return ImgPath;
	}

	/** Setter de l'attribtut : this.imgPath
	 * @param imgPath : Nouvelle valeur de l'attribut this.imgPath 
	 */
	public void setImgPath(String imgPath) {
		ImgPath = imgPath;
		panneauPrincipal.setPanelsImage(imgPath);
	}
	
	
}
