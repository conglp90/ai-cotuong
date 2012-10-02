package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import model.Constant;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MenuPanel menuPanel;
	ChessBoardPanel chessBoardPanel;

	public MainFrame() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(Constant.MAIN_WIDTH, Constant.MAIN_HEIGHT);
		setVisible(true);
		setBackground(Color.YELLOW);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(Constant.LOCATEX, Constant.LOCATEY);
		//setResizable(false);
		
		chessBoardPanel = new ChessBoardPanel();
		add(chessBoardPanel); //van de o day
		menuPanel = new MenuPanel();
		add(menuPanel);
	}
}
