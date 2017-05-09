package autoPlayer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import imageProcessing.*;

public class AutoPlayer{

	private Robot robot;
	private ImageCapturer imageCapturer;
	private ImageComparison imageComparison;
	private ImageStore imageStore;
	
	private String resolution;
	private final String DEFAULT_RESOLUTION = "1920x1080";
	
	private String log = "";
	private PrintStream writeLog;
	
	private enum GameStatus {
		BATTLE_MENU, TOURNAMENTS_MENU, SOCIAL_MENU, SHOP_MENU, 
		CARDS_MENU, BATTLE, COLLECTING_CHEST, COLLECTED_CHEST, UNKNOWN
	}
	
	private enum ChestStatus {
		UNLOCKING, UNLOCKABLE, LOCKED, EMPTY, UNKNOWN
	}
	
	private enum CollectingStatus{
		COLLECTING, COLLECTED, UNKNOWN
	}
	
	private GameStatus gameStatus;
	private ChestStatus firstChestStatus;
	private ChestStatus secondChestStatus;
	private ChestStatus thirdChestStatus;
	private ChestStatus fourthChestStatus;
	private ChestStatus freeChestStatus;
	private ChestStatus crownChestStatus;
	private CollectingStatus collectingStatus;
	
	public AutoPlayer(String screenResolution) throws Exception{
		if(screenResolution == "1920x1080" || screenResolution == "1366x768")
			this.resolution = screenResolution;
		else
			throw new Exception("Resolution mismatch");
		
		log += "ScreenResolution: " + resolution + "\n";
	}
	
	public AutoPlayer(){
		resolution = DEFAULT_RESOLUTION;
	}

