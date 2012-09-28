package model.chess;

import java.awt.Image;

import model.ChessPosition;
import model.Match;

import java.util.*;

public class Advisor extends Chess {

	public Advisor(Image shape, int row, int col) {
		// TODO Auto-generated constructor stub
		super(shape, row, col);
	}

	@Override
	public List <ChessPosition> getPosCanMove(ChessPosition current) {
		// TODO Auto-generated method stub
		List <ChessPosition> pos = new ArrayList<ChessPosition>();
		int x,y,upBound,lowBound,leftBound,rightBound,value;
		int dx[] = {1,1,-1,-1};
		int dy[] = {1,-1,1,-1};
		ChessPosition CpTemp = new ChessPosition();
		//khoi tao gioi han di chuyen cho quan sy
		
		x = this.getCol() ;
		y = this.getRow() ;
		value = Match.tablePos[x][y];
		if (x <= 2) {
			upBound = 0;
			lowBound= 2;
		} else {
			upBound = 7;
			lowBound = 9 ;
		}
		leftBound = 3 ;
		rightBound = 5;
		//diem phai duoi
		for (int i=1 ; i<=4 ; i++){
			x=this.getCol()+dx[i];
			y=this.getCol()+dy[i];
			if (((x>=leftBound)&&(x<=rightBound))&&((y>=upBound)&&(y<=lowBound))){
				if ((Match.tablePos[x][y]==0)||(Match.tablePos[x][y]*value < 0)){
					CpTemp.setCol(x);
					CpTemp.setRow(y);
					if (Match.tablePos[x][y]*value < 0) {
						CpTemp.setCanBeEaten(true);
					} else {
						CpTemp.setCanBeEaten(false);
					}
					pos.add(CpTemp);
				}
				
			}
		}
				return pos;
	}

}
