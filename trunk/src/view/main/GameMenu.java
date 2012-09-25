package view.main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/* 
   
 */


class GameMenu extends JPanel{

    public Image imgNewGame;
    public Image imgLoadGame;
    public Image imgSaveGame;
    public Image imgExit;
    public Image imgCreateCampaign;
    public Image imgUndo;
    public Image imgRedo;
    public Image imgPause;
    public Image imgSound;
    public Image imgHint;
    public GameMenu(){
    	loadImage();
    }
    public void paint(Graphics g){
    	g.drawImage(imgUndo,800,200,null);
    	g.drawImage(imgSaveGame,800,240,null);
    }
    public void loadImage(){
    	imgUndo=new ImageIcon("src/images/option/Undo.png").getImage();
    	imgSaveGame=new ImageIcon("src/images/option/Save.png").getImage();
    }

    public final void drawButton(Image img, int x, int y) {
    
    }

    public final void showTime() {
    
    }


}
