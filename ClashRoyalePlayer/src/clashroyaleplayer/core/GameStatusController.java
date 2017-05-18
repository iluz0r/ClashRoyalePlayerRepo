package clashroyaleplayer.core;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;

import clashroyaleplayer.imageprocessing.ImageComparison;

public class GameStatusController {
	
	protected ImageCapturer imageCapturer;
	protected ImageComparison imageComparison;
	protected ImageStore imageStore;
	protected AutoPlayer autoPlayer;
	
	public static enum GameStatus {
		BATTLE_MENU, TOURNAMENTS_MENU, SOCIAL_MENU, SHOP_MENU, CARDS_MENU,
		IN_BATTLE, END_BATTLE, ARENA_INFO, REWARD_LIMIT_REACHED, UNKNOWN
	    }

	    public static enum ChestStatus {
		UNLOCKING, UNLOCKABLE, LOCKED, EMPTY, UNKNOWN
	    }

	    public static enum CollectingStatus {
		COLLECTING, COLLECTED, UNKNOWN
	    }
	    
	    protected GameStatus gameStatus;
	    protected ChestStatus firstChestStatus;
	    protected ChestStatus secondChestStatus;
	    protected ChestStatus thirdChestStatus;
	    protected ChestStatus fourthChestStatus;
	    protected ChestStatus freeChestStatus;
	    protected ChestStatus crownChestStatus;
	    protected CollectingStatus collectingStatus;
		
