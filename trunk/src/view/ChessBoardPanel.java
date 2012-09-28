package view;

import javax.swing.*;

import model.Constant;

import java.awt.*;

public class ChessBoardPanel extends JPanel{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1976248615976616148L;
	Image imgBoard;
	public ChessBoardPanel(){
		loadImage();
	}
	public void loadImage(){
		imgBoard=new ImageIcon("src/images/board/board.png").getImage();
		
	}
	public void paint(Graphics g){
		g.drawImage(imgBoard,Constant.BOARD_X,Constant.BOARD_Y,null);
	}
}
