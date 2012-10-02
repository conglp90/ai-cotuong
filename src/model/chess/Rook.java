/*
 * Author : HoangNV , 28.9.2012
 */ 
package model.chess;
import java.util.ArrayList;
import java.util.List;

import model.ChessPosition;
import model.Match;

public class Rook extends Chess {
	public Rook(String img, int row, int col) {
		super(img, row, col);
		
	}

	@Override
	public List <ChessPosition> getPosCanMove(ChessPosition current,Match match) {
		List <ChessPosition> pos = new ArrayList<ChessPosition>();
		int x,y,upBound,lowBound,leftBound,rightBound,value,i,omg;
		ChessPosition CpTemp = new ChessPosition();
		x=current.getCol();
		y=current.getRow();
		value = match.tablePos[y][x];
		upBound  = 0 ; lowBound = 9;
		leftBound = 0; rightBound = 8;
		/*
		 * Thuc hien kiem tra cac o co the di duoc va an duoc cua quan xe
		 */
		//sang phai
		for (i=x+1 ; x<=rightBound ; i++ ){
			omg = match.tablePos[y][i] ;
			if (omg == 0) {
				CpTemp.setCol(i);
				CpTemp.setRow(y);
				CpTemp.setCanBeEaten(false);
				pos.add(CpTemp);
			}
			if (omg * value < 0) {
				CpTemp.setCol(i);
				CpTemp.setRow(y);
				CpTemp.setCanBeEaten(true);
				pos.add(CpTemp);
				break;
			} 
			if (omg * value >0) break;
		}
		//Sang ben trai
		for (i=x-1 ; x>leftBound ; i-- ){
			omg = match.tablePos[y][i] ;
			if (omg == 0) {
				CpTemp.setCol(i);
				CpTemp.setRow(y);
				CpTemp.setCanBeEaten(false);
				pos.add(CpTemp);
			}
			if (omg * value < 0) {
				CpTemp.setCol(i);
				CpTemp.setRow(y);
				CpTemp.setCanBeEaten(true);
				pos.add(CpTemp);
				break;
			} 
			if (omg * value >0) break;
		}
		//Di len tren
		for (i=y-1 ; y>upBound ; i-- ){
			omg = match.tablePos[i][x] ;
			if (omg == 0) {
				CpTemp.setCol(x);
				CpTemp.setRow(i);
				CpTemp.setCanBeEaten(false);
				pos.add(CpTemp);
			}
			if (omg * value < 0) {
				CpTemp.setCol(x);
				CpTemp.setRow(i);
				CpTemp.setCanBeEaten(true);
				pos.add(CpTemp);
				break;
			} 
			if (omg * value >0) break;
		}
		//di xuong duoi
		for (i=y+1 ; y<=lowBound ; i++ ){
			omg = match.tablePos[i][x] ;
			if (omg == 0) {
				CpTemp.setCol(x);
				CpTemp.setRow(i);
				CpTemp.setCanBeEaten(false);
				pos.add(CpTemp);
			}
			if (omg * value < 0) {
				CpTemp.setCol(x);
				CpTemp.setRow(i);
				CpTemp.setCanBeEaten(true);
				pos.add(CpTemp);
				break;
			} 
			if (omg * value >0) break;
		}
		
		return pos;
	}
}
