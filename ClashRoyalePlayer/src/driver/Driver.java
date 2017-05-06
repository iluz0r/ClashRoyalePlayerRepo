package driver;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;

import imageProcessing.ImageComparison;
import imageProcessing.ImageGetter;

public class Driver {

	public static void main(String[] args) throws AWTException, IOException {

		Robot robot = new Robot();
		ImageGetter imageGetter = new ImageGetter();
		ImageComparison imageComparison = new ImageComparison();
		
		/*
		//compare two images
		robot.delay(10000);
		BufferedImage image1 = imageGetter.captureFirstChest();
		BufferedImage image2 = imageGetter.captureSecondChest();
		double difference = imageComparison.compare(image1, image2);
		System.out.println("Le immagini si differenziano del: " + difference + "%");
		*/
		
		/*
		robot.delay(10000);
		//save first chest
		BufferedImage firstChest = imageGetter.captureFirstChest();
		imageGetter.saveImage(firstChest, "firstChest", "jpg");
		*/
		
		/*
		//get pointed coord
		robot.delay(10000);
		Point coord = MouseInfo.getPointerInfo().getLocation();
		System.out.println("X: " + coord.getX() + " Y: " + coord.getY());
		*/
		
		
		
	}

}
