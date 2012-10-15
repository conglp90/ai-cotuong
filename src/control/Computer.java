package control;

import java.util.ArrayList;
import java.util.List;

import model.ChessPosition;
import model.Constant;
import model.Match;
import model.MoveInfo;

public class Computer {
	private int BaseValue[] ={0,10,20,20,25,45,50,100,10000};
	Match match = new Match();
	Evaluate master = new Evaluate();

	
	public int alphaBeta(int alpha, int beta ,int depth , int type){
		int value = 0;
		if (depth == 0) return master.Eval();
		int best = -Constant.INFINITY-1;
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		arr = match.GetOrderedMoves(type);
		for (MoveInfo move : arr){
				Match.tryMove(move);
				value = -alphaBeta(-beta,-alpha,depth - 1, 1 - type);
				//if (move.getpiece() == -7) System.out.println(value+" "+best+" "+depth);
				Match.undoMove(move);
				if (value > best) {
					best = value;
					if (depth == Constant.Depth){
						Match.newMove = move;
						System.out.println(move.getx()+" "+move.gety()+" "+ best);
					} 
				}
				if (best > alpha) alpha = best;
				if (best >= beta) break;
			}
		return best;
	}
	public void thinking(int type) {
		Match.initChess();
		/*
		Evaluate master = new Evaluate();
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		arr = match.GetOrderedMoves(type);
		for (MoveInfo move : arr){
			System.out.println("*"+move.getx()+" " + move.gety()+" "+ move.getxx() +" "+move.getyy() +" " + move.getCost());
		}
		Match.initChess();
		System.out.println("fds");
		Match.tryMove(arr.get(3));
		for (int i=0 ; i<=9 ; i++){
			for (int j=0 ; j<=8; j++)
				System.out.print(Match.tablePos[i][j]+"  ");
			System.out.println();
		}
		int s = master.Eval();
		System.out.println(s);
		for (int i=1 ; i<=Match.count[0] ; i++){
			if (Match.Chess[0][i].getIsAlive())
			System.out.println(Match.Chess[0][i].getX()+" "+Match.Chess[0][i].getY()+" "+Match.Chess[0][i].getPiece()+" "+Match.Chess[0][i].getPiece()+" "+Match.Chess[0][i].getValue());
		}
		for (int i=1 ; i<=Match.count[1] ; i++){
			if (Match.Chess[1][i].getIsAlive())
				System.out.println(Match.Chess[1][i].getX()+" "+Match.Chess[1][i].getY()+" "+Match.Chess[1][i].getPiece()+" "+Match.Chess[1][i].getPiece()+" "+Match.Chess[1][i].getValue());
		}
		Match.undoMove(arr.get(3));
		*/
	alphaBeta(-Constant.INFINITY,Constant.INFINITY,Constant.Depth,type);
		
	}
}
