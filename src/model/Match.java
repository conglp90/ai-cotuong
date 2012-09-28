package model;

import model.chess.Chess;

public class Match {
	private Player redPlayer, blackPlayer;
	private Chess[] redChess, blackChess;
	private boolean isFinish = false;
	public final static int tablePos[][]={{6, 4, 3, 2, 7, 2, 3, 4, 6},
	  		  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
	  		  			  				  {0, 5, 0, 0, 0, 0, 0, 5, 0},
	  		  			  				  {1, 0, 1, 0, 1, 0, 1, 0, 1},
	  		  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
	  		  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
	  		  			  				  {-1, 0, -1, 0,-1, 0,-1, 0,-1},
	  		  			  				  {0, -5, 0, 0, 0, 0, 0,-5, 0},
	  		  			  				  {0, 0, 0, 0, 0, 0, 0, 0, 0},
	  		  			  				  {-6, -4,-3,-2,-7,-2,-3,-4,-6}};

}
