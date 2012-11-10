package control;

import java.util.ArrayList;
import java.util.List;
import model.Constant;
import model.Match;
import model.MoveInfo;

public class Computer {
	Match match = new Match();
	Evaluate master = new Evaluate();
	MoveInfo lastMove = new MoveInfo();
	
	public int alphaBeta(int alpha, int beta ,int depth , int type){
		int value = 0;
		if (depth <=0) {
			if (lastMove.getpiece() == 0) return master.Eval();
			return quiescentSearch(alpha,beta,1- type);
		}
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
						System.out.println(move.getx()+" "+move.gety()+" "+ best);
						Match.newMove = move;
					} 
				}
				if (best > alpha) alpha = best;
				if (best >= beta) break;
			}
		return best;
	}
	public List <MoveInfo> FilterMoves(int type){
		List <MoveInfo> arr  = match.GetOrderedMoves(type);
		List <MoveInfo> list = new ArrayList<MoveInfo>();
		for (MoveInfo move : arr){
			if (move.getpiece() != 0) list.add(move);
		}
		return list;
	}
	public int quiescentSearch(int alpha,int beta, int type){
		/*
		 * Phương pháp tìm kiếm chỉ thực hiện tìm kiếm với các nước ăn quân, hoặc
		 * chiếu tướng. Thuật toán chỉ dừng lại để đánh giá khi tướng bị ăn,hoặc không còn nước
		 * nào để đi.
		 * This makes the difference :D
		 */
		int best = -Constant.INFINITY-1;
		int value = 0;
		if (Match.isFinish){
			return Constant.INFINITY;
		}
		List <MoveInfo> listMoves = FilterMoves(type);
		if (listMoves.isEmpty()) return master.Eval();
		for (MoveInfo move : listMoves){
			Match.tryMove(move);
			value = -quiescentSearch(-beta,-alpha,1 - type);
			Match.undoMove(move);
			if (value > best)  best = value;
			if (best  > alpha) alpha = best;
			if (best  >= beta) break;
		}
		return best;
		
	}
	public int Search(int alpha ,int beta , int depth , int ply ,boolean nullOk, int type){
		/*
		 * Hàm xử lý chính cho việc tìm kiếm 
		 * Ở đây sẽ tùy vào nước đi, mà chọn phương pháp tìm kiếm thích hợp
		 */
		boolean failHigh;
		if (depth <=0) {
			if (lastMove.getpiece() == 0) return master.Eval();
			return quiescentSearch(alpha,beta,1- type);
		}
		//if (!Match.isCheck(type)&&)
		return 0;
	}
	public int negaScout(int alpha,int beta, int depth, int ply , int type){
		return 0;
	}
	public void thinking(int type) {
		Match.initChess();
		alphaBeta(-Constant.INFINITY,Constant.INFINITY,Constant.Depth,type);
		
	}
}
