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
		
		/*
		//compare two images
		String resolution = "1920x1080";
		ImageStore imageStore = new ImageStore(
					".\\images" + resolution + "\\battleButton.jpg", 
					".\\images" + resolution + "\\emptyChestSlot.jpg", 
					".\\images" + resolution + "\\lockedSilverChest.jpg", 
					".\\images" + resolution + "\\unlockingSilverChest.jpg",
					".\\images" + resolution + "\\openSilverChest.jpg",
					".\\images" + resolution + "\\openCrownChest.jpg",
					".\\images" + resolution + "\\openFreeChestx1.jpg",
					".\\images" + resolution + "\\lockedCrownChest.jpg",
					".\\images" + resolution + "\\lockedFreeChest.jpg",
					".\\images" + resolution + "\\lockedGoldChest.jpg",
					".\\images" + resolution + "\\unlockingGoldChest.jpg",
					".\\images" + resolution + "\\openFreeChestx2.jpg",
					".\\images" + resolution + "\\collectingFreeChest.jpg",
					".\\images" + resolution + "\\collectedFreeChest.jpg",
					".\\images" + resolution + "\\collectingGoldChest.jpg",
					".\\images" + resolution + "\\collectedGoldChest.jpg",
					".\\images" + resolution + "\\collectingCrownChest.jpg",
					".\\images" + resolution + "\\collectedCrownChest.jpg",
					".\\images" + resolution + "\\battleMenu.jpg",
					".\\images" + resolution + "\\cardsMenu.jpg",
					".\\images" + resolution + "\\shopMenu.jpg",
					".\\images" + resolution + "\\socialMenu.jpg",
					".\\images" + resolution + "\\tournamentsMenu.jpg",
					".\\images" + resolution + "\\lockedMagicChest.jpg",
					".\\images" + resolution + "\\unlockingMagicChest.jpg",
					".\\images" + resolution + "\\openGoldChest.jpg",
					".\\images" + resolution + "\\openMagicChest.jpg",
					".\\images" + resolution + "\\collectingMagicChest.jpg",
					".\\images" + resolution + "\\collectedMagicChest.jpg",
					".\\images" + resolution + "\\collectingSilverChest.jpg",
					".\\images" + resolution + "\\collectedSilverChest.jpg");
		Robot robot = new Robot();
		ImageCapturer imageCapturer = new ImageCapturer();
		ImageComparison imageComparison = new ImageComparison();
		robot.delay(3000);
		BufferedImage image1 = imageCapturer.captureCollectingChest();
		BufferedImage image2 = imageStore.getCollectingFreeChest();
		double difference = imageComparison.compare(image1, image2);
		System.out.println("Le immagini si differenziano del: " + difference + "%");
		*/
		
		/*
		//save image
		Robot robot = new Robot();
		ImageCapturer imageCapturer = new ImageCapturer();
		robot.delay(10000);
		Rectangle captureRect = new Rectangle(775, 390, 120, 96);
		BufferedImage image = imageCapturer.captureImage(captureRect);
		imageCapturer.saveImage(image, ".\\images1366x768\\" ,"rewardLimitReachedMini", "jpg");
		*/
		
		/*
		//get pointed coord
		Robot robot = new Robot();
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
		
		/*
		//check status
		robot.delay(000);
		BufferedImage capturedBattleMenu = imageCapturer.captureBattleMenu();
		BufferedImage capturedTournamentsMenu = imageCapturer.captureTournamentsMenu();
		BufferedImage capturedSocialMenu = imageCapturer.captureSocialMenu();
		BufferedImage capturedShopMenu = imageCapturer.captureShopMenu();
		BufferedImage capturedCardsMenu = imageCapturer.captureCardsMenu();
		
		BufferedImage battleMenu = imageStore.getBattleMenu();
		BufferedImage tournamentsMenu = imageStore.getTournamentsMenu();
		BufferedImage socialMenu = imageStore.getSocialMenu();
		BufferedImage shopMenu = imageStore.getShopMenu();
		BufferedImage cardsMenu = imageStore.getCardsMenu();
		
		Status status;
		
		if (imageComparison.imgEqual(battleMenu, capturedBattleMenu)) status = Status.BATTLEMENU;
		else
			if(imageComparison.imgEqual(shopMenu, capturedShopMenu)) status = Status.SHOPMENU;
			else
				if(imageComparison.imgEqual(socialMenu, capturedSocialMenu)) status = Status.SOCIALMENU;
				else
					if(imageComparison.imgEqual(tournamentsMenu, capturedTournamentsMenu)) status = Status.TOURNAMENTSMENU;
					else
						if(imageComparison.imgEqual(cardsMenu, capturedCardsMenu)) status = Status.CARDSMENU;
						else
							status = Status.UNKNOWN;
		
		System.out.println("Lo stato in cui siamo è: " + status.toString() + "\n");
		*/
		
		/*
		AutoPlayer player = new AutoPlayer();
		player.start();
		*/
		
	}

}
