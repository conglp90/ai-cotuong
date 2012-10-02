/**
 * 
 */
package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Constant;

/**
 * @author heroandtn3
 *
 */
public class MenuHomePanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Container contain;
	CardLayout card;
	JLabel newGame;
	
	ImageIcon imgNewGame =  new ImageIcon(Constant.OPT_DIR + "/newgame.gif");
	
	/**
	 * 
	 */
	public MenuHomePanel(Container ct, CardLayout c) {
		// TODO Auto-generated constructor stub
		this.card = c;
		this.contain = ct;
		setBackground(Color.BLUE);
		newGame = new JLabel(imgNewGame);
		newGame.addMouseListener(this);
		//add(newGame);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		card.show(contain, "LoadMenu");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
