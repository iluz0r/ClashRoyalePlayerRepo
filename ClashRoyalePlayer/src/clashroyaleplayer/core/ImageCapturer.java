package clashroyaleplayer.core;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class ImageCapturer extends clashroyaleplayer.imageprocessing.ImageCapturer{
	
	private AutoPlayer autoPlayer;
	
	protected ImageCapturer(AutoPlayer autoPlayer) throws Exception {
		super();
		this.autoPlayer = autoPlayer;
	}
	
	protected BufferedImage captureFirstChest() throws AWTException{
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(676, 767, 123, 152);
			break;
			
		case R_1366X768 : 
			captureRect = new Rectangle(479, 542, 87, 110);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	protected BufferedImage captureSecondChest() throws AWTException{
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(814, 767, 123, 152);
			break;
		
		case R_1366X768 : 
			captureRect = new Rectangle(575, 542, 87, 110);
			break;
		
		}
		
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	protected BufferedImage captureThirdChest() throws AWTException{
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(952, 767, 123, 152);
			break;
		
		case R_1366X768 : 
			captureRect = new Rectangle(671, 542, 87, 110);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}

	protected BufferedImage captureFourthChest() throws AWTException{
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(1090, 767, 123, 152);
			break;
		
		case R_1366X768 : 
			captureRect = new Rectangle(767, 542, 87, 110);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	
	}
	
	
	protected BufferedImage captureBattleButton() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(831, 619, 222, 108);
			break;
		
		case R_1366X768 : 
			captureRect = new Rectangle(587, 440, 157, 76);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	protected BufferedImage captureFreeChest() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(674, 174, 261, 83);
			break;
		
		case R_1366X768 : 
			captureRect = new Rectangle(478, 130, 183, 60);
			break;

		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	protected BufferedImage captureCrownChest() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(950, 175, 259, 83);
			break;
		
		case R_1366X768 : 
			captureRect = new Rectangle(668, 130, 183, 60);
			break;
			
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}
	
	protected BufferedImage captureCollectingChest() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(822, 579, 223, 166);
			break;
			
		case R_1366X768 : 
			captureRect = new Rectangle(588, 404, 143, 127);
			break;
			
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	protected BufferedImage captureCollectedChest() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(818, 267, 222, 217);
			break;
			
		case R_1366X768 : 
			captureRect = new Rectangle(580, 200, 150, 150);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureBattleMenu() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(851, 953, 182, 73);
			break;
		
		case R_1366X768 : 
			captureRect = new Rectangle(602, 661, 128, 65);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureCardsMenu() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(756, 953, 182, 73);
			break;
		
		case R_1366X768 : 
			captureRect = new Rectangle(536, 661, 128, 65);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureShopMenu() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(662, 953, 182, 73);
			break;
		
		case R_1366X768 : 
			captureRect = new Rectangle(470, 661, 128, 65);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureSocialMenu() throws AWTException {
		
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(944, 953, 182, 73);
			break;
		
		case R_1366X768 : 
			captureRect = new Rectangle(668, 661, 128, 65);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}
	
	public BufferedImage captureTournamentsMenu() throws AWTException {

		Rectangle captureRect = null;

		switch(autoPlayer.resolution){

		case R_1920X1080 : 
			captureRect = new Rectangle(1038, 953, 182, 73);
			break;

		case R_1366X768 : 
			captureRect = new Rectangle(734, 661, 128, 65);
			break;

		}

		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}

	public BufferedImage captureEmotesIcon() throws AWTException {

		Rectangle captureRect = null;

		switch(autoPlayer.resolution){

		case R_1920X1080 : 
			captureRect = new Rectangle(0, 0, 0, 0);
			break;

		case R_1366X768 : 
			captureRect = new Rectangle(485, 602, 42, 31);
			break;

		}

		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}

	public BufferedImage captureOkButton() throws AWTException {

		Rectangle captureRect = null;

		switch(autoPlayer.resolution){

		case R_1920X1080 : 
			captureRect = new Rectangle(0, 0, 0, 0);
			break;

		case R_1366X768 : 
			captureRect = new Rectangle(0, 0, 0, 0);
			break;

		}

		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}

	public BufferedImage captureRewardLimitReached() throws AWTException {

		Rectangle captureRect = null;

		switch(autoPlayer.resolution){

		case R_1920X1080 : 
			captureRect = new Rectangle(0, 0, 0, 0);
			break;

		case R_1366X768 : 
			captureRect = new Rectangle(0, 0, 0, 0);
			break;

		}

		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}

}
