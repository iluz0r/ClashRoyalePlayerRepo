package driver;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.IOException;

import imageProcessing.ImageGetter;

public class Driver {

	public static void main(String[] args) throws AWTException, IOException {

		ImageGetter imageGetter = new ImageGetter();
		
		BufferedImage firstChest = imageGetter.captureFirstChest();
		
		imageGetter.saveImage(firstChest, "immagine", "jpg");
		
	}

}
