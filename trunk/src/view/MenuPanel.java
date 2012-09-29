package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.Constant;

public class MenuPanel extends JPanel {
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

	public MenuPanel() {
		loadImage();
	}

	public void loadImage() {
		imgPause = new ImageIcon(Constant.OPT_DIR + "/pause.png").getImage();
		imgHint = new ImageIcon(Constant.OPT_DIR + "/hint.png").getImage();
		imgUndo = new ImageIcon(Constant.OPT_DIR + "/undo.png").getImage();
		imgRedo = new ImageIcon(Constant.OPT_DIR + "/redo.png").getImage();
		imgNewGame = new ImageIcon(Constant.OPT_DIR + "/newgame.gif").getImage();
		imgLoadGame = new ImageIcon(Constant.OPT_DIR + "/loadgame.gif").getImage();
		imgSaveGame = new ImageIcon(Constant.OPT_DIR + "/savegame.gif").getImage();
		imgExit = new ImageIcon(Constant.OPT_DIR + "/exit.gif").getImage();
		imgUndo = new ImageIcon(Constant.OPT_DIR + "/undo.png").getImage();
	}

	@Override
	public void paint(Graphics g) {
		
		g.drawImage(imgPause, Constant.MENU_X, Constant.MENU_Y - 2*Constant.IMG_HEIGHT, null);
		g.drawImage(imgHint, Constant.MENU_X + Constant.IMG_WIDTH, Constant.MENU_Y - 2*Constant.IMG_HEIGHT, null);
		g.drawImage(imgUndo, Constant.MENU_X, Constant.MENU_Y - Constant.IMG_HEIGHT, null);
		g.drawImage(imgRedo, Constant.MENU_X + Constant.IMG_WIDTH, Constant.MENU_Y - Constant.IMG_HEIGHT, null);
		g.drawImage(imgNewGame, Constant.MENU_X, Constant.MENU_Y, null);
		g.drawImage(imgLoadGame, Constant.MENU_X, Constant.MENU_Y + Constant.IMG_HEIGHT, null);
		g.drawImage(imgSaveGame, Constant.MENU_X, Constant.MENU_Y + 2*Constant.IMG_HEIGHT, null);
		g.drawImage(imgExit, Constant.MENU_X, Constant.MENU_Y + 3*Constant.IMG_HEIGHT, null);
	}

}
