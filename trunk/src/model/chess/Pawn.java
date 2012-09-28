package model.chess;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import model.ChessPosition;

public class Pawn extends Chess {

	public Pawn(String img, int row, int col) {
		// TODO Auto-generated constructor stub
		super(img, row, col);
	}

	@Override
	public List <ChessPosition> getPosCanMove(ChessPosition current) {
		List <ChessPosition> pos = new ArrayList<ChessPosition>();
		// TODO Auto-generated method stub
		return pos;
	}
}
