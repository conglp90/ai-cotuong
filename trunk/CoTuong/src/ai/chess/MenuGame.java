package ai.chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuGame extends JPanel implements MouseListener, MouseMotionListener{
	/**
	 * KhanhHoa
	 */
	private int width = 800;
	private int height = 720;
	Image background;
	Image continue1, continue2,newgame1, newgame2, exit1, exit2;
	Rectangle r1, r2, r3;
	boolean atContinue;
	boolean atNewGame;
	boolean atQuit;
	public MenuGame() {
		setBackground(Color.WHITE);
		setPreferredSize( new Dimension(width, height));
		initResources();
		atContinue = false;
		atNewGame = false;
		atQuit = false;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
    }
	
	private void initResources() {
		try {
			background = new ImageIcon("src/img/background.png").getImage();
			
			continue1 = new ImageIcon("src/img/continue1.png").getImage();
			continue2 = new ImageIcon("src/img/continue2.png").getImage();
			
			newgame1 = new ImageIcon("src/img/newgame1.png").getImage();
			newgame2 = new ImageIcon("src/img/newgame2.png").getImage();
			
			exit1 = new ImageIcon("src/img/exit1.png").getImage();
			exit2 = new ImageIcon("src/img/exit2.png").getImage();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		r1 = new Rectangle(350, 220, 150, 50);
		r2 = new Rectangle(350, 300, 150, 50);
		r3 = new Rectangle(350, 380, 150, 50);
	}
	public void paint(Graphics g) {				
		g.drawImage(background, 0, 0,width,height, null);
		if (atContinue) {
			g.drawImage(continue2, 350, 220, null);			
		}
		else {
			g.drawImage(continue1, 350, 220, null);
		}
		
		if (!atNewGame) {
			g.drawImage(newgame1, 350, 300, null);			
		}
		else {
			g.drawImage(newgame2, 350, 300, null);
		}
		
		if (!atQuit) {
			g.drawImage(exit1, 350, 380, null);			
		}
		else {
			g.drawImage(exit2, 350, 380, null);
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent arg0) {
		if (atQuit) {
			GameWindow.exit();
		}
		else if (atContinue) {
			GameWindow.ContinueGame();			
		} 
		else
			if (atNewGame){
				GameWindow.NewGame();
			}
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		Point p = e.getPoint();
		Rectangle sphere = new Rectangle(p.x - 1, p.y - 1, 2, 2);
		if (sphere.intersects(r1)) {
			atContinue = true;			
		}
		else {
			atContinue = false;
		}
		if (sphere.intersects(r2)) {
			atNewGame = true;			
		}
		else {
			atNewGame= false;
		}
		if (sphere.intersects(r3)) {
			atQuit = true;			
		}
		else {
			atQuit = false;
		}
		repaint();
	}
}
