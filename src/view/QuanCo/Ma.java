package view.QuanCo;

import java.awt.Graphics;
import java.awt.Image;

public class Ma extends QuanCo{
	public Ma(int row, int col, Image img) {
		super(row,col,img);
	}
	public void drawMa(Graphics g){
		g.drawImage(getImg(),getX(),getY(),42,42,null);
	}
	  public void getPosCanMove() {
		    
	  }
}
