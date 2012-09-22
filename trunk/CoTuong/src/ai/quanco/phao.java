package ai.quanco;

import java.awt.Graphics;
import java.awt.Image;

public class phao {
	private int x,y;
	Image phao;
	public phao(int x,int y, Image phao){
		this.x=x;
		this.y=y;
		this.phao=phao;
	}
	public void drawPhao(Graphics g){
		if (g!=null){
			g.drawImage(phao,x,y,42,42,null);
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
