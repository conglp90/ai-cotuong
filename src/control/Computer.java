package control;

import java.util.ArrayList;
import java.util.List;

import model.ChessPosition;
import model.Constant;
import model.Match;
import model.MoveInfo;

public class Computer {
	Evaluate master = new Evaluate();
	public void initChess(){
		int piece;
		boolean passriver;
		for (int i=0 ; i<=9 ; i++){
			for(int j=0;j<=8;j++){
				piece = Match.tablePos[i][j];
				if (piece > 0){
					Match.count[0]++;
					Match.status[i][j]=Match.count[0];
					passriver=false;
					if ((piece == 1)&&(i<5)) passriver=true;
					Match.Chess[0][Match.count[0]] = new Position(j,i,piece,passriver,true);
				} else if (piece < 0) { 
					Match.count[1]++;
					Match.status[i][j]=Match.count[1];
					passriver=true;
					if ((piece == 1)&&(i<5)) passriver=true;
					Match.Chess[1][Match.count[1]] = new Position(j,i,-piece,passriver,true);
				}
			}
		}
	}
	public void   tryMove(MoveInfo nmove){
		Match.tablePos[nmove.getToY()][nmove.getToX()] =
				Match.tablePos[nmove.getFromY()][nmove.getFromX()];
		Match.tablePos[nmove.getFromY()][nmove.getFromX()] = 0;
	}
	public void   undoMove(MoveInfo nmove){
		Match.tablePos[nmove.getFromY()][nmove.getFromX()] =
				Match.tablePos[nmove.getToY()][nmove.getToX()];
		Match.tablePos[nmove.getToY()][nmove.getToX()] = nmove.getValue();
	}
	public   List <MoveInfo> InitArrayMoves(int type){
		initChess();
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		List <ChessPosition> posCanMove; new ArrayList<ChessPosition>();
		Match match = new Match();
		//type = 1,phia duoi <0
		//type = -1 phia tren >0
		for (int i = 1 ;i <= Match.count[type];i++){
			ChessPosition current = new ChessPosition(Match.Chess[type][i].getX(),Match.Chess[type][i].getY(),false);
			posCanMove = new ArrayList<ChessPosition>();
			posCanMove = match.pieceChess[type][Match.Chess[type][i].getPiece()].getPosCanMove(current, match, type);
			for (ChessPosition pos : posCanMove) {
				int x= Match.Chess[type][i].getX();
				int y= Match.Chess[type][i].getY();
				int xx = pos.getCol();
				int yy= pos.getRow();
				MoveInfo nMove = new MoveInfo(x,y,xx,yy,match.tablePos[yy][xx]);
				arr.add(nMove);
			}
		}
		return arr;
	}
	public int alphaBeta(int anpha, int beta ,int depth , int type){
		int value;
		if (depth == 0) return master.Eval(type);
		int best = - Constant.INFINITY;
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		arr = InitArrayMoves(type);
		for (MoveInfo move : arr){
				if (best >= beta) break;
				if (best > anpha) anpha = best;
				tryMove(move);
				value = -alphaBeta(-beta,-anpha,depth - 1, 1 - type);
				undoMove(move);
				if (value > best) best = value;
			}
		return best;
	}
	public void thinking(int type) {
		int res = -Constant.INFINITY;
		List <MoveInfo> arr = new ArrayList<MoveInfo>();
		arr = InitArrayMoves(type);
		for (MoveInfo move : arr){
				tryMove(move);
				int value = alphaBeta(-Constant.INFINITY,Constant.INFINITY,Constant.Depth,1-type);
				undoMove(move);
				if (value > res){
					res = value;
					Match.newMove = move;
				}
			}
	}
}
