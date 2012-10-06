package model;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

import model.chess.Advisor;
import model.chess.Bishop;
import model.chess.Cannon;
import model.chess.Chess;
import model.chess.King;
import model.chess.Knight;
import model.chess.Pawn;
import model.chess.Rook;

public class Match {
	private Player redPlayer, blackPlayer;
	public final Chess[][] pieceChess;
	public final Chess[] redChess, blackChess;
	public final Image imgBoard = new ImageIcon(Constant.BOARD_DIR+"/banco.png").getImage();
	public final Image imgSelect = new ImageIcon(Constant.CHESS_DIR+"/select.png").getImage();
	public final Image imgWelcome = new ImageIcon(Constant.IMG_DIR + "/waiting.jpg").getImage();
	public final Image imgWaiting = new ImageIcon(Constant.IMG_DIR + "/waiting.jpg").getImage();
	public final Image imgPause = new ImageIcon(Constant.IMG_DIR + "/w1.jpg").getImage();
	public final Image imgDiduoc = new ImageIcon(Constant.CHESS_DIR+"/diduoc.png").getImage();
	public final Image imgAnduoc = new ImageIcon(Constant.CHESS_DIR+"/anduoc.png").getImage();
	private int level = 0;
	private boolean isFinish = false;
	private boolean isActive = false;
	private boolean isPause = false;

	private boolean isPlayWithCom = true;
	private boolean isComPlayFirst = false;
	/*public int tablePos[][]={{6, 4, 3, 2, 7, 2, 3, 4, 6},
  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
  			  				  {0, 5, 0, 0, 0, 0, 0, 5, 0},
  			  				  {1, 0, 1, 0, 1, 0, 1, 0, 1},
  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
  			  				  {-1, 0, -1, 0,-1, 0,-1, 0,-1},
  			  				  {0, -5, 0, 0, 0, 0, 0,-5, 0},
  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
  			  				  {-6, -4,-3,-2,-7,-2,-3,-4,-6}};*/

	public static int tablePos[][];
	private static File fi;

	
	public Match() {
		LoadMap();
		pieceChess = new Chess[2][8];
		pieceChess[0][1] = new Pawn(Constant.CHESS_DIR + "/totdo.png", 0, 0); // Tot do
		pieceChess[0][2] = new Advisor(Constant.CHESS_DIR + "/sydo.png", 0, 0); // Tot do
		pieceChess[0][3] = new Bishop(Constant.CHESS_DIR + "/tinhdo.png", 0, 0); // Tot do
		pieceChess[0][4] = new Knight(Constant.CHESS_DIR + "/mado.png", 0, 0); // Tot do
		pieceChess[0][5] = new Cannon(Constant.CHESS_DIR + "/phaodo.png", 0, 0); // Tot do
		pieceChess[0][6] = new Rook(Constant.CHESS_DIR + "/xedo.png", 0, 0); // Tot do
		pieceChess[0][7] = new King(Constant.CHESS_DIR + "/tuongdo.png", 0, 0); // Tot do
		
		pieceChess[1][1] = new Pawn(Constant.CHESS_DIR + "/totden.png", 0, 0); // Tot do
		pieceChess[1][2] = new Advisor(Constant.CHESS_DIR + "/syden.png", 0, 0); // Tot do
		pieceChess[1][3] = new Bishop(Constant.CHESS_DIR + "/tinhden.png", 0, 0); // Tot do
		pieceChess[1][4] = new Knight(Constant.CHESS_DIR + "/maden.png", 0, 0); // Tot do
		pieceChess[1][5] = new Cannon(Constant.CHESS_DIR + "/phaoden.png", 0, 0); // Tot do
		pieceChess[1][6] = new Rook(Constant.CHESS_DIR + "/xeden.png", 0, 0); // Tot do
		pieceChess[1][7] = new King(Constant.CHESS_DIR + "/tuongden.png", 0, 0); // Tot do
		redChess = new Chess[8];
		blackChess = new Chess[8];
		redChess[1] = new Pawn(Constant.CHESS_DIR + "/totdo.png", 0, 0); // Tot do
		redChess[2] = new Advisor(Constant.CHESS_DIR + "/sydo.png", 0, 0); // Sy do
		redChess[3] = new Bishop(Constant.CHESS_DIR + "/tinhdo.png", 0, 0); // Tinh do
		redChess[4] = new Knight(Constant.CHESS_DIR + "/mado.png", 0, 0); // Ma do
		redChess[5] = new Cannon(Constant.CHESS_DIR + "/phaodo.png", 0, 0); // Phao do
		redChess[6] = new Rook(Constant.CHESS_DIR + "/xedo.png", 0, 0); // Xe do
		redChess[7]= new King(Constant.CHESS_DIR + "/tuongdo.png", 0, 0); // Tuong do
		
		blackChess[1] = new Pawn(Constant.CHESS_DIR + "/totden.png", 0, 0); // Tot den
		blackChess[2] = new Advisor(Constant.CHESS_DIR + "/syden.png", 0, 0); // Sy den
		blackChess[3] = new Bishop(Constant.CHESS_DIR + "/tinhden.png", 0, 0); // Tinh den
		blackChess[4] = new Knight(Constant.CHESS_DIR + "/maden.png", 0, 0); // Ma den
		blackChess[5] = new Cannon(Constant.CHESS_DIR + "/phaoden.png", 0, 0); // Phao den
		blackChess[6] = new Rook(Constant.CHESS_DIR + "/xeden.png", 0, 0); // Xe den
		blackChess[7]= new King(Constant.CHESS_DIR + "/tuongden.png", 0, 0); // Tuong den
	}
	
	public boolean isPlayWithCom() {
		return this.isPlayWithCom;
	}
	
	public void setPLayWithCom(boolean status) {
		this.isPlayWithCom = status;
	}
	
	public boolean isComPlayFirst() {
		return this.isComPlayFirst;
	}
	
	public void setComPlayFirst(boolean status) {
		this.isComPlayFirst = status;
	}
	
	public void setActive(boolean status) {
		this.isActive = status;
	}
	
	public boolean isActive() {
		return this.isActive;
	}
	
	public void setPause(boolean status) {
		this.isPause = status;
	}
	
	public boolean isPause() {
		return this.isPause;
	}
	
	public boolean isFinish() {
		return this.isFinish;
	}
	
	public void setFinish(boolean status) {
		this.isFinish = status;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int num) {
		this.level = num;
	}
	
	public static void LoadMap(){
        int x=0,y=0,i=0,value;  
        tablePos=new int[10][9];
        fi = new File(Constant.MAP_DIR+"/map.txt");
        try {
            FileInputStream fi1 = new FileInputStream(fi);
            BufferedReader br = new BufferedReader( new InputStreamReader( fi1 ));
            String s=new String();
            try{
            	for(y=0;y<10;y++){
            		s=br.readLine().trim();
            		String[]B=s.split(" ");
            		for(x=0;x<9;x++){        
            			tablePos[y][x]=new Integer(B[x].trim());
            		}
            	}
            }
            catch(IOException e){
            	Logger.getLogger(Match.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        catch(IOException e){
        	Logger.getLogger(Match.class.getName()).log(Level.SEVERE,null,e);
        }
	}

}
