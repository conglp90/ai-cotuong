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
import javax.swing.JOptionPane;

import view.ChessBoardPanel;

import control.Position;

import model.chess.Advisor;
import model.chess.Bishop;
import model.chess.Cannon;
import model.chess.Chess;
import model.chess.King;
import model.chess.Knight;
import model.chess.Pawn;
import model.chess.Rook;

public class Match {
	public final Chess[][] pieceChess;
	public static Position Chess[][] = new Position[2][17];
	public static int  count[] = new int[2];
	public static int  status[][]=new int[10][10];
	public static MoveInfo newMove;
	
	public final Image imgBoard = new ImageIcon(Constant.BOARD_DIR+"/banco.png").getImage();
	public final Image imgSelect = new ImageIcon(Constant.CHESS_DIR+"/select.png").getImage();
	public final Image imgWelcome = new ImageIcon(Constant.IMG_DIR + "/welcome2.jpg").getImage();
	public final Image imgPause = new ImageIcon(Constant.IMG_DIR + "/waiting.jpg").getImage();
	public final Image imgDiduoc = new ImageIcon(Constant.CHESS_DIR+"/diduoc.png").getImage();
	public final Image imgAnduoc = new ImageIcon(Constant.CHESS_DIR+"/anduoc.png").getImage();
	private int level = 0;
	public static boolean isFinish = false;
	private static boolean isActive = false;
	private boolean isPause = false;
	private int x1=-1,x2=-1,y1=-1,y2=-1;
	private boolean isPlayWithCom = true;
	private boolean isComPlayFirst = false;
	ChessBoardPanel ches;
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
	public void setX1(int x1){
		this.x1=x1;
	}
	public int getX1(){
		return x1;
	}
	public void setY1(int y1){
		this.y1=y1;
	}
	public int getY1(){
		return y1;
	}
	public void setX2(int x2){
		this.x2=x2;
	}
	public int getX2(){
		return x2;
	}
	public void setY2(int y2){
		this.y2=y2;
	}
	public int getY2(){
		return y2;
	}
	public void LoadMap(){
        int x=0,y=0;
        setX1(-1);
        setY1(-1);
        setY2(-1);
        setX2(-1);
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
	public static void initChess(){
		count[0]=0;count[1]=0;
		for (int i=0 ; i<=9 ; i++)
			for (int j=0 ; j<=8 ; j++){
				int piece = tablePos[i][j];
				if (piece > 0 ) {
					//quan phia 0--4
					count[0]++;
					status[i][j]= count[0];
					boolean passriver = false;
					if ((piece == 1) && (i>=5)) passriver = true; 
					Chess[0][count[0]] = new Position(j,i,piece,passriver,true);
				}
				if (piece < 0) {
					count[1]++;
					status[i][j] = count[1];
					boolean passriver = false;
					if ((piece==-1) &&( i<=4)) passriver = true;
					Chess[1][count[1]] = new Position(j,i,-piece,passriver,true);
				}
			}
	}
	public static void   tryMove(MoveInfo nmove){
		int x = nmove.getx(), y = nmove.gety(),
		xx = nmove.getxx(), yy= nmove.getyy(),
		id = nmove.getId(),
		piece = nmove.getpiece(),
		cur = tablePos[y][x];
		//Mark died chess
		if (piece > 0) Chess[0][id].setIsAlive(false);
		if (piece < 0) Chess[1][id].setIsAlive(false);
		//Mark pawn has passed river
		if (cur == 1 && yy >=5 ) Chess[0][status[y][x]].setIsPassed(true);
		if (cur == -1 && yy <=4 ) Chess[1][status[y][x]].setIsPassed(true);
		//update status[][]
		status[yy][xx] = status[y][x];
		status[y][x] = 0;
		//update tablePos[][]
		tablePos[yy][xx] = tablePos[y][x];
		tablePos[y][x] = 0;
	}
	public static void   undoMove(MoveInfo nmove){
		int x= nmove.getx(), y = nmove.gety(),
			xx = nmove.getxx(), yy= nmove.getyy(),
			piece = nmove.getpiece(),
			id = nmove.getId(),
			cur = tablePos[y][x];
		if (Math.abs(piece)==7) isFinish = false;
		//update alive attribute
		if (piece > 0) Chess[0][id].setIsAlive(true);
		if (piece < 0) Chess[1][id].setIsAlive(true);
		//update passriver
		if (cur == 1 && y <=4 ) Chess[0][status[y][x]].setIsPassed(false);
		if (cur == -1 && y >=5 ) Chess[1][status[y][x]].setIsPassed(false);
		//update status[][]
		status[y][x] = status[yy][xx];
		status[yy][xx] = id;
		//update tablePos[][]
		tablePos[y][x] = tablePos[yy][xx];
		tablePos[yy][xx] = piece;
	}
}
