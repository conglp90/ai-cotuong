package view.QuanCo;

import java.awt.Graphics;
import java.awt.Image;

public class Xe extends QuanCo { 
	public Xe(int row, int col, Image img) {
		super(row,col,img);
	}
	public void drawXe(Graphics g){
		g.drawImage(getImg(),getX(),getY(),42,42,null);
	}
	public void getPosCanMove() {
		    
	}
}
