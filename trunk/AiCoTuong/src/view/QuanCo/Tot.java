package view.QuanCo;

import java.awt.Graphics;
import java.awt.Image;

public class Tot extends QuanCo {
	public Tot(int row, int col, Image img) {
		super(row,col,img);
	}
	public void drawTot(Graphics g){
		g.drawImage(getImg(),getX(),getY(),42,42,null);
	}
	  public void getPosCanMove() {
		    
	  }
}
