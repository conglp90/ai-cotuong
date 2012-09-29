package view;

import javax.swing.*;

import model.Constant;
import model.Match;
import model.chess.*;

import java.awt.*;

public class ChessBoardPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	// private static final long serialVersionUID = 1976248615976616148L;
	Match match = new Match();

	public ChessBoardPanel() {
		loadImage();
	}

	public void loadImage() {

	}

	public void paint(Graphics g) {
		drawBoard(g);
		drawChess(g);
	}

	private void drawBoard(Graphics g) {
		g.drawImage(match.imgBoard, Constant.BOARD_X, Constant.BOARD_Y,
					Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT, null);
	}

	private void drawChess(Graphics g) {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 9; j++) {
				int x = match.tablePos[i][j];
				if (x > 0) {
					g.drawImage(match.redChess[x].getShape(), 
								Constant.OX + j*Constant.length, 
								Constant.OY + i*Constant.length, 
								42, 42, null);
				} else if (x < 0)
					g.drawImage(match.blackChess[-x].getShape(),
								Constant.OX	+ j*Constant.length,
								Constant.OY + i*Constant.length,
								42, 42, null);
			}
	}

}
