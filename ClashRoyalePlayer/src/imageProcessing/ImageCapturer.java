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
	private final static String DEFAULT_RESOLUTION = "1920x1080";
	
	public ImageCapturer() throws Exception {
		this(DEFAULT_RESOLUTION);
	}

	public ImageCapturer(String screenResolution) throws Exception {
		if(screenResolution == "1920x1080" || screenResolution == "1366x768")
			this.resolution = screenResolution;
		else
			throw new Exception("Resolution mismatch");
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
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(676, 767, 123, 152);
			break;
			
		case "1366x768" : 
			captureRect = new Rectangle(479, 542, 87, 110);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	public BufferedImage captureSecondChest() throws AWTException{
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(814, 767, 123, 152);
			break;
		
		case "1366x768" : 
			captureRect = new Rectangle(575, 542, 87, 110);
			break;
		
		}
		
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	public BufferedImage captureThirdChest() throws AWTException{
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(952, 767, 123, 152);
			break;
		
		case "1366x768" : 
			captureRect = new Rectangle(671, 542, 87, 110);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}

	public BufferedImage captureFourthChest() throws AWTException{
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(1090, 767, 123, 152);
			break;
		
		case "1366x768" : 
			captureRect = new Rectangle(767, 542, 87, 110);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	
	}
	
	
	public BufferedImage captureBattleButton() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(831, 619, 222, 108);
			break;
		
		case "1366x768" : 
			captureRect = new Rectangle(587, 440, 157, 76);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	public BufferedImage captureFreeChest() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(674, 174, 261, 83);
			break;
		
		case "1366x768" : 
			captureRect = new Rectangle(478, 130, 183, 60);
			break;

		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	public BufferedImage captureCrownChest() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(950, 175, 259, 83);
			break;
		
		case "1366x768" : 
			captureRect = new Rectangle(668, 130, 183, 60);
			break;
			
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	public BufferedImage captureCollectingChest() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(822, 579, 223, 166);
			break;
			
		case "1366x768" : 
			captureRect = new Rectangle(588, 404, 143, 127);
			break;
			
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureCollectedChest() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(818, 267, 222, 217);
			break;
			
		case "1366x768" : 
			captureRect = new Rectangle(580, 200, 150, 150);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureBattleMenu() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(851, 953, 182, 73);
			break;
		
		case "1366x768" : 
			captureRect = new Rectangle(602, 661, 128, 65);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureCardsMenu() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(756, 953, 182, 73);
			break;
		
		case "1366x768" : 
			captureRect = new Rectangle(536, 661, 128, 65);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureShopMenu() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(662, 953, 182, 73);
			break;
		
		case "1366x768" : 
			captureRect = new Rectangle(470, 661, 128, 65);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureSocialMenu() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(944, 953, 182, 73);
			break;
		
		case "1366x768" : 
			captureRect = new Rectangle(668, 661, 128, 65);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureTournamentsMenu() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(resolution){
		
		case "1920x1080" : 
			captureRect = new Rectangle(1038, 953, 182, 73);
			break;
		
		case "1366x768" : 
			captureRect = new Rectangle(734, 661, 128, 65);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
}