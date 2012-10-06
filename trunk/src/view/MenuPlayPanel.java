/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Constant;

/**
 * @author heroandtn3
 * 
 */
public class MenuPlayPanel extends MyPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon imgPause, imgPlay;
	JLabel lbPausePlay;

	MyLabelButton lbUndo, lbRedo, lbGoHome;

	/**
	 * 
	 */
	public MenuPlayPanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		super(mp);
		
		loadImage();
		initLabel();
		addAll();

	}

	private void addAll() {
		int mid = cardPanel.getPreferredSize().height / 50 / 2 - 1;
		setLayout(null);
		addBut(lbGoHome, 1, 0);
		addBut(lbUndo, 0, mid);
		addBut(lbPausePlay, 1, mid);
		addBut(lbRedo, 2, mid);

	}

	private void addBut(Component c, int x, int y) {
		c.setBounds(10 + x * 50, 10 + y * 50, 
					c.getPreferredSize().width, c.getPreferredSize().height);
		add(c);
	}

	private void initLabel() {
		lbUndo = new MyLabelButton(Constant.OPT_DIR + "/undo", "Undo", false);
		lbUndo.addMouseListener(this);

		lbRedo = new MyLabelButton(Constant.OPT_DIR + "/redo", "Redo", false);
		lbRedo.addMouseListener(this);

		lbPausePlay = new JLabel(imgPause);
		lbPausePlay.addMouseListener(this);

		lbGoHome = new MyLabelButton(Constant.OPT_DIR + "/home",
				"Back to Home Menu", false);
		lbGoHome.addMouseListener(this);

	}

	private void loadImage() {
		imgPause = new ImageIcon(Constant.OPT_DIR + "/pause");
		imgPlay = new ImageIcon(Constant.OPT_DIR + "/play");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbGoHome) {
			cardPanel.swapPanel("HomeMenu");
		} else if (source == lbPausePlay) {
			if (cardPanel.getMainFrame().getMatch().isPause()) {
				cardPanel.getMainFrame().getMatch().setPause(false);
				lbPausePlay.setIcon(imgPlay);
			} else {
				cardPanel.getMainFrame().getMatch().setPause(true);
				lbPausePlay.setIcon(imgPause);
			}
			cardPanel.getMainFrame().getChessBoardPanel().repaint();
		} else if (source == lbUndo) {
			System.out.println("Undo");
		} else if (source == lbRedo) {
			System.out.println("Redo");
		}
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbPausePlay) {
			source.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			source.setIcon(new ImageIcon(source.getIcon().toString() + "-hover"));

			if (cardPanel.getMainFrame().getMatch().isPause())
				source.setToolTipText("Play");
			else
				source.setToolTipText("Pause");
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbPausePlay) {
			lbPausePlay
					.setIcon(cardPanel.getMainFrame().getMatch().isPause() ? imgPlay
							: imgPause);
		}
	}

}
