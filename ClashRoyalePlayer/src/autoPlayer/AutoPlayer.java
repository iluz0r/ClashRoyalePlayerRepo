package autoPlayer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import autoPlayer.controller.BaseController;
import imageProcessing.ImageComparison;

public class AutoPlayer{

    public enum GameStatus {
	BATTLE_MENU, TOURNAMENTS_MENU, SOCIAL_MENU, SHOP_MENU, CARDS_MENU, BATTLE, COLLECTING_CHEST, COLLECTED_CHEST, ARENA_INFO, UNKNOWN
    }

    public enum ChestStatus {
	UNLOCKING, UNLOCKABLE, LOCKED, EMPTY, UNKNOWN
    }

    public enum CollectingStatus {
	COLLECTING, COLLECTED, UNKNOWN
    }
    public class GameStatusController extends BaseController {


	private ImageCapturer imageCapturer;
	private ImageComparison imageComparison;
	private ImageStore imageStore;

	private GameStatus gameStatus;
	private ChestStatus firstChestStatus;
	private ChestStatus secondChestStatus;
	private ChestStatus thirdChestStatus;
	private ChestStatus fourthChestStatus;
	private ChestStatus freeChestStatus;
	private ChestStatus crownChestStatus;
	private CollectingStatus collectingStatus;
	
	public GameStatusController(String resolution) throws Exception{
		imageCapturer = new ImageCapturer(resolution);
		imageComparison = new ImageComparison();
		imageStore = new ImageStore(resolution);
	}
	
	public GameStatus getGameStatus() {
	    return gameStatus;
	}
	public void setGameStatus(GameStatus gameStatus) {
	    this.gameStatus = gameStatus;
	}
	public ChestStatus getFirstChestStatus() {
	    return firstChestStatus;
	}
	public void setFirstChestStatus(ChestStatus firstChestStatus) {
	    this.firstChestStatus = firstChestStatus;
	}
	public ChestStatus getSecondChestStatus() {
	    return secondChestStatus;
	}
	public void setSecondChestStatus(ChestStatus secondChestStatus) {
	    this.secondChestStatus = secondChestStatus;
	}
	public ChestStatus getThirdChestStatus() {
	    return thirdChestStatus;
	}
	public void setThirdChestStatus(ChestStatus thirdChestStatus) {
	    this.thirdChestStatus = thirdChestStatus;
	}
	public ChestStatus getFourthChestStatus() {
	    return fourthChestStatus;
	}
	public void setFourthChestStatus(ChestStatus fourthChestStatus) {
	    this.fourthChestStatus = fourthChestStatus;
	}
	public ChestStatus getFreeChestStatus() {
	    return freeChestStatus;
	}
	public void setFreeChestStatus(ChestStatus freeChestStatus) {
	    this.freeChestStatus = freeChestStatus;
	}
	public ChestStatus getCrownChestStatus() {
	    return crownChestStatus;
	}
	public void setCrownChestStatus(ChestStatus crownChestStatus) {
	    this.crownChestStatus = crownChestStatus;
	}
	public CollectingStatus getCollectingStatus() {
	    return collectingStatus;
	}
	public void setCollectingStatus(CollectingStatus collectingStatus) {
	    this.collectingStatus = collectingStatus;
	}
	
	public void checkGameStatus() throws AWTException{
		
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
		updateLog("Action: check gameStatus, game state: " + gameStatus.toString());
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
		
		pointOutside();
		
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
		
		updateLog("Action: checkFirstChestStatus, the state is " + firstChestStatus.toString());
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
		
		pointOutside();
		
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
		
		updateLog("Action: checkSecondChestStatus, the state is " + secondChestStatus.toString());
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
		
		pointOutside();
	
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
	
		updateLog("Action: checkThirdChestStatus, the state is " + thirdChestStatus.toString());
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
		
		pointOutside();
	
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
		updateLog("Action: checkFouthChestStatus, the state is " + fourthChestStatus.toString());
	}
	
	private void checkFreeChestStatus() throws AWTException{
		freeChestStatus = ChestStatus.UNKNOWN;
		
		BufferedImage openFreeChestx1 = imageStore.getOpenFreeChestx1();
		BufferedImage openFreeChestx2 = imageStore.getOpenFreeChestx2();
		
		BufferedImage capturedFreeChest = imageCapturer.captureFreeChest();
		
		pointOutside();
		
		if(
				imageComparison.imgEqual(capturedFreeChest, openFreeChestx1) ||
				imageComparison.imgEqual(capturedFreeChest, openFreeChestx2))
			freeChestStatus = ChestStatus.UNLOCKABLE;
		else
			freeChestStatus = ChestStatus.UNLOCKING;
		
		updateLog("Action: checkFreeChestStatus, the state is " + freeChestStatus.toString());
	}
	
