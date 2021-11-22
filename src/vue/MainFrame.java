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

	private MainPanel panneauPrincipal = new MainPanel();
	private Toolbar toolbar = new Toolbar();

	private Save save = new Save();
	private Charge charge = new Charge();

	public MainFrame() {
		setUpCommandToolbar();
		add(panneauPrincipal);
		add(toolbar, BorderLayout.NORTH);
		// Faire en sorte que le X de la fen�tre ferme la fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		// Rendre la fen�tre visible
		setVisible(true);
		// Mettre la fen�tre au centre de l'�cran
		setLocationRelativeTo(null);
		// Emp�cher la redimension de la fen�tre
		setResizable(false);
	}



	public void setUpCommandToolbar(){
		toolbar.setAction(save);
		toolbar.setAction(charge);
		toolbar.setUndo();
	}
}
