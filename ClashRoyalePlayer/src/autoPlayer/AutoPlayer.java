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
	
	protected Robot robot;
	
	protected String resolution;
	protected final static String DEFAULT_RESOLUTION = "1920x1080";
	
	private String log = "";
	private PrintStream writeLog;
	
	GameStatusController gameController = new GameStatusController(this);
	Actions actions = new Actions(this);
	
	
	public AutoPlayer(String screenResolution) throws Exception{
		if(screenResolution == "1920x1080" || screenResolution == "1366x768")
			this.resolution = screenResolution;
		else
			throw new Exception("Resolution mismatch");
		
		updateLog("ScreenResolution: " + resolution);
	}
	
	public AutoPlayer() throws Exception{
		this(DEFAULT_RESOLUTION);
	}

	private void init() throws Exception{
		robot = new Robot();
		
		robot.delay(10000);
		this.gameController.checkGameStatus();
		
		updateLog("Initial state: " + this.gameController.getGameStatus().toString());
	}

	
	public void start() throws Exception{
		init();

		
		while(this.gameController.getGameStatus() != GameStatusController.GameStatus.UNKNOWN){
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
					
					if(this.gameController.getFirstChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE){
						actions.openFirstChest();
						break;
					}
					if(this.gameController.getSecondChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE){
						actions.openSecondChest();
						break;
					}
					if(this.gameController.getThirdChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE){
						actions.openThirdChest();
						break;
					}
					if(this.gameController.getFourthChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE){
						actions.openFourthChest();
						break;
					}
					if(this.gameController.getFreeChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE){
						actions.openFreeChest();
						break;
					}
					if(this.gameController.getCrownChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE){
						actions.openCrownChest();
						break;
					}
					if(
							this.gameController.getFirstChestStatus() != GameStatusController.ChestStatus.UNLOCKING &&
							this.gameController.getSecondChestStatus() != GameStatusController.ChestStatus.UNLOCKING &&
							this.gameController.getThirdChestStatus() != GameStatusController.ChestStatus.UNLOCKING &&
								this.gameController.getFourthChestStatus() != GameStatusController.ChestStatus.UNLOCKING)
					{
						if(this.gameController.getFirstChestStatus() == GameStatusController.ChestStatus.LOCKED)
							actions.unlockFirstChest();
						else
							if(this.gameController.getSecondChestStatus() == GameStatusController.ChestStatus.LOCKED)
								actions.unlockSecondChest();
							else
								if(this.gameController.getThirdChestStatus() == GameStatusController.ChestStatus.LOCKED)
									actions.unlockThirdChest();
								else
									if(this.gameController.getFourthChestStatus() == GameStatusController.ChestStatus.LOCKED)
										actions.unlockFourthChest();
					}
					
					robot.delay(3000);
					this.gameController.checkGameStatus();
					break;
				}
				
				case "TOURNAMENTS_MENU" : {
					actions.switchMenu("BATTLE_MENU");
					break;
				}
				
				case "SOCIAL_MENU" : {
					actions.switchMenu("BATTLE_MENU");
					break;
				}
				
				case "SHOP_MENU" : {
					actions.switchMenu("BATTLE_MENU");
					break;
				}
				
				case "CARDS_MENU" : {
					actions.switchMenu("BATTLE_MENU");
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
	
	protected void updateLog(String update){
		log += update + ";\n";
	}
	
}