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
		BATTLEMENU, TOURNAMENTSMENU, SOCIALMENU, SHOPMENU, 
		CARDSMENU, BATTLE, UNKNOWN
	}
	
	private enum ChestStatus {
		UNLOCKING, UNLOCKABLE, LOCKED, EMPTY, UNKNOWN
	}
	
	private GameStatus gameStatus;
	private ChestStatus firstChestStatus;
	private ChestStatus secondChestStatus;
	private ChestStatus thirdChestStatus;
	private ChestStatus fourthChestStatus;
	
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
					".\\images" + resolution + "\\collectedMagicChest.jpg");
			break;
		case "1366x768" : 
			imageStore = new ImageStore();
			break;

		}
		
		robot.delay(10000);
		checkGameStatus();
	}

	
	public void start() throws Exception{
		this.init();
		log += "Initial state: " + gameStatus.toString() + ";\n";
		
		while(gameStatus.toString() != GameStatus.UNKNOWN.toString()){
			switch(gameStatus.toString()){
			
				case "UNKNOWN" : break;
			
				case "BATTLEMENU" : {
					checkFirstChestStatus();
					log += "Action: checkFirstChestStatus, the state is " + firstChestStatus.toString() + ";\n";
					checkSecondChestStatus();
					log += "Action: checkSecondChestStatus, the state is " + secondChestStatus.toString() + ";\n";
					checkThirdChestStatus();
					log += "Action: checkThirdChestStatus, the state is " + thirdChestStatus.toString() + ";\n";
					checkFourthChestStatus();
					log += "Action: checkFourthChestStatus, the state is " + fourthChestStatus.toString() + ";\n";
					
					robot.delay(3000);
					checkGameStatus();
				}
				
				case "TOURNAMENTSMENU" : {
					tapBattleMenu();
					robot.delay(3000);
					checkGameStatus();
					log += "Action: from TOURNAMENTSMENU to " + gameStatus.toString() + ";\n";
				}
				
				case "SOCIALMENU" : {
					tapBattleMenu();
					robot.delay(3000);
					checkGameStatus();
					log += "Action from SOCIALMENU to " + gameStatus.toString() + ";\n";
				}
				
				case "SHOPMENU" : {
					tapBattleMenu();
					robot.delay(3000);
					checkGameStatus();
					log += "Action from SHOPMENU to " + gameStatus.toString() + ";\n";
				}
				
				case "CARDSMENU" : {
					tapBattleMenu();
					robot.delay(3000);
					checkGameStatus();
					log += "Action: from SHOPMENU to " + gameStatus.toString() + ";\n";
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
		
		if (imageComparison.imgEqual(battleMenu, capturedBattleMenu)) 
			gameStatus = GameStatus.BATTLEMENU;
		else
			if(imageComparison.imgEqual(shopMenu, capturedShopMenu)) 
				gameStatus = GameStatus.SHOPMENU;
			else
				if(imageComparison.imgEqual(socialMenu, capturedSocialMenu)) 
					gameStatus = GameStatus.SOCIALMENU;
				else
					if(imageComparison.imgEqual(tournamentsMenu, capturedTournamentsMenu)) 
						gameStatus = GameStatus.TOURNAMENTSMENU;
					else
						if(imageComparison.imgEqual(cardsMenu, capturedCardsMenu)) 
							gameStatus = GameStatus.CARDSMENU;
						else
							gameStatus = GameStatus.UNKNOWN;
	}
	
	private void checkFirstChestStatus() throws AWTException{
		
		ChestStatus firstChestStatus = ChestStatus.UNKNOWN;
		
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
				imageComparison.imgEqual(lockedSilverChest, capturedFirstChest) ||
				imageComparison.imgEqual(lockedGoldChest, capturedFirstChest) ||
				imageComparison.imgEqual(lockedMagicChest, capturedFirstChest)) 
			firstChestStatus = ChestStatus.LOCKED;
		else
			if(
					imageComparison.imgEqual(unlockingSilverChest, capturedFirstChest) ||
					imageComparison.imgEqual(unlockingGoldChest, capturedFirstChest) ||
					imageComparison.imgEqual(unlockingMagicChest, capturedFirstChest))
				firstChestStatus = ChestStatus.UNLOCKING;
			else
				if(
						imageComparison.imgEqual(openSilverChest, capturedFirstChest) ||
						imageComparison.imgEqual(openGoldChest, capturedFirstChest) ||
						imageComparison.imgEqual(openMagicChest, capturedFirstChest))
					firstChestStatus = ChestStatus.UNLOCKABLE;
				else
					if(imageComparison.imgEqual(emptyChest, capturedFirstChest))
						firstChestStatus = ChestStatus.EMPTY;
		
		
		this.firstChestStatus = firstChestStatus;
	}
	
	private void checkSecondChestStatus() throws AWTException{
		
		ChestStatus secondChestStatus = ChestStatus.UNKNOWN;
		
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
				imageComparison.imgEqual(lockedSilverChest, capturedSecondChest) ||
				imageComparison.imgEqual(lockedGoldChest, capturedSecondChest) ||
				imageComparison.imgEqual(lockedMagicChest, capturedSecondChest)) 
			secondChestStatus = ChestStatus.LOCKED;
		else
			if(
					imageComparison.imgEqual(unlockingSilverChest, capturedSecondChest) ||
					imageComparison.imgEqual(unlockingGoldChest, capturedSecondChest) ||
					imageComparison.imgEqual(unlockingMagicChest, capturedSecondChest))
				secondChestStatus = ChestStatus.UNLOCKING;
			else
				if(
						imageComparison.imgEqual(openSilverChest, capturedSecondChest) ||
						imageComparison.imgEqual(openGoldChest, capturedSecondChest) ||
						imageComparison.imgEqual(openMagicChest, capturedSecondChest))
					secondChestStatus = ChestStatus.UNLOCKABLE;
				else
					if(imageComparison.imgEqual(emptyChest, capturedSecondChest))
						secondChestStatus = ChestStatus.EMPTY;
		
		
		this.secondChestStatus = secondChestStatus;
	}

	private void checkThirdChestStatus() throws AWTException{
	
	ChestStatus thirdChestStatus = ChestStatus.UNKNOWN;
	
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
			imageComparison.imgEqual(lockedSilverChest, capturedThirdChest) ||
			imageComparison.imgEqual(lockedGoldChest, capturedThirdChest) ||
			imageComparison.imgEqual(lockedMagicChest, capturedThirdChest)) 
		thirdChestStatus = ChestStatus.LOCKED;
	else
		if(
				imageComparison.imgEqual(unlockingSilverChest, capturedThirdChest) ||
				imageComparison.imgEqual(unlockingGoldChest, capturedThirdChest) ||
				imageComparison.imgEqual(unlockingMagicChest, capturedThirdChest))
			thirdChestStatus = ChestStatus.UNLOCKING;
		else
			if(
					imageComparison.imgEqual(openSilverChest, capturedThirdChest) ||
					imageComparison.imgEqual(openGoldChest, capturedThirdChest) ||
					imageComparison.imgEqual(openMagicChest, capturedThirdChest))
				thirdChestStatus = ChestStatus.UNLOCKABLE;
			else
				if(imageComparison.imgEqual(emptyChest, capturedThirdChest))
					thirdChestStatus = ChestStatus.EMPTY;
	
	
	this.thirdChestStatus = thirdChestStatus;
	}
	
	private void checkFourthChestStatus() throws AWTException{
		
	ChestStatus fourthChestStatus = ChestStatus.UNKNOWN;
	
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
			imageComparison.imgEqual(lockedSilverChest, capturedFourthChest) ||
			imageComparison.imgEqual(lockedGoldChest, capturedFourthChest) ||
			imageComparison.imgEqual(lockedMagicChest, capturedFourthChest)) 
		fourthChestStatus = ChestStatus.LOCKED;
	else
		if(
				imageComparison.imgEqual(unlockingSilverChest, capturedFourthChest) ||
				imageComparison.imgEqual(unlockingGoldChest, capturedFourthChest) ||
				imageComparison.imgEqual(unlockingMagicChest, capturedFourthChest))
			fourthChestStatus = ChestStatus.UNLOCKING;
		else
			if(
					imageComparison.imgEqual(openSilverChest, capturedFourthChest) ||
					imageComparison.imgEqual(openGoldChest, capturedFourthChest) ||
					imageComparison.imgEqual(openMagicChest, capturedFourthChest))
				fourthChestStatus = ChestStatus.UNLOCKABLE;
			else
				if(imageComparison.imgEqual(emptyChest, capturedFourthChest))
					fourthChestStatus = ChestStatus.EMPTY;
	
	
	this.fourthChestStatus = fourthChestStatus;
	}
	
	private void tap(int x, int y){
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(250);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
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
	
	private void tapTournamentsButton() {
		switch(resolution){
		case "1920x1080" : 
			this.tap(1173, 982);
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
	
}