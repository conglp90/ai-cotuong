package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ChessPosition;
import model.Constant;
import model.Match;
import model.chess.Rook;


public class ChessBoardPanel extends JPanel implements MouseMotionListener,MouseListener{
	/**
	 * 
	 */
	private int x1=-1,y1=-1;
	//private 
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private boolean ok=true,ok1=true;
	MainFrame mainFrame;
	Match match;
	ChessPosition current = null,h=null;
	List <ChessPosition> pos = new ArrayList<ChessPosition>();
	
	public ChessBoardPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.match = this.mainFrame.getMatch();
		setBackground(Color.GREEN);
		setPreferredSize(new Dimension(Constant.BOARD_WIDTH, Constant.MAIN_HEIGHT));
		add(new JLabel("Chess"));
		addMouseListener(this);
	}
	@Override
	public void paint(Graphics g) {
		if (match.isActive()) {
			drawBoard(g);
			drawChess(g);
		} else {
			drawWelcome(g);
		}
		
	}
	
	private void drawWelcome(Graphics g) {
		g.drawImage(match.imgWelcome, Constant.BOARD_X, Constant.BOARD_Y,
				Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT, null);
	}

	private void drawBoard(Graphics g) {
		g.drawImage(match.imgBoard, Constant.BOARD_X, Constant.BOARD_Y,
					Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT, null);
	}

	private void drawChess(Graphics g) {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 9; j++) {
				int x = match.tablePos[i][j];
				for (int i1=0;i1<pos.size();i1++){
					h=pos.get(i1);
					g.drawImage(match.imgDiduoc,
							Constant.OX	+ h.getCol()*Constant.length+5,
							Constant.OY + h.getRow()*Constant.length+5,
							30, 30, null);
				}
				if (j==x1&&i==y1){
					g.drawImage(match.imgSelect,
							Constant.OX+j*Constant.length,
							Constant.OY+i*Constant.length,42,42,null);
				}
				if (x > 0) {
					g.drawImage(match.redChess[x].getShape(), 
								Constant.OX + j*Constant.length, 
								Constant.OY + i*Constant.length, 
								42, 42, null);
				} else 
					if (x < 0)
					g.drawImage(match.blackChess[-x].getShape(),
								Constant.OX	+ j*Constant.length,
								Constant.OY + i*Constant.length,
								42, 42, null);
			}
		repaint();	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x=(e.getX()-Constant.OX)/Constant.length;
		int y=(e.getY()-Constant.OY)/Constant.length;
		int i2=0;
		//x1,y1 la toa do select dong tho li hien o sang len
		if (ok && (x>=0)&&(x<9)&&(y>=0)&&(y<10)&&(match.tablePos[y][x]!=0)){
			x1=x;
			y1=y;
			int table=Math.abs(match.tablePos[y][x]);
			current=new ChessPosition(x,y,false);
			pos=match.redChess[table].getPosCanMove(current, match);
			ok=false;
		}
		if (ok && (x>=0)&&(x<9)&&(y>=0)&&(y<10)&&(match.tablePos[y][x]==0)){
				x1=-1;
				y1=-1;
				ok=true;
		}
		//kiem tra co an quan khong 
		for (int i1=0;i1<pos.size();i1++){
			h=pos.get(i1);
			int y2=h.getRow();
			int x2=h.getCol();
			if (x1>=0&&y1>=0&&match.tablePos[y2][x2]!=0 && x2==x&& y2==y){
				match.tablePos[y2][x2]=match.tablePos[y1][x1];
				match.tablePos[y1][x1]=0;
				pos.clear();
				x1=-1;
				y1=-1;
				ok=true;
				break;
			}
		} 
		//chi cho di vao nhung o sang
		if (!ok&&x>=0&&x<9&& y>=0&&y<10&&match.tablePos[y][x]==0&&x1>=0&&y1>=0){
			for (int i1=0;i1<pos.size();i1++){
				h=pos.get(i1);
				int y2=h.getRow();
				int x2=h.getCol();
				if (x1>=0&&y1>=0&&x==x2 &&y==y2){
					match.tablePos[y][x]=match.tablePos[y1][x1];
					match.tablePos[y1][x1]=0;
					ok=true;
					x1=-1;
					y1=-1;
				}
			}
			pos.clear();
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
