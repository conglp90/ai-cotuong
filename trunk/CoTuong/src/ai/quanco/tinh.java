package ai.quanco;

import java.awt.Graphics;
import java.awt.Image;

public class tinh {
	private int x,y;
	Image tinh;
	public tinh(int x,int y, Image xe){
		this.x=x;
		this.y=y;
		this.tinh=xe;
	}
	public void drawTinh(Graphics g){
		if (g!=null){
			g.drawImage(tinh,x,y,42,42,null);
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
