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
	public List<ChessPosition> getPosCanMove(Match match, ChessPosition current,  int type) {
		List<ChessPosition> pos = new ArrayList<ChessPosition>();
		int x,y,upBound,lowBound,leftBound,rightBound,value,i,omg,j;
		ChessPosition CpTemp;
		x=current.getCol();
		y=current.getRow();
		value = match.getTablePos()[y][x];
		upBound  = 0 ; lowBound = 9;
		leftBound = 0; rightBound = 8;
		/*
		 *  Thuc hien kiem tra 4 huong, de xet o di duoc cua quan phao
		 *  Dong thoi kiem tra xem o co the an duoc
		 */
		
		//Sang ben phai
		
		for (i=x+1 ; i<=rightBound ; i++){
			omg = match.getTablePos()[y][i] ;
			if (omg == 0) {
				CpTemp = new ChessPosition(i,y,false);
				pos.add(CpTemp);
			} else {
				for (j=i+1 ; j<=rightBound ; j++) {
					if (match.getTablePos()[y][j] != 0) {
						if (value * match.getTablePos()[y][j] < 0) {
							CpTemp = new ChessPosition(j,y,true);
							pos.add(CpTemp);
						}
					break;
					}
				}
				break;
			}
		}
	
		
		//Sang ben trai
		for (i=x-1 ; i>=leftBound ; i--){
			omg = match.getTablePos()[y][i] ;
			if (omg == 0) {
				CpTemp = new ChessPosition(i,y,false);
				pos.add(CpTemp);
			} else {
				for (j=i-1 ; j>=leftBound ; j--) {
					if (match.getTablePos()[y][j] != 0) {
						if (value * match.getTablePos()[y][j] < 0) {
							CpTemp = new ChessPosition(j,y,true);
							pos.add(CpTemp);
						}
					break;
					}
				}
				break;
			}
		}
		//Di len tren
		for (i=y-1 ; i>=upBound ; i--){
			omg = match.getTablePos()[i][x] ;
			if (omg == 0) {
				CpTemp = new ChessPosition(x,i,false);
				pos.add(CpTemp);
			} else {
				for (j=i-1 ; j>=upBound ; j--) {
					if (match.getTablePos()[j][x] != 0) {
						if (value * match.getTablePos()[j][x] < 0) {
							CpTemp = new ChessPosition(x,j,true);
							pos.add(CpTemp);
						}
					break;
					}
				}
				break;
			}
		}
		//di xuong duoi
		for (i=y+1 ; i<=lowBound ; i++){
			omg = match.getTablePos()[i][x] ;
			if (omg == 0) {
				CpTemp = new ChessPosition(x,i,false);
				pos.add(CpTemp);
			} else {
				for (j=i+1 ; j<=lowBound ; j++) {
					if (match.getTablePos()[j][x] != 0) {
						if (value * match.getTablePos()[j][x] < 0) {
							CpTemp = new ChessPosition(x,j,true);
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
	
	@Override
	public List<ChessPosition> getTargetPos(Match match, ChessPosition current,  int type) {
		List<ChessPosition> pos = new ArrayList<ChessPosition>();
		int x,y,upBound,lowBound,leftBound,rightBound,value,i,omg,j;
		ChessPosition CpTemp;
		x=current.getCol();
		y=current.getRow();
		value = match.getTablePos()[y][x];
		upBound  = 0 ; lowBound = 9;
		leftBound = 0; rightBound = 8;
		/*
		 *  Thuc hien kiem tra 4 huong, de xet o di duoc cua quan phao
		 *  Dong thoi kiem tra xem o co the an duoc
		 */
		
		//Sang ben phai
		
		for (i=x+1 ; i<=rightBound ; i++){
			omg = match.getTablePos()[y][i] ;
			if (omg != 0) {
				for (j=i+1 ; j<=rightBound ; j++) {
					if (match.getTablePos()[y][j] != 0) {
						if (value * match.getTablePos()[y][j] < 0) {
							CpTemp = new ChessPosition(j,y,true);
						} else CpTemp = new ChessPosition(j,y,false);
						pos.add(CpTemp);
					break;
					}
				}
				break;
			}
		}
	
		
		//Sang ben trai
		for (i=x-1 ; i>=leftBound ; i--){
			omg = match.getTablePos()[y][i] ;
			if (omg != 0) {
				for (j=i-1 ; j>=leftBound ; j--) {
					if (match.getTablePos()[y][j] != 0) {
						if (value * match.getTablePos()[y][j] < 0) {
							CpTemp = new ChessPosition(j,y,true);
						}else CpTemp = new ChessPosition(j,y,false);
						pos.add(CpTemp);
					break;
					}
				}
				break;
			}
		}
		//Di len tren
		for (i=y-1 ; i>=upBound ; i--){
			omg = match.getTablePos()[i][x] ;
			if (omg != 0) {
				for (j=i-1 ; j>=upBound ; j--) {
					if (match.getTablePos()[j][x] != 0) {
						if (value * match.getTablePos()[j][x] < 0) {
							CpTemp = new ChessPosition(x,j,true);
						} else CpTemp = new ChessPosition(x,j,false);
					pos.add(CpTemp);
					break;
					}
				}
				break;
			}
		}
		//di xuong duoi
		for (i=y+1 ; i<=lowBound ; i++){
			omg = match.getTablePos()[i][x] ;
			if (omg != 0) {
				for (j=i+1 ; j<=lowBound ; j++) {
					if (match.getTablePos()[j][x] != 0) {
						if (value * match.getTablePos()[j][x] < 0) {
							CpTemp = new ChessPosition(x,j,true);
						} else CpTemp = new ChessPosition(x,j,false);
						pos.add(CpTemp);
					break;
					}
				}
				break;
			}
		}
		return pos;
	}

}
