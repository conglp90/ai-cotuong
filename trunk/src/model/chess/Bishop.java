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
		// TODO Auto-generated method stub
		return pos;
	}

}
