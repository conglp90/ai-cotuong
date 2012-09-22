package ai.chess;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ai.quanco.ma;
import ai.quanco.phao;
import ai.quanco.sy;
import ai.quanco.tinh;
import ai.quanco.tot;
import ai.quanco.tuong;
import ai.quanco.xe;

public class GamePanel extends JPanel implements Runnable,MouseListener,MouseMotionListener{

	
	/**
	 * 
	 */
	xe x1;
	ma m;
	tot to;
	tinh ti;
	sy s;
	phao p;
	tuong tu;
	Image banco;
	Image totdo,tuongdo,xedo,sydo,mado,phaodo,tinhdo;
	Image totden,tuongden,xeden,syden,maden,phaoden,tinhden;
	Image xedo_click,mado_click,xeden_click,maden_click;
	Image totden_click,totdo_click,sydo_click,syden_click,tuongden_click,tuongdo_click;
	Image tinhden_click,tinhdo_click,phaodo_click,phaoden_click;
	public int toadoxedo1X=20;
	public int toadoxedo1Y=20; 
	public int toadoxedo2X=20+67*8;
	public int toadoxedo2Y=20; 
	public int toadoxeden1X=20;
	public int toadoxeden1Y=20+68*9;
	public int toadoxeden2X=20+8*67;
	public int toadoxeden2Y=20+68*9;
	
	public int toadomado1X=20+67;
	public int toadomado1Y=20;
	public int toadomado2X=20+67*7;
	public int toadomado2Y=20; 
	public int toadomaden1X=20+67;
	public int toadomaden1Y=20+68*9;
	public int toadomaden2X=20+7*67;
	public int toadomaden2Y=20+68*9;
	
	public int toadotinhdo1X=20+67*2;
	public int toadotinhdo1Y=20;
	public int toadotinhdo2X=20+67*6;
	public int toadotinhdo2Y=20; 
	public int toadotinhden1X=20+67*2;
	public int toadotinhden1Y=20+68*9;
	public int toadotinhden2X=20+6*67;
	public int toadotinhden2Y=20+68*9;
	
	public int toadosydo1X=20+67*3;
	public int toadosydo1Y=20;
	public int toadosydo2X=20+67*5;
	public int toadosydo2Y=20; 
	public int toadosyden1X=20+67*3;
	public int toadosyden1Y=20+68*9;
	public int toadosyden2X=20+5*67;
	public int toadosyden2Y=20+68*9;
	
	public int toadotuongdoX=20+67*4;
	public int toadotuongdoY=20;
	public int toadotuongdenX=20+67*4;
	public int toadotuongdenY=20+68*9;
	
	public int toadophaodo1X=20+67;
	public int toadophaodo1Y=20+68*2;
	public int toadophaodo2X=20+67*7;
	public int toadophaodo2Y=20+68*2; 
	public int toadophaoden1X=20+67;
	public int toadophaoden1Y=20+68*7;
	public int toadophaoden2X=20+7*67;
	public int toadophaoden2Y=20+68*7;
	
	public int toadototdo1X=20;
	public int toadototdo1Y=20+68*3;
	public int toadototdo2X=20+67*2;
	public int toadototdo2Y=20+68*3;
	public int toadototdo3X=20+67*4;
	public int toadototdo3Y=20+68*3;
	public int toadototdo4X=20+67*6;
	public int toadototdo4Y=20+68*3;
	public int toadototdo5X=20+67*8;
	public int toadototdo5Y=20+68*3;
	
	public int toadototden1X=20;
	public int toadototden1Y=20+68*6;
	public int toadototden2X=20+67*2;
	public int toadototden2Y=20+68*6;
	public int toadototden3X=20+67*4;
	public int toadototden3Y=20+68*6;
	public int toadototden4X=20+67*6;
	public int toadototden4Y=20+68*6;
	public int toadototden5X=20+67*8;
	public int toadototden5Y=20+68*6;
	
	public int toadoX,toadoY;
	int y;
	boolean qXedo1=false,qXedo2=false,qXeden1=false,qXeden2=false;
	boolean qMado1=false,qMado2=false,qMaden1=false,qMaden2=false;
	boolean qTinhdo1=false,qTinhdo2=false,qTinhden1=false,qTinhden2=false;
	boolean qSydo1=false,qSydo2=false,qSyden1=false,qSyden2=false;
	boolean qPhaodo1=false,qPhaodo2=false,qPhaoden1=false,qPhaoden2=false;
	boolean qTuongdo=false,qTuongden=false;
	boolean qTotdo1=false,qTotdo2=false,qTotdo3=false,qTotdo4=false,qTotdo5=false;
	
