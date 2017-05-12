package clashroyaleplayer.imageprocessing;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCapturer{

	private Robot robot = new Robot();
	
	public ImageCapturer() throws AWTException{
		
	}
	
	public BufferedImage captureImage(Rectangle captureRect) throws AWTException {
		
		BufferedImage bufferedImage = robot.createScreenCapture(captureRect);
		return bufferedImage;
		
	}
	
	public void saveImage(BufferedImage image, String basePath, String fileName, String format) throws IOException{
		
		fileName = fileName + "." + format;
		ImageIO.write(image, format, new File(basePath + fileName));
		
	}
	
}