	private void checkCrownChestStatus() throws AWTException{
		crownChestStatus = ChestStatus.UNKNOWN;
		
		BufferedImage openCrownChest = imageStore.getOpenCrownChest();
		
		BufferedImage capturedCrownChest = imageCapturer.captureCrownChest();
		
		pointOutside();
		
		if(imageComparison.imgEqual(capturedCrownChest, openCrownChest))
			crownChestStatus = ChestStatus.UNLOCKABLE;
		else
			crownChestStatus = ChestStatus.UNLOCKING;
		
		updateLog("Action: checkCrownChestStatus, the state is " + crownChestStatus.toString());
		
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
		
		pointOutside();
		
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
		
		updateLog("Action: checkCollectingStatus, the state is " + collectingStatus.toString());
	}
    }

	private Robot robot;
	
	private String resolution;
	private final static String DEFAULT_RESOLUTION = "1920x1080";
	
	private String log = "";
	private PrintStream writeLog;
	
	GameStatusController gameController = new GameStatusController(resolution);
	
	public AutoPlayer(String screenResolution) throws Exception{
		if(screenResolution == "1920x1080" || screenResolution == "1366x768")
			this.resolution = screenResolution;
		else
			throw new Exception("Resolution mismatch");
		
		updateLog("ScreenResolution: " + resolution);
	}
	
	public AutoPlayer() throws Exception{
		this(DEFAULT_RESOLUTION);
		updateLog("ScreenResolution: " + resolution);
	}

