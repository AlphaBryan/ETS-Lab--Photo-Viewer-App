package vue;

import javax.swing.JPanel;

import main.Application;

import java.awt.Graphics;



import model.Images;

public class PanelStatic extends JPanel {
	
    private static final long serialVersionUID = 4L;
    private Images image;
    
    private void testImage() {
        String MettreImageTest = "./test/TestedImage.png" ; 
		this.image = new Images(MettreImageTest);

    }
    
	/**
	 * Construteur de la classe PanelStatic.java
	 * @param Image : Instance de l'attribut de l'image du panel 
	 */
	public PanelStatic(Images image) {
		super();
		this.image = image;
		testImage();
	}
	
	/**
	@see javax.swing.JComponent#paint(java.awt.Graphics)
	**/
	@Override
	public void paint(Graphics g) {
		System.out.println("@test"); //S'arrete a un certain moment... TODO : Repair 
		//System.out.println("Test detected path : "+ Application.getMainFrame().getImgPath().toString());
        super.paint(g);
		if(image != null ) {
	        g.drawImage(image.getImg(), 0, 0, this); // see javadoc for more info on the parameters      
		}
		else{
            g.drawRect(20, 20, 250, 250);
            g.drawString("Static", 125, 10);
		}
	}

	/** Getter de l'attribut : Images
	 * @return Images : Instance de l'attribut this.image
	 */
	public Images getImage() {
		return image;
	}

	/** Setter de l'attribtut : this.image
	 * @param image : Nouvelle valeur de l'attribut this.image 
	 */
	public void setImage(Images image) {
		this.image = image;
	}

	/** Setter de l'attribtut : this.image
	 * @param imagePath : Nouveau Chemin absolue de l'attribut this.image 
	 */
	public void setImage(String imagePath) {
		this.image = new Images(imagePath);
	}
	
}
