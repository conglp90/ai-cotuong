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
	private static final int TITLE_FONT_SIZE = 24;
	private static final int SUBTITLE_FONT_SIZE = 12;
	private static final int INFO_TITLE_FONT_SIZE = 15;
	private static final int INFO_FONT_SIZE = 13;
	private static final Color PANEL_COLOR = new Color(26, 33, 51);
	private static final Color PREVIEW_COLOR = new Color(36, 45, 69);
	private static final Color ACCENT_COLOR = new Color(246, 200, 95);
	private static final Color MUTED_TEXT_COLOR = new Color(196, 204, 224);

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
	private Match previewMatch;
	private boolean hasSavedMatch;

	/**
	 * 
	 */
	public MenuLoadPanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		super(mp);

		setPreferredSize(cardPanel.getPreferredSize());
		setBackground(PANEL_COLOR);

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
		configureLabel(lbTitle, new Font(Font.SANS_SERIF, Font.BOLD, TITLE_FONT_SIZE), ACCENT_COLOR);
		configureLabel(lbSubtitle, new Font(Font.SANS_SERIF, Font.PLAIN, SUBTITLE_FONT_SIZE), Color.WHITE);

		lbPreview.setOpaque(true);
		lbPreview.setBackground(PREVIEW_COLOR);
		lbPreview.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(ACCENT_COLOR, 2),
				BorderFactory.createEmptyBorder(14, 14, 14, 14)));
		lbPreview.setHorizontalAlignment(JLabel.CENTER);

		configureLabel(lbSaveState, new Font(Font.SANS_SERIF, Font.BOLD, INFO_TITLE_FONT_SIZE), ACCENT_COLOR);
		configureLabel(lbModeInfo, new Font(Font.SANS_SERIF, Font.PLAIN, INFO_FONT_SIZE), Color.WHITE);
		configureLabel(lbTurnInfo, new Font(Font.SANS_SERIF, Font.PLAIN, INFO_FONT_SIZE), Color.WHITE);
		configureLabel(lbLevelInfo, new Font(Font.SANS_SERIF, Font.PLAIN, INFO_FONT_SIZE), Color.WHITE);
		configureLabel(lbHint, new Font(Font.SANS_SERIF, Font.ITALIC, SUBTITLE_FONT_SIZE), MUTED_TEXT_COLOR);

		lbLoadLastGame = new MyLabelButton(Constant.OPT_DIR+ "/ok", "Load last saved game", false);
		lbLoadLastGame.addMouseListener(this);

		lbBackHome = new MyLabelButton(Constant.OPT_DIR+ "/back", "Back to home menu", false);
		lbBackHome.addMouseListener(this);

	}

	private void configureLabel(JLabel label, Font font, Color foreground) {
		label.setFont(font);
		label.setForeground(foreground);
		label.setHorizontalAlignment(JLabel.CENTER);
	}

	public void refreshPreviewInfo() {
		previewMatch = new Match();
		hasSavedMatch = previewMatch.readeMatchFromFile("lastmap");
		if (!hasSavedMatch) {
			previewMatch.readDefaultMatch();
		}

		lbSaveState.setText(hasSavedMatch ? "Saved match ready" : "No saved match yet");
		lbModeInfo.setText(previewMatch.isPlayWithCom() ? "Mode: Human vs Com" : "Mode: Human vs Human");
		if (previewMatch.isPlayWithCom()) {
			lbTurnInfo.setText(previewMatch.isComPlayFirst() ? "Turn: Computer" : "Turn: Human");
			lbLevelInfo.setText("Level: " + previewMatch.getLevel());
		} else {
			lbTurnInfo.setText(previewMatch.isComPlayFirst() ? "Turn: Player 2" : "Turn: Player 1");
			lbLevelInfo.setText("Level: Not used");
		}
		lbHint.setText(hasSavedMatch ? "<html><div style='text-align:center;'>Data source:<br>src/model/map/lastmap</div></html>"
				: "<html><div style='text-align:center;'>Fallback:<br>default board layout</div></html>");

		lbPreview.setIcon(createPreviewIcon(previewMatch));
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
		if (previewMatch == null) {
			refreshPreviewInfo();
		}
		cardPanel.swapPanel(MenuPlayPanel.KEY);
		cardPanel.getMainFrame().getChessBoardPanel().setMatch(previewMatch);
		cardPanel.getMainFrame().getChessBoardPanel().initGame();
		cardPanel.getMainFrame().getChessBoardPanel().repaint();
		cardPanel.getPlayMenu().setSlLevelValue(previewMatch.getLevel());
		if (previewMatch.isPlayWithCom()) {
			cardPanel.getPlayMenu().setLbCom(previewMatch.getLevel());
		} else {
			cardPanel.getPlayMenu().setLbCom(0);
		}
		cardPanel.getPlayMenu().setComPlaying(previewMatch.isComPlayFirst());
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
