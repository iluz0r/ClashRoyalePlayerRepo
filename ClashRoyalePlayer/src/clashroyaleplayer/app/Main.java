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
		Rectangle captureRect = new Rectangle(814, 983, 28, 20);
		BufferedImage image = imageCapturer.captureImage(captureRect);
		imageCapturer.saveImage(image, ".\\images1920x1080\\battle\\" ,"immagine", "jpg");
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
