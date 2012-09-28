package view;

import javax.swing.*;

import model.Constant;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MainFrame(){
		setSize(Constant.MAIN_WIDTH, Constant.MAIN_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(Constant.LOCATEX,Constant.LOCATEY);
		setResizable(false);
		MenuPanel MP=new MenuPanel();
		add(MP);
	}
	public static void main(String args[]){
		new MainFrame();
	}
}
