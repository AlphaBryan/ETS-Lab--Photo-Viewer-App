package vue;

import controlleur.*;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame  {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121 - Image";
	private static final Dimension DIMENSION = new Dimension(700, 700);
	
	private MainPanel panneauPrincipal ;
	private static Toolbar toolbar = new Toolbar();

	public MainFrame() {
		panneauPrincipal = new MainPanel();
		toolbar = new Toolbar();
		setUpCommandToolbar();
		setUpCommandPanels() ;
		add(panneauPrincipal);
		add(toolbar, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}



	/**
	 * Methode permettant : d'associer chacun des boutons de la Toolbar à sa commande respective
	 */
	public void setUpCommandToolbar(){
		Toolbar.setAction(new Save());
		Toolbar.setAction(new Charge());
		Toolbar.setAction(new Undo());
		Toolbar.setAction(new Redo()) ; 
	}

	
	/**
	 * Methode permettant : d'associer respectivement une commande a tous les sous Panel de notre MainPanel
	 */
	public void setUpCommandPanels(){
		panneauPrincipal.getpTranslation().setAction(new Translate());
		panneauPrincipal.getpZoom().setAction(new Zoom());
	}
	


	/** Setter de l'attribtut : this.imgPath
	 * @param imgPath : Nouvelle valeur de l'attribut this.imgPath 
	 */
	public void setImgPath(String imgPath) {
		panneauPrincipal.setPanelsImage(imgPath);
		repaint();
	}



	/** Getter de l'attribut : MainPanel
	 * @return MainPanel : Instance de l'attribut this.panneauPrincipal
	 */
	public  MainPanel getPanneauPrincipal() {
		return panneauPrincipal;
	}



	/** Setter de l'attribtut : this.panneauPrincipal
	 * @param panneauPrincipal : Nouvelle valeur de l'attribut this.panneauPrincipal 
	 */
	public  void setPanneauPrincipal(MainPanel panneauPrincipal) {
		this.panneauPrincipal = panneauPrincipal;
		repaint();
	}
	
	
	
}
