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
public class MenuLoadPanel extends MyPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String KEY = "MenuLoadPanel";

	private MyLabelButton lbBackHome;
	private MyLabelButton lbLoadLastGame;

	/**
	 * 
	 */
	public MenuLoadPanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		super(mp);

		setBackground(Color.WHITE);

		initLabel();
		addAll();
	}

	private void addAll() {
		addComponent(new JLabel("Load Game"), 0, 0, 1, 3);
		addComponent(new JLabel("Load the last saved match"), 1, 0, 1, 3);
		addComponent(lbLoadLastGame, 2, 0, 1, 3);
		addComponent(lbBackHome, 3, 0, 1, 3);
	}

	private void initLabel() {
		lbLoadLastGame = new MyLabelButton(Constant.OPT_DIR+ "/ok", "Load last saved game", false);
		lbLoadLastGame.addMouseListener(this);

		lbBackHome = new MyLabelButton(Constant.OPT_DIR+ "/back", "Back to home menu", false);
		lbBackHome.addMouseListener(this);

	}

	private void loadAndInitializeMatch() {
		Match match = new Match();
		if (!match.readeMatchFromFile("lastmap")) {
			match.readDefaultMatch();
		}
		cardPanel.swapPanel(MenuPlayPanel.KEY);
		cardPanel.getMainFrame().getChessBoardPanel().setMatch(match);
		cardPanel.getMainFrame().getChessBoardPanel().initGame();
		cardPanel.getMainFrame().getChessBoardPanel().repaint();
		cardPanel.getPlayMenu().setSlLevelValue(match.getLevel());
		if (match.isPlayWithCom()) {
			cardPanel.getPlayMenu().setLbCom(match.getLevel());
		} else {
			cardPanel.getPlayMenu().setLbCom(0);
		}
		cardPanel.getPlayMenu().setComPlaying(match.isComPlayFirst());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbLoadLastGame) {
			loadAndInitializeMatch();
		} else if (source == lbBackHome) {
			cardPanel.swapPanel(MenuHomePanel.KEY);
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
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

}
