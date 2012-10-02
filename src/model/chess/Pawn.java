package model.chess;

import java.util.ArrayList;
import java.util.List;

import model.ChessPosition;
import model.Match;

public class Pawn extends Chess {
	private boolean passedRiver = false;
	public Pawn(String img, int row, int col) {
		// TODO Auto-generated constructor stub
		super(img, row, col);
	}

	@Override
	public List <ChessPosition> getPosCanMove(ChessPosition current, Match match) {
		List <ChessPosition> pos = new ArrayList<ChessPosition>();
		ChessPosition CpTemp ;
		int x,y,value,omg,tmpX,tmpY;
		x = current.getCol() ;
		y = current.getRow() ;
		if (y <= 4 )  omg = 1 ; 
		 else omg = -1;
		value = match.tablePos[y][x];
		if (passedRiver) {
			tmpX = x;
			tmpY = y - omg;
			if ((tmpY >= 0)&&((match.tablePos[tmpY][tmpX]==0)||(match.tablePos[tmpY][tmpX] * value < 0))) {
				
				if (match.tablePos[tmpY][tmpX]*value < 0) {
					CpTemp = new ChessPosition(tmpX,tmpY,true);
				} else {
					CpTemp = new ChessPosition(tmpX,tmpY,false);
				}
				pos.add(CpTemp);	
			}
			tmpX = x-1;
			tmpY = y;
			if ((tmpX >= 0)&&((match.tablePos[tmpY][tmpX]==0)||(match.tablePos[tmpY][tmpX] * value < 0))) {
				
				if (match.tablePos[tmpY][tmpX]*value < 0) {
					CpTemp = new ChessPosition(tmpX,tmpY,true);
				} else {
					CpTemp = new ChessPosition(tmpX,tmpY,false);
				}
				pos.add(CpTemp);	
			}
			tmpX = x+1;
			tmpY = y;
			if ((tmpX <= 8)&&((match.tablePos[tmpY][tmpX]==0)||(match.tablePos[tmpY][tmpX] * value < 0))) {
				if (match.tablePos[tmpY][tmpX]*value < 0) {
					CpTemp = new ChessPosition(tmpX,tmpY,true);
				} else {
					CpTemp = new ChessPosition(tmpX,tmpY,false);
				}
				pos.add(CpTemp);	
			}
		} else {
			tmpX = x;
			tmpY = y + omg;
			if ((tmpY >= 0)&&((match.tablePos[tmpY][tmpX]==0)||(match.tablePos[tmpY][tmpX] * value < 0))) {
				if (match.tablePos[tmpY][tmpX]*value < 0) {
					CpTemp = new ChessPosition(tmpX,tmpY,true);
				} else {
					CpTemp = new ChessPosition(tmpX,tmpY,false);
				}
				if (((tmpY == 5) && (omg == 1)) || ((tmpY==4) && (omg==-1)))  passedRiver = true;
				pos.add(CpTemp);	
			}
				
		}
				
		return pos;
	}
}
