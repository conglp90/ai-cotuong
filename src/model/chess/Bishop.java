package model.chess;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import model.ChessPosition;

public class Bishop extends Chess {

	public Bishop(String img, int row, int col) {
		super(img, row, col);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List <ChessPosition> getPosCanMove(ChessPosition current) {
		List <ChessPosition> pos = new ArrayList<ChessPosition>();
		// TODO Auto-generated method stub
		return pos;
	}

}
