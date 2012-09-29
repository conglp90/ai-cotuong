/*
 * Author HoangNv, 29.09.2012
 */
package model.chess;

import java.util.ArrayList;
import java.util.List;

import model.ChessPosition;
import model.Match;

public class King extends Chess {

	public King(String img, int row, int col) {
		super(img, row, col);
	}

	@Override
	public List <ChessPosition> getPosCanMove(ChessPosition current, Match match) {
		List <ChessPosition> pos = new ArrayList<ChessPosition>();
		int x,y,upBound,lowBound,leftBound,rightBound,value,i,j;
		boolean loMatTuong ;
		int dx[] = {0,1,-1,0,0};
		int dy[] = {0,0,0,1,-1};
		ChessPosition CpTemp = new ChessPosition();
		x = current.getCol() ;
		y = current.getRow() ;
		value = match.tablePos[y][x];

		//khoi tao gioi han di chuyen cho quan tuong
		 
		x = current.getCol() ;
		y = current.getRow() ;
		value = match.tablePos[y][x];

		if (x <= 2) {
			upBound = 0;
			lowBound= 2;
		} else {
			upBound = 7;
			lowBound = 9 ;
		}
		leftBound = 3 ;
		rightBound = 5;
		/*
		 *Xet 4 o quanh o tuong, kiem tra hop le, neu hop le thi cho di
		 *Chu y xet ca lo mat tuong, face to face 
		 */
		
		for (i=1 ; i<=4 ; i++){
			x=this.getCol()+dx[i];
			y=this.getRow()+dy[i];
			if (((x>=leftBound)&&(x<=rightBound))&&((y>=upBound)&&(y<=lowBound))){
				if ((match.tablePos[y][x]==0)||(match.tablePos[y][x]*value < 0)){
					//Kiem tra xem co lo mat tuong ?
					loMatTuong = false;
					if (upBound == 0) {
						for (j = y +1 ; j<= lowBound ; j++) {
							if (match.tablePos[j][x] !=0) {
								if (match.tablePos[j][x] + value ==0 ) {
									loMatTuong= true;
								}
								break;
							}
						}
					} else {
						for (j = y - 1 ; j>= upBound ; j++) {
							if (match.tablePos[j][x] !=0) {
								if (match.tablePos[j][x] + value == 0 ) {
									loMatTuong= true;
								}
								break;
							}
						}
						
					}
					
					if (!loMatTuong) {
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
		}
		
		return pos;
	}
}