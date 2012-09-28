/*
 * Author : HoangNV , 28.9.2012
 */
package model.chess;

import java.awt.Image;

import model.ChessPosition;
import model.Match;

import java.util.*;

public class Advisor extends Chess {

	public Advisor(String img, int row, int col) {
		super(img, row, col);
	}

	@Override
	public List <ChessPosition> getPosCanMove(ChessPosition current) {
		List <ChessPosition> pos = new ArrayList<ChessPosition>();
		/*int x,y,upBound,lowBound,leftBound,rightBound,value;
		int dx[] = {1,1,-1,-1};
		int dy[] = {1,-1,1,-1};
		ChessPosition CpTemp = new ChessPosition();
		
		//khoi tao gioi han di chuyen cho quan sy
		 
		
		x = this.getCol() ;
		y = this.getRow() ;
		value = Match.tablePos[y][x];
		if (x <= 2) {
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
			x=this.getCol()+dx[i];
			y=this.getRow()+dy[i];
			if (((x>=leftBound)&&(x<=rightBound))&&((y>=upBound)&&(y<=lowBound))){
				if ((Match.tablePos[y][x]==0)||(Match.tablePos[y][x]*value < 0)){
					CpTemp.setCol(x);
					CpTemp.setRow(y);
					if (Match.tablePos[y][x]*value < 0) {
						CpTemp.setCanBeEaten(true);
					} else {
						CpTemp.setCanBeEaten(false);
					}
					pos.add(CpTemp);
				}
				
			}
		}*/
				return pos;
	}

}
