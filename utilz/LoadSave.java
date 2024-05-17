package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	/*place here all images to access them with loadsave.variable */
    public static final String MENU_BACKGROUND="menu_background.jpg";
	public static final String LOGO="logo.png";
	public static final String MENU_BUTTONS="menu_buttons.png";
	public static final String PAUSEDOVERLAY="pausedoverlay.png";
	public static final String FIRMA="firma.png";



    public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("res/" + fileName);
		try {
			if (is != null) {
				img = ImageIO.read(is);
			} else {
				// Handle the case where the image file is not found
				System.err.println("Image file not found: " + fileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return img;
	}
}
