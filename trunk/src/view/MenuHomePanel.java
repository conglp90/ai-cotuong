/**
 * 
 */
package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Constant;
import model.ImageService;

/**
 * @author heroandtn3
 *
 */
public class MenuHomePanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MenuPanel cardPanel;
	
	private ImageIcon imgNewGame;
	private ImageIcon imgCreateGame;
	private ImageIcon imgLoadGame;
	private ImageIcon imgExit;
	
	private JLabel lbNewGame, lbCreateGame, lbLoadGame, lbExit;
		
	/**
	 * 
	 */
	public MenuHomePanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(150, Constant.MAIN_HEIGHT));
		setLayout(null);
		this.cardPanel = mp;
		loadImage();
		initLabel();
	}
	
	private void initLabel() {
		int x = (this.getPreferredSize().width - 130)/2;
		int y = this.getPreferredSize().height/2;
		int width = 130;
		int height = 44;
		int distance = 50;
		
		lbNewGame = new JLabel(imgNewGame);
		lbNewGame.addMouseListener(this);
		lbNewGame.setBounds(x, y - 3*distance, width, height);
		add(lbNewGame);
		
		lbCreateGame = new JLabel(imgCreateGame);
		lbCreateGame.addMouseListener(this);
		lbCreateGame.setBounds(x, y - 2*distance, width, height);
		add(lbCreateGame);
		
		lbLoadGame = new JLabel(imgLoadGame);
		lbLoadGame.addMouseListener(this);
		lbLoadGame.setBounds(x, y - distance, width, height);
		add(lbLoadGame);
		
		lbExit = new JLabel(imgExit);
		lbExit.addMouseListener(this);
		lbExit.setBounds(x, y, width, height);
		add(lbExit);
	}
	
	private void loadImage() {
		imgNewGame = new ImageIcon(Constant.OPT_DIR + "/newgame.gif");
		imgCreateGame = new ImageIcon(Constant.OPT_DIR + "/creategame.gif");
		imgLoadGame = new ImageIcon(Constant.OPT_DIR + "/loadgame.gif");
		imgExit = new ImageIcon(Constant.OPT_DIR + "/exit.gif");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbNewGame) {
			cardPanel.swapPanel("NewMenu");
		} else if (source == lbCreateGame) {
			cardPanel.swapPanel("CreateMenu");
		} else if (source == lbLoadGame) {
			cardPanel.swapPanel("LoadMenu");
		} else if (source == lbExit)
			System.exit(0);
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
		source.setIcon(ImageService.hightlight((ImageIcon)source.getIcon()));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbNewGame) {
			lbNewGame.setIcon(imgNewGame);
		} else if (source == lbCreateGame) {
			lbCreateGame.setIcon(imgCreateGame);
		} else if (source == lbLoadGame) {
			lbLoadGame.setIcon(imgLoadGame);
		} else if (source == lbExit) {
			lbExit.setIcon(imgExit);
		}
		
		this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

}
