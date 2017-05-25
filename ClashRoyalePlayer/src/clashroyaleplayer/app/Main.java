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
import clashroyaleplayer.core.AutoPlayer.Resolution;
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
		Rectangle captureRect = new Rectangle(560, 610, 64, 79);
		BufferedImage image = imageCapturer.captureImage(captureRect);
		
		
		int j= 100;
		int k = 200;
		int l = 300;
		for(int i=0; i<100; i++){

			robot.delay(500);

			captureRect = new Rectangle(578, 693, 17, 15);
			image = imageCapturer.captureImage(captureRect);
			imageCapturer.saveImage(image, ".\\images1366x768\\test\\" ,"card" + i, "jpg");

			captureRect = new Rectangle(578, 693, 17, 15);
			image = imageCapturer.captureImage(captureRect);
			imageCapturer.saveImage(image, ".\\images1366x768\\test\\" ,"card" + j, "jpg");

			captureRect = new Rectangle(578, 693, 17, 15);
			image = imageCapturer.captureImage(captureRect);
			imageCapturer.saveImage(image, ".\\images1366x768\\test\\" ,"card" + k, "jpg");

			captureRect = new Rectangle(578, 693, 17, 15);
			image = imageCapturer.captureImage(captureRect);
			imageCapturer.saveImage(image, ".\\images1366x768\\test\\" ,"card" + l, "jpg");
			j++;
			k++;
			l++;
		}
		*/
		
		/*
		//get pointed coord
		robot.delay(10000);
		Point coord = MouseInfo.getPointerInfo().getLocation();
		System.out.println("X: " + coord.getX() + " Y: " + coord.getY());
		*/
		
	
		/*
		robot.delay(5000);
		ImageCapturer imageCapturer = new ImageCapturer();
		BufferedImage image1 = ImageIO.read(new File(".\\images1366x768\\test\\61.jpg"));
		BufferedImage image2 = ImageIO.read(new File(".\\images1366x768\\test\\6.jpg"));
		ImageComparison imageComparison = new ImageComparison();
		double difference = imageComparison.compare(image1, image2);
		System.out.println(difference);
		*/
		
		
		AutoPlayer player = new AutoPlayer();
		player.start();
		
		
		
	}

}
