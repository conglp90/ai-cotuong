package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import control.Computer;

import model.*;

public class ChessBoardPanel extends JPanel implements MouseMotionListener,
		MouseListener {
	private int recentX = -1, recentY = -1, piece = 0, type = 0;
	private static final long serialVersionUID = 1L;
	private boolean selected = false, okXY = false,ok=true;
	// private boolean ok=MenuNewPanel.dichuyen;
	MainFrame mainFrame;
	Match match;
	MoveInfo newmove;
	Computer com = new Computer();
	Player player;
	ChessPosition current = null, h = null;
	List<ChessPosition> posCanMove = new ArrayList<ChessPosition>();

	public ChessBoardPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.match = this.mainFrame.getMatch();
		setBackground(Color.GREEN);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		setPreferredSize(new Dimension(Constant.BOARD_WIDTH,
				Constant.MAIN_HEIGHT));
		add(new JLabel("Chess"));
		addMouseListener(this);
		// System.out.println(ok);
	}

	@Override
	public void paint(Graphics g) {
		if (!match.isActive()) {
			drawWelcome(g);
		} else if (match.isPause()) {
			drawPauseScreen(g);
		} else {
			drawBoard(g);
			drawChess(g);
		}

	}

	private void drawPauseScreen(Graphics g) {
		g.drawImage(match.imgPause, Constant.BOARD_X, Constant.BOARD_Y,
				Constant.BOARD_WIDTH, Constant.MAIN_HEIGHT, null);
	}

	private void drawWelcome(Graphics g) {
		g.drawImage(match.imgWelcome, Constant.BOARD_X, Constant.BOARD_Y,
				Constant.BOARD_WIDTH, Constant.MAIN_HEIGHT, null);
	}

	private void drawBoard(Graphics g) {
		g.drawImage(match.imgBoard, Constant.BOARD_X, Constant.BOARD_Y,
				Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT, null);
	}

	private void drawChess(Graphics g) {
		int x = 0, i = 0, j = 0;
		for (i = 0; i < 10; i++)
			for (j = 0; j < 9; j++) {
				piece = match.tablePos[i][j];
				type = 1;
				if (piece > 0)
					type = 0;
				x = Math.abs(piece);
				if (x > 0) {
					g.drawImage(match.pieceChess[type][x].getShape(),
							Constant.OX + j * Constant.length, Constant.OY + i
									* Constant.length, 42, 42, null);
				}
			}
		for (ChessPosition h : posCanMove) {
			g.drawImage(match.imgSelect, Constant.OX + Constant.length
					* recentX, Constant.OY + Constant.length * recentY, 42, 42,
					null);
			if (h.getCanBeEaten()) {
				g.drawImage(match.imgAnduoc, Constant.OX + h.getCol()
						* Constant.length + 7, Constant.OY + h.getRow()
						* Constant.length + 7, 25, 25, null);
			} else
				g.drawImage(match.imgDiduoc, Constant.OX + h.getCol()
						* Constant.length + 7, Constant.OY + h.getRow()
						* Constant.length + 7, 25, 25, null);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int x = (e.getX() - Constant.OX) / Constant.length;
		int y = (e.getY() - Constant.OY) / Constant.length;
		// x1,y1 la toa do select dong tho li hien o sang len
		if (!Match.isFinish) {
		if (((x >= 0) && (x < 9)) && ((y >= 0) && (y < 10))) {
			if (!selected) {
				if (match.tablePos[y][x] < 0) {
					piece = match.tablePos[y][x];
					int side = 1;
					if (y <= 4)
						side = -1;
					type = 1;
					current = new ChessPosition(x, y, false);
					posCanMove = match.pieceChess[type][Math.abs(piece)]
							.getPosCanMove(current, match, side);
					recentX = x;
					recentY = y;
					selected = true;
					repaint();
				}
			} else {
				okXY = false;
				
				for (int count = 0; count < posCanMove.size(); count++) {
					ChessPosition pos = posCanMove.get(count);
					if ((x == pos.getCol()) && (y == pos.getRow())) {
						okXY = true;
					}
					posCanMove.clear();
				}
				if (okXY) {
					piece = match.tablePos[y][x];
					if ((piece == 0) ||(piece * match.tablePos[recentY][recentX] < 0)) {
							match.tablePos[y][x] = match.tablePos[recentY][recentX];
							match.tablePos[recentY][recentX] = 0;
							if (Match.tablePos[y][x] == 7) Match.isFinish = true;
							System.out.println(Match.isFinish + " " + y + " " + x);
							posCanMove.clear();
							repaint();
							selected = false;
							com.thinking(0);
							recentX = Match.newMove.getx();
							recentY = Match.newMove.gety();
							Match.tryMove(Match.newMove);
							
							repaint();
							
					} 
				} else {
					if (match.tablePos[y][x] < 0) {
						piece = match.tablePos[y][x];
						int side = 1;
						if (y <= 4)
							side = -1;
						type = 1;
						current = new ChessPosition(x, y, false);
						posCanMove = match.pieceChess[type][Math.abs(piece)]
								.getPosCanMove(current, match, side);
						recentX = x;
						recentY = y;
						selected = true;
						repaint();
					}

				}
			}
		}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
