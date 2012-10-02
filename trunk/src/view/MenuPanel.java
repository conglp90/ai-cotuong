package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.MyEvent;

import model.Constant;

public class MenuPanel extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final Dimension menuDim = new Dimension(Constant.MAIN_WIDTH - Constant.BOARD_WIDTH - 20,
													Constant.MAIN_HEIGHT); // kich thuoc khung menu
	CardLayout card = new CardLayout();
	
	// cac panel phu
	MenuHomePanel homeMenu = new MenuHomePanel();
	MenuNewPanel newMenu = new MenuNewPanel();
	MenuCreatePanel createMenu = new MenuCreatePanel();
	MenuLoadPanel loadMenu = new MenuLoadPanel();
	MenuPlayPanel playMenu = new MenuPlayPanel();
	
	ImageIcon imgNewGame;
	ImageIcon imgCreateGame;
	ImageIcon imgSaveGame;
	ImageIcon imgLoadGame;
	ImageIcon imgUndo;
	ImageIcon imgRedo;
	ImageIcon imgExit;
	ImageIcon imgPause;
	ImageIcon imgPlay;
	ImageIcon imgSound;
	ImageIcon imgHint;
	ImageIcon imgBack;
	ImageIcon imgHome;
	 
	
	
	JLabel newGame, createGame, loadGame, backHome, exitGame, backPlay, goHome;
	
	

	public MenuPanel() {
		
		setPreferredSize(menuDim);
		setLayout(card);
		setVisible(true);
		
		loadImage();
		initLabel();
		
		
		homeMenu.add(newGame);
		homeMenu.add(createGame);
		homeMenu.add(loadGame);
		homeMenu.add(exitGame);
		homeMenu.add(backPlay);
		
		add(homeMenu, "HomeMenu");
		add(newMenu, "NewMenu");
		add(createMenu, "CreateMenu");
		add(loadMenu, "LoadMenu");
		add(playMenu, "PlayMenu");
		
		
	}
	
	private void initLabel() {
		backHome = new JLabel(imgBack);
		backHome.addMouseListener(this);
		
		newGame = new JLabel(imgNewGame);
		newGame.addMouseListener(this);
		
		createGame = new JLabel(imgCreateGame);
		createGame.addMouseListener(this);
		
		loadGame = new JLabel(imgLoadGame);
		loadGame.addMouseListener(this);
		
		exitGame = new JLabel(imgExit);
		exitGame.addMouseListener(this);
		
		backPlay = new JLabel(imgBack);
		backPlay.addMouseListener(this);
		
		goHome = new JLabel(imgHome);
		goHome.addMouseListener(this);
	}

	public void loadImage() {
		imgPause = new ImageIcon(Constant.OPT_DIR + "/pause.png");
		imgHint = new ImageIcon(Constant.OPT_DIR + "/hint.png");
		imgUndo = new ImageIcon(Constant.OPT_DIR + "/undo.png");
		imgRedo = new ImageIcon(Constant.OPT_DIR + "/redo.png");
		imgNewGame = new ImageIcon(Constant.OPT_DIR + "/newgame.gif");
		imgCreateGame = new ImageIcon(Constant.OPT_DIR + "/creategame.gif");
		imgLoadGame = new ImageIcon(Constant.OPT_DIR + "/loadgame.gif");
		imgSaveGame = new ImageIcon(Constant.OPT_DIR + "/savegame.gif");
		imgExit = new ImageIcon(Constant.OPT_DIR + "/exit.gif");
		imgUndo = new ImageIcon(Constant.OPT_DIR + "/undo.png");
		imgBack = new ImageIcon(Constant.OPT_DIR + "/back.png");
		imgHome = new ImageIcon(Constant.OPT_DIR + "/home.png");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == newGame) {
			card.show(this, "NewMenu");
			newMenu.add(backHome);
		} else if (source == createGame) {
			card.show(this, "CreateMenu");
			createMenu.add(backHome);
		} else if (source == loadGame) {
			card.show(this, "LoadMenu");
			loadMenu.add(backHome);
		} else if (source == backHome) {
			card.show(this, "HomeMenu");
		} else if (source == backPlay) {
			card.show(this, "PlayMenu");
			playMenu.add(goHome);
		} else if (source == goHome) {
			card.show(this, "HomeMenu");
			homeMenu.add(backPlay);
		} else if (source == exitGame)
			System.exit(0);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

/*	@Override
	public void paint(Graphics g) {
		
		g.drawImage(imgPause, Constant.MENU_X, Constant.MENU_Y - 2*Constant.IMG_HEIGHT, null);
		g.drawImage(imgHint, Constant.MENU_X + Constant.IMG_WIDTH, Constant.MENU_Y - 2*Constant.IMG_HEIGHT, null);
		g.drawImage(imgUndo, Constant.MENU_X, Constant.MENU_Y - Constant.IMG_HEIGHT, null);
		g.drawImage(imgRedo, Constant.MENU_X + Constant.IMG_WIDTH, Constant.MENU_Y - Constant.IMG_HEIGHT, null);
		g.drawImage(imgNewGame, Constant.MENU_X, Constant.MENU_Y, null);
		g.drawImage(imgLoadGame, Constant.MENU_X, Constant.MENU_Y + Constant.IMG_HEIGHT, null);
		g.drawImage(imgSaveGame, Constant.MENU_X, Constant.MENU_Y + 2*Constant.IMG_HEIGHT, null);
		g.drawImage(imgExit, Constant.MENU_X, Constant.MENU_Y + 3*Constant.IMG_HEIGHT, null);
	}*/

	

}
