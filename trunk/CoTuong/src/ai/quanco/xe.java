package ai.quanco;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class xe {
	private int x,y;
	Image xe;
	private int a[][]=new int[10][9];
	public xe(int x,int y,int a[][]){
		this.x=x;
		this.y=y;
	}
	public xe(int x,int y, Image xe){
		this.x=x;
		this.y=y;
		this.xe=xe;
	}
	public boolean kiemtra(int i,int j,int x1,int y1,int vitri[][]){ 
		int x2=(x1)/67;
		int y2=(y1)/68;
		int k; 
		//i,j toa do moi cua xe
		//x2,y2 toa do hien tai cua xe
		/*for (int i1=0;i1<10;i1++){
			for (int j1=0;j1<9;j1++)
				System.out.print(vitri[i1][j1]+" ");
				System.out.println();
		}
		System.out.println(i+" "+j);*/
		if(i>=0&&i<9 &&j>=0 &&j<=10){
			if (i==x2){
				if (j<y2){
					for (k=j;k<y2;k++)
						if (vitri[k][i]!=0)return false;
					return true;
				}
				if (j>y2){
					for (k=y2+1;k<=j;k++)
						if (vitri[k][i]!=0)return false;
					return true;
				}
				
			
			}
			else
				if (j==y2){
					if (i<x2){
						for (k=i;k<x2;k++)
							if (vitri[j][k]!=0)return false;
						return true;
					}
				if (i>x2){
					for (k=x2+1;k<=i;k++)
						if (vitri[j][k]!=0)return false;
					return true;
				}
			}
		}
		return false;
	}
	public void HienOcothedi(){
		int i,j;
		Graphics g = null;
		//draw(g);
		if (x>=0 &&y>=0 &&x<9 &&y<10){
			i=x;
			while (i+1<9&& a[y][i+1]==0) i++;
			//for (j=x+1;j<i;j++)
				//draw(g);
				
		} 
	}
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.drawOval(x, y,42,42);
	}
	public void drawXe(Graphics g){
		if (g!=null){
			g.drawImage(xe,x,y,42,42,null);
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
