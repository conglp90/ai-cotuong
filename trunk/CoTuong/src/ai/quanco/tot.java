package ai.quanco;

import java.awt.Graphics;
import java.awt.Image;

public class tot {
	private int x,y;
	Image tot;
	public tot(int x,int y, Image xe){
		this.x=x;
		this.y=y;
		this.tot=xe;
	}
	public void drawTot(Graphics g){
		if (g!=null){
			g.drawImage(tot,x,y,42,42,null);
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
