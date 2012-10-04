package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import model.Constant;
import model.Match;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuPanel menuPanel;
	private ChessBoardPanel chessBoardPanel;
	
	private Match match = new Match();

	public MainFrame() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(Constant.MAIN_WIDTH, Constant.MAIN_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(Constant.LOCATEX, Constant.LOCATEY);
		//setResizable(false);
		
		chessBoardPanel = new ChessBoardPanel(this);
		getContentPane().add(chessBoardPanel);
		menuPanel = new MenuPanel(this);
		getContentPane().add(menuPanel);
	}
	
	public ChessBoardPanel getChessBoardPanel() {
		return this.chessBoardPanel;
	}
	
	public MenuPanel getMenuPanel() {
		return this.menuPanel;
	}
	
	public Match getMatch() {
		return this.match;
	}
	
}
