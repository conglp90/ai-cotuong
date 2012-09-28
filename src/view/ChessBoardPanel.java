package view;

import javax.swing.*;

import model.Constant;
import model.Match;
import model.chess.*;

import java.awt.*;

public class ChessBoardPanel extends JPanel{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1976248615976616148L;
	Image imgBoard;
	Image imgChessRed[]=new Image[8];
	Image imgChessBlack[]=new Image[8];

	public ChessBoardPanel(){
		loadImage();
	}
	public void loadImage(){
		imgBoard=new ImageIcon("src/images/board/banco.png").getImage();
		imgChessRed[6]=new ImageIcon("src/images/chess/xedo.png").getImage();
		imgChessRed[4]=new ImageIcon("src/images/chess/mado.png").getImage();
		imgChessRed[3]=new ImageIcon("src/images/chess/tinhdo.png").getImage();
		imgChessRed[2]=new ImageIcon("src/images/chess/sydo.png").getImage();
		imgChessRed[1]=new ImageIcon("src/images/chess/totdo.png").getImage();
		imgChessRed[5]=new ImageIcon("src/images/chess/phaodo.png").getImage();
		imgChessRed[7]=new ImageIcon("src/images/chess/tuongdo.png").getImage();
		
		imgChessBlack[6]=new ImageIcon("src/images/chess/xeden.png").getImage();
		imgChessBlack[4]=new ImageIcon("src/images/chess/maden.png").getImage();
		imgChessBlack[3]=new ImageIcon("src/images/chess/tinhden.png").getImage();
		imgChessBlack[2]=new ImageIcon("src/images/chess/syden.png").getImage();
		imgChessBlack[1]=new ImageIcon("src/images/chess/totden.png").getImage();
		imgChessBlack[5]=new ImageIcon("src/images/chess/phaoden.png").getImage();
		imgChessBlack[7]=new ImageIcon("src/images/chess/tuongden.png").getImage();
		
	}
	public void paint(Graphics g){
		g.drawImage(imgBoard,Constant.BOARD_X,Constant.BOARD_Y,Constant.BOARD_WIDTH,Constant.BOARD_HEIGHT,null);
		drawChess(g);
	} 
	public void drawChess(Graphics g){
		for (int i=0;i<10;i++)
			for (int j=0;j<9;j++){
				int x=Match.tablePos[i][j];
				if (x>0){
					g.drawImage(imgChessRed[x],Constant.OX+j*Constant.length,Constant.OY+i*Constant.length,42,42,null);
				}else
				if (x<0)
					g.drawImage(imgChessBlack[-x],Constant.OX+j*Constant.length,Constant.OY+i*Constant.length,42,42,null);
			}
			
	}
}
