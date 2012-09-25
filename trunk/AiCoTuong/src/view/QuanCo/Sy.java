package view.QuanCo;

import java.awt.Graphics;
import java.awt.Image;


/* 
   
 */


public class Sy extends QuanCo{
	public Sy(int row, int col, Image img) {
		super(row,col,img);
	}
	public void drawSy(Graphics g){
		g.drawImage(getImg(),getX(),getY(),42,42,null);
	}
    public void getPosCanMove() {
    
    }


}
