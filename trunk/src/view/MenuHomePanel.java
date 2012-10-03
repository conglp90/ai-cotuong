/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.awt.image.RescaleOp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Constant;

/**
 * @author heroandtn3
 *
 */
public class MenuHomePanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MenuPanel cardPanel;
	
	private ImageIcon imgNewGame;
	private ImageIcon imgCreateGame;
	private ImageIcon imgLoadGame;
	private ImageIcon imgExit;
	
	private JLabel lbNewGame, lbCreateGame, lbLoadGame, lbExit;
	
	/**
	 * 
	 */
	public MenuHomePanel(MenuPanel mp) {
		// TODO Auto-generated constructor stub
		setBackground(Color.GREEN);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		this.cardPanel = mp;
		loadImage();
		initLabel();
		
	}
	
	private void initLabel() {
		lbNewGame = new JLabel(imgNewGame);
		lbNewGame.addMouseListener(this);
		add(lbNewGame);
		
		lbCreateGame = new JLabel(imgCreateGame);
		lbCreateGame.addMouseListener(this);
		add(lbCreateGame);
		
		lbLoadGame = new JLabel(imgLoadGame);
		lbLoadGame.addMouseListener(this);
		add(lbLoadGame);
		
		lbExit = new JLabel(imgExit);
		lbExit.addMouseListener(this);
		add(lbExit);
	}
	
	private void loadImage() {
		imgNewGame = new ImageIcon(Constant.OPT_DIR + "/newgame.gif");
		imgCreateGame = new ImageIcon(Constant.OPT_DIR + "/creategame.gif");
		imgLoadGame = new ImageIcon(Constant.OPT_DIR + "/loadgame.gif");
		imgExit = new ImageIcon(Constant.OPT_DIR + "/exit.gif");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbNewGame) {
			cardPanel.swapPanel("NewMenu");
		} else if (source == lbCreateGame) {
			cardPanel.swapPanel("CreateMenu");
		} else if (source == lbLoadGame) {
			cardPanel.swapPanel("LoadMenu");
		} else if (source == lbExit)
			System.exit(0);
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
		if (source == lbNewGame) {
			System.out.println("New Enetered");
			BufferedImage img = toBufferedImage(imgNewGame.getImage());
			RescaleOp op = new RescaleOp(1.5f, 0, null);
			img = op.filter(img, img);
			lbNewGame.setIcon(new ImageIcon(img));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel source = (JLabel) e.getSource();
		if (source == lbNewGame) {
			System.out.println("New exited");
			lbNewGame.setIcon(imgNewGame);
		}
	}
	
	public BufferedImage toBufferedImage(Image image) {
	    if (image instanceof BufferedImage) {
	        return (BufferedImage)image;
	    }

	    // This code ensures that all the pixels in the image are loaded
	    image = new ImageIcon(image).getImage();

	    // Determine if the image has transparent pixels; for this method's
	    // implementation, see Determining If an Image Has Transparent Pixels
	    boolean hasAlpha = hasAlpha(image);

	    // Create a buffered image with a format that's compatible with the screen
	    BufferedImage bimage = null;
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    try {
	        // Determine the type of transparency of the new buffered image
	        int transparency = Transparency.OPAQUE;
	        if (hasAlpha) {
	            transparency = Transparency.BITMASK;
	        }

	        // Create the buffered image
	        GraphicsDevice gs = ge.getDefaultScreenDevice();
	        GraphicsConfiguration gc = gs.getDefaultConfiguration();
	        bimage = gc.createCompatibleImage(
	            image.getWidth(null), image.getHeight(null), transparency);
	    } catch (HeadlessException e) {
	        // The system does not have a screen
	    }

	    if (bimage == null) {
	        // Create a buffered image using the default color model
	        int type = BufferedImage.TYPE_INT_RGB;
	        if (hasAlpha) {
	            type = BufferedImage.TYPE_INT_ARGB;
	        }
	        bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
	    }

	    // Copy image to buffered image
	    Graphics g = bimage.createGraphics();

	    // Paint the image onto the buffered image
	    g.drawImage(image, 0, 0, null);
	    g.dispose();

	    return bimage;
	}
	
	 public boolean hasAlpha(Image image) {
         // If buffered image, the color model is readily available
         if (image instanceof BufferedImage) {return ((BufferedImage)image).getColorModel().hasAlpha();}
     
         // Use a pixel grabber to retrieve the image's color model;
         // grabbing a single pixel is usually sufficient
         PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
         try {pg.grabPixels();} catch (InterruptedException e) {}
     
         // Get the image's color model
         return pg.getColorModel().hasAlpha();
     }


}
