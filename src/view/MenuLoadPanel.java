/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	private JLabel lbTitle = new JLabel("LOAD GAME");
	private JLabel lbSubtitle = new JLabel("<html><div style='text-align:center;'>Resume your latest saved match</div></html>");
	private JLabel lbPreview = new JLabel();
	private JLabel lbSaveState = new JLabel();
	private JLabel lbModeInfo = new JLabel();
	private JLabel lbTurnInfo = new JLabel();
	private JLabel lbLevelInfo = new JLabel();
	private JLabel lbHint = new JLabel();

	/**
	 * 
	 */
	public MenuLoadPanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		super(mp);

		setPreferredSize(cardPanel.getPreferredSize());
		setBackground(new Color(26, 33, 51));

		initLabel();
		refreshPreviewInfo();
		addAll();
	}

	private void addAll() {
		setAnchor(GridBagConstraints.CENTER);
		setInsets(new Insets(18, 10, 0, 10));
		addComponent(lbTitle, 0, 0, 1, 3);
		setInsets(new Insets(2, 10, 10, 10));
		addComponent(lbSubtitle, 1, 0, 1, 3);

		setInsets(new Insets(18, 10, 10, 10));
		addComponent(lbPreview, 2, 0, 3, 3);

		setAnchor(GridBagConstraints.CENTER);
		setInsets(new Insets(10, 18, 4, 10));
		addComponent(lbSaveState, 5, 0, 1, 3);
		addComponent(lbModeInfo, 6, 0, 1, 3);
		addComponent(lbTurnInfo, 7, 0, 1, 3);
		addComponent(lbLevelInfo, 8, 0, 1, 3);
		addComponent(lbHint, 9, 0, 1, 3);

		setAnchor(GridBagConstraints.CENTER);
		setInsets(new Insets(22, 10, 4, 10));
		addComponent(lbLoadLastGame, 10, 0, 1, 3);
		setInsets(new Insets(6, 10, 10, 10));
		addComponent(lbBackHome, 11, 0, 1, 3);
	}

	private void initLabel() {
		lbTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		lbTitle.setForeground(new Color(246, 200, 95));
		lbTitle.setHorizontalAlignment(JLabel.CENTER);

		lbSubtitle.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		lbSubtitle.setForeground(Color.WHITE);
		lbSubtitle.setHorizontalAlignment(JLabel.CENTER);

		lbPreview.setOpaque(true);
		lbPreview.setBackground(new Color(36, 45, 69));
		lbPreview.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(246, 200, 95), 2),
				BorderFactory.createEmptyBorder(14, 14, 14, 14)));
		lbPreview.setHorizontalAlignment(JLabel.CENTER);

		lbSaveState.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		lbModeInfo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
		lbTurnInfo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
		lbLevelInfo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
		lbHint.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 12));

		lbSaveState.setForeground(new Color(246, 200, 95));
		lbModeInfo.setForeground(Color.WHITE);
		lbTurnInfo.setForeground(Color.WHITE);
		lbLevelInfo.setForeground(Color.WHITE);
		lbHint.setForeground(new Color(196, 204, 224));
		lbSaveState.setHorizontalAlignment(JLabel.CENTER);
		lbModeInfo.setHorizontalAlignment(JLabel.CENTER);
		lbTurnInfo.setHorizontalAlignment(JLabel.CENTER);
		lbLevelInfo.setHorizontalAlignment(JLabel.CENTER);
		lbHint.setHorizontalAlignment(JLabel.CENTER);

		lbLoadLastGame = new MyLabelButton(Constant.OPT_DIR+ "/ok", "Load last saved game", false);
		lbLoadLastGame.addMouseListener(this);

		lbBackHome = new MyLabelButton(Constant.OPT_DIR+ "/back", "Back to home menu", false);
		lbBackHome.addMouseListener(this);

	}

	public void refreshPreviewInfo() {
		Match match = new Match();
		boolean hasSavedMatch = match.readeMatchFromFile("lastmap");
		if (!hasSavedMatch) {
			match.readDefaultMatch();
		}

		lbSaveState.setText(hasSavedMatch ? "Saved match ready" : "No saved match yet");
		lbModeInfo.setText(match.isPlayWithCom() ? "Mode: Human vs Com" : "Mode: Human vs Human");
		if (match.isPlayWithCom()) {
			lbTurnInfo.setText(match.isComPlayFirst() ? "Turn: Computer" : "Turn: Human");
			lbLevelInfo.setText("Level: " + match.getLevel());
		} else {
			lbTurnInfo.setText(match.isComPlayFirst() ? "Turn: Player 2" : "Turn: Player 1");
			lbLevelInfo.setText("Level: Not used");
		}
		lbHint.setText(hasSavedMatch ? "<html><div style='text-align:center;'>Data source:<br>src/model/map/lastmap</div></html>"
				: "<html><div style='text-align:center;'>Fallback:<br>default board layout</div></html>");

		lbPreview.setIcon(createPreviewIcon(match));
		lbLoadLastGame.setToolTipText(hasSavedMatch ? "Load last saved game" : "Load default match");
	}

	private ImageIcon createPreviewIcon(Match match) {
		if (!match.isPlayWithCom()) {
			return new ImageIcon(Constant.COM_DIR + "human.png");
		}

		if (match.getLevel() >= 6) {
			return new ImageIcon(Constant.COM_DIR + "thor.png");
		}
		if (match.getLevel() >= 4) {
			return new ImageIcon(Constant.COM_DIR + "iron.png");
		}
		return new ImageIcon(Constant.COM_DIR + "captain.png");
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
