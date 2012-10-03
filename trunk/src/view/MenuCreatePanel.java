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
public class MenuCreatePanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MenuPanel cardPanel;
	
	ImageIcon imgBackHome;
	
	JLabel lbBackHome;

	/**
	 * 
	 */
	public MenuCreatePanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		this.cardPanel = mp;
		setBackground(Color.YELLOW);
		add(new JLabel("Create Game"));
		
		loadImage();
		initLabel();
	}
	
	private void initLabel() {
		lbBackHome = new JLabel(imgBackHome);
		lbBackHome.addMouseListener(this);
		add(lbBackHome);
	}
	
	private void loadImage() {
		imgBackHome = new ImageIcon(Constant.OPT_DIR + "/back.png");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbBackHome) {
			cardPanel.swapPanel("HomeMenu");
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
