package ai.quanco;

import java.awt.Graphics;
import java.awt.Image;

public class ma {
	private int x,y;
	Image ma;
	public ma(int x,int y, Image ma){
		this.x=x;
		this.y=y;
		this.ma=ma;
	}
	public void drawMa(Graphics g){
		if (g!=null){
			g.drawImage(ma,x,y,42,42,null);
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