	boolean qTotden1=false,qTotden2=false,qTotden3=false,qTotden4=false,qTotden5=false;
	boolean mado1dichuyen=false,xedo1dichuyen=false,mado2dichuyen=false,xedo2dichuyen=false;
	boolean maden1dichuyen=false,xeden1dichuyen=false,maden2dichuyen=false,xeden2dichuyen=false;
	boolean sydo1dichuyen=false,sydo2dichuyen=false,tinhdo1dichuyen=false,tinhdo2dichuyen=false;
	boolean syden1dichuyen=false,syden2dichuyen=false,tinhden1dichuyen=false,tinhden2dichuyen=false;
	boolean phaodo1dichuyen=false,phaodo2dichuyen=false,phaoden1dichuyen=false,phaoden2dichuyen=false;
	boolean tuongdodichuyen=false,tuongdendichuyen=false;
	boolean totdo1dichuyen=false,totdo2dichuyen=false,totdo3dichuyen=false,totdo4dichuyen=false,totdo5dichuyen=false;
	boolean totden1dichuyen=false,totden2dichuyen=false,totden3dichuyen=false,totden4dichuyen=false,totden5dichuyen=false;

	boolean dodi=true,dendi=false;
	Rectangle mado1,xedo1,mado2,xedo2,sydo1,sydo2,tinhdo1,tinhdo2;
	Rectangle phaodo1,phaodo2,tuongdo1,totdo1,totdo2,totdo3,totdo4,totdo5;
	Rectangle maden1,xeden1,maden2,xeden2,syden1,syden2,tinhden1,tinhden2;
	Rectangle phaoden1,phaoden2,tuongden1,totden1,totden2,totden3,totden4,totden5;
	public static final int WIDTH =800;  
	public static final int HEIGHT = 720;
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

