package view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.Constant;
import model.Match;

public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Dimension menuDim = new Dimension(Constant.MAIN_WIDTH
			- Constant.BOARD_WIDTH - 30, Constant.MAIN_HEIGHT); // kich thuoc khung menu

	private CardLayout card = new CardLayout(0, 0);

	// cac panel phu
	private MenuHomePanel homeMenu;
	private MenuNewPanel newMenu;
	private MenuCreatePanel createMenu;
	private MenuLoadPanel loadMenu;
	private MenuPlayPanel playMenu;

	private MainFrame mainFrame;
	private Match match;

	public MenuPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.match = mainFrame.getMatch();
		setPreferredSize(menuDim);
		setMinimumSize(menuDim);

		setLayout(card);

		homeMenu = new MenuHomePanel(this);
		add(homeMenu, "HomeMenu");

		newMenu = new MenuNewPanel(this);
		add(newMenu, "NewMenu");

		createMenu = new MenuCreatePanel(this);
		add(createMenu, "CreateMenu");

		loadMenu = new MenuLoadPanel(this);
		add(loadMenu, "LoadMenu");

		playMenu = new MenuPlayPanel(this);
		add(playMenu, "PlayMenu");

		setVisible(true);
	}

	public void swapPanel(String key) {
		card.show(this, key);
	}

	public MainFrame getMainFrame() {
		return this.mainFrame;
	}
}
