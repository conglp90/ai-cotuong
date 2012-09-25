package view.QuanCo;

import java.awt.Graphics;
import java.awt.Image;

import view.ToaDo;

/* 
   
 */


public class Tuong extends QuanCo {
	
	 
	public Tuong(int row, int col, Image img) {
		super(row,col,img);
	}
	public void drawTuong(Graphics g){
		g.drawImage(getImg(),getX(),getY(),42,42,null);
	}

	public void getPosCanMove() {
		    
	 }


}
