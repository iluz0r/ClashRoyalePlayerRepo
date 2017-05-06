package imageProcessing;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageGetter{

	private BufferedImage getImage(Rectangle captureRect) throws AWTException {
		
		Robot robot = new Robot();
		BufferedImage bufferedImage = robot.createScreenCapture(captureRect);
		return bufferedImage;
		
	}
	
	public void saveImage(BufferedImage image, String fileName, String format) throws IOException{
		
		fileName = fileName + "." + format;
		ImageIO.write(image, format, new File("./images/" + fileName));
		
	}
	
	public BufferedImage captureFirstChest() throws AWTException{
		
		Rectangle captureRect = new Rectangle(100, 100, 100, 100);
		BufferedImage capturedImage = getImage(captureRect);
		return capturedImage;
		
	}
	
}