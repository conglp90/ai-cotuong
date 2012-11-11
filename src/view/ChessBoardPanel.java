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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import control.Computer;

import model.*;

public class ChessBoardPanel extends JPanel implements MouseMotionListener,
		MouseListener {
	private int recentX = -1, recentY = -1, piece = 0, type = 0,x=-1,y=-1;
	private static final long serialVersionUID = 1L;
	private boolean selected = false, okXY = false,ok=true;
	private int hienChieu=1;
	private static MyQueue queue=new MyQueue();
	private static MyStack stack=new MyStack();
	// private boolean ok=MenuNewPanel.dichuyen;
	MainFrame mainFrame;
	private static Match match;
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
		//g.drawImage(match.imgUndo,600,600,42,42,null);
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
				g.drawImage(match.imgSelect, Constant.OX + Constant.length
						* match.getX1(), Constant.OY + Constant.length * match.getY1(), 42, 42,
						null);
				g.drawImage(match.imgSelect, Constant.OX + Constant.length
						* match.getX2(), Constant.OY + Constant.length * match.getY2(), 42, 42,
						null);
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
		//repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		x = (e.getX() - Constant.OX) / Constant.length;
		y = (e.getY() - Constant.OY) / Constant.length;
		if (!match.isComPlayFirst()&& !match.isFinish){
		// x1,y1 la toa do select dong tho li hien o sang len
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
								.getPosCanMove(current, side);
						recentX = x;
						recentY = y;
						selected = true;
					}
				} else {
					okXY = false;
					for (int count = 0; count < posCanMove.size(); count++) {
						ChessPosition pos = posCanMove.get(count);
						if ((x == pos.getCol()) && (y == pos.getRow())) {
							okXY = true;
						}
					}
					if (okXY) {
						piece = match.tablePos[y][x];
						if ((piece == 0) ||(piece * match.tablePos[recentY][recentX] < 0)) {
								if (match.tablePos[y][x]==7){
									match.setFinish(true);
									showDlgYou();//hien thong bao nguoi thang
								}
								int cuoi=match.tablePos[y][x];
								match.tablePos[y][x] = match.tablePos[recentY][recentX];
								int dau=match.tablePos[recentY][recentX];
								stack.push(new Node(recentY, recentX, y, x,dau,cuoi));
								match.tablePos[recentY][recentX] = 0;
								
								selected = false;
								match.setComPlayFirst(true);
								hienChieu=1;
						} 
						posCanMove.clear();
					} else {
						if (match.tablePos[y][x] < 0) {
							piece = match.tablePos[y][x];
							int side = 1;
							if (y <= 4)
								side = -1;
							type = 1;
							current = new ChessPosition(x, y, false);
							posCanMove = match.pieceChess[type][Math.abs(piece)]
									.getPosCanMove(current,  side);
							recentX = x;
							recentY = y;
							selected = true;
						}
	
					}
				}
				
				int a[][]=new int[9][8];
				a=match.tablePos;
				repaint();
				if (!Player.kiemtraquandenchieutuong(a)){
					if (hienChieu<2)
					showChieu();
				}
				
				
			}
		}
		repaint();
		
		// Sang Hero says: doan code nay suu tam tren mang, to cung chua hieu no lam
		// to dang doc them ve Threads trong java, hy vong se hieu :)) 
		// p/s: Computer xu li cham qua
		if (!match.isFinish())
		new Thread() {
	        public void run() {
	            SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							if (match.isComPlayFirst()){ 
								com.thinking(0);
								if (Math.abs(match.tablePos[match.newMove.getyy()][match.newMove.getxx()])==7){
									match.setFinish(true);
									showDlgCom();//hien thong bao may thang
								}
								int dau=match.tablePos[match.newMove.gety()][match.newMove.getx()];
								int cuoi=match.tablePos[match.newMove.getyy()][match.newMove.getxx()];
								match.tryMove(match.newMove);
								match.setComPlayFirst(false);
								//x1,y1,x2,y2 toa do can select khi maydi
								match.setX1(match.newMove.getx());
								match.setY1(match.newMove.gety());
								match.setX2(match.newMove.getxx());
								match.setY2(match.newMove.getyy());
								
								stack.push(new Node(match.newMove.gety(),match.newMove.getx(),match.newMove.getyy(),match.newMove.getxx(),dau,cuoi));
								int a[][]=new int[9][8];
								a=match.tablePos;
								repaint();
								if (!player.kiemtraquandochieutuong(a)){
									if (hienChieu<2)
									showChieu();
								}
								System.out.println(match.getIsUndo());
								
								hienChieu=1;
							}
						}
	                });
	        }
	    }.run();
	    // end doan code suu tam	
	}
	
	public void showUndo(){
			match.setX1(-1);
			match.setY1(-1);
			match.setX2(-1);
			match.setY2(-1);
			Node node=stack.pop();
			if(node!=null){
				System.out.println(node.getXdau()+" "+node.getYdau()+" "+node.getXcuoi()+" "+node.getYcuoi());
				match.tablePos[node.getXdau()][node.getYdau()] = node.getGtDau();
				match.tablePos[node.getXcuoi()][node.getYcuoi()] = node.getGtCuoi();
				queue.insert(new Node(node.getXdau(),node.getYdau(),node.getXcuoi(),node.getYcuoi(),node.getGtDau(),node.getGtCuoi()));
				
			}
			else System.out.println("khong con phan tu");
			Node node1=stack.pop();
			if(node1!=null){
				System.out.println(node1.getXdau()+" "+node1.getYdau()+" "+node1.getXcuoi()+" "+node1.getYcuoi());
				match.tablePos[node1.getXdau()][node1.getYdau()] = node1.getGtDau();
				match.tablePos[node1.getXcuoi()][node1.getYcuoi()] = node1.getGtCuoi();
				queue.insert(new Node(node1.getXdau(),node1.getYdau(),node1.getXcuoi(),node1.getYcuoi(),node1.getGtDau(),node1.getGtCuoi()));
			}
			else System.out.println("khong con phan tu");
	}
	public void showRedo(){
		match.setX1(-1);
		match.setY1(-1);
		match.setX2(-1);
		match.setY2(-1);
		Node node=queue.remove();
		if(node!=null){
			System.out.println(node.getXdau()+" "+node.getYdau()+" "+node.getXcuoi()+" "+node.getYcuoi());
			match.tablePos[node.getXdau()][node.getYdau()] = node.getGtDau();
			match.tablePos[node.getXcuoi()][node.getYcuoi()] = node.getGtCuoi();
			stack.push(new Node(node.getXcuoi(),node.getYcuoi(),node.getXdau(),node.getYdau(),node.getGtCuoi(),node.getGtDau()));
		}
		else System.out.println("khong con phan tu");
		Node node1=queue.remove();
		if(node1!=null){
			System.out.println(node1.getXdau()+" "+node1.getYdau()+" "+node1.getXcuoi()+" "+node1.getYcuoi());
			match.tablePos[node1.getXdau()][node1.getYdau()] = node1.getGtDau();
			match.tablePos[node1.getXcuoi()][node1.getYcuoi()] = node1.getGtCuoi();
			stack.push(new Node(node1.getXcuoi(),node1.getYcuoi(),node1.getXdau(),node1.getYdau(),node1.getGtCuoi(),node1.getGtDau()));

		}
		else System.out.println("khong con phan tu");
}
	public void showDlgYou(){
		JOptionPane.showConfirmDialog(this,"Bạn có muốn thoát Game?","You Win",
				JOptionPane.OK_OPTION);
	}
	public void showDlgCom(){
		JOptionPane.showConfirmDialog(this,"Ban Co Muon Thoat Game?","Com Win",
			JOptionPane.OK_OPTION);
	}
	public void showChieu(){
		JOptionPane.showConfirmDialog(this,"Da bi chieu","Chieu Tuong",
			JOptionPane.OK_OPTION);
		hienChieu++;
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