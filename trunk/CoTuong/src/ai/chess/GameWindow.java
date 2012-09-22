package ai.chess;

import javax.swing.JFrame;

public class GameWindow extends JFrame {	
	static GameWindow gW;
	static MenuGame mG;
	static GamePanel gP;
	public GameWindow(int width, int height) {      
		mG = new MenuGame();
		add(mG);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setTitle("Game");
        setVisible(true);
        setResizable(false);
    }	
	

    public static void main(String[] args) {
        gW = new GameWindow(800, 720);
    }

    public static void exit() {
    	System.exit(0);
    }
    
    public static void backToMenu() {
    	mG = new MenuGame();
    	gW.add(mG);
    	gW.remove(gP);
    	gW.invalidate();
    	gW.validate();
    }
    
    public static void ContinueGame() {
    	gP = new GamePanel();
    	gW.add(gP);
    	gW.remove(mG);
    	gW.invalidate();
    	gW.validate();
    }
    public static void NewGame() {
    	gP = new GamePanel();
    	gW.add(gP);
    	gW.remove(mG);
    	gW.invalidate();
    	gW.validate();
    }

}