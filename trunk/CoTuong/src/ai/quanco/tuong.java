package ai.quanco;

import java.awt.Graphics;
import java.awt.Image;

public class tuong {
	private int x,y;
	Image tuong;
	public tuong(int x,int y, Image xe){
		this.x=x;
		this.y=y;
		this.tuong=xe;
	}
	public void drawTuong(Graphics g){
		if (g!=null){
			g.drawImage(tuong,x,y,42,42,null);
		}
	}
	public void SetX(int x){
		this.x=x;
	}
	public int getX(){
		return x;
	}
	public void SetY(int y){
		this.y=y;
	}
	public int getY(){
		return y;
	}

}
