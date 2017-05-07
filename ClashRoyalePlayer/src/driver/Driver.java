package driver;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import autoPlayer.AutoPlayer;
import imageProcessing.ImageComparison;
import imageProcessing.ImageCapturer;
import imageProcessing.ImageStore;

public class Driver {
	
	public static void main(String[] args) throws AWTException, IOException {

		Robot robot = new Robot();
		ImageCapturer imageCapturer = new ImageCapturer();
		ImageComparison imageComparison = new ImageComparison();
		/*
		imageStore = new ImageStore(
				".\\images\\battleButton.jpg", 
				".\\images\\emptyChestSlot.jpg", 
				".\\images\\lockedSilverChest.jpg", 
				".\\images\\unlockingSilverChest.jpg",
				".\\images\\openSilverChest.jpg",
				".\\images\\openCrownChest.jpg",
				".\\images\\openFreeChestx1.jpg",
				".\\images\\lockedCrownChest.jpg",
				".\\images\\lockedFreeChest.jpg",
				".\\images\\lockedGoldChest.jpg",
				".\\images\\unlockingGoldChest.jpg",
				".\\images\\openFreeChestx2.jpg",
				".\\images\\collectingFreeChest.jpg",
				".\\images\\collectedFreeChest.jpg",
				".\\images\\collectingGoldChest.jpg",
				".\\images\\collectedGoldChest.jpg",
				".\\images\\collectingCrownChest.jpg",
				".\\images\\collectedCrownChest.jpg",
				".\\images\\battleMenu.jpg",
				".\\images\\cardsMenu.jpg",
				".\\images\\shopMenu.jpg",
				".\\images\\socialMenu.jpg",
				".\\images\\tournamentsMenu.jpg",
				".\\images\\lockedMagicChest.jpg",
				".\\images\\unlockingMagicChest.jpg"); 
		*/
		AutoPlayer player = new AutoPlayer();
		
		/*
		//compare two images
		robot.delay(10000);
		BufferedImage image1 = imageCapturer.captureFirstChest();
		BufferedImage image2 = imageCapturer.captureSecondChest();
		double difference = imageComparison.compare(image1, image2);
		System.out.println("Le immagini si differenziano del: " + difference + "%");
		*/
		
		/*
		//save image
		robot.delay(10000);
		BufferedImage image = imageCapturer.captureSecondChest();
		imageCapturer.saveImage(image, "unlockingMagicChest", "jpg");
		*/
		
		/*
		//get pointed coord
		robot.delay(10000);
		Point coord = MouseInfo.getPointerInfo().getLocation();
		System.out.println("X: " + coord.getX() + " Y: " + coord.getY());
		*/
		
		/*
		robot.delay(10000);
		BufferedImage image1 = ImageIO.read(new File(".\\images\\battleMenu.jpg"));
		BufferedImage image2 = imageCapturer.captureBattleMenu();
		double difference = imageComparison.compare(image1, image2);
		System.out.println("Le immagini si differenziano del: " + difference + "%");
		*/
		
	}

}
