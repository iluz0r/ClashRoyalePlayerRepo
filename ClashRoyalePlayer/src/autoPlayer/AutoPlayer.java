package autoPlayer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
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
				".\\images\\collectedCrownChest.jpg");
		status = checkStatus();
	}

	// da fare
	public void start() throws AWTException, IOException{
		this.init();
		this.stop();
	}
	
	public void stop(){
		System.exit(0);
	}
	
	// da fare
	private Status checkStatus(){
		return Status.UNKNOWN;
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
	
	private void tapBattleSection(){
		this.tap(945, 975);
	}
	
}
