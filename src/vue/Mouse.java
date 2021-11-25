package vue;
import java.awt.event.*;
import java.awt.Color;

import javax.swing.JPanel;

public class Mouse implements MouseListener {

	/**
	@see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	**/
	@Override
    public void mouseClicked(MouseEvent event) {
                /* source is the object that got clicked
                 * 
                 * If the source is actually a JPanel, 
                 * then will the object be parsed to JPanel 
                 * since we need the setBackground() method
                 */
        Object source = event.getSource();
        if(source instanceof JPanel){
            JPanel panelPressed = (JPanel) source;
            panelPressed.setBackground(Color.blue);
        }
    }

	/**
	@see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	**/
	@Override
	public void mousePressed(MouseEvent e) {
	}

	/**
	@see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	**/
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	/**
	@see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	**/
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	@see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	**/
	@Override
	public void mouseExited(MouseEvent e) {
	}

}
