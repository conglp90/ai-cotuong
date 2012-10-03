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

	public final Dimension menuDim = new Dimension(Constant.MAIN_WIDTH
			- Constant.BOARD_WIDTH - 50, Constant.MAIN_HEIGHT); // kich thuoc
																// khung menu
	private CardLayout card = new CardLayout();

	// cac panel phu
	private MenuHomePanel homeMenu = new MenuHomePanel(this);
	private MenuNewPanel newMenu = new MenuNewPanel(this);
	private MenuCreatePanel createMenu = new MenuCreatePanel(this);
	private MenuLoadPanel loadMenu = new MenuLoadPanel(this);
	private MenuPlayPanel playMenu = new MenuPlayPanel(this);
	
	private MainFrame mainFrame;
	private Match match;

	public MenuPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.match = mainFrame.getMatch();
		setPreferredSize(menuDim);
		setLayout(card);
		setVisible(true);

		add(homeMenu, "HomeMenu");
		add(newMenu, "NewMenu");
		add(createMenu, "CreateMenu");
		add(loadMenu, "LoadMenu");
		add(playMenu, "PlayMenu");
		card.show(this, "HomeMenu");

	}

	public void swapPanel(String key) {
		card.show(this, key);
	}
	
	public MainFrame getMainFrame() {
		return this.mainFrame;
	}
}
