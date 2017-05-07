package driver;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
		ImageStore imageStore = new ImageStore(
				".\\images\\battleButton.jpg", 
				".\\images\\emptyChestSlot.jpg", 
				".\\images\\lockedSilverChestA9.jpg", 
				".\\images\\unlockingSilverChest.jpg",
				".\\images\\openSilverChest.jpg",
				".\\images\\openCrownChest.jpg",
				".\\images\\openFreeChestx1.jpg",
				".\\images\\lockedCrownChest.jpg",
				".\\images\\lockedFreeChest.jpg",
				".\\images\\lockedGoldChestA9.jpg",
				".\\images\\unlockingGoldChest.jpg",
				".\\images\\openFreeChestx2.jpg",
				".\\images\\collectingFreeChest.jpg",
				".\\images\\collectedFreeChest.jpg",
				".\\images\\collectingGoldChest.jpg",
				".\\images\\collectedGoldChest.jpg",
				".\\images\\collectingCrownChest.jpg",
				".\\images\\collectedCrownChest.jpg"); 
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
		BufferedImage image = imageCapturer.captureCollectedChest();
		imageCapturer.saveImage(image, "collectedCrownChest", "jpg");
		*/
		
		/*
		//get pointed coord
		robot.delay(10000);
		Point coord = MouseInfo.getPointerInfo().getLocation();
		System.out.println("X: " + coord.getX() + " Y: " + coord.getY());
		*/
		
		/*
		robot.delay(10000);
		BufferedImage lockedSilverChestA9 = imageStore.getLockedSilverChestA9();
		BufferedImage secondChest = imageCapturer.captureSecondChest();
		double difference = imageComparison.compare(lockedSilverChestA9, secondChest);
		System.out.println("Le immagini si differenziano del: " + difference + "%");
		*/
		
		
	}

}
