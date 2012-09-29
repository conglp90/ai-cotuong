package model;

import java.awt.Image;

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
	public final Chess[] redChess, blackChess;
	public final Image imgBoard = new ImageIcon(Constant.BOARD_DIR+"/banco.png").getImage();
	private boolean isFinish = false;
	public int tablePos[][]={{6, 4, 3, 2, 7, 2, 3, 4, 6},
  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
  			  				  {0, 5, 0, 0, 0, 0, 0, 5, 0},
  			  				  {1, 0, 1, 0, 1, 0, 1, 0, 1},
  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
  			  				  {-1, 0, -1, 0,-1, 0,-1, 0,-1},
  			  				  {0, -5, 0, 0, 0, 0, 0,-5, 0},
  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
  			  				  {-6, -4,-3,-2,-7,-2,-3,-4,-6}};
	
	public Match() {
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
		blackChess[7]= new King(Constant.CHESS_DIR + "/black_king.png", 0, 0); // Tuong den
		
	}
}
