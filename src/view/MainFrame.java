package view;

import java.awt.Color;
import java.awt.Dimension;
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
		getContentPane().setBackground(Color.BLACK);
		setUndecorated(true);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		getContentPane().setPreferredSize(new Dimension(Constant.MAIN_WIDTH, Constant.MAIN_HEIGHT));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(Constant.LOCATEX, Constant.LOCATEY);
		//setResizable(false);
		
		chessBoardPanel = new ChessBoardPanel(this);
		getContentPane().add(chessBoardPanel);
		menuPanel = new MenuPanel(this);
		getContentPane().add(menuPanel);
	
		setVisible(true);
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
