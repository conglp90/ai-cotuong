/**
 * 
 */
package model;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.awt.image.RescaleOp;

import javax.swing.ImageIcon;

/**
 * @author heroandtn3
 *
 */
public class ImageService {

	/**
	 * 
	 */
	public ImageService() {
		// TODO Auto-generated constructor stub
	}
	
	public static ImageIcon hightlight(ImageIcon image) {
		BufferedImage img = toBufferedImage(image.getImage());
		RescaleOp op = new RescaleOp(1.3f, 0, null);
		img = op.filter(img, img);
		return (new ImageIcon(img));
	}
	
	private static BufferedImage toBufferedImage(Image image) {
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
	
	 private static boolean hasAlpha(Image image) {
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
