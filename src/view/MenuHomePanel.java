/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import model.Constant;
import model.Match;

/**
 * @author heroandtn3
 * 
 */
public class MenuHomePanel extends MyPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MyLabelButton lbNewGame, lbCreateGame, lbLoadGame, lbExit,
			lbCancel, lbOk;
	private JLabel lbWarn;
	private Match match=null;

	/**
	 * 
	 */
	public MenuHomePanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		super(mp);
		setBackground(Color.GREEN);
		setPreferredSize(cardPanel.getPreferredSize());

		initLabel();
		addAll();
	}

	private void addAll() {
		addComponent(lbNewGame, 0, 0, 1, 3);
		addComponent(lbCreateGame, 1, 0, 1, 3);
		addComponent(lbLoadGame, 2, 0, 1, 3);
		addComponent(lbExit, 3, 0, 1, 3);
		addComponent(lbWarn, 5, 0, 1, 3);
		addComponent(lbCancel, 6, 0, 1, 1);
		addComponent(lbOk, 6, 2, 1, 1);
	}

	private void setWarnVisible(boolean status) {
		lbWarn.setVisible(status);
		lbCancel.setVisible(status);
		lbOk.setVisible(status);
	}

	private void initLabel() {

		lbNewGame = new MyLabelButton(Constant.OPT_DIR+ "/newgame.gif", "Play new game", true);
		lbNewGame.addMouseListener(this);

		lbCreateGame = new MyLabelButton(Constant.OPT_DIR+ "/creategame.gif", "Create a game", true);
		lbCreateGame.addMouseListener(this);

		lbLoadGame = new MyLabelButton(Constant.OPT_DIR+ "/loadgame.gif", "Load a game", true);
		lbLoadGame.addMouseListener(this);

		lbExit = new MyLabelButton(Constant.OPT_DIR+ "/exit.gif", "Exit game", true);
		lbExit.addMouseListener(this);

		lbWarn = new JLabel("Are you want to exit?");

		lbCancel = new MyLabelButton(Constant.OPT_DIR+ "/cancel", "No, back to game",  false);
		lbCancel.addMouseListener(this);

		lbOk = new MyLabelButton(Constant.OPT_DIR+ "/ok", "Yes, I want to quit",  false);
		lbOk.addMouseListener(this);
		setWarnVisible(false);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbNewGame) {
			cardPanel.swapPanel("NewMenu");
			MenuNewPanel mn=new MenuNewPanel(cardPanel);
		} else if (source == lbCreateGame) {
			cardPanel.swapPanel("CreateMenu");
		} else if (source == lbLoadGame) {
			cardPanel.swapPanel("LoadMenu");
		} else if (source == lbExit) {
			setWarnVisible(true);
		} else if (source == lbCancel) {
			setWarnVisible(false);
		} else if (source == lbOk) {
			System.exit(0);
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
;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
