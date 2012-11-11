package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.chess.Advisor;
import model.chess.Bishop;
import model.chess.Cannon;
import model.chess.Chess;
import model.chess.King;
import model.chess.Knight;
import model.chess.Pawn;
import model.chess.Rook;
import control.Evaluate;
import control.Position;

public class Match {
	private Position chess[][] = new Position[2][17];
	private Chess[][] pieceChess;
	private int count[] = new int[2];
	private int status[][] = new int[13][13];
	private MoveInfo newMove;


	private int level = 0;
	private boolean finish = false;
	private boolean active = false;
	private boolean undo = false;
	private boolean pause = false;
	private int x1 = -1, x2 = -1, y1 = -1, y2 = -1;
	private boolean playWithCom = true;
	private boolean comPlayFirst = false;
	//ChessBoardPanel ches;
	/*
	 * public int tablePos[][]={{6, 4, 3, 2, 7, 2, 3, 4, 6}, {0, 0, 0, 0, 0, 0,
	 * 0, 0, 0}, {0, 5, 0, 0, 0, 0, 0, 5, 0}, {1, 0, 1, 0, 1, 0, 1, 0, 1}, {0,
	 * 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {-1, 0, -1, 0,-1,
	 * 0,-1, 0,-1}, {0, -5, 0, 0, 0, 0, 0,-5, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
	 * {-6, -4,-3,-2,-7,-2,-3,-4,-6}};
	 */

	private int tablePos[][];
	private File fi;

	public Match() {
		LoadMap();
		finish = false;
		playWithCom = true;
		comPlayFirst = false;
		pieceChess = new Chess[2][8];
		pieceChess[0][1] = new Pawn(Constant.CHESS_DIR + "/totdo.png", 0, 0); // Tot
																				// do
		pieceChess[0][2] = new Advisor(Constant.CHESS_DIR + "/sydo.png", 0, 0); // Tot
																				// do
		pieceChess[0][3] = new Bishop(Constant.CHESS_DIR + "/tinhdo.png", 0, 0); // Tot
																					// do
		pieceChess[0][4] = new Knight(Constant.CHESS_DIR + "/mado.png", 0, 0); // Tot
																				// do
		pieceChess[0][5] = new Cannon(Constant.CHESS_DIR + "/phaodo.png", 0, 0); // Tot
																					// do
		pieceChess[0][6] = new Rook(Constant.CHESS_DIR + "/xedo.png", 0, 0); // Tot
																				// do
		pieceChess[0][7] = new King(Constant.CHESS_DIR + "/tuongdo.png", 0, 0); // Tot
																				// do

		pieceChess[1][1] = new Pawn(Constant.CHESS_DIR + "/totden.png", 0, 0); // Tot
																				// do
		pieceChess[1][2] = new Advisor(Constant.CHESS_DIR + "/syden.png", 0, 0); // Tot
																					// do
		pieceChess[1][3] = new Bishop(Constant.CHESS_DIR + "/tinhden.png", 0, 0); // Tot
																					// do
		pieceChess[1][4] = new Knight(Constant.CHESS_DIR + "/maden.png", 0, 0); // Tot
																				// do
		pieceChess[1][5] = new Cannon(Constant.CHESS_DIR + "/phaoden.png", 0, 0); // Tot
																					// do
		pieceChess[1][6] = new Rook(Constant.CHESS_DIR + "/xeden.png", 0, 0); // Tot
																				// do
		pieceChess[1][7] = new King(Constant.CHESS_DIR + "/tuongden.png", 0, 0); // Tot
																					// do

	}

	

