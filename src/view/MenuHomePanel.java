/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
	private GridBagLayout gridBag = new GridBagLayout();
	private GridBagConstraints gridBC = new GridBagConstraints();

	private ImageIcon imgNewGame, imgCreateGame, imgLoadGame, imgExit,
			imgCancel, imgOk, imgStore;

	private JLabel lbNewGame, lbCreateGame, lbLoadGame, lbExit, lbWarn,
			lbCancel, lbOk;

	/**
	 * 
	 */
	public MenuHomePanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		this.cardPanel = mp;
		setBackground(Color.GREEN);
		setPreferredSize(cardPanel.getPreferredSize());
		setLayout(gridBag);
		gridBC.anchor = GridBagConstraints.CENTER;
		gridBC.insets = new Insets(3, 0, 3, 0);

		loadImage();
		initLabel();
		addAll();
	}

	private void addAll() {
		addComponent(lbNewGame, 0, 0, 1, 3);
		addComponent(lbCreateGame, 1, 0, 1, 3);
		addComponent(lbLoadGame, 2, 0, 1, 3);
		addComponent(lbExit, 3, 0, 1, 3);
		addComponent(lbWarn, 5, 0, 1, 3);
		addComponent(lbCancel, 6, 0, 1, 1);
		addComponent(lbOk, 6, 2, 1, 1);
	}

	private void setWarnVisible(boolean status) {
		lbWarn.setVisible(status);
		lbCancel.setVisible(status);
		lbOk.setVisible(status);
	}

	private void initLabel() {

		lbNewGame = new JLabel(imgNewGame);
		lbNewGame.addMouseListener(this);

		lbCreateGame = new JLabel(imgCreateGame);
		lbCreateGame.addMouseListener(this);

		lbLoadGame = new JLabel(imgLoadGame);
		lbLoadGame.addMouseListener(this);

		lbExit = new JLabel(imgExit);
		lbExit.addMouseListener(this);

		lbWarn = new JLabel("Are you want to exit?");

		lbCancel = new JLabel(imgCancel);
		lbCancel.addMouseListener(this);

		lbOk = new JLabel(imgOk);
		lbOk.addMouseListener(this);
		setWarnVisible(false);

	}

	private void loadImage() {
		imgNewGame = new ImageIcon(Constant.OPT_DIR + "/newgame.gif");
		imgCreateGame = new ImageIcon(Constant.OPT_DIR + "/creategame.gif");
		imgLoadGame = new ImageIcon(Constant.OPT_DIR + "/loadgame.gif");
		imgExit = new ImageIcon(Constant.OPT_DIR + "/exit.gif");
		imgOk = new ImageIcon(Constant.OPT_DIR + "/ok");
		imgCancel = new ImageIcon(Constant.OPT_DIR + "/cancel");
	}

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
		if (source == lbNewGame) {
			cardPanel.swapPanel("NewMenu");
		} else if (source == lbCreateGame) {
			cardPanel.swapPanel("CreateMenu");
		} else if (source == lbLoadGame) {
			cardPanel.swapPanel("LoadMenu");
		} else if (source == lbExit) {
			setWarnVisible(true);
		} else if (source == lbCancel) {
			setWarnVisible(false);
		} else if (source == lbOk) {
			System.exit(0);
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
		if (source == lbOk || source == lbCancel) {
			source.setIcon(new ImageIcon(source.getIcon().toString() + "-hover"));
		} else {
			source.setIcon(ImageService.hightlight((ImageIcon) source.getIcon()));
		}
		source.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		source.setIcon(imgStore);
	}

}
