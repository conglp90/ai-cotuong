package model.chess;

import java.util.ArrayList;
import java.util.List;

import model.ChessPosition;
import model.Match;

public class Bishop extends Chess {

	public Bishop(String img, int row, int col) {
		super(img, row, col);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ChessPosition> getPosCanMove(ChessPosition current, Match match) {
		List<ChessPosition> pos = new ArrayList<ChessPosition>();
		int x,y,upBound,lowBound,leftBound,rightBound,value;
		int dx[] = {0,2,2,-2,-2};
		int dy[] = {0,2,-2,2,-2};
		ChessPosition CpTemp = new ChessPosition();
		/*
		 * khoi tao gioi han di chuyen cho quan sy
		 */
		
		x = current.getCol() ;
		y = current.getRow() ;
		value = match.tablePos[y][x];
		if (x <= 2) {
			upBound = 0;
			lowBound= 4;
		} else {
			upBound = 5;
			lowBound = 9 ;
		}
		leftBound = 0 ;
		rightBound = 8;
		/*
		 * Xet 4 o quanh o sy, kiem tra hop le, neu hop le thi cho di
		 */
		for (int i=1 ; i<=4 ; i++){
			x=this.getCol()+dx[i];
			y=this.getRow()+dy[i];
			if (((x>=leftBound)&&(x<=rightBound))&&((y>=upBound)&&(y<=lowBound))){
				if ((match.tablePos[y][x]==0)||(match.tablePos[y][x]*value < 0)){
					CpTemp.setCol(x);
					CpTemp.setRow(y);
					if (match.tablePos[y][x]*value < 0) {
						CpTemp.setCanBeEaten(true);
					} else {
						CpTemp.setCanBeEaten(false);
					}
					pos.add(CpTemp);
				}
				
			}
		}
		// TODO Auto-generated method stub
		return pos;
	}

}