	public void LoadMap() {
		int x = 0, y = 0;
		setX1(-1);
		setY1(-1);
		setY2(-1);
		setX2(-1);
		tablePos = new int[10][9];
		fi = new File(Constant.MAP_DIR + "/map.txt");
		try {
			FileInputStream fi1 = new FileInputStream(fi);
			BufferedReader br = new BufferedReader(new InputStreamReader(fi1));
			String s = new String();
			try {
				for (y = 0; y < 10; y++) {
					s = br.readLine().trim();
					String[] B = s.split(" ");
					for (x = 0; x < 9; x++) {
						tablePos[y][x] = new Integer(B[x].trim());
					}
				}
			} catch (IOException e) {
				Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null,
						e);
			}
		} catch (IOException e) {
			Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void initChess() {
		count[0] = 0;
		count[1] = 0;
		for (int i = 0; i <= 10; i++)
			for (int j = 0; j <= 10; j++)
				status[i][j] = 0;
		for (int i = 0; i <= 9; i++)
			for (int j = 0; j <= 8; j++) {
				int piece = tablePos[i][j];
				if (piece > 0) {
					// quan phia 0--4
					count[0]++;
					status[i][j] = count[0];
					boolean passriver = false;
					if ((piece == 1) && (i >= 5))
						passriver = true;
					chess[0][count[0]] = new Position(j, i, piece, passriver,
							true);
				}
				if (piece < 0) {
					count[1]++;
					status[i][j] = count[1];
					boolean passriver = false;
					if ((piece == -1) && (i <= 4))
						passriver = true;
					chess[1][count[1]] = new Position(j, i, -piece, passriver,
							true);
				}
			}
	}

	public void tryMove(MoveInfo nmove) {
		int x = nmove.getx(), y = nmove.gety(), xx = nmove.getxx(), yy = nmove
				.getyy(), toid = nmove.gettoId(), fromid = nmove.getfromId(), piece = nmove
				.getpiece(), cur = tablePos[y][x];
		// update chess[][]
		int type = 1;
		if (cur > 0)
			type = 0;
		chess[type][fromid].setX(xx);
		chess[type][fromid].setY(yy);
		// Mark died king
		if (Math.abs(piece) == 7)
			finish = true;
		// Mark died chess
		if (piece > 0)
			chess[0][toid].setIsAlive(false);
		if (piece < 0)
			chess[1][toid].setIsAlive(false);
		// Mark pawn has passed river
		if (cur == 1 && yy >= 5)
			chess[0][status[y][x]].setIsPassed(true);
		if (cur == -1 && yy <= 4)
			chess[1][status[y][x]].setIsPassed(true);
		// update status[][]
		status[yy][xx] = fromid;
		status[y][x] = 0;
		// update tablePos[][]
		tablePos[yy][xx] = tablePos[y][x];
		tablePos[y][x] = 0;
	}

	public void undoMove(MoveInfo nmove) {
		int x = nmove.getx(), y = nmove.gety(), xx = nmove.getxx(), yy = nmove
				.getyy(), piece = nmove.getpiece(), fromid = nmove.getfromId(), toid = nmove
				.gettoId(), cur = tablePos[yy][xx];
		if (Math.abs(piece) == 7)
			finish = false;
		// update chess
		// update alive attribute
		if (cur > 0) {
			chess[0][fromid].setX(x);
			chess[0][fromid].setY(y);
		} else {
			chess[1][fromid].setX(x);
			chess[1][fromid].setY(y);
		}

		if (piece > 0) {
			chess[0][toid].setIsAlive(true);
			chess[0][toid].setX(xx);
			chess[0][toid].setY(yy);

		} else if (piece < 0) {
			chess[1][toid].setIsAlive(true);
			chess[1][toid].setX(xx);
			chess[1][toid].setY(yy);
		}
		// update passriver
		if (cur == 1 && y <= 4)
			chess[0][fromid].setIsPassed(false);
		if (cur == -1 && y >= 5)
			chess[1][fromid].setIsPassed(false);
		// update status[][]
		status[y][x] = fromid;
		status[yy][xx] = toid;
		// update tablePos[][]
		tablePos[y][x] = tablePos[yy][xx];
		tablePos[yy][xx] = piece;
	}

	public boolean isCheck(int type) {
		return false;
	}

	/**
	 * codevui IT4: Là tổng hợp các nước đi 
	 * codevui IT4: được sắp xếp theo một thứ tự ưu tiên nhất định 
	 * codevui IT4: type là loại quân sẽ đi
	 * codevui IT4: type = 0 ;à bên máy
	 * codevui IT4: type =1 là bên người
	 * @param match
	 * @param type
	 * @return
	 */
	public List<MoveInfo> GetOrderedMoves(Match match, int type) {
		Evaluate master = new Evaluate();
		int piece, x, y;
		ChessPosition current;
		List<MoveInfo> arr = new ArrayList<MoveInfo>();
		List<ChessPosition> posCanMove = new ArrayList<ChessPosition>();

		for (int i = 1; i <= count[type]; i++) {
			if (chess[type][i].getIsAlive()) {
				piece = chess[type][i].getPiece();
				x = chess[type][i].getX();
				y = chess[type][i].getY();
				// System.out.println(x+" "+y+" "+status[y][x]);
				current = new ChessPosition(x, y, false);
				posCanMove = pieceChess[type][piece].getPosCanMove(match, current,
						type);
				for (ChessPosition pos : posCanMove) {
					int fromid = status[y][x];
					int yy = pos.getRow();
					int xx = pos.getCol();
					int toid = status[yy][xx];
					int pi = tablePos[yy][xx];
					MoveInfo nMove = new MoveInfo(x, y, xx, yy, pi, fromid,
							toid);
					tryMove(nMove);
					nMove.setCost(master.Eval(match));
					undoMove(nMove);
					/*
					 * Chen nMove vao vi tri trong mang arr, sap xep giam dan
					 */
					int first = 0;
					int last = arr.size() - 1;
					int mid = 0;
					while (first < last) {
						mid = (first + last) / 2;
						MoveInfo tmp;
						tmp = arr.get(mid);
						if (tmp.getCost() <= nMove.getCost())
							last = mid - 1;
						if (tmp.getCost() > nMove.getCost())
							first = mid + 1;
					}
					arr.add(mid, nMove);

				}

			}
		}

		return arr;
	}
	
	public boolean isPlayWithCom() {
		return this.playWithCom;
	}

	public void setPLayWithCom(boolean status) {
		this.playWithCom = status;
	}

	public boolean isComPlayFirst() {
		return this.comPlayFirst;
	}

	public void setComPlayFirst(boolean status) {
		this.comPlayFirst = status;
	}

	public void setActive(boolean status) {
		this.active = status;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setPause(boolean status) {
		this.pause = status;
	}

	public void setIsUndo(boolean undo) {
		this.undo = undo;
	}

	public boolean getUndo() {
		return this.undo;
	}

	public boolean isPause() {
		return this.pause;
	}

	public boolean isFinish() {
		return this.finish;
	}

	public void setFinish(boolean status) {
		this.finish = status;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int num) {
		this.level = num;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX1() {
		return x1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY1() {
		return y1;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getX2() {
		return x2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getY2() {
		return y2;
	}

	/**
	 * @return the newMove
	 */
	public MoveInfo getNewMove() {
		return newMove;
	}

	/**
	 * @param newMove the newMove to set
	 */
	public void setNewMove(MoveInfo newMove) {
		this.newMove = newMove;
	}



	/**
	 * @return the pieceChess
	 */
	public Chess[][] getPieceChess() {
		return pieceChess;
	}



	/**
	 * @param pieceChess the pieceChess to set
	 */
	public void setPieceChess(Chess[][] pieceChess) {
		this.pieceChess = pieceChess;
	}



	/**
	 * @return the tablePos
	 */
	public int[][] getTablePos() {
		return tablePos;
	}



	/**
	 * @param tablePos the tablePos to set
	 */
	public void setTablePos(int[][] tablePos) {
		this.tablePos = tablePos;
	}



	/**
	 * @return the count
	 */
	public int[] getCount() {
		return count;
	}



	/**
	 * @param count the count to set
	 */
	public void setCount(int[] count) {
		this.count = count;
	}



	/**
	 * @return the chess
	 */
	public Position[][] getChess() {
		return chess;
	}



	/**
	 * @param chess the chess to set
	 */
	public void setChess(Position[][] chess) {
		this.chess = chess;
	}



	/**
	 * @return the status
	 */
	public int[][] getStatus() {
		return status;
	}



	/**
	 * @param status the status to set
	 */
	public void setStatus(int[][] status) {
		this.status = status;
	}



	/**
	 * @return the fi
	 */
	public File getFi() {
		return fi;
	}



	/**
	 * @param fi the fi to set
	 */
	public void setFi(File fi) {
		this.fi = fi;
	}



	/**
	 * @param undo the undo to set
	 */
	public void setUndo(boolean undo) {
		this.undo = undo;
	}



	/**
	 * @param playWithCom the playWithCom to set
	 */
	public void setPlayWithCom(boolean playWithCom) {
		this.playWithCom = playWithCom;
	}
}
