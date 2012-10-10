package control;

import java.util.ArrayList;
import java.util.List;

import model.ChessPosition;
import model.Constant;
import model.Match;
import model.MoveInfo;

public class Computer {
	private int BaseValue[] ={0,10,20,20,25,45,50,100,10000};
	private boolean isFinish = false;
	Match match = new Match();
	public void   tryMove(MoveInfo nmove){
		if (Math.abs(Match.tablePos[nmove.getToY()][nmove.getToX()])==7) isFinish = true;
		Match.tablePos[nmove.getToY()][nmove.getToX()] =
				Match.tablePos[nmove.getFromY()][nmove.getFromX()];
		Match.tablePos[nmove.getFromY()][nmove.getFromX()] = 0;
	}
	public void   undoMove(MoveInfo nmove){
		if (Math.abs(nmove.getValue())==7) isFinish = false;
		Match.tablePos[nmove.getFromY()][nmove.getFromX()] =
				Match.tablePos[nmove.getToY()][nmove.getToX()];
		Match.tablePos[nmove.getToY()][nmove.getToX()] = nmove.getValue();
	}
	public   List <MoveInfo> InitArrayMoves(int side){
		int type,piece;
		ChessPosition current;
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		List <ChessPosition> posCanMove = new ArrayList<ChessPosition>();
		//type = 1,phia duoi <0
		//type = -1 phia tren >0
		type = 1;
		if (side == 0) type = -1; 
		for (int i=0; i<= 9 ; i++)
			for (int j=0; j<=8; j++) {
				piece = Match.tablePos[i][j];
				if (piece * type < 0 ) {
					current = new ChessPosition(j, i, false);
					posCanMove = match.pieceChess[side][Math.abs(piece)].getPosCanMove(current, match,type);
					for (ChessPosition pos : posCanMove) {
						MoveInfo nMove = new MoveInfo(j,i,pos.getCol(),pos.getRow(),match.tablePos[pos.getRow()][pos.getCol()]);
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
		if (depth == 0) return Evaluate(type);
		if (isFinish) return Evaluate(type)-(Constant.Depth - depth);
		int best = -Constant.INFINITY;
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		arr = InitArrayMoves(type);
		if (best < beta)
		for (MoveInfo move : arr){
				tryMove(move);
				value = -alphaBeta(-beta,-anpha,depth - 1, 1 - type);
				undoMove(move);
				if (value > best) best = value;
				if (best > anpha) anpha = best;
				if (best >= beta) break;
				
			}
		return best;
	}
	public void thinking(int type) {
		int res = -Constant.INFINITY;
		System.out.println("dfasfda");
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		arr = InitArrayMoves(type);
		for (MoveInfo move : arr){
				tryMove(move);
				int value = -alphaBeta(-Constant.INFINITY,Constant.INFINITY,Constant.Depth,1-type);
				undoMove(move);
				if (value > res){
					res = value;
					
					Match.newMove = move;
					System.out.println(move.getFromX()+" "+move.getFromY()+ " " + res);
				}
			}
	}
}
