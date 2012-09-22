package ai.quanco;

import java.awt.Graphics;
import java.awt.Image;

public class sy {
	private int x,y;
	Image sy;
	public sy(int x,int y, Image xe){
		this.x=x;
		this.y=y;
		this.sy=xe;
	}
	public void drawSy(Graphics g){
		if (g!=null){
			g.drawImage(sy,x,y,42,42,null);
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
