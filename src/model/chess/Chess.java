package model.chess;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import model.ChessPosition;

public abstract class Chess {

	private int row, col; //toa do 9 x 10
	Image shape;
	boolean died =false;
	
	public Chess(String img, int row, int col) {
		this.row = row;
		this.col = col;
		this.shape = new ImageIcon(img).getImage();
	}
	
	public int getRow() {
		return this.row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public int getX() {
		return row; //tinh sau
	}
	
	public int getY() {
		return col; //tinh sau
	}
	
	public Image getShape() {
		return this.shape;
	}
	
	public boolean isDied() {
		return this.died;
	}
	
	public void setDied(boolean status) {
		this.died = status;
	}
	
	// tra ve mang chua vi tri 
	public abstract List<ChessPosition> getPosCanMove(ChessPosition current);
}
