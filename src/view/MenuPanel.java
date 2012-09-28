package view;

import java.awt.*;

import javax.swing.*;

import model.Constant;

public class MenuPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image imgNewGame;
	Image imgSaveGame;
	Image imgLoadGame;
	Image imgUndo;
	Image imgRedo;
	Image imgExit;
	Image imgPause;
	Image imgPlay;
	Image imgSound;
	Image imgHint;
	public MenuPanel(){
		loadImage();
		
	}
	public void loadImage(){
		imgSaveGame=new ImageIcon("src/images/option/Save.png").getImage();
		imgUndo=new ImageIcon("src/images/option/Undo.png").getImage();
	}
	public void paint(Graphics g){
		g.drawImage(imgSaveGame,Constant.SAVE_X,Constant.SAVE_Y,null);
		g.drawImage(imgUndo,Constant.UNDO_X,Constant.UNDO_Y,null);
	}
	

}
