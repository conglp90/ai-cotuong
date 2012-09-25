package view.main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/* 
   
 */


class GameBoard extends JFrame  {

    public int x;
    public int y;
    public int WIDTH=900;
    public int HEIGHT=700;
    public int [][] tablePos;
    BanCo banco;
    GameMenu gameMenu;
    public GameBoard(){
    	banco=new BanCo();
		add(banco);
		gameMenu=new GameMenu();
		add(gameMenu);
    	setBackground(Color.white);    
    	setSize(WIDTH, HEIGHT);
		setVisible(true);
		setResizable(false);
		
    }
}
