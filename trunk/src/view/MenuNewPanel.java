/**
 * 
 */
package view;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		this.cardPanel = mp;
		loadImage();
		initLabel();
		
	}
	
	private void initLabel() {
		lbBackHome = new JLabel(imgBackHome, SwingConstants.CENTER);
		lbBackHome.addMouseListener(this);
		add(lbBackHome);
		
		lbOk = new JLabel(imgOk, SwingConstants.CENTER);
		lbOk.addMouseListener(this);
		add(lbOk);
	}
	
	private void loadImage() {
		imgBackHome = new ImageIcon(Constant.OPT_DIR + "/back");
		imgOk = new ImageIcon(Constant.OPT_DIR + "/ok");
	}
	
/*	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon(Constant.IMG_DIR +"/welcome.jpg").getImage(), 
					0, 0, this.getWidth(), this.getHeight(), null);
	}*/

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
		JLabel source = (JLabel) e.getSource();
		source.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		source.setIcon(new ImageIcon(source.getIcon().toString()+ "-hover"));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbBackHome) {
			lbBackHome.setIcon(imgBackHome);
		} else if (source == lbOk) {
			lbOk.setIcon(imgOk);
		}
		
	}

}
