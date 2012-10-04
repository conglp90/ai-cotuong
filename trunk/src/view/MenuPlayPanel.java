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

import model.Constant;

/**
 * @author heroandtn3
 *
 */
public class MenuPlayPanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MenuPanel cardPanel;
	
	ImageIcon imgGoHome, imgPause, imgPlay, imgStore;
	JLabel lbGoHome, lbPausePlay;
	
	/**
	 * 
	 */
	public MenuPlayPanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		this.cardPanel = mp;
		add(new JLabel("Playing"));
		loadImage();
		initLabel();
		
	}
	
	private void initLabel() {
		
		lbPausePlay = new JLabel(imgPause);
		lbPausePlay.addMouseListener(this);
		add(lbPausePlay);
		
		lbGoHome = new JLabel(imgGoHome);
		lbGoHome.addMouseListener(this);
		add(lbGoHome);
		
	}
	
	private void loadImage() {
		imgGoHome = new ImageIcon(Constant.OPT_DIR + "/home");
		imgPause = new ImageIcon(Constant.OPT_DIR + "/pause");
		imgPlay = new ImageIcon(Constant.OPT_DIR + "/play");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbGoHome) {
			cardPanel.swapPanel("HomeMenu");
		} if (source == lbPausePlay) {
			if (cardPanel.getMainFrame().getMatch().isPause()) {
				cardPanel.getMainFrame().getMatch().setPause(false);
				lbPausePlay.setIcon(imgPlay);
			} else {
				cardPanel.getMainFrame().getMatch().setPause(true);
				lbPausePlay.setIcon(imgPause);
			}
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
		imgStore = (ImageIcon) source.getIcon();
		source.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		source.setIcon(new ImageIcon(source.getIcon().toString() + "-hover"));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbPausePlay) {
			lbPausePlay.setIcon(cardPanel.getMainFrame().getMatch().isPause()?imgPlay:imgPause);
		} else {
			source.setIcon(imgStore);
		}
	}

}
