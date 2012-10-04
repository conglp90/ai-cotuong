/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	private GridBagLayout gridBag = new GridBagLayout();
	private GridBagConstraints gridBC = new GridBagConstraints();

	// cac nut dieu khien
	private ImageIcon imgBackHome, imgOk, imgStore;
	private JLabel lbBackHome, lbOk;

	// chon che do choi
	private JLabel lbMode = new JLabel("Select player mode:");
	private ButtonGroup modeGroup = new ButtonGroup();
	private JRadioButton radioCom, radioHum;
	
	// chon ai di truoc
	private JLabel lbWho = new JLabel("Who will play first?");
	private ButtonGroup whoGroup = new ButtonGroup();
	private JRadioButton radioComFirst, radioHumFirst;

	// chon level
	private JLabel lbLevel = new JLabel("Select level:");
	private ButtonGroup levelGroup = new ButtonGroup();
	private JRadioButton radioCaptain, radioIron, radioThor, radioHulk;
	private ImageIcon imgCaptain, imgIron, imgThor, imgHulk;

	/**
	 * 
	 */
	public MenuNewPanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		this.cardPanel = mp;
		setLayout(gridBag);
		gridBC.anchor = GridBagConstraints.WEST;
		gridBC.insets = new Insets(10, 0, 3, 0);
		//gridBC.fill = GridBagConstraints.BOTH;
		loadImage();
		initLabel();
		initRadio();
		addAll();

	}

	private void addAll() {
		// control
		addComponent(lbBackHome, 0, 0, 1, 1);
		addComponent(lbOk, 0, 1, 1, 1);

		// mode
		addComponent(lbMode, 2, 0, 1, 2);
		addComponent(radioCom, 3, 0, 1, 5);
		addComponent(radioHum, 4, 0, 1, 5);
		
		// who play first
		addComponent(lbWho, 6, 0, 1, 5);
		addComponent(radioComFirst, 7, 0, 1, 5);
		addComponent(radioHumFirst, 8, 0, 1, 5);

		// level
		addComponent(lbLevel, 10, 0, 1, 2);
		addComponent(radioCaptain, 11, 0, 1, 1);
		addComponent(radioIron, 12, 0, 1, 1);
		addComponent(radioThor, 13, 0, 1, 1);
		addComponent(radioHulk, 14, 0, 1, 1);
	}

	private void initRadio() {
		// che do choi
		radioCom = new JRadioButton("Human vs Computer", true);
		modeGroup.add(radioCom);

		radioHum = new JRadioButton("Human vs Human", false);
		modeGroup.add(radioHum);
		
		// ai choi truoc
		radioComFirst = new JRadioButton("Computer", true);
		whoGroup.add(radioComFirst);
		radioHumFirst = new JRadioButton("Human", false);
		whoGroup.add(radioHumFirst);

		// level
		radioCaptain = new JRadioButton("Captain", true);
		levelGroup.add(radioCaptain);

		radioIron = new JRadioButton("Iron", false);
		levelGroup.add(radioIron);

		radioThor = new JRadioButton("Thor", false);
		levelGroup.add(radioThor);

		radioHulk = new JRadioButton("Hulk", false);
		levelGroup.add(radioHulk);

	}

	private void initLabel() {
		lbBackHome = new JLabel(imgBackHome, SwingConstants.CENTER);
		lbBackHome.addMouseListener(this);

		lbOk = new JLabel(imgOk, SwingConstants.CENTER);
		lbOk.addMouseListener(this);
	}

	private void loadImage() {
		imgBackHome = new ImageIcon(Constant.OPT_DIR + "/back");
		imgOk = new ImageIcon(Constant.OPT_DIR + "/ok");

		imgCaptain = new ImageIcon(Constant.LEVEL_DIR + "/captain.png");
		imgIron = new ImageIcon(Constant.LEVEL_DIR + "/iron.png");
		imgThor = new ImageIcon(Constant.LEVEL_DIR + "/thor.png");
		imgHulk = new ImageIcon(Constant.LEVEL_DIR + "/hulk.png");
	}

	/*
	 * public void paintComponent(Graphics g) { g.drawImage(new
	 * ImageIcon(Constant.IMG_DIR +"/welcome.jpg").getImage(), 0, 0,
	 * this.getWidth(), this.getHeight(), null); }
	 */

	private void addComponent(Component c, int row, int col, int nrow, int ncol) {
		// TODO Auto-generated method stub

		gridBC.gridx = col;
		gridBC.gridy = row;

		gridBC.gridwidth = ncol;
		gridBC.gridheight = nrow;

		this.gridBag.setConstraints(c, gridBC);
		this.add(c);
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
		JLabel source = (JLabel) e.getSource();
		imgStore = (ImageIcon) source.getIcon();
		source.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		source.setIcon(new ImageIcon(source.getIcon().toString() + "-hover"));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		source.setIcon(imgStore);

	}

}
