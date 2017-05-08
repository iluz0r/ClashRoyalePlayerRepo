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
	
	private String resolution;
	private final String DEFAULT_RESOLUTION = "1920x1080";
	
	public ImageCapturer() throws AWTException {
		resolution = DEFAULT_RESOLUTION;
	}

	public ImageCapturer(String screenResolution) throws Exception {
		if(screenResolution == "1920x1080" || screenResolution == "1366x768")
			this.resolution = screenResolution;
		else
			throw new Exception("Risoluzione non gestita");
	}
	
	private BufferedImage captureImage(Rectangle captureRect) throws AWTException {
		
		BufferedImage bufferedImage = robot.createScreenCapture(captureRect);
		return bufferedImage;
		
	}
	
	public void saveImage(BufferedImage image, String fileName, String format) throws IOException{
		
		fileName = fileName + "." + format;
		ImageIO.write(image, format, new File("./images" + resolution + "/" + fileName));
		
	}
	
	public BufferedImage captureFirstChest() throws AWTException{
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(676, 767, 123, 152);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	public BufferedImage captureSecondChest() throws AWTException{
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(814, 767, 123, 152);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	public BufferedImage captureThirdChest() throws AWTException{
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(952, 767, 123, 152);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}

	public BufferedImage captureFourthChest() throws AWTException{
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(1090, 767, 123, 152);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	
	}
	
	public BufferedImage captureBattleButton() throws AWTException {
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(831, 619, 222, 108);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	public BufferedImage captureFreeChest() throws AWTException {
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(674, 174, 261, 83);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	//a
	public BufferedImage captureCrownChest() throws AWTException {
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(950, 175, 259, 83);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	public BufferedImage captureCollectingChest() throws AWTException {
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(822, 579, 223, 166);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureCollectedChest() throws AWTException {
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(818, 267, 222, 217);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureBattleMenu() throws AWTException {
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(851, 953, 182, 73);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureCardsMenu() throws AWTException {
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(756, 953, 182, 73);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureShopMenu() throws AWTException {
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(662, 953, 182, 73);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureSocialMenu() throws AWTException {
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(944, 953, 182, 73);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureTournamentsMenu() throws AWTException {
		
		Rectangle captureRect;
		
		switch(resolution){
		
		case "1920x1080" : captureRect = new Rectangle(1038, 953, 182, 73);
		
		case "1366x768" : captureRect = new Rectangle(0, 0, 0, 0);

		default : captureRect = new Rectangle(0, 0, 0, 0);
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
}