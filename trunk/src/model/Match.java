package model;

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
	public Chess[] redChess, blackChess;
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
		
		redChess[1] = new Pawn("src/images/chess/totdo.png", 0, 0); // Tot do
		redChess[2] = new Advisor("src/images/chess/sydo.png", 0, 0); // Sy do
		redChess[3] = new Bishop("src/images/chess/tinhdo.png", 0, 0); // Tinh do
		redChess[4] = new Knight("src/images/chess/mado.png", 0, 0); // Ma do
		redChess[5] = new Cannon("src/images/chess/phaodo.png", 0, 0); // Phao do
		redChess[6] = new Rook("src/images/chess/xedo.png", 0, 0); // Xe do
		redChess[7]= new King("src/images/chess/tuongdo.png", 0, 0); // Tuong do
		
		blackChess[1] = new Pawn("src/images/chess/totden.png", 0, 0); // Tot den
		blackChess[2] = new Advisor("src/images/chess/syden.png", 0, 0); // Sy den
		blackChess[3] = new Bishop("src/images/chess/tinhden.png", 0, 0); // Tinh den
		blackChess[4] = new Knight("src/images/chess/maden.png", 0, 0); // Ma den
		blackChess[5] = new Cannon("src/images/chess/phaoden.png", 0, 0); // Phao den
		blackChess[6] = new Rook("src/images/chess/xeden.png", 0, 0); // Xe den
		blackChess[7]= new King("src/images/chess/tuongden.png", 0, 0); // Tuong den
		
	}
}
