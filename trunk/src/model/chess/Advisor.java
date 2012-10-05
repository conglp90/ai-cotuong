/*
 * Author : HoangNV , 28.9.2012
 */
package model.chess;

import java.util.ArrayList;
import java.util.List;

import model.ChessPosition;
import model.Match;

public class Advisor extends Chess {

	public Advisor(String img, int row, int col) {
		super(img, row, col);
	}

	@Override
	public List <ChessPosition> getPosCanMove(ChessPosition current, Match match , int side) {
		List <ChessPosition> pos = new ArrayList<ChessPosition>();
		ChessPosition CpTemp ;
		int x,y,upBound,lowBound,leftBound,rightBound,value;
		int dx[] = {0,1,1,-1,-1};
		int dy[] = {0,1,-1,1,-1};
		//khoi tao gioi han di chuyen cho quan sy
		 
		x = current.getCol() ;
		y = current.getRow() ;
		value = match.tablePos[y][x];

		if (side == -1) {
			upBound = 0;
			lowBound= 2;
		} else {
			upBound = 7;
			lowBound = 9 ;
		}
		leftBound = 3 ;
		rightBound = 5;
		
		//Xet 4 o quanh o sy, kiem tra hop le, neu hop le thi cho di
		
		for (int i=1 ; i<=4 ; i++){
			x=current.getCol()+dx[i];
			y=current.getRow()+dy[i];
			if (((x>=leftBound)&&(x<=rightBound))&&((y>=upBound)&&(y<=lowBound))){
				if ((match.tablePos[y][x]==0)||(match.tablePos[y][x]*value < 0)){
					if (match.tablePos[y][x]*value < 0) {
						CpTemp = new ChessPosition(x,y,true);
					} else {
						CpTemp = new ChessPosition(x,y,false);
					}
					pos.add(CpTemp);
				}
				
			}
		}
				return pos;
	}

}
