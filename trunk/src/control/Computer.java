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

	
	public float alphaBeta(float alpha, float beta ,int depth , int type){
		float value = 0;
		if (depth == 0) return master.Eval();
		float best = -Constant.INFINITY-1;
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		arr = match.GetOrderedMoves(type);
		for (MoveInfo move : arr){
				Match.tryMove(move);
				
				value = -alphaBeta(-beta,-alpha,depth - 1, 1 - type);
				if (move.getpiece() == -7) System.out.println(value+" "+best+" "+depth);
				Match.undoMove(move);
				if (value > best) {
					best = value;
					if (depth == Constant.Depth){
						Match.newMove = move;
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
		master.Eval();
		System.out.println(master.PosValue[5][3][4]);
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
	
		arr = match.GetOrderedMoves(type);
		for (MoveInfo move : arr){
			System.out.println(move.getx()+" " + move.gety()+" "+ move.getxx() +" "+move.getyy() +" " + move.getCost());
		}
		
		System.out.println("fds");
		Match.tryMove(arr.get(24));
		float s = master.Eval();
		System.out.println(s);
		Match.undoMove(arr.get(24));
		*/
		alphaBeta(-Constant.INFINITY,Constant.INFINITY,Constant.Depth,type);
		
	}
}