	private void init() throws Exception{
		robot = new Robot();
		imageCapturer = new ImageCapturer(resolution);
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
					".\\images" + resolution + "\\unlockingMagicChest.jpg",
					".\\images" + resolution + "\\openGoldChest.jpg",
					".\\images" + resolution + "\\openMagicChest.jpg",
					".\\images" + resolution + "\\collectingMagicChest.jpg",
					".\\images" + resolution + "\\collectedMagicChest.jpg",
					".\\images" + resolution + "\\collectingSilverChest.jpg",
					".\\images" + resolution + "\\collectedSilverChest.jpg");
			break;
		case "1366x768" : 
			imageStore = new ImageStore();
			break;

		}
		
		robot.delay(10000);
		pointOutside();
		checkGameStatus();
	}

	
	public void start() throws Exception{
		this.init();
		log += "Initial state: " + gameStatus.toString() + ";\n";
		
		while(gameStatus != GameStatus.UNKNOWN){
			pointOutside();
			checkGameStatus();
			switch(gameStatus.toString()){
			
				case "UNKNOWN" : break;
			
				case "BATTLE_MENU" : {
					checkFirstChestStatus();
					checkSecondChestStatus();
					checkThirdChestStatus();
					checkFourthChestStatus();
					checkFreeChestStatus();
					checkCrownChestStatus();
					
					if(firstChestStatus == ChestStatus.UNLOCKABLE){
						openFirstChest();
						break;
					}
					if(secondChestStatus == ChestStatus.UNLOCKABLE){
						openSecondChest();
						break;
					}
					if(thirdChestStatus == ChestStatus.UNLOCKABLE){
						openThirdChest();
						break;
					}
					if(fourthChestStatus == ChestStatus.UNLOCKABLE){
						openFourthChest();
						break;
					}
					if(freeChestStatus == ChestStatus.UNLOCKABLE){
						openFreeChest();
						break;
					}
					if(crownChestStatus == ChestStatus.UNLOCKABLE){
						openCrownChest();
						break;
					}
					
					robot.delay(3000);
					checkGameStatus();
					break;
				}
				
				case "TOURNAMENTS_MENU" : {
					switchMenu("BATTLE_MENU");
					break;
				}
				
				case "SOCIAL_MENU" : {
					switchMenu("BATTLE_MENU");
					break;
				}
				
				case "SHOP_MENU" : {
					switchMenu("BATTLE_MENU");
					break;
				}
				
				case "CARDS_MENU" : {
					switchMenu("BATTLE_MENU");
					break;
				}
			
			}
		}
		log += "Final state: " + gameStatus.toString() + ";\n";
		this.stop();
	}
	
	
	public void stop() throws IOException{
		String path = ".\\log.txt";
		FileOutputStream logFile = new FileOutputStream(path);
        writeLog = new PrintStream(logFile);
        writeLog.print(log);
		System.out.println(log);

		System.exit(0);
	}
	
	private void checkGameStatus() throws AWTException{
		
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
		
		if (imageComparison.imgEqual(battleMenu, capturedBattleMenu, 3)) 
			gameStatus = GameStatus.BATTLE_MENU;
		else
			if(imageComparison.imgEqual(shopMenu, capturedShopMenu, 3)) 
				gameStatus = GameStatus.SHOP_MENU;
			else
				if(imageComparison.imgEqual(socialMenu, capturedSocialMenu, 3)) 
					gameStatus = GameStatus.SOCIAL_MENU;
				else
					if(imageComparison.imgEqual(tournamentsMenu, capturedTournamentsMenu, 3)) 
						gameStatus = GameStatus.TOURNAMENTS_MENU;
					else
						if(imageComparison.imgEqual(cardsMenu, capturedCardsMenu, 3)) 
							gameStatus = GameStatus.CARDS_MENU;
						else
							gameStatus = GameStatus.UNKNOWN;
		log += "Action: check gameStatus, game state: " + gameStatus.toString() + ";\n";
	}
	
	private void checkFirstChestStatus() throws AWTException{
		
		firstChestStatus = ChestStatus.UNKNOWN;
		
		BufferedImage lockedSilverChest = imageStore.getLockedSilverChest();
		BufferedImage unlockingSilverChest = imageStore.getUnlockingSilverChest();
		BufferedImage openSilverChest = imageStore.getOpenSilverChest();
		BufferedImage lockedGoldChest = imageStore.getLockedGoldChest();
		BufferedImage unlockingGoldChest = imageStore.getUnlockingGoldChest();
		BufferedImage openGoldChest = imageStore.getOpenGoldChest();
		BufferedImage lockedMagicChest = imageStore.getLockedMagicChest();
		BufferedImage unlockingMagicChest = imageStore.getUnlockingMagicChest();
		BufferedImage openMagicChest = imageStore.getOpenMagicChest();
		BufferedImage emptyChest = imageStore.getEmptyChestSlot();
		
		BufferedImage capturedFirstChest = imageCapturer.captureFirstChest();
		
		if(
				imageComparison.imgEqual(lockedSilverChest, capturedFirstChest, 10) ||
				imageComparison.imgEqual(lockedGoldChest, capturedFirstChest, 10) ||
				imageComparison.imgEqual(lockedMagicChest, capturedFirstChest, 10)) 
			firstChestStatus = ChestStatus.LOCKED;
		else
			if(
					imageComparison.imgEqual(unlockingSilverChest, capturedFirstChest, 10) ||
					imageComparison.imgEqual(unlockingGoldChest, capturedFirstChest, 10) ||
					imageComparison.imgEqual(unlockingMagicChest, capturedFirstChest, 10))
				firstChestStatus = ChestStatus.UNLOCKING;
			else
				if(
						imageComparison.imgEqual(openSilverChest, capturedFirstChest, 10) ||
						imageComparison.imgEqual(openGoldChest, capturedFirstChest, 10) ||
						imageComparison.imgEqual(openMagicChest, capturedFirstChest, 10))
					firstChestStatus = ChestStatus.UNLOCKABLE;
				else
					if(imageComparison.imgEqual(emptyChest, capturedFirstChest, 10))
						firstChestStatus = ChestStatus.EMPTY;
		
		log += "Action: checkFirstChestStatus, the state is " + firstChestStatus.toString() + ";\n";
	}
	
	private void checkSecondChestStatus() throws AWTException{
		
		secondChestStatus = ChestStatus.UNKNOWN;
		
		BufferedImage lockedSilverChest = imageStore.getLockedSilverChest();
		BufferedImage unlockingSilverChest = imageStore.getUnlockingSilverChest();
		BufferedImage openSilverChest = imageStore.getOpenSilverChest();
		BufferedImage lockedGoldChest = imageStore.getLockedGoldChest();
		BufferedImage unlockingGoldChest = imageStore.getUnlockingGoldChest();
		BufferedImage openGoldChest = imageStore.getOpenGoldChest();
		BufferedImage lockedMagicChest = imageStore.getLockedMagicChest();
		BufferedImage unlockingMagicChest = imageStore.getUnlockingMagicChest();
		BufferedImage openMagicChest = imageStore.getOpenMagicChest();
		BufferedImage emptyChest = imageStore.getEmptyChestSlot();
		
		BufferedImage capturedSecondChest = imageCapturer.captureSecondChest();
		
		if(
				imageComparison.imgEqual(lockedSilverChest, capturedSecondChest, 10) ||
				imageComparison.imgEqual(lockedGoldChest, capturedSecondChest, 10) ||
				imageComparison.imgEqual(lockedMagicChest, capturedSecondChest, 10)) 
			secondChestStatus = ChestStatus.LOCKED;
		else
			if(
					imageComparison.imgEqual(unlockingSilverChest, capturedSecondChest, 10) ||
					imageComparison.imgEqual(unlockingGoldChest, capturedSecondChest, 10) ||
					imageComparison.imgEqual(unlockingMagicChest, capturedSecondChest, 10))
				secondChestStatus = ChestStatus.UNLOCKING;
			else
				if(
						imageComparison.imgEqual(openSilverChest, capturedSecondChest, 10) ||
						imageComparison.imgEqual(openGoldChest, capturedSecondChest, 10) ||
						imageComparison.imgEqual(openMagicChest, capturedSecondChest, 10))
					secondChestStatus = ChestStatus.UNLOCKABLE;
				else
					if(imageComparison.imgEqual(emptyChest, capturedSecondChest, 10))
						secondChestStatus = ChestStatus.EMPTY;
		
		log += "Action: checkSecondChestStatus, the state is " + secondChestStatus.toString() + ";\n";
	}

	private void checkThirdChestStatus() throws AWTException{
	
		thirdChestStatus = ChestStatus.UNKNOWN;
	
		BufferedImage lockedSilverChest = imageStore.getLockedSilverChest();
		BufferedImage unlockingSilverChest = imageStore.getUnlockingSilverChest();
		BufferedImage openSilverChest = imageStore.getOpenSilverChest();
		BufferedImage lockedGoldChest = imageStore.getLockedGoldChest();
		BufferedImage unlockingGoldChest = imageStore.getUnlockingGoldChest();
		BufferedImage openGoldChest = imageStore.getOpenGoldChest();
		BufferedImage lockedMagicChest = imageStore.getLockedMagicChest();
		BufferedImage unlockingMagicChest = imageStore.getUnlockingMagicChest();
		BufferedImage openMagicChest = imageStore.getOpenMagicChest();
		BufferedImage emptyChest = imageStore.getEmptyChestSlot();
	
		BufferedImage capturedThirdChest = imageCapturer.captureThirdChest();
	
		if(
				imageComparison.imgEqual(lockedSilverChest, capturedThirdChest, 10) ||
				imageComparison.imgEqual(lockedGoldChest, capturedThirdChest, 10) ||
				imageComparison.imgEqual(lockedMagicChest, capturedThirdChest, 10)) 
			thirdChestStatus = ChestStatus.LOCKED;
		else
			if(
					imageComparison.imgEqual(unlockingSilverChest, capturedThirdChest, 10) ||
					imageComparison.imgEqual(unlockingGoldChest, capturedThirdChest, 10) ||
					imageComparison.imgEqual(unlockingMagicChest, capturedThirdChest, 10))
				thirdChestStatus = ChestStatus.UNLOCKING;
			else
				if(
						imageComparison.imgEqual(openSilverChest, capturedThirdChest, 10) ||
						imageComparison.imgEqual(openGoldChest, capturedThirdChest, 10) ||
						imageComparison.imgEqual(openMagicChest, capturedThirdChest, 10))
					thirdChestStatus = ChestStatus.UNLOCKABLE;
				else
					if(imageComparison.imgEqual(emptyChest, capturedThirdChest, 10))
						thirdChestStatus = ChestStatus.EMPTY;
	
		log += "Action: checkThirdChestStatus, the state is " + thirdChestStatus.toString() + ";\n";
	}
	
	private void checkFourthChestStatus() throws AWTException{
		
		fourthChestStatus = ChestStatus.UNKNOWN;
	
		BufferedImage lockedSilverChest = imageStore.getLockedSilverChest();
		BufferedImage unlockingSilverChest = imageStore.getUnlockingSilverChest();
		BufferedImage openSilverChest = imageStore.getOpenSilverChest();
		BufferedImage lockedGoldChest = imageStore.getLockedGoldChest();
		BufferedImage unlockingGoldChest = imageStore.getUnlockingGoldChest();
		BufferedImage openGoldChest = imageStore.getOpenGoldChest();
		BufferedImage lockedMagicChest = imageStore.getLockedMagicChest();
		BufferedImage unlockingMagicChest = imageStore.getUnlockingMagicChest();
		BufferedImage openMagicChest = imageStore.getOpenMagicChest();
		BufferedImage emptyChest = imageStore.getEmptyChestSlot();
	
		BufferedImage capturedFourthChest = imageCapturer.captureFourthChest();
	
		if(
				imageComparison.imgEqual(lockedSilverChest, capturedFourthChest, 10) ||
				imageComparison.imgEqual(lockedGoldChest, capturedFourthChest, 10) ||
				imageComparison.imgEqual(lockedMagicChest, capturedFourthChest, 10)) 
			fourthChestStatus = ChestStatus.LOCKED;
		else
			if(
					imageComparison.imgEqual(unlockingSilverChest, capturedFourthChest, 10) ||
					imageComparison.imgEqual(unlockingGoldChest, capturedFourthChest, 10) ||
					imageComparison.imgEqual(unlockingMagicChest, capturedFourthChest, 10))
				fourthChestStatus = ChestStatus.UNLOCKING;
			else
				if(
						imageComparison.imgEqual(openSilverChest, capturedFourthChest, 10) ||
						imageComparison.imgEqual(openGoldChest, capturedFourthChest, 10) ||
						imageComparison.imgEqual(openMagicChest, capturedFourthChest, 10))
					fourthChestStatus = ChestStatus.UNLOCKABLE;
				else
					if(imageComparison.imgEqual(emptyChest, capturedFourthChest, 10))
						fourthChestStatus = ChestStatus.EMPTY;
		log += "Action: checkFouthChestStatus, the state is " + fourthChestStatus.toString() + ";\n";
	}
	
	private void checkFreeChestStatus() throws AWTException{
		freeChestStatus = ChestStatus.UNKNOWN;
		
		BufferedImage openFreeChestx1 = imageStore.getOpenFreeChestx1();
		BufferedImage openFreeChestx2 = imageStore.getOpenFreeChestx2();
		
		BufferedImage capturedFreeChest = imageCapturer.captureFreeChest();
		
		if(
				imageComparison.imgEqual(capturedFreeChest, openFreeChestx1) ||
				imageComparison.imgEqual(capturedFreeChest, openFreeChestx2))
			freeChestStatus = ChestStatus.UNLOCKABLE;
		else
			freeChestStatus = ChestStatus.UNLOCKING;
		
		log += "Action: checkFreeChestStatus, the state is " + freeChestStatus.toString() + ";\n";
	}
	
	private void checkCrownChestStatus() throws AWTException{
		crownChestStatus = ChestStatus.UNKNOWN;
		
		BufferedImage openCrownChest = imageStore.getOpenCrownChest();
		
		BufferedImage capturedCrownChest = imageCapturer.captureCrownChest();
		
		if(imageComparison.imgEqual(capturedCrownChest, openCrownChest))
			crownChestStatus = ChestStatus.UNLOCKABLE;
		else
			crownChestStatus = ChestStatus.UNLOCKING;
		
		log += "Action: checkCrownChestStatus, the state is " + crownChestStatus.toString() + ";\n";
		
	}
	
	private void checkCollectingStatus() throws AWTException{
		collectingStatus = CollectingStatus.UNKNOWN;
		
		BufferedImage capturedCollectingChest = imageCapturer.captureCollectingChest();
		BufferedImage capturedCollectedChest = imageCapturer.captureCollectedChest();
		
		BufferedImage collectingSilverChest = imageStore.getCollectingSilverChest();
		BufferedImage collectingGoldChest = imageStore.getCollectingGoldChest();
		BufferedImage collectingMagicChest = imageStore.getCollectingMagicChest();
		BufferedImage collectingFreeChest = imageStore.getCollectingFreeChest();
		BufferedImage collectingCrownChest = imageStore.getCollectingCrwonChest();
		BufferedImage collectedSilverChest = imageStore.getCollectedSilverChest();
		BufferedImage collectedGoldChest = imageStore.getCollectedGoldChest();
		BufferedImage collectedMagicChest = imageStore.getCollectedMagicChest();
		BufferedImage collectedFreeChest = imageStore.getCollectedFreeChest();
		BufferedImage collectedCrownChest = imageStore.getCollectedCrownChest();
		
		if(
				imageComparison.imgEqual(capturedCollectingChest, collectingSilverChest, 15) ||
				imageComparison.imgEqual(capturedCollectingChest, collectingGoldChest, 15) ||
				imageComparison.imgEqual(capturedCollectingChest, collectingMagicChest, 15) ||
				imageComparison.imgEqual(capturedCollectingChest, collectingCrownChest, 15) ||
				imageComparison.imgEqual(capturedCollectingChest, collectingFreeChest,15))
			collectingStatus = CollectingStatus.COLLECTING;
			else
				if(
						imageComparison.imgEqual(capturedCollectedChest, collectedSilverChest, 15) ||
						imageComparison.imgEqual(capturedCollectedChest, collectedGoldChest,15) ||
						imageComparison.imgEqual(capturedCollectedChest, collectedMagicChest, 15) ||
						imageComparison.imgEqual(capturedCollectedChest, collectedCrownChest, 15) ||
						imageComparison.imgEqual(capturedCollectedChest, collectedFreeChest, 15))
					collectingStatus = CollectingStatus.COLLECTED;
		
		log += "Action: checkCollectingStatus, the state is " + collectingStatus.toString() + ";\n";
	}
	
	private void tap(int x, int y){
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(250);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	private void point(int x, int y){
		robot.mouseMove(x, y);
	}
	
	
	private void tapBattleButton(){
		switch(resolution){
		case "1920x1080" : 
			this.tap(944, 668);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
	}
	
	private void tapFirstChest(){
		switch(resolution){
		case "1920x1080" : 
			this.tap(739, 847);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
	}
	
	private void tapSecondChest(){
		switch(resolution){
		case "1920x1080" : 
			this.tap(873, 847);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
	}
	
	private void tapThirdChest(){
		switch(resolution){
		case "1920x1080" : 
			this.tap(1013, 847);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
	}
	
	private void tapFourthChest(){
		switch(resolution){
		case "1920x1080" : 
			this.tap(1153, 847);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
	}
	
	private void pointOutside(){
		switch(resolution){
		case "1920x1080" : 
			this.point(1400, 500);
			break;
		case "1366x768" : 
			this.point(0, 0);
			break;
		default: break;
		}
	}
	
	private void tapCentre(){
		switch(resolution){
		case "1920x1080" : 
			this.tap(937, 465);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
	}
	
	private void tapFreeChest(){
		switch(resolution){
		case "1920x1080" : 
			this.tap(811, 214);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
	}
	
	private void tapCrownChest(){
		switch(resolution){
		case "1920x1080" : 
			this.tap(1070, 214);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
	}
	
	private void openFirstChest() throws AWTException{
		tapFirstChest();
		pointOutside();
		log += "Action: open first chest;\n";
		robot.delay(3000);
		checkCollectingStatus();
		while(collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			checkCollectingStatus();
		}
	}
	
	private void openSecondChest() throws AWTException{
		tapSecondChest();
		pointOutside();
		log += "Action: open second chest;\n";
		robot.delay(3000);
		checkCollectingStatus();
		while(collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			checkCollectingStatus();
		}
	}
	
	private void openThirdChest() throws AWTException{
		tapThirdChest();
		pointOutside();
		log += "Action: open third chest;\n";
		robot.delay(3000);
		checkCollectingStatus();
		while(collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			checkCollectingStatus();
		}
	}
	
	private void openFourthChest() throws AWTException{
		tapFourthChest();
		pointOutside();
		log += "Action: open fourth chest;\n";
		robot.delay(3000);
		checkCollectingStatus();
		while(collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			checkCollectingStatus();
		}
	}
	
	private void openFreeChest() throws AWTException{
		tapFreeChest();
		pointOutside();
		log += "Action: open free chest;\n";
		robot.delay(3000);
		checkCollectingStatus();
		while(collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			checkCollectingStatus();
		}
	}
	
	private void openCrownChest() throws AWTException{
		tapCrownChest();
		pointOutside();
		log += "Action: open crown chest;\n";
		robot.delay(3000);
		checkCollectingStatus();
		while(collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			checkCollectingStatus();
		}
	}
	
	private void switchMenu(String menuToGo) throws AWTException{
		checkGameStatus();
		String oldMenu = gameStatus.toString();
		
		switch(menuToGo){
		
		case "BATTLE_MENU" : {
			if(gameStatus != GameStatus.BATTLE_MENU){
				tapBattleMenu();
				robot.delay(3000);
				pointOutside();
				checkGameStatus();
				log += "Action: from " + oldMenu + " to " + gameStatus.toString() + ";\n";
			}
			break;
		}
		
		case "TOURNAMENTS_MENU" : {
			if(gameStatus != GameStatus.TOURNAMENTS_MENU){
				tapTournamentsMenu();
				robot.delay(3000);
				pointOutside();
				checkGameStatus();
				log += "Action: from " + oldMenu + " to " + gameStatus.toString() + ";\n";
			}
		}
		
		case "SOCIAL_MENU" : {
			if(gameStatus != GameStatus.SOCIAL_MENU){
				tapSocialMenu();
				robot.delay(3000);
				pointOutside();
				checkGameStatus();
				log += "Action: from " + oldMenu + " to " + gameStatus.toString() + ";\n";
			}
		}
		
		case "SHOP_MENU" : {
			if(gameStatus != GameStatus.SHOP_MENU){
				tapShopMenu();
				robot.delay(3000);
				pointOutside();
				checkGameStatus();
				log += "Action: from " + oldMenu + " to " + gameStatus.toString() + ";\n";
			}
		}
		
		case "CARDS_MENU" : {
			if(gameStatus != GameStatus.CARDS_MENU){
				tapCardsMenu();
				robot.delay(3000);
				pointOutside();
				checkGameStatus();
				log += "Action: from " + oldMenu + " to " + gameStatus.toString() + ";\n";
			}
		}
		}
	}

	
	private void tapBattleMenu(){
		switch(resolution){
		case "1920x1080" : 
			this.tap(945, 975);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
	}
	
	private void tapCardsMenu() {
		switch(resolution){
		case "1920x1080" : 
			this.tap(861, 990);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
		
	}

	private void tapShopMenu() {
		switch(resolution){
		case "1920x1080" : 
			this.tap(685, 918);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
		
	}

	private void tapSocialMenu() {
		switch(resolution){
		case "1920x1080" : 
			this.tap(945, 975);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
		
	}

	private void tapTournamentsMenu() {
		switch(resolution){
		case "1920x1080" : 
			this.tap(1017, 1004);
			break;
		case "1366x768" : 
			this.tap(0, 0);
			break;
		default: break;
		}
	}
	
}