	public GamePanel() {
		setBackground(Color.BLACK);    
		setPreferredSize( new Dimension(WIDTH, HEIGHT));
		setVisible(true);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		LoadImage();
	}
	public void LoadImage(){
		banco=new ImageIcon("src/img/banco.png").getImage();
		totdo=new ImageIcon("src/img/totdo.png").getImage();
		totden=new ImageIcon("src/img/totden.png").getImage();
		tuongdo=new ImageIcon("src/img/tuongdo.png").getImage();
		tuongden=new ImageIcon("src/img/tuongden.png").getImage();
		sydo=new ImageIcon("src/img/sydo.png").getImage();
		syden=new ImageIcon("src/img/syden.png").getImage();
		xedo=new ImageIcon("src/img/xedo.png").getImage();
		xeden=new ImageIcon("src/img/xeden.png").getImage();
		phaodo=new ImageIcon("src/img/phaodo.png").getImage();
		phaoden=new ImageIcon("src/img/phaoden.png").getImage();
		tinhdo=new ImageIcon("src/img/tinhdo.png").getImage();
		tinhden=new ImageIcon("src/img/tinhden.png").getImage();
		mado=new ImageIcon("src/img/mado.png").getImage();
		maden=new ImageIcon("src/img/maden.png").getImage();
		
		xedo_click=new ImageIcon("src/img/xedo_click.png").getImage();
		mado_click=new ImageIcon("src/img/mado_click.png").getImage();
		xeden_click=new ImageIcon("src/img/xeden_click.png").getImage();
		maden_click=new ImageIcon("src/img/maden_click.png").getImage();
		tuongden_click=new ImageIcon("src/img/tuongden_click.png").getImage();
		tuongdo_click=new ImageIcon("src/img/tuongdo_click.png").getImage();
		phaoden_click=new ImageIcon("src/img/phaoden_click.png").getImage();
		phaodo_click=new ImageIcon("src/img/phaodo_click.png").getImage();
		syden_click=new ImageIcon("src/img/syden_click.png").getImage();
		sydo_click=new ImageIcon("src/img/sydo_click.png").getImage();
		totden_click=new ImageIcon("src/img/totden_click.png").getImage();
		totdo_click=new ImageIcon("src/img/totdo_click.png").getImage();
		tinhden_click=new ImageIcon("src/img/tinhden_click.png").getImage();
		tinhdo_click=new ImageIcon("src/img/tinhdo_click.png").getImage();
		
	}
	public void paint(Graphics g){
		g.drawImage(banco,0,0,600,HEIGHT-30,null);
		for (int i=0;i<10;i++)
			for (int j=0;j<9;j++){ 
				if (Math.abs(vitri[i][j])==6){
					if (vitri[i][j]>0){
						    if (!qXedo1){
						    	x1=new xe(toadoxedo1X,toadoxedo1Y,xedo);
						    	x1.drawXe(g);
						    }
						    else{
						    	x1=new xe(toadoxedo1X,toadoxedo1Y,xedo_click);
						    	x1.drawXe(g);
						    }
						    if (!qXedo2){
						    	x1=new xe(toadoxedo2X,toadoxedo2Y,xedo);
						    	x1.drawXe(g);
						    }
						    else{
						    	x1=new xe(toadoxedo2X,toadoxedo2Y,xedo_click);
						    	x1.drawXe(g);
						    }
					}
					else
					{
						
						if (!qXeden1){
					    	x1=new xe(toadoxeden1X,toadoxeden1Y,xeden);
					    	x1.drawXe(g);
					    }
					    else{
					    	x1=new xe(toadoxeden1X,toadoxeden1Y,xeden_click);
					    	x1.drawXe(g);
					    }
					    if (!qXeden2){
					    	x1=new xe(toadoxeden2X,toadoxeden2Y,xeden);
					    	x1.drawXe(g);
					    }
					    else{
					    	x1=new xe(toadoxeden2X,toadoxeden2Y,xeden_click);
					    	x1.drawXe(g);
					    }
					}
				}
				if (Math.abs(vitri[i][j])==4){
					if (vitri[i][j]>0){
						    if(!qMado1){
						    	m=new ma(toadomado1X,toadomado1Y,mado);
						    	m.drawMa(g);
						    	
						    }
						    else{
						    	m=new ma(toadomado1X,toadomado1Y,mado_click);
								m.drawMa(g);
						    }
						    if(!qMado2){
						    	m=new ma(toadomado2X,toadomado2Y,mado);
						    	m.drawMa(g);
						    	
						    }
						    else{
						    	m=new ma(toadomado2X,toadomado2Y,mado_click);
								m.drawMa(g);
						    }
					}
					else
					{
						if(!qMaden1){
					    	m=new ma(toadomaden1X,toadomaden1Y,maden);
					    	m.drawMa(g);
					    	
					    }
					    else{
					    	m=new ma(toadomaden1X,toadomaden1Y,maden_click);
							m.drawMa(g);
					    }
					    if(!qMaden2){
					    	m=new ma(toadomaden2X,toadomaden2Y,maden);
					    	m.drawMa(g);
					    	
					    }
					    else{
					    	m=new ma(toadomaden2X,toadomaden2Y,maden_click);
							m.drawMa(g);
					    }
					}
				}
				if (Math.abs(vitri[i][j])==3){
					if (vitri[i][j]>0){
						 if(!qTinhdo1){
						    	ti=new tinh(toadotinhdo1X,toadotinhdo1Y,tinhdo);
						    	ti.drawTinh(g);
						    	
						    }
						    else{
						    	ti=new tinh(toadotinhdo1X,toadotinhdo1Y,tinhdo_click);
						    	ti.drawTinh(g);
						    }
						    if(!qTinhdo2){
						    	ti=new tinh(toadotinhdo2X,toadotinhdo2Y,tinhdo);
						    	ti.drawTinh(g);
						    	
						    }
						    else{
						    	ti=new tinh(toadotinhdo2X,toadotinhdo2Y,tinhdo_click);
						    	ti.drawTinh(g);
						    }
					}
					else
					{
						if(!qTinhden1){
					    	ti=new tinh(toadotinhden1X,toadotinhden1Y,tinhden);
					    	ti.drawTinh(g);
					    	
					    }
					    else{
					    	ti=new tinh(toadotinhden1X,toadotinhden1Y,tinhden_click);
					    	ti.drawTinh(g);
					    }
					    if(!qTinhden2){
					    	ti=new tinh(toadotinhden2X,toadotinhden2Y,tinhden);
					    	ti.drawTinh(g);
					    	
					    }
					    else{
					    	ti=new tinh(toadotinhden2X,toadotinhden2Y,tinhden_click);
					    	ti.drawTinh(g);
					    }
					}
				}
				if (Math.abs(vitri[i][j])==2){
					if (vitri[i][j]>0){
						if(!qSydo1){
					    	s=new sy(toadosydo1X,toadosydo1Y,sydo);
					    	s.drawSy(g);
					    	
					    }
					    else{
					    	s=new sy(toadosydo1X,toadosydo1Y,sydo_click);
					    	s.drawSy(g);
					    }
					    if(!qSydo2){
					    	s=new sy(toadosydo2X,toadosydo2Y,sydo);
					    	s.drawSy(g);
					    	
					    }
					    else{
					    	s=new sy(toadosydo2X,toadosydo2Y,sydo_click);
					    	s.drawSy(g);
					    }
					}
					else
					{
						if(!qSyden1){
					    	s=new sy(toadosyden1X,toadosyden1Y,syden);
					    	s.drawSy(g);
					    	
					    }
					    else{
					    	s=new sy(toadosyden1X,toadosyden1Y,syden_click);
					    	s.drawSy(g);
					    }
					    if(!qSyden2){
					    	s=new sy(toadosyden2X,toadosyden2Y,syden);
					    	s.drawSy(g);
					    	
					    }
					    else{
					    	s=new sy(toadosyden2X,toadosyden2Y,syden_click);
					    	s.drawSy(g);
					    }
					}
				}
				if (Math.abs(vitri[i][j])==7){
					if (vitri[i][j]>0){
						if(!qTuongdo){
					    	tu=new tuong(toadotuongdoX,toadotuongdoY,tuongdo);
					    	tu.drawTuong(g);
					    	
					    }
					    else{
					    	tu=new tuong(toadotuongdoX,toadotuongdoY,tuongdo_click);
					    	tu.drawTuong(g);
					    }
					}
					else
					{
						if(!qTuongden){
					    	tu=new tuong(toadotuongdenX,toadotuongdenY,tuongden);
					    	tu.drawTuong(g);
					    	
					    }
					    else{
					    	tu=new tuong(toadotuongdenX,toadotuongdenY,tuongden_click);
					    	tu.drawTuong(g);
					    }
					}
				}
				if (Math.abs(vitri[i][j])==5){
					if (vitri[i][j]>0){
						if(!qPhaodo1){
					    	p=new phao(toadophaodo1X,toadophaodo1Y,phaodo);
					    	p.drawPhao(g);
					    	
					    }
					    else{
					    	p=new phao(toadophaodo1X,toadophaodo1Y,phaodo_click);
					    	p.drawPhao(g);
					    }
					    if(!qPhaodo2){
					    	p=new phao(toadophaodo2X,toadophaodo2Y,phaodo);
					    	p.drawPhao(g);
					    	
					    }
					    else{
					    	p=new phao(toadophaodo2X,toadophaodo2Y,phaodo_click);
					    	p.drawPhao(g);
					    }
					}
					else
					{
						if(!qPhaoden1){
					    	p=new phao(toadophaoden1X,toadophaoden1Y,phaoden);
					    	p.drawPhao(g);
					    	
					    }
					    else{
					    	p=new phao(toadophaoden1X,toadophaoden1Y,phaoden_click);
					    	p.drawPhao(g);
					    }
					    if(!qPhaoden2){
					    	p=new phao(toadophaoden2X,toadophaoden2Y,phaoden);
					    	p.drawPhao(g);
					    	
					    }
					    else{
					    	p=new phao(toadophaoden2X,toadophaoden2Y,phaoden_click);
					    	p.drawPhao(g);
					    }
					}
				}
				if (Math.abs(vitri[i][j])==1){
					if (vitri[i][j]>0){
						if(!qTotdo1){
					    	to=new tot(toadototdo1X,toadototdo1Y,totdo);
					    	to.drawTot(g);
					    	
					    }
					    else{
					    	to=new tot(toadototdo1X,toadototdo1Y,totdo_click);
					    	to.drawTot(g);
					    }
						//--------------------------------------------
						if(!qTotdo2){
					    	to=new tot(toadototdo2X,toadototdo2Y,totdo);
					    	to.drawTot(g);
					    	
					    }
					    else{
					    	to=new tot(toadototdo2X,toadototdo2Y,totdo_click);
					    	to.drawTot(g);
					    }
						//----------------------------------------
						if(!qTotdo3){
					    	to=new tot(toadototdo3X,toadototdo3Y,totdo);
					    	to.drawTot(g);
					    	
					    }
					    else{
					    	to=new tot(toadototdo3X,toadototdo3Y,totdo_click);
					    	to.drawTot(g);
					    }
						//----------------------------------------
						if(!qTotdo4){
					    	to=new tot(toadototdo4X,toadototdo4Y,totdo);
					    	to.drawTot(g);
					    	
					    }
					    else{
					    	to=new tot(toadototdo4X,toadototdo4Y,totdo_click);
					    	to.drawTot(g);
					    }
						//---------------------------------------------
						if(!qTotdo5){
					    	to=new tot(toadototdo5X,toadototdo5Y,totdo);
					    	to.drawTot(g);
					    	
					    }
					    else{
					    	to=new tot(toadototdo5X,toadototdo5Y,totdo_click);
					    	to.drawTot(g);
					    }
					}
					else
					{
						if(!qTotden1){
					    	to=new tot(toadototden1X,toadototden1Y,totden);
					    	to.drawTot(g);
					    	
					    }
					    else{
					    	to=new tot(toadototden1X,toadototden1Y,totden_click);
					    	to.drawTot(g);
					    }
						//--------------------------------------------
						if(!qTotden2){
					    	to=new tot(toadototden2X,toadototden2Y,totden);
					    	to.drawTot(g);
					    	
					    }
					    else{
					    	to=new tot(toadototden2X,toadototden2Y,totden_click);
					    	to.drawTot(g);
					    }
						//----------------------------------------
						if(!qTotden3){
					    	to=new tot(toadototden3X,toadototden3Y,totden);
					    	to.drawTot(g);
					    	
					    }
					    else{
					    	to=new tot(toadototden3X,toadototden3Y,totden_click);
					    	to.drawTot(g);
					    }
						//----------------------------------------
						if(!qTotden4){
					    	to=new tot(toadototden4X,toadototden4Y,totden);
					    	to.drawTot(g);
					    	
					    }
					    else{
					    	to=new tot(toadototden4X,toadototden4Y,totden_click);
					    	to.drawTot(g);
					    }
						//---------------------------------------------
						if(!qTotden5){
					    	to=new tot(toadototden5X,toadototden5Y,totden);
					    	to.drawTot(g);
					    	
					    }
					    else{
					    	to=new tot(toadototden5X,toadototden5Y,totden_click);
					    	to.drawTot(g);
					    }
				}
				
			}	
		}
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//nogn
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x,y;
		x=e.getX();
		y=e.getY();
		x=(x-20)/67;
		y=(y-20)/68;
		mado1=new Rectangle(toadomado1X,toadomado1Y,42,42);
		mado2=new Rectangle(toadomado2X,toadomado2Y,42,42);
		xedo1=new Rectangle(toadoxedo1X,toadoxedo1Y,42,42);
		xedo2=new Rectangle(toadoxedo2X,toadoxedo2Y,42,42);
		tinhdo1=new Rectangle(toadotinhdo1X,toadotinhdo1Y,42,42);
		sydo1=new Rectangle(toadosydo1X,toadosydo1Y,42,42);
		phaodo1=new Rectangle(toadophaodo1X,toadophaodo1Y,42,42);
		tuongdo1=new Rectangle(toadotuongdoX,toadotuongdoY,42,42);
		tinhdo2=new Rectangle(toadotinhdo2X,toadotinhdo2Y,42,42);
		sydo2=new Rectangle(toadosydo2X,toadosydo2Y,42,42);
		phaodo2=new Rectangle(toadophaodo2X,toadophaodo2Y,42,42);
		totdo1=new Rectangle(toadototdo1X,toadototdo1Y,42,42);
		totdo2=new Rectangle(toadototdo2X,toadototdo2Y,42,42);
		totdo3=new Rectangle(toadototdo3X,toadototdo3Y,42,42);
		totdo4=new Rectangle(toadototdo4X,toadototdo4Y,42,42);
		totdo5=new Rectangle(toadototdo5X,toadototdo5Y,42,42);
		
		maden1=new Rectangle(toadomaden1X,toadomaden1Y,42,42);
		xeden1=new Rectangle(toadoxeden1X,toadoxeden1Y,42,42);
		tinhden1=new Rectangle(toadotinhden1X,toadotinhden1Y,42,42);
		syden1=new Rectangle(toadosyden1X,toadosyden1Y,42,42);
		phaoden1=new Rectangle(toadophaoden1X,toadophaoden1Y,42,42);
		maden2=new Rectangle(toadomaden2X,toadomaden2Y,42,42);
		xeden2=new Rectangle(toadoxeden2X,toadoxeden2Y,42,42);
		tinhden2=new Rectangle(toadotinhden2X,toadotinhden2Y,42,42);
		syden2=new Rectangle(toadosyden2X,toadosyden2Y,42,42);
		phaoden2=new Rectangle(toadophaoden2X,toadophaoden2Y,42,42);
		tuongden1=new Rectangle(toadotuongdenX,toadotuongdenY,42,42);
		totden1=new Rectangle(toadototden1X,toadototden1Y,42,42);
		totden2=new Rectangle(toadototden2X,toadototden2Y,42,42);
		totden3=new Rectangle(toadototden3X,toadototden3Y,42,42);
		totden4=new Rectangle(toadototden4X,toadototden4Y,42,42);
		totden5=new Rectangle(toadototden5X,toadototden5Y,42,42);
		
		
		Point p = e.getPoint();
		Rectangle sphere = new Rectangle(p.x - 1, p.y - 1, 2, 2);
		if (dodi){
		if (sphere.intersects(xedo1)) {
			qXedo1 = !qXedo1;
			xedo1dichuyen=!xedo1dichuyen;
			x1=new xe(x,y,vitri);
			x1.HienOcothedi();
		}
		else {
			qXedo1= false;
		}
		if (sphere.intersects(xedo2)){
			qXedo2 = !qXedo2;
			xedo2dichuyen=!xedo2dichuyen;
			x1=new xe(x,y,vitri);
			x1.HienOcothedi();
		}
		else {
			qXedo2= false;
		}
		
		//---------------------------------------
		if (sphere.intersects(mado1)) {
			qMado1=!qMado1;
			mado1dichuyen=!mado1dichuyen;
		}
		else {
			qMado1 = false;
		}
		if (sphere.intersects(mado2)) {
			qMado2=!qMado2;
			mado2dichuyen=!mado2dichuyen;
		}
		else {
			qMado2 = false;
		}
		//----------------------------------------
		if (sphere.intersects(sydo1)) {
			qSydo1=!qSydo1;
			sydo1dichuyen=!sydo1dichuyen;
		}
		else {
			qSydo1 = false;
		}
		if (sphere.intersects(sydo2)) {
			qSydo2=!qSydo2;
			sydo2dichuyen=!sydo2dichuyen;
		}
		else {
			qSydo2 = false;
		}
		//-----------------------------------
		if (sphere.intersects(tinhdo1)) {
			qTinhdo1=!qTinhdo1;
			tinhdo1dichuyen=!tinhdo1dichuyen;
		}
		else {
			qTinhdo1 = false;
		}
		if (sphere.intersects(tinhdo2)) {
			qTinhdo2=!qTinhdo2;
			tinhdo2dichuyen=!tinhdo2dichuyen;
		}
		else {
			qTinhdo2 = false;
		}
		//-----------------------------------
		if (sphere.intersects(phaodo1)) {
			qPhaodo1=!qPhaodo1;
			phaodo1dichuyen=!phaodo1dichuyen;
		}
		else {
			qPhaodo1 = false;
		}
		if (sphere.intersects(phaodo2)) {
			qPhaodo2=!qPhaodo2;
			phaodo2dichuyen=!phaodo2dichuyen;
		}
		else {
			qPhaodo2 = false;
		}
		//-----------------------
		if (sphere.intersects(tuongdo1)) {
			qTuongdo=!qTuongdo;
			tuongdodichuyen=!tuongdodichuyen;
		}
		else {
			qTuongdo = false;
		}
		//-----------------------
		if (sphere.intersects(totdo1)) {
			qTotdo1=!qTotdo1;
			totdo1dichuyen=!totdo1dichuyen;
		}
		else {
			qTotdo1 = false;
		}
		if (sphere.intersects(totdo2)) {
			qTotdo2=!qTotdo2;
			totdo2dichuyen=!totdo2dichuyen;
		}
		else {
			qTotdo2 = false;
		}
		if (sphere.intersects(totdo3)) {
			qTotdo3=!qTotdo3;
			totdo3dichuyen=!totdo3dichuyen;
		}
		else {
			qTotdo3 = false;
		}
		if (sphere.intersects(totdo4)) {
			qTotdo4=!qTotdo4;
			totdo4dichuyen=!totdo4dichuyen;
		}
		else {
			qTotdo4 = false;
		}
		if (sphere.intersects(totdo5)) {
			qTotdo5=!qTotdo5;
			totdo5dichuyen=!totdo5dichuyen;
		}
		else {
			qTotdo5 = false;
		}
		//-----------------------
				if (!sphere.intersects(xedo1) && !qXedo1 &&xedo1dichuyen)  {
					if (x1.kiemtra(x,y,toadoxedo1X,toadoxedo1Y,vitri)){ 
						vitri[(toadoxedo1Y-20)/68][(toadoxedo1X-20)/67]=0;
						vitri[y][x]=6;
						toadoxedo1X=x*67+20;
						toadoxedo1Y=y*68+20;
						dendi=true;
						dodi=false;
						xedo1dichuyen=false;
					}
				}
				if (!sphere.intersects(xedo2) && !qXedo2 &&xedo2dichuyen) {
					if (x1.kiemtra(x,y,toadoxedo2X,toadoxedo2Y,vitri)){ 
						vitri[(toadoxedo2Y-20)/68][(toadoxedo2X-20)/67]=0;
						vitri[y][x]=6;
						toadoxedo2X=x*67+20;
						toadoxedo2Y=y*68+20;
						dendi=true;
						dodi=false;
						xedo2dichuyen=false;
					}
				}
				if (!sphere.intersects(mado1) && !qMado1 &&mado1dichuyen) {
					toadomado1X=x*67+20;
					toadomado1Y=y*68+20;
					dendi=true;
					dodi=false;
					mado1dichuyen=false;
				}
				if (!sphere.intersects(mado2) && !qMado2 &&mado2dichuyen) {
					toadomado2X=x*67+20;
					toadomado2Y=y*68+20;
					dendi=true;
					dodi=false;
					mado2dichuyen=false;
				}
				if (!sphere.intersects(sydo1) && !qSydo1 &&sydo1dichuyen) {
					toadosydo1X=x*67+20;
					toadosydo1Y=y*68+20;
				}
				if (!sphere.intersects(sydo2) && !qSydo2 &&sydo2dichuyen) {
					toadosydo2X=x*67+20;
					toadosydo2Y=y*68+20;
					dendi=true;
					dodi=false;
					sydo2dichuyen=false;
				}
				if (!sphere.intersects(tinhdo1) && !qTinhdo1 &&tinhdo1dichuyen) {
					toadotinhdo1X=x*67+20;
					toadotinhdo1Y=x*68+20;
					dendi=true;
					dodi=false;
					tinhdo1dichuyen=false;
				}
				if (!sphere.intersects(tinhdo2) && !qTinhdo2 &&tinhdo2dichuyen) {
					toadotinhdo2X=x*67+20;
					toadotinhdo2Y=y*68+20;
					dendi=true;
					dodi=false;
					tinhdo2dichuyen=false;
				}
				if (!sphere.intersects(phaodo1) && !qPhaodo1 &&phaodo1dichuyen) {
					toadophaodo1X=x*67+20;
					toadophaodo1Y=y*68+20;
					dendi=true;
					dodi=false;
					phaodo1dichuyen=false;
				}
				if (!sphere.intersects(phaodo2) && !qPhaodo2 &&phaodo2dichuyen) {
					toadophaodo2X=x*67+20;
					toadophaodo2Y=y*68+20;
					dendi=true;
					dodi=false;
					phaodo2dichuyen=false;
				}
				if (!sphere.intersects(tuongdo1) && !qTuongdo &&tuongdodichuyen) {
					toadotuongdoX=x*67+20;
					toadotuongdoY=y*68+20;
					dendi=true;
					dodi=false;
					tuongdodichuyen=false;
				}
				if (!sphere.intersects(totdo1) && !qTotdo1 &&totdo1dichuyen) {
					toadototdo1X=x*67+20;
					toadototdo1Y=y*68+20;
					dendi=true;
					dodi=false;
					totdo1dichuyen=false;
				}
				if (!sphere.intersects(totdo2) && !qTotdo2 &&totdo2dichuyen) {
					toadototdo2X=x*67+20;
					toadototdo2Y=y*68+20;
					dendi=true;
					dodi=false;
					totdo2dichuyen=false;
				}
				if (!sphere.intersects(totdo3) && !qTotdo3 &&totdo3dichuyen) {
					toadototdo3X=x*67+20;
					toadototdo3Y=y*68+20;
					dendi=true;
					dodi=false;
					totdo3dichuyen=false;
				}
				if (!sphere.intersects(totdo4) && !qTotdo4 &&totdo4dichuyen) {
					toadototdo4X=x*67+20;
					toadototdo4Y=y*68+20;
					dendi=true;
					dodi=false;
					totdo4dichuyen=false;
				}
				if (!sphere.intersects(totdo5) && !qTotdo5 &&totdo5dichuyen) {
					toadototdo5X=x*67+20;
					toadototdo5Y=y*68+20;
					dendi=true;
					dodi=false;
					totdo5dichuyen=false;
				}
		}
		if (dendi){
		//-----------------------
		if (sphere.intersects(xeden1)) {
			qXeden1 = !qXeden1;
			xeden1dichuyen=!xeden1dichuyen;
			x1=new xe(x,y,vitri);
			x1.HienOcothedi();
		}
		else {
			qXeden1= false;
		}
		if (sphere.intersects(xeden2)) {
			qXeden2 = !qXeden2;
			xeden2dichuyen=!xeden2dichuyen;
			x1=new xe(x,y,vitri);
			x1.HienOcothedi();
		}
		else {
			qXeden2= false;
		}
		//---------------------------------------
		if (sphere.intersects(maden1)) {
			qMaden1=!qMaden1;
			maden1dichuyen=!maden1dichuyen;
		}
		else {
			qMaden1 = false;
		}
		if (sphere.intersects(maden2)) {
			qMaden2=!qMaden2;
			maden2dichuyen=!maden2dichuyen;
		}
		else {
			qMaden2 = false;
		}
		//----------------------------------------
		if (sphere.intersects(syden1)) {
			qSyden1=!qSyden1;
			syden1dichuyen=!syden1dichuyen;
		}
		else {
			qSyden1 = false;
		}
		if (sphere.intersects(syden2)) {
			qSyden2=!qSyden2;
			syden2dichuyen=!syden2dichuyen;
		}
		else {
			qSyden2 = false;
		}
		//-----------------------------------
		if (sphere.intersects(tinhden1)) {
			qTinhden1=!qTinhden1;
			tinhden1dichuyen=!tinhden1dichuyen;
		}
		else {
			qTinhden1 = false;
		}
		if (sphere.intersects(tinhden2)) {
			qTinhden2=!qTinhden2;
			tinhden2dichuyen=!tinhden2dichuyen;
		}
		else {
			qTinhden2 = false;
		}
		//-----------------------------------
		if (sphere.intersects(phaoden1)) {
			qPhaoden1=!qPhaoden1;
			phaoden1dichuyen=!phaoden1dichuyen;
		}
		else {
			qPhaoden1 = false;
		}
		if (sphere.intersects(phaoden2)) {
			qPhaoden2=!qPhaoden2;
			phaoden2dichuyen=!phaoden2dichuyen;
		}
		else {
			qPhaoden2 = false;
		}
		//-----------------------
		if (sphere.intersects(tuongden1)) {
			qTuongden=!qTuongden;
			tuongdendichuyen=!tuongdendichuyen;
		}
		else {
			qTuongden = false;
		}
		//-----------------------
		if (sphere.intersects(totden1)) {
			qTotden1=!qTotden1;
			totden1dichuyen=!totden1dichuyen;
		}
		else {
			qTotden1 = false;
		}
		if (sphere.intersects(totden2)) {
			qTotden2=!qTotden2;
			totden2dichuyen=!totden2dichuyen;
		}
		else {
			qTotden2 = false;
		}
		if (sphere.intersects(totden3)) {
			qTotden3=!qTotden3;
			totden3dichuyen=!totden3dichuyen;
		}
		else {
			qTotden3 = false;
		}
		if (sphere.intersects(totden4)) {
			qTotden4=!qTotden4;
			totden4dichuyen=!totden4dichuyen;
		}
		else {
			qTotden4 = false;
		}
		if (sphere.intersects(totden5)) {
			qTotden5=!qTotden5;
			totden5dichuyen=!totden5dichuyen;
		}
		else {
			qTotden5 = false;
		}
		
		//-----------------------
		if (!sphere.intersects(xeden1) && !qXeden1 &&xeden1dichuyen) {
			if (x1.kiemtra(x,y,toadoxeden1X,toadoxeden1Y,vitri)){ 
				vitri[(toadoxeden1Y-20)/68][(toadoxeden1X-20)/67]=0;
				vitri[y][x]=6;
				toadoxeden1X=x*67+20;
				toadoxeden1Y=y*68+20;
				dendi=false;
				dodi=true;
				xeden1dichuyen=false;
			}
		}
		if (!sphere.intersects(xeden2) && !qXeden2 &&xeden2dichuyen) {
			if (x1.kiemtra(x,y,toadoxeden2X,toadoxeden2Y,vitri)){
				vitri[(toadoxeden2Y-20)/68][(toadoxedo2X-20)/67]=0;
				vitri[y][x]=6;
				toadoxeden2X=x*67+20;
				toadoxeden2Y=y*68+20;
				dendi=false;
				dodi=true;
				xeden2dichuyen=false;
			}
		}
		if (!sphere.intersects(maden1) && !qMaden1 &&maden1dichuyen) {
			toadomaden1X=x*67+20;
			toadomaden1Y=y*68+20;
			dendi=false;
			dodi=true;
			maden1dichuyen=false;
		}
		if (!sphere.intersects(maden2) && !qMaden2 &&maden2dichuyen) {
			toadomaden2X=x*67+20;
			toadomaden2Y=y*68+20;
			dendi=false;
			dodi=true;
			maden2dichuyen=false;
		}
		if (!sphere.intersects(syden1) && !qSyden1 &&syden1dichuyen) {
			toadosyden1X=x*67+20;
			toadosyden1Y=y*68+20;
			dendi=false;
			dodi=true;
			syden1dichuyen=false;
		}
		if (!sphere.intersects(syden2) && !qSyden2 &&syden2dichuyen) {
			toadosyden2X=x*67+20;
			toadosyden2Y=y*68+20;
			dendi=false;
			dodi=true;
			syden2dichuyen=false;
		}
		if (!sphere.intersects(tinhden1) && !qTinhden1 &&tinhden1dichuyen) {
			toadotinhden1X=x*67+20;
			toadotinhden1Y=y*68+20;
			dendi=false;
			dodi=true;
			tinhden1dichuyen=false;
		}
		if (!sphere.intersects(tinhden2) && !qTinhden2 &&tinhden2dichuyen) {
			toadotinhden2X=x*67+20;
			toadotinhden2Y=y*68+20;
			dendi=false;
			dodi=true;
			tinhden2dichuyen=false;
		}
		if (!sphere.intersects(phaoden1) && !qPhaoden1 &&phaoden1dichuyen) {
			toadophaoden1X=x*67+20;
			toadophaoden1Y=y*68+20;
			dendi=false;
			dodi=true;
			phaoden1dichuyen=false;
		}
		if (!sphere.intersects(phaoden2) && !qPhaoden2 &&phaoden2dichuyen) {
			toadophaoden2X=x*67+20;
			toadophaoden2Y=y*68+20;
			dendi=false;
			dodi=true;
			phaoden2dichuyen=false;
		}
		if (!sphere.intersects(tuongden1) && !qTuongden &&tuongdendichuyen) {
			toadotuongdenX=x*67+20;
			toadotuongdenY=y*68+20;
			dendi=false;
			dodi=true;
			tuongdendichuyen=false;
		}
		if (!sphere.intersects(totden1) && !qTotden1 &&totden1dichuyen) {
			toadototden1X=x*67+20;
			toadototden1Y=y*68+20;
			dendi=false;
			dodi=true;
			totden1dichuyen=false;
		}
		if (!sphere.intersects(totden2) && !qTotden2 &&totden2dichuyen) {
			toadototden2X=x*67+20;
			toadototden2Y=y*68+20;
			dendi=false;
			dodi=true;
			totden2dichuyen=false;
		}
		if (!sphere.intersects(totden3) && !qTotden3 &&totden3dichuyen) {
			toadototden3X=x*67+20;
			toadototden3Y=y*68+20;
			dendi=false;
			dodi=true;
			totden3dichuyen=false;
		}
		if (!sphere.intersects(totden4) && !qTotden4 &&totden4dichuyen) {
			toadototden4X=x*67+20;
			toadototden4Y=y*68+20;
			dendi=false;
			dodi=true;
			totden4dichuyen=false;
		}
		if (!sphere.intersects(totden5) && !qTotden5 &&totden5dichuyen) {
			toadototden5X=x*67+20;
			toadototden5Y=y*68+20;
			dendi=false;
			dodi=true;
			totden5dichuyen=false;
		}
		}
		
	} 
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
