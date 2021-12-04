package helpers;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class ImageConverter {
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
	
	public static WritableImage toWritableImage(BufferedImage image) {
        WritableImage writableImage = null;
        
        if (image != null) {
        	writableImage = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = writableImage.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }
 
        return writableImage;
	}
	
	public static WritableImage convertFromAwtToWritableImage(Image img) {
		BufferedImage image = toBufferedImage(img);
		return toWritableImage(image);
	}
}