	private void init() throws Exception{
		robot = new Robot();
		
		robot.delay(10000);
		this.gameController.checkGameStatus();
		
		updateLog("Initial state: " + this.gameController.getGameStatus().toString());
	}

	
	public void start() throws Exception{
		init();

		
		while(this.gameController.getGameStatus() != GameStatus.UNKNOWN){
		    this.gameController.checkGameStatus();
			switch(this.gameController.getGameStatus().toString()){
			
				case "UNKNOWN" : break;
			
				case "BATTLE_MENU" : {
					this.gameController.checkFirstChestStatus();
					this.gameController.checkSecondChestStatus();
					this.gameController.checkThirdChestStatus();
					this.gameController.checkFourthChestStatus();
					this.gameController.checkFreeChestStatus();
					this.gameController.checkCrownChestStatus();
					
					if(this.gameController.getFirstChestStatus() == ChestStatus.UNLOCKABLE){
						openFirstChest();
						break;
					}
					if(this.gameController.getSecondChestStatus() == ChestStatus.UNLOCKABLE){
						openSecondChest();
						break;
					}
					if(this.gameController.getThirdChestStatus() == ChestStatus.UNLOCKABLE){
						openThirdChest();
						break;
					}
					if(this.gameController.getFourthChestStatus() == ChestStatus.UNLOCKABLE){
						openFourthChest();
						break;
					}
					if(this.gameController.getFreeChestStatus() == ChestStatus.UNLOCKABLE){
						openFreeChest();
						break;
					}
					if(this.gameController.getCrownChestStatus() == ChestStatus.UNLOCKABLE){
						openCrownChest();
						break;
					}
					if(
							this.gameController.getFirstChestStatus() != ChestStatus.UNLOCKING &&
							this.gameController.getSecondChestStatus() != ChestStatus.UNLOCKING &&
							this.gameController.getThirdChestStatus() != ChestStatus.UNLOCKING &&
								this.gameController.getFourthChestStatus() != ChestStatus.UNLOCKING)
					{
						if(this.gameController.getFirstChestStatus() == ChestStatus.LOCKED)
							unlockFirstChest();
						else
							if(this.gameController.getSecondChestStatus() == ChestStatus.LOCKED)
								unlockSecondChest();
							else
								if(this.gameController.getThirdChestStatus() == ChestStatus.LOCKED)
									unlockThirdChest();
								else
									if(this.gameController.getFourthChestStatus() == ChestStatus.LOCKED)
										unlockFourthChest();
					}
					
					robot.delay(3000);
					this.gameController.checkGameStatus();
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
		this.stop();
	}

	public void stop() throws IOException{
		
		updateLog("Final state: " + this.gameController.getGameStatus().toString());
		
		String path = ".\\log.txt";
		FileOutputStream logFile = new FileOutputStream(path);
        writeLog = new PrintStream(logFile);
        writeLog.print(log);
		System.out.println(log);

		System.exit(0);
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
			this.tap(661, 476);
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
			this.tap(523, 600);
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
			this.tap(619, 600);
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
			this.tap(716, 600);
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
			this.tap(808, 600);
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
			this.point(1082, 305);
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
			this.tap(661, 348);
			break;
		default: break;
		}
	}
	
	private void tapStartUnlock(){
		switch(resolution){
		case "1920x1080" : 
			this.tap(939, 684);
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
			this.tap(585, 159);
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
			this.tap(760, 161);
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
			this.tap(664, 697);
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
			this.tap(593, 708);
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
			this.tap(481, 699);
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
			this.tap(729, 701);
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
			this.tap(850, 694);
			break;
		default: break;
		}
	}
	
	private void openFirstChest() throws AWTException{
		tapFirstChest();
		updateLog("Action: open first chest");
		robot.delay(3000);
		this.gameController.checkCollectingStatus();
		while(this.gameController.collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			this.gameController.checkCollectingStatus();
		}
	}
	
	private void openSecondChest() throws AWTException{
		tapSecondChest();
		updateLog("Action: open second chest");
		robot.delay(3000);
		this.gameController.checkCollectingStatus();
		while(this.gameController.collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			this.gameController.checkCollectingStatus();
		}
	}
	
	private void openThirdChest() throws AWTException{
		tapThirdChest();
		updateLog("Action: open third chest");
		robot.delay(3000);
		this.gameController.checkCollectingStatus();
		while(this.gameController.collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			this.gameController.checkCollectingStatus();
		}
	}
	
	private void openFourthChest() throws AWTException{
		tapFourthChest();
		updateLog("Action: open fourth chest");
		robot.delay(3000);
		this.gameController.checkCollectingStatus();
		while(this.gameController.collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			this.gameController.checkCollectingStatus();
		}
	}
	
	private void openFreeChest() throws AWTException{
		tapFreeChest();
		updateLog("Action: open free chest");
		robot.delay(3000);
		this.gameController.checkCollectingStatus();
		while(this.gameController.collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			this.gameController.checkCollectingStatus();
		}
	}
	
	private void openCrownChest() throws AWTException{
		tapCrownChest();
		updateLog("Action: open crown chest");
		robot.delay(3000);
		this.gameController.checkCollectingStatus();
		while(this.gameController.collectingStatus != CollectingStatus.UNKNOWN){
			tapCentre();
			robot.delay(3000);
			this.gameController.checkCollectingStatus();
		}
	}
	
	private void unlockFourthChest() {
		tapFourthChest();
		robot.delay(2000);
		tapStartUnlock();
		robot.delay(2000);
		updateLog("Action: unlocking fourth chest");
	}

	private void unlockThirdChest() {
		tapThirdChest();
		robot.delay(2000);
		tapStartUnlock();
		robot.delay(2000);
		updateLog("Action: unlocking third chest");
	}

	private void unlockSecondChest() {
		tapSecondChest();
		robot.delay(2000);
		tapStartUnlock();
		robot.delay(2000);
		updateLog("Action: unlocking second chest");
	}

	private void unlockFirstChest() {
		tapFirstChest();
		robot.delay(2000);
		tapStartUnlock();
		robot.delay(2000);
		updateLog("Action: unlocking first chest");
	}
	
	private void switchMenu(String menuToGo) throws AWTException{
	    this.gameController.checkGameStatus();
		String oldMenu = this.gameController.gameStatus.toString();
		
		switch(menuToGo){
		
		case "BATTLE_MENU" : {
			if(this.gameController.gameStatus != GameStatus.BATTLE_MENU){
				tapBattleMenu();
				robot.delay(3000);
				this.gameController.checkGameStatus();
				updateLog("Action: switched from " + oldMenu + " to " + this.gameController.gameStatus.toString());
			}
			break;
		}
		
		case "TOURNAMENTS_MENU" : {
			if(this.gameController.gameStatus != GameStatus.TOURNAMENTS_MENU){
				tapTournamentsMenu();
				robot.delay(3000);
				this.gameController.checkGameStatus();
				updateLog("Action: switched from " + oldMenu + " to " + this.gameController.gameStatus.toString());
			}
		}
		
		case "SOCIAL_MENU" : {
			if(this.gameController.gameStatus != GameStatus.SOCIAL_MENU){
				tapSocialMenu();
				robot.delay(3000);
				this.gameController.checkGameStatus();
				updateLog("Action: switched from " + oldMenu + " to " + this.gameController.gameStatus.toString());
			}
		}
		
		case "SHOP_MENU" : {
			if(this.gameController.gameStatus != GameStatus.SHOP_MENU){
				tapShopMenu();
				robot.delay(3000);
				this.gameController.checkGameStatus();
				updateLog("Action: switched from " + oldMenu + " to " + this.gameController.gameStatus.toString());
				}
		}
		
		case "CARDS_MENU" : {
			if(this.gameController.gameStatus != GameStatus.CARDS_MENU){
				tapCardsMenu();
				robot.delay(3000);
				this.gameController.checkGameStatus();
				updateLog("Action: switched from " + oldMenu + " to " + this.gameController.gameStatus.toString());
			}
		}
		}
	}
		
	private void updateLog(String update){
		log += update + ";\n";
	}
	
}