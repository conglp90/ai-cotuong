package view.main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import view.ToaDo;
import view.QuanCo.*;

/* 
   
 */


class BanCo extends JPanel {

    public int x;
    public int y;
    public Image banco;
    public Image imgxedo,imgxeden;
    public Image imgmado,imgmaden;
    public Image imgtotdo,imgtotden;
    public Image imgtinhdo,imgtinhden;
    public Image imgtuongdo,imgtuongden;
    public Image imgsydo,imgsyden;
    public Image imgphaodo,imgphaoden;
    Xe xe;
    Tuong tuong;
    Tot tot;
    Sy sy;
    Phao phao;
    Tinh tinh;
    Ma ma;
    public int WIDTH=900;
    public int HEIGHT=700;
    public int vitri[][]={{6, 4, 3, 2, 7, 2, 3, 4, 6},
	  		  {0, 0, 0, 0, 0, 0, 0, 0, 0},
	  		  {0, 5, 0, 0, 0, 0, 0, 5, 0},
	  		  {1, 0, 1, 0, 1, 0, 1, 0, 1},
	  		  {0, 0, 0, 0, 0, 0, 0, 0, 0},
	  		  {0, 0, 0, 0, 0, 0, 0, 0, 0},
	  		  {-1, 0, -1, 0,-1, 0,-1, 0,-1},
	  		  {0, -5, 0, 0, 0, 0, 0,-5, 0},
	  		  {0, 0, 0, 0, 0, 0, 0, 0, 0},
	  		  {-6, -4,-3,-2,-7,-2,-3,-4,-6}};
    public BanCo(){
    	setSize(WIDTH, HEIGHT);
    	setVisible(true);
    	loadImage();
    }
    public void paint(Graphics g){
    	g.drawImage(banco,150,0,WIDTH-300,HEIGHT-30,null);
    	draw(g);
    }
    public void draw(Graphics g){
    	for (int i=0;i<10;i++)
    		for (int j=0;j<9;j++){
    			if (vitri[i][j]==6){
    				xe=new Xe(i,j,imgxedo);
    				xe.drawXe(g);
    			}
    			if (vitri[i][j]==-6){
    				xe=new Xe(i,j,imgxeden);
    				xe.drawXe(g);
    			}
    			if (vitri[i][j]==4){
    				ma=new Ma(i,j,imgmado);
    				ma.drawMa(g);
    			}
    			if (vitri[i][j]==-4){
    				ma=new Ma(i,j,imgmaden);
    				ma.drawMa(g);
    			}
    			if (vitri[i][j]==3){
    				tinh=new Tinh(i,j,imgtinhdo);
    				tinh.drawTinh(g);
    			}
    			if (vitri[i][j]==-3){
    				tinh=new Tinh(i,j,imgtinhden);
    				tinh.drawTinh(g);
    			}
    			if (vitri[i][j]==2){
    				sy=new Sy(i,j,imgsydo);
    				sy.drawSy(g);
    			}
    			if (vitri[i][j]==-2){
    				sy=new Sy(i,j,imgsyden);
    				sy.drawSy(g);
    			}
    			if (vitri[i][j]==5){
    				phao=new Phao(i,j,imgphaodo);
    				phao.drawPhao(g);
    			}
    			if (vitri[i][j]==-5){
    				phao=new Phao(i,j,imgphaoden);
    				phao.drawPhao(g);
    			}
    			if (vitri[i][j]==7){
    				tuong=new Tuong(i,j,imgtuongdo);
    				tuong.drawTuong(g);
    			}
    			if (vitri[i][j]==-7){
    				tuong=new Tuong(i,j,imgtuongden);
    				tuong.drawTuong(g);
    			}
    			if (vitri[i][j]==1){
    				tot=new Tot(i,j,imgtotdo);
    				tot.drawTot(g);
    			}
    			if (vitri[i][j]==-1){
    				tot=new Tot(i,j,imgtotden);
    				tot.drawTot(g);
    			}
    		}
    }
    public void loadImage(){
    	banco=new ImageIcon("src/images/banco/banco.png").getImage();
    	imgxedo=new ImageIcon("src/images/chess/xedo.png").getImage();
    	imgxeden=new ImageIcon("src/images/chess/xeden.png").getImage();
    	imgmado=new ImageIcon("src/images/chess/mado.png").getImage();
    	imgmaden=new ImageIcon("src/images/chess/maden.png").getImage();
    	imgtinhdo=new ImageIcon("src/images/chess/tinhdo.png").getImage();
    	imgtinhden=new ImageIcon("src/images/chess/tinhden.png").getImage();
    	imgsydo=new ImageIcon("src/images/chess/sydo.png").getImage();
    	imgsyden=new ImageIcon("src/images/chess/syden.png").getImage();
    	imgtuongdo=new ImageIcon("src/images/chess/tuongdo.png").getImage();
    	imgtuongden=new ImageIcon("src/images/chess/tuongden.png").getImage();
    	imgphaodo=new ImageIcon("src/images/chess/phaodo.png").getImage();
    	imgphaoden=new ImageIcon("src/images/chess/phaoden.png").getImage();
    	imgtotdo=new ImageIcon("src/images/chess/totdo.png").getImage();
    	imgtotden=new ImageIcon("src/images/chess/totden.png").getImage();
    }
    public void drawChess(Image img, int x, int y) {
    
    }

    public void highLight(ToaDo [] td, int n) {
    
    }


}
