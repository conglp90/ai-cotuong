package model.chess;

import java.awt.Image;

import model.ChessPosition;
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
		int x,y,upBound,lowBound,leftBound,rightBound ;
		x = this.getCol() ;
		y = this.getRow() ;
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
		x=this.getCol()+1;
		y=this.getCol()+1;
		if (((x>=leftBound)&&(x<=rightBound))&&((y>=upBound)&&(y<=lowBound))){
			
		}
		//diem phai tren
		x=this.getCol()+1;
		y=this.getCol()-1;
		if (((x>=leftBound)&&(x<=rightBound))&&((y>=upBound)&&(y<=lowBound))){
			
		}
		//diem trai duoi
		x=this.getCol()-1;
		y=this.getCol()+1;
		if (((x>=leftBound)&&(x<=rightBound))&&((y>=upBound)&&(y<=lowBound))){
			
		}
		//diem trai tren 
		x=this.getCol()-1;
		y=this.getCol()-1;
		if (((x>=leftBound)&&(x<=rightBound))&&((y>=upBound)&&(y<=lowBound))){
			
		}
		
		return pos;
	}

}
