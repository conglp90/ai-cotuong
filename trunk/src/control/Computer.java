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
	public   List <MoveInfo> InitArrayMoves(int type){
		int piece,x,y;
		ChessPosition current;
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		List <ChessPosition> posCanMove = new ArrayList<ChessPosition>();
		//type = 1,phia duoi <0
		//type = -1 phia tren >0
		for (int i=1 ; i <= Match.count[type]; i++){
			if (Match.Chess[type][i].getIsAlive()){
				piece = Match.Chess[type][i].getPiece();
				x = Match.Chess[type][i].getX();
				y = Match.Chess[type][i].getY();
				current = new ChessPosition(x, y, false);
				posCanMove = match.pieceChess[type][piece].getPosCanMove(current, match,type);
				for (ChessPosition pos : posCanMove) {
					MoveInfo nMove = new MoveInfo(x,y,pos.getCol(),pos.getRow(),Match.tablePos[pos.getRow()][pos.getCol()],Match.status[pos.getRow()][pos.getCol()]);
					arr.add(nMove);
				}
			}
		}
		
		return arr;
	}
	public int Evaluate(int typeOfChess) {
		/*
		 * typeOfChess = 0 <=> quan >0
		 * typeOfChess = 1 <=> quan <0
		 */
		int sideOfBoard=0,side=0;
		if (typeOfChess == 0) sideOfBoard = -1;
		if (typeOfChess == 1) sideOfBoard = 1;
		int result = 0;
		for (int i=0;i<10;i++) {
			for (int j=0 ; j<9 ;j++){
				if (sideOfBoard * match.tablePos[i][j]<0) {
					result =result + BaseValue[Math.abs(match.tablePos[i][j])];
					//kiem tra xem neu tot da qua song thi tang gia tri cho no
					side = 1;
					if (i<=4) side = -1;
					if (Math.abs(match.tablePos[i][j])==1) {
						if (side * match.tablePos[i][j] > 0) {
							result = result + 10;
						}
					}
				} else {
					result =result - BaseValue[Math.abs(match.tablePos[i][j])];
					//kiem tra xem neu tot da qua song thi tang gia tri cho no
					side = 1;
					if (i<=4) side = -1;
					if (Math.abs(match.tablePos[i][j])==1) {
						if (side * match.tablePos[i][j] > 0) {
							result = result - 10;
						}
					}
				}
			}
		}
		return result;
		
	}
	public int alphaBeta(int anpha, int beta ,int depth , int type){
		int value;
		if (depth == 0) return master.Eval(type);
		if (Match.isFinish) return master.Eval(type)-(Constant.Depth - depth);
		int best = -Constant.INFINITY;
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		arr = InitArrayMoves(type);
		if (best < beta)
		for (MoveInfo move : arr){
				Match.tryMove(move);
				value = -alphaBeta(-beta,-anpha,depth - 1, 1 - type);
				Match.undoMove(move);
				if (value > best) best = value;
				if (best > anpha) anpha = best;
				if (best >= beta) break;
				
			}
		return best;
	}
	public void thinking(int type) {
		int res = -Constant.INFINITY;
		System.out.println("dfasfda");
		Match.initChess();
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		arr = InitArrayMoves(type);
		for (MoveInfo move : arr){
				Match.tryMove(move);
				int value = -alphaBeta(-Constant.INFINITY,Constant.INFINITY,Constant.Depth,1-type);
				Match.undoMove(move);
				if (value > res){
					res = value;
					
					Match.newMove = move;
					System.out.println(move.getx()+" "+move.gety()+ " " + res);
				}
			}
	}
}
