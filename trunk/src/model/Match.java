package model;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import view.ChessBoardPanel;

import control.Evaluate;
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
	public static  Chess[][] pieceChess;
	public static Position Chess[][] = new Position[2][17];
	public static int  count[] = new int[2];
	public static int  status[][]=new int[13][13];
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
		for (int i=0 ; i<= 10 ; i++)
			for (int j=0;j<=10 ;j++)
				status[i][j] = 0;
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
		toid = nmove.gettoId(),
		fromid = nmove.getfromId(),
		piece = nmove.getpiece(),
		cur = tablePos[y][x];
		//update chess[][]
		int type = 1;
		if (cur > 0) type = 0;
		Chess[type][fromid].setX(xx);
		Chess[type][fromid].setY(yy);
		//Mark died king
		if (Math.abs(piece) == 7) isFinish = true;
		//Mark died chess
		if (piece > 0) Chess[0][toid].setIsAlive(false);
		if (piece < 0) Chess[1][toid].setIsAlive(false);
		//Mark pawn has passed river
		if (cur == 1 && yy >=5 ) Chess[0][status[y][x]].setIsPassed(true);
		if (cur == -1 && yy <=4 ) Chess[1][status[y][x]].setIsPassed(true);
		//update status[][]
		status[yy][xx] = fromid;
		status[y][x] = 0;
		//update tablePos[][]
		tablePos[yy][xx] = tablePos[y][x];
		tablePos[y][x] = 0;
	}
	public static void   undoMove(MoveInfo nmove){
		int x= nmove.getx(), y = nmove.gety(),
			xx = nmove.getxx(), yy= nmove.getyy(),
			piece = nmove.getpiece(),
			fromid = nmove.getfromId(),
			toid = nmove.gettoId(),
			cur = tablePos[yy][xx];
		if (Math.abs(piece)==7) isFinish = false;
		//update chess
		//update alive attribute
		if (cur > 0){
			Chess[0][fromid].setX(x);
			Chess[0][fromid].setY(y);
		} else{
			Chess[1][fromid].setX(x);
			Chess[1][fromid].setY(y);
		}
			
		if (piece > 0){
			Chess[0][toid].setIsAlive(true);
			Chess[0][toid].setX(xx);
			Chess[0][toid].setY(yy);
			
		} else
		if (piece < 0) {
			Chess[1][toid].setIsAlive(true);
			Chess[1][toid].setX(xx);
			Chess[1][toid].setY(yy);
		}
		//update passriver
		if (cur == 1 && y <=4 ) Chess[0][fromid].setIsPassed(false);
		if (cur == -1 && y >=5 ) Chess[1][fromid].setIsPassed(false);
		//update status[][]
		status[y][x] = fromid;
		status[yy][xx] = toid;
		//update tablePos[][]
		tablePos[y][x] = tablePos[yy][xx];
		tablePos[yy][xx] = piece;
	}
	public   List <MoveInfo> GetOrderedMoves(int type){
		Evaluate master = new Evaluate();
		int piece,x,y;
		ChessPosition current;
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		List <ChessPosition> posCanMove = new ArrayList<ChessPosition>();
		
		for (int i=1 ; i <= Match.count[type]; i++){
			if (Match.Chess[type][i].getIsAlive()){
				piece = Match.Chess[type][i].getPiece();
				x = Chess[type][i].getX();
				y = Chess[type][i].getY();
				current = new ChessPosition(x, y, false);
				posCanMove = pieceChess[type][piece].getPosCanMove(current,type);
				for (ChessPosition pos : posCanMove) {
					int fromid = status[y][x];
					int yy = pos.getRow();
					int xx = pos.getCol();
					int toid = status[yy][xx];
					int pi = tablePos[yy][xx];
					MoveInfo nMove = new MoveInfo(x,y,xx,yy,pi,fromid,toid);
					tryMove(nMove);
					nMove.setCost(master.Eval());
					undoMove(nMove);
					/*
					 * Chen nMove vao vi tri trong mang arr, sap xep giam dan
					 */
					int first = 0; int last = arr.size()-1;int mid = 0; 
					while (first < last) {
						mid = (first + last) / 2;
						MoveInfo tmp;
						tmp = arr.get(mid);
						if (tmp.getCost() < nMove.getCost()) last = mid -1;
						if (tmp.getCost() >= nMove.getCost()) first = mid +1;
					}
					arr.add(mid,nMove);
					
				}
			
			}
		}
		
		return arr;
	}
}
