/**
 * 
 */
package view;

import java.awt.Color;
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
public class MenuNewPanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MenuPanel cardPanel;
	
	private ImageIcon imgBackHome, imgOk;
	
	private JLabel lbBackHome, lbOk;
	

	
	
	/**
	 * 
	 */
	public MenuNewPanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		setBackground(Color.RED);
		this.cardPanel = mp;
		loadImage();
		initLabel();
		
	}
	
	private void initLabel() {
		lbBackHome = new JLabel(imgBackHome);
		lbBackHome.addMouseListener(this);
		add(lbBackHome);
		
		lbOk = new JLabel(imgOk);
		lbOk.addMouseListener(this);
		add(lbOk);
	}
	
	private void loadImage() {
		imgBackHome = new ImageIcon(Constant.OPT_DIR + "/back.png");
		imgOk = new ImageIcon(Constant.OPT_DIR + "/ok.png");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbBackHome) {
			cardPanel.swapPanel("HomeMenu");
		} else if (source == lbOk) {
			cardPanel.swapPanel("PlayMenu");
			cardPanel.getMainFrame().getMatch().setActive(true);
			cardPanel.getMainFrame().getChessBoardPanel().repaint();
		}
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
