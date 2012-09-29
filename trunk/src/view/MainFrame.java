package view;

import javax.swing.*;

import model.Constant;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MenuPanel menuPanel;
	ChessBoardPanel chessBoardPanel;

	public MainFrame() {
		setSize(Constant.MAIN_WIDTH, Constant.MAIN_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(Constant.LOCATEX, Constant.LOCATEY);
		setResizable(false);
		menuPanel = new MenuPanel();
		add(menuPanel);
		chessBoardPanel = new ChessBoardPanel();
		add(chessBoardPanel);
	}
}
