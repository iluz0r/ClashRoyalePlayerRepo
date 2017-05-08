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
	
	private String resolution;
	private final String DEFAULT_RESOLUTION = "1920x1080";
	
	private enum Status {
		BATTLEMENU, TOURNAMENTSMENU, SOCIALMENU, SHOPMENU, 
		CARDSMENU, BATTLE, UNKNOWN
	}
	
	private Status status;
	

	private void init() throws AWTException, IOException{
		robot = new Robot();
		imageCapturer = new ImageCapturer();
		imageComparison = new ImageComparison();
		switch(resolution){
		
		case "1920x1080" : 
			imageStore = new ImageStore(
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
					".\\images" + resolution + "\\unlockingMagicChest.jpg");
		case "1366x768" : 
			imageStore = new ImageStore();
			
		default : 
			imageStore = new ImageStore();
		}
		
		robot.delay(10000);
		checkStatus();
	}

	/*
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
	*/
	
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
		switch(resolution){
		case "1920x1080" : this.tap(944, 668);
		case "1366x768" : this.tap(0, 0);
		default: break;
		}
	}
	
	private void tapTournamentsButton() {
		switch(resolution){
		case "1920x1080" : this.tap(1173, 982);
		case "1366x768" : this.tap(0, 0);
		default: break;
		}
	}
	
	private void tapFirstChest(){
		switch(resolution){
		case "1920x1080" : this.tap(739, 847);
		case "1366x768" : this.tap(0, 0);
		default: break;
		}
	}
	
	private void tapSecondChest(){
		switch(resolution){
		case "1920x1080" : this.tap(873, 847);
		case "1366x768" : this.tap(0, 0);
		default: break;
		}
	}
	
	private void tapThirdChest(){
		switch(resolution){
		case "1920x1080" : this.tap(1013, 847);
		case "1366x768" : this.tap(0, 0);
		default: break;
		}
	}
	
	private void tapFourthChest(){
		switch(resolution){
		case "1920x1080" : this.tap(1153, 847);
		case "1366x768" : this.tap(0, 0);
		default: break;
		}
	}
	
	private void tapBattleMenu(){
		switch(resolution){
		case "1920x1080" : this.tap(945, 975);
		case "1366x768" : this.tap(0, 0);
		default: break;
		}
	}
	
}
