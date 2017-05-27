package clashroyaleplayer.core;

import java.awt.AWTException;
import java.awt.event.InputEvent;

import clashroyaleplayer.core.GameStatusController.GameStatus;

public class Actions {

	protected AutoPlayer autoPlayer;
	
	protected Actions(AutoPlayer autoPlayer){
		this.autoPlayer = autoPlayer;
	}
	
	protected void tap(int x, int y){
		autoPlayer.robot.mouseMove(x, y);
		autoPlayer.robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		autoPlayer.robot.delay(250);
		autoPlayer.robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	private void point(int x, int y){
		autoPlayer.robot.mouseMove(x, y);
	}
	
	
	protected void tapBattleButton(){
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(944, 668);
			break;
		case R_1366X768 : 
			this.tap(661, 476);
			break;
		default: break;
		}
	}
	
	protected void tapFirstChest(){
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(739, 847);
			break;
		case R_1366X768 : 
			this.tap(523, 600);
			break;
		default: break;
		}
	}
	
	protected void tapSecondChest(){
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(873, 847);
			break;
		case R_1366X768 : 
			this.tap(619, 600);
			break;
		default: break;
		}
	}
	
	protected void tapThirdChest(){
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(1013, 847);
			break;
		case R_1366X768 : 
			this.tap(716, 600);
			break;
		default: break;
		}
	}
	
	protected void tapFourthChest(){
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(1153, 847);
			break;
		case R_1366X768 : 
			this.tap(808, 600);
			break;
		default: break;
		}
	}
	
	protected void pointOutside(){
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.point(1400, 500);
			break;
		case R_1366X768 : 
			this.point(1082, 305);
			break;
		default: break;
		}
	}
	
	protected void tapCentre(){
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(937, 465);
			break;
		case R_1366X768 : 
			this.tap(661, 348);
			break;
		default: break;
		}
	}
	
	protected void tapStartUnlock(){
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(939, 684);
			break;
		case R_1366X768 : 
			this.tap(662, 477);
			break;
		default: break;
		}
	}
	
	protected void tapFreeChest(){
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(811, 214);
			break;
		case R_1366X768 : 
			this.tap(585, 159);
			break;
		default: break;
		}
	}
	
	protected void tapCrownChest(){
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(1070, 214);
			break;
		case R_1366X768 : 
			this.tap(760, 161);
			break;
		default: break;
		}
	}
	
	protected void tapBattleMenu(){
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(945, 975);
			break;
		case R_1366X768 : 
			this.tap(664, 697);
			break;
		default: break;
		}
	}
	
	protected void tapCardsMenu() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(861, 990);
			break;
		case R_1366X768 : 
			this.tap(593, 708);
			break;
		default: break;
		}
		
	}

	protected void tapShopMenu() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(685, 918);
			break;
		case R_1366X768 : 
			this.tap(481, 699);
			break;
		default: break;
		}
		
	}

	protected void tapSocialMenu() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(945, 975);
			break;
		case R_1366X768 : 
			this.tap(729, 701);
			break;
		default: break;
		}
		
	}

	protected void tapTournamentsMenu() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(1017, 1004);
			break;
		case R_1366X768 : 
			this.tap(850, 694);
			break;
		default: break;
		}
	}
	
	protected void tapCloseArenaInfoButton() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(943, 979);
			break;
		case R_1366X768 : 
			this.tap(665, 682);
			break;
		default: break;
		}	
	}
	
	//reward limit reached status
	protected void tapYesButton() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(939, 662);
			break;
		case R_1366X768 : 
			this.tap(662, 466);
			break;
		default: break;
		}	
	}
	
	//end battle status
	protected void tapOkButton() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(944, 908);
			break;
		case R_1366X768 : 
			this.tap(666, 640);
			break;
		default: break;
		}	
	}
	
	protected void openFirstChest() throws AWTException{
		tapFirstChest();
		autoPlayer.updateLog("Action: open first chest");
		autoPlayer.robot.delay(3000);
		autoPlayer.gameController.checkCollectingStatus();
		while(autoPlayer.gameController.collectingStatus != GameStatusController.CollectingStatus.UNKNOWN){
			tapCentre();
			autoPlayer.robot.delay(3000);
			autoPlayer.gameController.checkCollectingStatus();
		}
	}
	
	protected void openSecondChest() throws AWTException{
		tapSecondChest();
		autoPlayer.updateLog("Action: open second chest");
		autoPlayer.robot.delay(3000);
		autoPlayer.gameController.checkCollectingStatus();
		while(autoPlayer.gameController.collectingStatus != GameStatusController.CollectingStatus.UNKNOWN){
			tapCentre();
			autoPlayer.robot.delay(3000);
			autoPlayer.gameController.checkCollectingStatus();
		}
	}
	
	protected void openThirdChest() throws AWTException{
		tapThirdChest();
		autoPlayer.updateLog("Action: open third chest");
		autoPlayer.robot.delay(3000);
		autoPlayer.gameController.checkCollectingStatus();
		while(autoPlayer.gameController.collectingStatus != GameStatusController.CollectingStatus.UNKNOWN){
			tapCentre();
			autoPlayer.robot.delay(3000);
			autoPlayer.gameController.checkCollectingStatus();
		}
	}
	
	protected void openFourthChest() throws AWTException{
		tapFourthChest();
		autoPlayer.updateLog("Action: open fourth chest");
		autoPlayer.robot.delay(3000);
		autoPlayer.gameController.checkCollectingStatus();
		while(autoPlayer.gameController.collectingStatus != GameStatusController.CollectingStatus.UNKNOWN){
			tapCentre();
			autoPlayer.robot.delay(3000);
			autoPlayer.gameController.checkCollectingStatus();
		}
	}
	
	protected void openFreeChest() throws AWTException{
		tapFreeChest();
		autoPlayer.updateLog("Action: open free chest");
		autoPlayer.robot.delay(3000);
		autoPlayer.gameController.checkCollectingStatus();
		while(autoPlayer.gameController.collectingStatus != GameStatusController.CollectingStatus.UNKNOWN){
			tapCentre();
			autoPlayer.robot.delay(3000);
			autoPlayer.gameController.checkCollectingStatus();
		}
	}
	
	protected void openCrownChest() throws AWTException{
		tapCrownChest();
		autoPlayer.updateLog("Action: open crown chest");
		autoPlayer.robot.delay(3000);
		autoPlayer.gameController.checkCollectingStatus();
		while(autoPlayer.gameController.collectingStatus != GameStatusController.CollectingStatus.UNKNOWN){
			tapCentre();
			autoPlayer.robot.delay(3000);
			autoPlayer.gameController.checkCollectingStatus();
		}
	}
	
	protected void unlockFourthChest() {
		tapFourthChest();
		autoPlayer.robot.delay(2000);
		tapStartUnlock();
		autoPlayer.robot.delay(2000);
		autoPlayer.updateLog("Action: unlocking fourth chest");
	}

	protected void unlockThirdChest() {
		tapThirdChest();
		autoPlayer.robot.delay(2000);
		tapStartUnlock();
		autoPlayer.robot.delay(2000);
		autoPlayer.updateLog("Action: unlocking third chest");
	}

	protected void unlockSecondChest() {
		tapSecondChest();
		autoPlayer.robot.delay(2000);
		tapStartUnlock();
		autoPlayer.robot.delay(2000);
		autoPlayer.updateLog("Action: unlocking second chest");
	}

	protected void unlockFirstChest() {
		tapFirstChest();
		autoPlayer.robot.delay(2000);
		tapStartUnlock();
		autoPlayer.robot.delay(2000);
		autoPlayer.updateLog("Action: unlocking first chest");
	}
	
	protected void switchMenu(String menuToGo) throws AWTException{
		autoPlayer.gameController.checkGameStatus();
		String oldMenu = autoPlayer.gameController.gameStatus.toString();
		
		switch(menuToGo){
		
		case "BATTLE_MENU" : {
			if(autoPlayer.gameController.gameStatus != GameStatusController.GameStatus.BATTLE_MENU){
				tapBattleMenu();
				autoPlayer.robot.delay(3000);
				autoPlayer.gameController.checkGameStatus();
				autoPlayer.updateLog("Action: switched from " + oldMenu + " to " + autoPlayer.gameController.gameStatus.toString());
			}
			break;
		}
		
		case "TOURNAMENTS_MENU" : {
			if(autoPlayer.gameController.gameStatus != GameStatusController.GameStatus.TOURNAMENTS_MENU){
				tapTournamentsMenu();
				autoPlayer.robot.delay(3000);
				autoPlayer.gameController.checkGameStatus();
				autoPlayer.updateLog("Action: switched from " + oldMenu + " to " + autoPlayer.gameController.gameStatus.toString());
			}
		}
		
		case "SOCIAL_MENU" : {
			if(autoPlayer.gameController.gameStatus != GameStatusController.GameStatus.SOCIAL_MENU){
				tapSocialMenu();
				autoPlayer.robot.delay(3000);
				autoPlayer.gameController.checkGameStatus();
				autoPlayer.updateLog("Action: switched from " + oldMenu + " to " + autoPlayer.gameController.gameStatus.toString());
			}
		}
		
		case "SHOP_MENU" : {
			if(autoPlayer.gameController.gameStatus != GameStatusController.GameStatus.SHOP_MENU){
				tapShopMenu();
				autoPlayer.robot.delay(3000);
				autoPlayer.gameController.checkGameStatus();
				autoPlayer.updateLog("Action: switched from " + oldMenu + " to " + autoPlayer.gameController.gameStatus.toString());
				}
		}
		
		case "CARDS_MENU" : {
			if(autoPlayer.gameController.gameStatus != GameStatusController.GameStatus.CARDS_MENU){
				tapCardsMenu();
				autoPlayer.robot.delay(3000);
				autoPlayer.gameController.checkGameStatus();
				autoPlayer.updateLog("Action: switched from " + oldMenu + " to " + autoPlayer.gameController.gameStatus.toString());
			}
		}
		}
	}

	protected void closeArenaInfo() {
		autoPlayer.robot.delay(2000);
		tapCloseArenaInfoButton();
		autoPlayer.robot.delay(5000);
		autoPlayer.updateLog("Action: closeArenaInfo");
	}
	
	protected void closeBattle(){
		autoPlayer.robot.delay(2000);		
		tapOkButton();
		autoPlayer.robot.delay(5000);
		autoPlayer.updateLog("Action: closeBattle");
	}
	
	protected void startBattle() throws AWTException{
		boolean foundBattle = false;
		autoPlayer.robot.delay(2000);
		switch(autoPlayer.gameController.gameStatus){
		case BATTLE_MENU : {
			tapBattleButton();
			autoPlayer.updateLog("Action: startBattle");
			for(int i = 0; i < 10; i++) {
				autoPlayer.robot.delay(1000);
				autoPlayer.gameController.checkGameStatus();
				if(autoPlayer.gameController.gameStatus == GameStatus.IN_BATTLE)
				{
					i = 100;
					foundBattle = true;
				}
				if(autoPlayer.gameController.gameStatus == GameStatus.REWARD_LIMIT_REACHED)
				{
					i = 100;
				}
			}
			break;
		}
		
		case REWARD_LIMIT_REACHED : {
			tapYesButton();
			autoPlayer.updateLog("Action: startBattle");
			for(int i = 0; i < 10; i++) {
				autoPlayer.robot.delay(1000);
				autoPlayer.gameController.checkGameStatus();
				if(autoPlayer.gameController.gameStatus == GameStatus.IN_BATTLE)
				{
					i = 100;
					foundBattle = true;
				}
			}
			break;
		}
		
		default : break;

		}
		
		if(foundBattle)
		{
			autoPlayer.updateLog("Battle started!");
		}
		else
		{
			autoPlayer.updateLog("Couldn't find any battle!");
		}
	}
}
