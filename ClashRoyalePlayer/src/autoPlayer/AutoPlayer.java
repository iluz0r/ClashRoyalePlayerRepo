package autoPlayer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import imageProcessing.*;

public class AutoPlayer{

	private Robot robot;
	private ImageCapturer imageCapturer;
	private ImageComparison imageComparison;
	private ImageStore imageStore;
	
	private enum Status {
		BATTLEMENU, TOURNAMENTSMENU, SOCIALMENU, SHOPMENU, 
		CARDSMENU, BATTLE, UNKNOWN
	}
	
	private Status status;
	

	private void init() throws AWTException, IOException{
		robot = new Robot();
		imageCapturer = new ImageCapturer();
		imageComparison = new ImageComparison();
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
		robot.delay(10000);
		checkStatus();
	}

	// da fare
	public void start() throws AWTException, IOException{
		this.init();
		System.out.println("Stato iniziale: " + status.toString());
		
		while(status.toString() != Status.UNKNOWN.toString()){
			switch(status.toString()){
			
				case "UNKNOWN" : break;
			
				case "BATTLEMENU" : {
					tapTournamentsButton();
					robot.delay(3000);
					checkStatus();
					System.out.println("Da BATTLEMENU a: " + status.toString());
				}
				
				case "TOURNAMENTSMENU" : {
					tapBattleMenu();
					robot.delay(3000);
					checkStatus();
					System.out.println("Da TOURNAMENTSMENU a: " + status.toString());
				}
			
			}
		}
		System.out.println("Stato Finale: " + status.toString());
		this.stop();
	}
	
	public void stop(){
		System.exit(0);
	}
	
	private void checkStatus() throws AWTException{
		
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
	}
	
	private void tap(int x, int y){
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(250);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	
	private void tapBattleButton(){
		this.tap(944, 668);
	}
	
	private void tapTournamentsButton() {
		this.tap(1173, 982);
	}
	
	private void tapFirstChest(){
		this.tap(739, 847);
	}
	
	private void tapSecondChest(){
		this.tap(873, 847);
	}
	
	private void tapThirdChest(){
		this.tap(1013, 847);
	}
	
	private void tapFourthChest(){
		this.tap(1153, 847);
	}
	
	private void tapBattleMenu(){
		this.tap(945, 975);
	}
	
}
