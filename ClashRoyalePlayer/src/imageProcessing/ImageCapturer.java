package imageProcessing;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCapturer{

	private Robot robot = new Robot();
	
	public ImageCapturer() throws AWTException {
	}

	private BufferedImage captureImage(Rectangle captureRect) throws AWTException {
		
		BufferedImage bufferedImage = robot.createScreenCapture(captureRect);
		return bufferedImage;
		
	}
	
	public void saveImage(BufferedImage image, String fileName, String format) throws IOException{
		
		fileName = fileName + "." + format;
		ImageIO.write(image, format, new File("./images/" + fileName));
		
	}
	
	public BufferedImage captureFirstChest() throws AWTException{
		
		Rectangle captureRect = new Rectangle(676, 767, 123, 152);
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	public BufferedImage captureSecondChest() throws AWTException{
		
		Rectangle captureRect = new Rectangle(814, 767, 123, 152);
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	public BufferedImage captureThirdChest() throws AWTException{
		
		Rectangle captureRect = new Rectangle(952, 767, 123, 152);
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}

	public BufferedImage captureFourthChest() throws AWTException{
	
		Rectangle captureRect = new Rectangle(1090, 767, 123, 152);
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	
	}
	
	public BufferedImage captureBattleButton() throws AWTException {
		
		Rectangle captureRect = new Rectangle(831, 619, 222, 108);
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
}