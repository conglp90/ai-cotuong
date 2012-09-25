package view.main;

import java.awt.Color;

import javax.swing.*;
	// dong nay viet tren may cua Sang
public class Main{
	public static int WIDTH=900;
	public static int HEIGHT=720;
	public static void main(String[] args) {
	        GameBoard f = new GameBoard();
	        f.pack();
	        f.setSize(WIDTH, HEIGHT);
	        f.setLocation(200, 2);
	        f.setVisible(true);
	    }
}
