/*
 * Author HoangNv, 29.09.2012
 */
package model.chess;

import java.util.ArrayList;
import java.util.List;

import model.ChessPosition;
import model.Match;

public class Cannon extends Chess {

	public Cannon(String img, int row, int col) {
		super(img, row, col);
	}

	@Override
	public List<ChessPosition> getPosCanMove(ChessPosition current, Match match) {
		List<ChessPosition> pos = new ArrayList<ChessPosition>();
		int x,y,upBound,lowBound,leftBound,rightBound,value,i,omg,j;
		ChessPosition CpTemp = new ChessPosition();
		x=current.getCol();
		y=current.getRow();
		value = match.tablePos[y][x];
		upBound  = 0 ; lowBound = 9;
		leftBound = 0; rightBound = 8;
		/*
		 *  Thuc hien kiem tra 4 huong, de xet o di duoc cua quan phao
		 *  Dong thoi kiem tra xem o co the an duoc
		 */
 
		for (i=x+1 ; x<=rightBound ; i++){
			omg = match.tablePos[y][i] ;
			if (omg == 0) {
				
				CpTemp.setCol(i);
				CpTemp.setRow(y);
				CpTemp.setCanBeEaten(false);
				pos.add(CpTemp);
			} else {
				for (j=i+1 ; j<=rightBound ; j++) {
					if (match.tablePos[y][j] != 0) {
						if (value * match.tablePos[y][j] < 0) {
							CpTemp.setCol(j);
							CpTemp.setRow(y);
							CpTemp.setCanBeEaten(true);
							pos.add(CpTemp);
						}
					break;
					}
				}
				break;
			}
		}
	
		
		//Sang ben trai
		for (i=x-1 ; x>=leftBound ; i--){
			omg = match.tablePos[y][i] ;
			if (omg == 0) {
				CpTemp.setCol(i);
				CpTemp.setRow(y);
				CpTemp.setCanBeEaten(false);
				pos.add(CpTemp);
			} else {
				for (j=i-1 ; j>=leftBound ; j--) {
					if (match.tablePos[y][j] != 0) {
						if (value * match.tablePos[y][j] < 0) {
							CpTemp.setCol(j);
							CpTemp.setRow(y);
							CpTemp.setCanBeEaten(true);
							pos.add(CpTemp);
						}
					break;
					}
				}
				break;
			}
		}
		//Di len tren
		for (i=y-1 ; y>=upBound ; i--){
			omg = match.tablePos[i][x] ;
			if (omg == 0) {
				CpTemp.setCol(x);
				CpTemp.setRow(i);
				CpTemp.setCanBeEaten(false);
				pos.add(CpTemp);
			} else {
				for (j=i-1 ; j>=upBound ; j--) {
					if (match.tablePos[j][x] != 0) {
						if (value * match.tablePos[j][x] < 0) {
							CpTemp.setCol(x);
							CpTemp.setRow(j);
							CpTemp.setCanBeEaten(true);
							pos.add(CpTemp);
						}
					break;
					}
				}
				break;
			}
		}
		//di xuong duoi
		for (i=y+1 ; y<=lowBound ; i++){
			omg = match.tablePos[i][x] ;
			if (omg == 0) {
				CpTemp.setCol(x);
				CpTemp.setRow(i);
				CpTemp.setCanBeEaten(false);
				pos.add(CpTemp);
			} else {
				for (j=i+1 ; j<=lowBound ; j++) {
					if (match.tablePos[j][x] != 0) {
						if (value * match.tablePos[j][x] < 0) {
							CpTemp.setCol(x);
							CpTemp.setRow(j);
							CpTemp.setCanBeEaten(true);
							pos.add(CpTemp);
						}
					break;
					}
				}
				break;
			}
		}
		return pos;
	}

}