		public GameStatusController(AutoPlayer autoPlayer) throws Exception{
			
			this.autoPlayer = autoPlayer;
			imageCapturer = new ImageCapturer(autoPlayer);
			imageComparison = new ImageComparison();
			imageStore = new ImageStore("." + File.separator + "images" + autoPlayer.resolutionToString() + File.separator);
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
		
		protected void checkGameStatus() throws AWTException{
			
			BufferedImage capturedBattleMenu = imageCapturer.captureBattleMenu();
			BufferedImage capturedTournamentsMenu = imageCapturer.captureTournamentsMenu();
			BufferedImage capturedSocialMenu = imageCapturer.captureSocialMenu();
			BufferedImage capturedShopMenu = imageCapturer.captureShopMenu();
			BufferedImage capturedCardsMenu = imageCapturer.captureCardsMenu();
			BufferedImage capturedEmotesIcon = imageCapturer.captureEmotesIcon();
			BufferedImage capturedOkButton = imageCapturer.captureOkButton();
			BufferedImage capturedLowBarArenaInfo = imageCapturer.captureLowBarArenaInfo();
			BufferedImage capturedRewardLimitReachedMini = imageCapturer.captureRewardLimitReachedMini();
			
			BufferedImage battleMenu = imageStore.getBattleMenu();
			BufferedImage tournamentsMenu = imageStore.getTournamentsMenu();
			BufferedImage socialMenu = imageStore.getSocialMenu();
			BufferedImage shopMenu = imageStore.getShopMenu();
			BufferedImage cardsMenu = imageStore.getCardsMenu();
			BufferedImage emotesIcon = imageStore.getEmotesIcon();
			BufferedImage okButton = imageStore.getOkButton();
			BufferedImage lowBarArenaInfo = imageStore.getLowBarArenaInfo();
			BufferedImage rewardLimitReachedMini = imageStore.getRewardLimitReachedMini();
			
			autoPlayer.actions.pointOutside();

			if(imageComparison.imgEqual(emotesIcon, capturedEmotesIcon, 3)){
				if(imageComparison.imgEqual(okButton, capturedOkButton, 3))
					gameStatus = GameStatus.END_BATTLE;
				else
					gameStatus = GameStatus.IN_BATTLE;
			}
			else
				if (imageComparison.imgEqual(battleMenu, capturedBattleMenu, 3)) 
					gameStatus = GameStatus.BATTLE_MENU;
				else
					if(imageComparison.imgEqual(lowBarArenaInfo, capturedLowBarArenaInfo, 3))
						gameStatus = GameStatus.ARENA_INFO;
					else
						if(imageComparison.imgEqual(rewardLimitReachedMini, capturedRewardLimitReachedMini, 3))
							gameStatus = GameStatus.REWARD_LIMIT_REACHED;
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
			autoPlayer.updateLog("Action: check gameStatus, game state: " + gameStatus.toString());
		}
		
		protected void checkFirstChestStatus() throws AWTException{
			
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
			BufferedImage lockedGiantChest = imageStore.getLockedGiantChest();
			BufferedImage unlockingGiantChest = imageStore.getUnlockingGiantChest();
			BufferedImage openGiantChest = imageStore.getOpenGiantChest();
			BufferedImage emptyChest = imageStore.getEmptyChestSlot();
			
			BufferedImage capturedFirstChest = imageCapturer.captureFirstChest();
			
			autoPlayer.actions.pointOutside();
			
			if(
					imageComparison.imgEqual(lockedSilverChest, capturedFirstChest, 15) ||
					imageComparison.imgEqual(lockedGoldChest, capturedFirstChest, 15) ||
					imageComparison.imgEqual(lockedMagicChest, capturedFirstChest, 15) ||
					imageComparison.imgEqual(lockedGiantChest, capturedFirstChest, 15))
			{
				firstChestStatus = ChestStatus.LOCKED;
			}
			else
				if(
						imageComparison.imgEqual(unlockingSilverChest, capturedFirstChest, 15) ||
						imageComparison.imgEqual(unlockingGoldChest, capturedFirstChest, 15) ||
						imageComparison.imgEqual(unlockingMagicChest, capturedFirstChest, 15) ||
						imageComparison.imgEqual(unlockingGiantChest, capturedFirstChest, 15))
				{
					firstChestStatus = ChestStatus.UNLOCKING;
				}
				else
					if(
							imageComparison.imgEqual(openSilverChest, capturedFirstChest, 15) ||
							imageComparison.imgEqual(openGoldChest, capturedFirstChest, 15) ||
							imageComparison.imgEqual(openMagicChest, capturedFirstChest, 15) ||
							imageComparison.imgEqual(openGiantChest, capturedFirstChest, 15))
					{
						firstChestStatus = ChestStatus.UNLOCKABLE;
					}
					else
						if(imageComparison.imgEqual(emptyChest, capturedFirstChest, 15))
						{
							firstChestStatus = ChestStatus.EMPTY;
						}
			
			autoPlayer.updateLog("Action: checkFirstChestStatus, the state is " + firstChestStatus.toString());
		}
		
		protected void checkSecondChestStatus() throws AWTException{
			
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
			BufferedImage lockedGiantChest = imageStore.getLockedGiantChest();
			BufferedImage unlockingGiantChest = imageStore.getUnlockingGiantChest();
			BufferedImage openGiantChest = imageStore.getOpenGiantChest();
			BufferedImage emptyChest = imageStore.getEmptyChestSlot();
			
			BufferedImage capturedSecondChest = imageCapturer.captureSecondChest();
			
			autoPlayer.actions.pointOutside();
			
			if(
					imageComparison.imgEqual(lockedSilverChest, capturedSecondChest, 15) ||
					imageComparison.imgEqual(lockedGoldChest, capturedSecondChest, 15) ||
					imageComparison.imgEqual(lockedMagicChest, capturedSecondChest, 15) ||
					imageComparison.imgEqual(lockedGiantChest, capturedSecondChest, 15))
			{
				secondChestStatus = ChestStatus.LOCKED;
			}
			else
				if(
						imageComparison.imgEqual(unlockingSilverChest, capturedSecondChest, 15) ||
						imageComparison.imgEqual(unlockingGoldChest, capturedSecondChest, 15) ||
						imageComparison.imgEqual(unlockingMagicChest, capturedSecondChest, 15) ||
						imageComparison.imgEqual(unlockingGiantChest, capturedSecondChest, 15))
				{
					secondChestStatus = ChestStatus.UNLOCKING;
				}
				else
					if(
							imageComparison.imgEqual(openSilverChest, capturedSecondChest, 15) ||
							imageComparison.imgEqual(openGoldChest, capturedSecondChest, 15) ||
							imageComparison.imgEqual(openMagicChest, capturedSecondChest, 15) ||
							imageComparison.imgEqual(openGiantChest, capturedSecondChest, 15))
					{
						secondChestStatus = ChestStatus.UNLOCKABLE;
					}
					else
						if(imageComparison.imgEqual(emptyChest, capturedSecondChest, 15))
						{
							secondChestStatus = ChestStatus.EMPTY;
						}
			
			autoPlayer.updateLog("Action: checkSecondChestStatus, the state is " + secondChestStatus.toString());
		}
		protected void checkThirdChestStatus() throws AWTException{
			
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
			BufferedImage lockedGiantChest = imageStore.getLockedGiantChest();
			BufferedImage unlockingGiantChest = imageStore.getUnlockingGiantChest();
			BufferedImage openGiantChest = imageStore.getOpenGiantChest();
			BufferedImage emptyChest = imageStore.getEmptyChestSlot();
		
			BufferedImage capturedThirdChest = imageCapturer.captureThirdChest();
			
			autoPlayer.actions.pointOutside();
		
			if(
					imageComparison.imgEqual(lockedSilverChest, capturedThirdChest, 15) ||
					imageComparison.imgEqual(lockedGoldChest, capturedThirdChest, 15) ||
					imageComparison.imgEqual(lockedMagicChest, capturedThirdChest, 15) ||
					imageComparison.imgEqual(lockedGiantChest, capturedThirdChest, 15))
			{
				thirdChestStatus = ChestStatus.LOCKED;
			}
			else
				if(
						imageComparison.imgEqual(unlockingSilverChest, capturedThirdChest, 15) ||
						imageComparison.imgEqual(unlockingGoldChest, capturedThirdChest, 15) ||
						imageComparison.imgEqual(unlockingMagicChest, capturedThirdChest, 15) ||
						imageComparison.imgEqual(unlockingGiantChest, capturedThirdChest, 15))
				{
					thirdChestStatus = ChestStatus.UNLOCKING;
				}
				else
					if(
							imageComparison.imgEqual(openSilverChest, capturedThirdChest, 15) ||
							imageComparison.imgEqual(openGoldChest, capturedThirdChest, 15) ||
							imageComparison.imgEqual(openMagicChest, capturedThirdChest, 15) ||
							imageComparison.imgEqual(openGiantChest, capturedThirdChest, 15))
					{
						thirdChestStatus = ChestStatus.UNLOCKABLE;
					}
					else
						if(imageComparison.imgEqual(emptyChest, capturedThirdChest, 15))
						{
							thirdChestStatus = ChestStatus.EMPTY;
						}
		
			autoPlayer.updateLog("Action: checkThirdChestStatus, the state is " + thirdChestStatus.toString());
		}
		
		protected void checkFourthChestStatus() throws AWTException{
			
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
			BufferedImage lockedGiantChest = imageStore.getLockedGiantChest();
			BufferedImage unlockingGiantChest = imageStore.getUnlockingGiantChest();
			BufferedImage openGiantChest = imageStore.getOpenGiantChest();
			BufferedImage emptyChest = imageStore.getEmptyChestSlot();
		
			BufferedImage capturedFourthChest = imageCapturer.captureFourthChest();
			
			autoPlayer.actions.pointOutside();
		
			if(
					imageComparison.imgEqual(lockedSilverChest, capturedFourthChest, 15) ||
					imageComparison.imgEqual(lockedGoldChest, capturedFourthChest, 15) ||
					imageComparison.imgEqual(lockedMagicChest, capturedFourthChest, 15) ||
					imageComparison.imgEqual(lockedGiantChest, capturedFourthChest, 15))
			{
				fourthChestStatus = ChestStatus.LOCKED;
			}
			else
				if(
						imageComparison.imgEqual(unlockingSilverChest, capturedFourthChest, 15) ||
						imageComparison.imgEqual(unlockingGoldChest, capturedFourthChest, 15) ||
						imageComparison.imgEqual(unlockingMagicChest, capturedFourthChest, 15) ||
						imageComparison.imgEqual(unlockingGiantChest, capturedFourthChest, 15))
				{
					fourthChestStatus = ChestStatus.UNLOCKING;
				}
				else
					if(
							imageComparison.imgEqual(openSilverChest, capturedFourthChest, 15) ||
							imageComparison.imgEqual(openGoldChest, capturedFourthChest, 15) ||
							imageComparison.imgEqual(openMagicChest, capturedFourthChest, 15) ||
							imageComparison.imgEqual(openGiantChest, capturedFourthChest, 15))
					{
						fourthChestStatus = ChestStatus.UNLOCKABLE;
					}
					else
						if(imageComparison.imgEqual(emptyChest, capturedFourthChest, 15))
						{
							fourthChestStatus = ChestStatus.EMPTY;
						}
			autoPlayer.updateLog("Action: checkFourthChestStatus, the state is " + fourthChestStatus.toString());
		}
		
		protected void checkFreeChestStatus() throws AWTException{
			freeChestStatus = ChestStatus.UNKNOWN;
			
			BufferedImage openFreeChestx1 = imageStore.getOpenFreeChestx1();
			BufferedImage openFreeChestx2 = imageStore.getOpenFreeChestx2();
			
			BufferedImage capturedFreeChest = imageCapturer.captureFreeChest();
			
			autoPlayer.actions.pointOutside();
			
			if(
					imageComparison.imgEqual(capturedFreeChest, openFreeChestx1) ||
					imageComparison.imgEqual(capturedFreeChest, openFreeChestx2))
				freeChestStatus = ChestStatus.UNLOCKABLE;
			else
				freeChestStatus = ChestStatus.UNLOCKING;
			
			autoPlayer.updateLog("Action: checkFreeChestStatus, the state is " + freeChestStatus.toString());
		}
		
		protected void checkCrownChestStatus() throws AWTException{
			crownChestStatus = ChestStatus.UNKNOWN;
			
			BufferedImage openCrownChest = imageStore.getOpenCrownChest();
			
			BufferedImage capturedCrownChest = imageCapturer.captureCrownChest();
			
			autoPlayer.actions.pointOutside();
			
			if(imageComparison.imgEqual(capturedCrownChest, openCrownChest))
				crownChestStatus = ChestStatus.UNLOCKABLE;
			else
				crownChestStatus = ChestStatus.UNLOCKING;
			
			autoPlayer.updateLog("Action: checkCrownChestStatus, the state is " + crownChestStatus.toString());
			
		}
		
		protected void checkAllChestStatus() throws AWTException {
			checkFirstChestStatus();
			checkSecondChestStatus();
			checkThirdChestStatus();
			checkFourthChestStatus();
			checkFreeChestStatus();
			checkCrownChestStatus();
		}
		protected void checkCollectingStatus() throws AWTException{
			
			collectingStatus = CollectingStatus.UNKNOWN;
			
			BufferedImage capturedCollectingChest = imageCapturer.captureCollectingChest();
			BufferedImage capturedCollectedChest = imageCapturer.captureCollectedChest();
			
			BufferedImage collectingSilverChest = imageStore.getCollectingSilverChest();
			BufferedImage collectingGoldChest = imageStore.getCollectingGoldChest();
			BufferedImage collectingMagicChest = imageStore.getCollectingMagicChest();
			BufferedImage collectingGiantChest = imageStore.getCollectingGiantChest();
			BufferedImage collectingFreeChest = imageStore.getCollectingFreeChest();
			BufferedImage collectingCrownChest = imageStore.getCollectingCrwonChest();
			BufferedImage collectedSilverChest = imageStore.getCollectedSilverChest();
			BufferedImage collectedGoldChest = imageStore.getCollectedGoldChest();
			BufferedImage collectedMagicChest = imageStore.getCollectedMagicChest();
			BufferedImage collectedGiantChest = imageStore.getCollectedGiantChest();
			BufferedImage collectedFreeChest = imageStore.getCollectedFreeChest();
			BufferedImage collectedCrownChest = imageStore.getCollectedCrownChest();
			
			autoPlayer.actions.pointOutside();
			
			if(
					imageComparison.imgEqual(capturedCollectingChest, collectingSilverChest, 15) ||
					imageComparison.imgEqual(capturedCollectingChest, collectingGoldChest, 15) ||
					imageComparison.imgEqual(capturedCollectingChest, collectingMagicChest, 15) ||
					imageComparison.imgEqual(capturedCollectingChest, collectingCrownChest, 15) ||
					imageComparison.imgEqual(capturedCollectingChest, collectingFreeChest,15) ||
					imageComparison.imgEqual(capturedCollectingChest, collectingGiantChest))
			{
				collectingStatus = CollectingStatus.COLLECTING;
			}
				else
					if(
							imageComparison.imgEqual(capturedCollectedChest, collectedSilverChest, 15) ||
							imageComparison.imgEqual(capturedCollectedChest, collectedGoldChest,15) ||
							imageComparison.imgEqual(capturedCollectedChest, collectedMagicChest, 15) ||
							imageComparison.imgEqual(capturedCollectedChest, collectedCrownChest, 15) ||
							imageComparison.imgEqual(capturedCollectedChest, collectedFreeChest, 15) ||
							imageComparison.imgEqual(capturedCollectedChest, collectedGiantChest, 15))
					{
						collectingStatus = CollectingStatus.COLLECTED;
					}
			
			autoPlayer.updateLog("Action: checkCollectingStatus, the state is " + collectingStatus.toString());
		}
	    
}
