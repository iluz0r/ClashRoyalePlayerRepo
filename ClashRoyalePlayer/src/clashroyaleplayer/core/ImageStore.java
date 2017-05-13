package clashroyaleplayer.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageStore {

	private BufferedImage battleButton;
	private BufferedImage emptyChestSlot;
	private BufferedImage lockedSilverChest;
	private BufferedImage unlockingSilverChest;
	private BufferedImage openSilverChest;
	private BufferedImage openCrownChest;
	private BufferedImage openFreeChestx1;
	private BufferedImage lockedCrownChest;
	private BufferedImage lockedFreeChest;
	private BufferedImage lockedGoldChest;
	private BufferedImage unlockingGoldChest;
	private BufferedImage openFreeChestx2;
	private BufferedImage collectingFreeChest;
	private BufferedImage collectedFreeChest;
	private BufferedImage collectingGoldChest;
	private BufferedImage collectedGoldChest;
	private BufferedImage collectingCrwonChest;
	private BufferedImage collectedCrownChest;
	private BufferedImage battleMenu;
	private BufferedImage cardsMenu;
	private BufferedImage shopMenu;
	private BufferedImage socialMenu;
	private BufferedImage tournamentsMenu;
	private BufferedImage lockedMagicChest;
	private BufferedImage unlockingMagicChest;
	private BufferedImage openGoldChest;
	private BufferedImage openMagicChest;
	private BufferedImage collectingMagicChest;
	private BufferedImage collectedMagicChest;
	private BufferedImage collectingSilverChest;
	private BufferedImage collectedSilverChest;
	private BufferedImage emotesIcon;
	private BufferedImage okButton;
	private BufferedImage lowBarArenaInfo;
	private BufferedImage rewardLimitReached;
	private BufferedImage rewardLimitReachedMini;
	private BufferedImage lockedLegendaryChest;
	private BufferedImage unlockingLegendaryChest;
	
	public ImageStore(String basePath) throws IOException {
		
		this.setBattleButton(basePath + "battleButton.jpg");
		this.setEmptyChestSlot(basePath + "emptyChestSlot.jpg");
		this.setLockedSilverChest(basePath + "lockedSilverChest.jpg");
		this.setUnlockingSilverChest(basePath + "unlockingSilverChest.jpg");
		this.setOpenSilverChest(basePath + "openSilverChest.jpg");
		this.setOpenCrownChest(basePath + "openCrownChest.jpg");
		this.setLockedCrownChest(basePath + "lockedCrownChest.jpg");
		this.setLockedFreeChest(basePath + "lockedFreeChest.jpg");
		this.setLockedGoldChest(basePath + "lockedGoldChest.jpg");
		this.setOpenFreeChestx1(basePath + "openFreeChestx1.jpg");
		this.setUnlockingGoldChest(basePath + "unlockingGoldChest.jpg");
		this.setOpenFreeChestx2(basePath + "openFreeChestx2.jpg");
		this.setCollectingFreeChest(basePath + "collectingFreeChest.jpg");
		this.setCollectedFreeChest(basePath + "collectedFreeChest.jpg");
		this.setCollectingGoldChest(basePath + "collectingGoldChest.jpg");
		this.setCollectedGoldChest(basePath + "collectedGoldChest.jpg");
		this.setCollectingCrwonChest(basePath + "collectingCrownChest.jpg");
		this.setCollectedCrownChest(basePath + "collectedCrownChest.jpg");
		this.setBattleMenu(basePath + "battleMenu.jpg");
		this.setCardsMenu(basePath + "cardsMenu.jpg");
		this.setShopMenu(basePath + "shopMenu.jpg");
		this.setSocialMenu(basePath + "socialMenu.jpg");
		this.setTournamentsMenu(basePath + "tournamentsMenu.jpg");
		this.setLockedMagicChest(basePath + "lockedMagicChest.jpg");
		this.setUnlockingMagicChest(basePath + "unlockingMagicChest.jpg");
		this.setOpenGoldChest(basePath + "openGoldChest.jpg");
		this.setOpenMagicChest(basePath + "openMagicChest.jpg");
		this.setCollectingMagicChest(basePath + "collectingMagicChest.jpg");
		this.setCollectedMagicChest(basePath + "collectedMagicChest.jpg");
		this.setCollectingSilverChest(basePath + "collectingSilverChest.jpg");
		this.setCollectedSilverChest(basePath + "collectedSilverChest.jpg");
		this.setEmotesIcon(basePath + "emotesIcon.jpg");
		this.setOkButton(basePath + "okButton.jpg");
		this.setLowBarArenaInfo(basePath + "lowBarArenaInfo.jpg");
		this.setRewardLimitReached(basePath + "rewardLimitReached.jpg");
		this.setRewardLimitReachedMini(basePath + "rewardLimitReachedMini.jpg");
		this.setLockedLegendaryChest(basePath + "lockedLegendaryChest.jpg");
		this.setUnlockingLegendaryChest(basePath + "unlockingLegendaryChest.jpg");
		
	}
	
	
	protected BufferedImage getBattleButton() {
		return battleButton;
	}

	protected void setBattleButton(String battleButtonPath) throws IOException {
		this.battleButton = ImageIO.read(new File(battleButtonPath));
	}
	
	protected BufferedImage getLockedSilverChest(){
		return this.lockedSilverChest;
	}
	
	protected void setLockedSilverChest(String lockedSilverChestPath) throws IOException{
		this.lockedSilverChest = ImageIO.read(new File(lockedSilverChestPath));
	}
	
	protected BufferedImage getEmptyChestSlot(){
		return this.emptyChestSlot;
	}
	
	protected void setEmptyChestSlot(String emptyChestSlotPath) throws IOException{
		this.emptyChestSlot = ImageIO.read(new File(emptyChestSlotPath));
	}
	
	protected BufferedImage getUnlockingSilverChest(){
		return this.unlockingSilverChest;
	}
	
	protected void setUnlockingSilverChest(String unlockingSilverChestPath) throws IOException{
		this.unlockingSilverChest = ImageIO.read(new File(unlockingSilverChestPath));
	}
	
	protected BufferedImage getOpenSilverChest() {
		return this.openSilverChest;
	}
	
	protected void setOpenSilverChest(String openSilverChestPath) throws IOException{
		this.openSilverChest = ImageIO.read(new File(openSilverChestPath));
	}
	
	protected BufferedImage getOpenCrownChest() {
		return this.openCrownChest;
	}
	
	protected void setOpenCrownChest(String openCrownChestPath) throws IOException{
		this.openCrownChest = ImageIO.read(new File(openCrownChestPath));
	}
	
	protected BufferedImage getLockedCrownChest() {
		return this.lockedCrownChest;
	}
	
	protected void setLockedCrownChest(String lockedCrownChestPath) throws IOException{
		this.lockedCrownChest = ImageIO.read(new File(lockedCrownChestPath));
	}
	
	protected BufferedImage getLockedFreeChest() {
		return this.lockedFreeChest;
	}
	
	protected void setLockedFreeChest(String lockedFreeChestPath) throws IOException{
		this.lockedFreeChest = ImageIO.read(new File(lockedFreeChestPath));
	}
	
	protected BufferedImage getLockedGoldChest() {
		return this.lockedGoldChest;
	}
	
	protected void setLockedGoldChest(String lockedGoldChestPath) throws IOException{
		this.lockedGoldChest = ImageIO.read(new File(lockedGoldChestPath));
	}
	
	protected BufferedImage getOpenFreeChestx1() {
		return this.openFreeChestx1;
	}
	
	protected void setOpenFreeChestx1(String openFreeChestx1Path) throws IOException{
		this.openFreeChestx1 = ImageIO.read(new File(openFreeChestx1Path));
	}
	
	protected BufferedImage getUnlockingGoldChest() {
		return this.unlockingGoldChest;
	}
	
	protected void setUnlockingGoldChest(String unlockingGoldChestPath) throws IOException{
		this.unlockingGoldChest = ImageIO.read(new File(unlockingGoldChestPath));
	}
	
	protected BufferedImage getOpenFreeChestx2() {
		return this.openFreeChestx2;
	}
	
	protected void setOpenFreeChestx2(String openFreeChestx2Path) throws IOException{
		this.openFreeChestx2 = ImageIO.read(new File(openFreeChestx2Path));
	}

	protected BufferedImage getCollectingFreeChest() {
		return collectingFreeChest;
	}

	protected void setCollectingFreeChest(String collectingFreeChestPath) throws IOException {
		this.collectingFreeChest = ImageIO.read(new File(collectingFreeChestPath));
	}

	protected BufferedImage getCollectedFreeChest() {
		return collectedFreeChest;
	}

	protected void setCollectedFreeChest(String collectedFreeChestPath) throws IOException {
		this.collectedFreeChest = ImageIO.read(new File(collectedFreeChestPath));
	}

	protected BufferedImage getCollectingGoldChest() {
		return collectingGoldChest;
	}

	protected void setCollectingGoldChest(String collectingGoldChestPath) throws IOException {
		this.collectingGoldChest = ImageIO.read(new File(collectingGoldChestPath));
	}

	protected BufferedImage getCollectedGoldChest() {
		return collectedGoldChest;
	}

	protected void setCollectedGoldChest(String collectedGoldChestPath) throws IOException {
		this.collectedGoldChest = ImageIO.read(new File(collectedGoldChestPath));
	}

	protected BufferedImage getCollectingCrwonChest() {
		return collectingCrwonChest;
	}

	protected void setCollectingCrwonChest(String collectingCrwonChestPath) throws IOException {
		this.collectingCrwonChest = ImageIO.read(new File(collectingCrwonChestPath));
	}

	protected BufferedImage getCollectedCrownChest() {
		return collectedCrownChest;
	}

	protected void setCollectedCrownChest(String collectedCrownChestPath) throws IOException {
		this.collectedCrownChest = ImageIO.read(new File(collectedCrownChestPath));
	}

	protected BufferedImage getBattleMenu() {
		return battleMenu;
	}

	protected void setBattleMenu(String battleMenuPath) throws IOException {
		this.battleMenu = ImageIO.read(new File(battleMenuPath));
	}

	protected BufferedImage getCardsMenu() {
		return cardsMenu;
	}

	protected void setCardsMenu(String cardsMenuPath) throws IOException {
		this.cardsMenu = ImageIO.read(new File(cardsMenuPath));
	}

	protected BufferedImage getShopMenu() {
		return shopMenu;
	}

	protected void setShopMenu(String shopMenuPath) throws IOException {
		this.shopMenu = ImageIO.read(new File(shopMenuPath));
	}

	protected BufferedImage getSocialMenu() {
		return socialMenu;
	}

	protected void setSocialMenu(String socialMenuPath) throws IOException {
		this.socialMenu = ImageIO.read(new File(socialMenuPath));
	}

	protected BufferedImage getTournamentsMenu() {
		return tournamentsMenu;
	}

	protected void setTournamentsMenu(String tournamentsMenuPath) throws IOException {
		this.tournamentsMenu = ImageIO.read(new File(tournamentsMenuPath));
	}

	protected BufferedImage getLockedMagicChest() {
		return lockedMagicChest;
	}

	protected void setLockedMagicChest(String lockedMagicChestPath) throws IOException {
		this.lockedMagicChest = ImageIO.read(new File(lockedMagicChestPath));
	}

	protected BufferedImage getUnlockingMagicChest() {
		return unlockingMagicChest;
	}

	protected void setUnlockingMagicChest(String unlockingMagicChestPath) throws IOException {
		this.unlockingMagicChest = ImageIO.read(new File(unlockingMagicChestPath));
	}

	protected BufferedImage getOpenGoldChest() {
		return openGoldChest;
	}

	protected void setOpenGoldChest(String openGoldChestPath) throws IOException {
		this.openGoldChest = ImageIO.read(new File(openGoldChestPath));
	}

	protected BufferedImage getOpenMagicChest() {
		return openMagicChest;
	}

	protected void setOpenMagicChest(String openMagicChestPath) throws IOException {
		this.openMagicChest = ImageIO.read(new File(openMagicChestPath));
	}

	protected BufferedImage getCollectingMagicChest() {
		return collectingMagicChest;
	}

	protected void setCollectingMagicChest(String collectingMagicChestPath) throws IOException {
		this.collectingMagicChest = ImageIO.read(new File(collectingMagicChestPath));
	}

	protected BufferedImage getCollectedMagicChest() {
		return collectedMagicChest;
	}

	protected void setCollectedMagicChest(String collectedMagicChestPath) throws IOException {
		this.collectedMagicChest = ImageIO.read(new File(collectedMagicChestPath));
	}

	protected BufferedImage getCollectingSilverChest() {
		return collectingSilverChest;
	}

	protected void setCollectingSilverChest(String collectingSilverChestPath) throws IOException {
		this.collectingSilverChest = ImageIO.read(new File(collectingSilverChestPath));
	}

	protected BufferedImage getCollectedSilverChest() {
		return collectedSilverChest;
	}

	protected void setCollectedSilverChest(String collectedSilverChestPath) throws IOException {
		this.collectedSilverChest = ImageIO.read(new File(collectedSilverChestPath));
	}


	protected BufferedImage getEmotesIcon() {
		return emotesIcon;
	}


	protected void setEmotesIcon(String emotesIconPath) throws IOException {
		this.emotesIcon = ImageIO.read(new File(emotesIconPath));
	}


	protected BufferedImage getOkButton() {
		return okButton;
	}


	protected void setOkButton(String okButtonPath) throws IOException {
		this.okButton = ImageIO.read(new File(okButtonPath));
	}


	protected BufferedImage getLowBarArenaInfo() {
		return lowBarArenaInfo;
	}


	protected void setLowBarArenaInfo(String lowBarArenaInfoPath) throws IOException {
		this.lowBarArenaInfo = ImageIO.read(new File(lowBarArenaInfoPath));
	}


	protected BufferedImage getRewardLimitReached() {
		return rewardLimitReached;
	}


	protected void setRewardLimitReached(String rewardLimitReachedPath) throws IOException {
		this.rewardLimitReached = ImageIO.read(new File(rewardLimitReachedPath));
	}


	protected BufferedImage getRewardLimitReachedMini() {
		return rewardLimitReachedMini;
	}


	protected void setRewardLimitReachedMini(String rewardLimitReachedMiniPath) throws IOException {
		this.rewardLimitReachedMini = ImageIO.read(new File(rewardLimitReachedMiniPath));
	}


	protected BufferedImage getLockedLegendaryChest() {
		return lockedLegendaryChest;
	}


	protected void setLockedLegendaryChest(String lockedLegendaryChestPath) throws IOException {
		this.lockedLegendaryChest = ImageIO.read(new File(lockedLegendaryChestPath));
	}


	protected BufferedImage getUnlockingLegendaryChest() {
		return unlockingLegendaryChest;
	}


	protected void setUnlockingLegendaryChest(String unlockingLegendaryChestPath) throws IOException {
		this.unlockingLegendaryChest = ImageIO.read(new File(unlockingLegendaryChestPath));
	}
}
