/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Constant;

/**
 * @author heroandtn3
 * 
 */
public class MenuCreatePanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MenuPanel cardPanel;
	private GridBagLayout gridBag = new GridBagLayout();
	private GridBagConstraints gridBC = new GridBagConstraints();

	ImageIcon imgBackHome;

	JLabel lbBackHome;

	/**
	 * 
	 */
	public MenuCreatePanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		this.cardPanel = mp;
		setLayout(gridBag);
		gridBC.anchor = GridBagConstraints.CENTER;
		gridBC.insets = new Insets(3, 0, 3, 0);
		setBackground(Color.YELLOW);

		loadImage();
		initLabel();
		addAll();
	}

	private void addAll() {
		addComponent(new JLabel("Create Game"), 0, 0, 1, 3);
		addComponent(lbBackHome, 1, 0, 1, 3);
	}

	private void initLabel() {
		lbBackHome = new JLabel(imgBackHome);
		lbBackHome.addMouseListener(this);
	}

	private void loadImage() {
		imgBackHome = new ImageIcon(Constant.OPT_DIR + "/back");
	}

	private void addComponent(Component c, int row, int col, int nrow, int ncol) {
		// TODO Auto-generated method stub

		gridBC.gridx = col;
		gridBC.gridy = row;

		gridBC.gridwidth = ncol;
		gridBC.gridheight = nrow;

		this.gridBag.setConstraints(c, gridBC);
		this.add(c);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbBackHome) {
			cardPanel.swapPanel("HomeMenu");
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
		source.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		source.setIcon(new ImageIcon(source.getIcon().toString() + "-hover"));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbBackHome) {
			lbBackHome.setIcon(imgBackHome);
		}
	}

}
