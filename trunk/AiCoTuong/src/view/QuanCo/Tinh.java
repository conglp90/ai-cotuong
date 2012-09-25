package view.QuanCo;

import java.awt.Graphics;
import java.awt.Image;

public class Tinh extends QuanCo{
	public Tinh(int row, int col, Image img) {
		super(row,col,img);
	}
	public void drawTinh(Graphics g){
		g.drawImage(getImg(),getX(),getY(),42,42,null);
	}
	public void getPosCanMove() {
		    
	}
}
