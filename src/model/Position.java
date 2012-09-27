package model;
/*
 * 
 * 
 */

public class Position {
	private  int row ;
	private  int col ;
	private  boolean CanBeEaten;
	public int getRow(){
		return this.row;
	}
	public int getCol(){
		return this.col;
	}
	public boolean getCanBeEaten(){
		return this.CanBeEaten;
	}
	public void setRow(int row){
		this.row = row ;
	}
	public void setCol(int col){
		this.col = col;
	}
	public void setCanBeEaten(boolean CanBeEaten){
		this.CanBeEaten = CanBeEaten ;
	}
}
