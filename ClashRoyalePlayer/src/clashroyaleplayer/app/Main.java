package clashroyaleplayer.app;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import clashroyaleplayer.core.AutoPlayer;
import clashroyaleplayer.core.ImageStore;
import clashroyaleplayer.imageprocessing.ImageCapturer;
import clashroyaleplayer.imageprocessing.ImageComparison;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Robot robot = new Robot();
		
		/*
		//save image
		ImageCapturer imageCapturer = new ImageCapturer();
		robot.delay(10000);
		Rectangle captureRect = new Rectangle(791, 864, 93, 109);
		BufferedImage image = imageCapturer.captureImage(captureRect);
		imageCapturer.saveImage(image, ".\\images1920x1080\\battle\\" ,"card1", "jpg");
		*/
		
		/*
		captureRect = new Rectangle(896, 864, 93, 109);
		image = imageCapturer.captureImage(captureRect);
		imageCapturer.saveImage(image, ".\\images1920x1080\\battle\\" ,"card2", "jpg");
		
		captureRect = new Rectangle(1002, 864, 93, 109);
		image = imageCapturer.captureImage(captureRect);
		imageCapturer.saveImage(image, ".\\images1920x1080\\battle\\" ,"card3", "jpg");
		
		captureRect = new Rectangle(1107, 866, 93, 109);
		image = imageCapturer.captureImage(captureRect);
		imageCapturer.saveImage(image, ".\\images1920x1080\\battle\\" ,"card4", "jpg");
		*/
		
		/*
		//get pointed coord
		robot.delay(10000);
		Point coord = MouseInfo.getPointerInfo().getLocation();
		System.out.println("X: " + coord.getX() + " Y: " + coord.getY());
		*/
		
		/*
		AutoPlayer player = new AutoPlayer();
		player.start();
		*/
		
	}

}
