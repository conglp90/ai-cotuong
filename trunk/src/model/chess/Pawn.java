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
	private boolean CheckPassRiver(ChessPosition current, Match match, int side) {
		if (side * match.tablePos[current.getRow()][current.getCol()] > 0) return true;
		return false ; 
	}
	public List <ChessPosition> getPosCanMove(ChessPosition current, Match match , int side) {
		List <ChessPosition> pos = new ArrayList<ChessPosition>();
		ChessPosition CpTemp ;
		int x,y,value,omg,tmpX,tmpY;
		x = current.getCol() ;
		y = current.getRow() ;
		if (y <= 4 )  omg = 1 ; 
		 else omg = -1;
		passedRiver = CheckPassRiver(current,match,side);
		value = match.tablePos[y][x];
		if (passedRiver) {
			tmpX = x;
			tmpY = y - omg;
			if ((tmpY >= 0)&&(tmpY<=9)&&((match.tablePos[tmpY][tmpX]==0)||(match.tablePos[tmpY][tmpX] * value < 0))) {
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
				
				if (match.tablePos[tmpY][tmpX] * value < 0) {
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
				pos.add(CpTemp);	
			}
				
		}
				
		return pos;
	}
}
