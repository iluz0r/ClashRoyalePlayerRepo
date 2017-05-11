package imageProcessing;

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
	
	public ImageStore(String basePath) 
					throws IOException
	{
		this.setBattleButton(basePath + "battleButton.img");
		this.setEmptyChestSlot(basePath + "emptyChestSlot");
		this.setLockedSilverChest(basePath + "lockedSilverChest");
		this.setUnlockingSilverChest(basePath + "unlockingSilverChest");
		this.setOpenSilverChest(basePath + "openSilverChest");
		this.setOpenCrownChest(basePath + "openCrownChest");
		this.setLockedCrownChest(basePath + "lockedCrownChest");
		this.setLockedFreeChest(basePath + "lockedFreeChest");
		this.setLockedGoldChest(basePath + "lockedGoldChest");
		this.setOpenFreeChestx1(basePath + "openFreeChestx1");
		this.setUnlockingGoldChest(basePath + "unlockingGoldChest");
		this.setOpenFreeChestx2(basePath + "openFreeChestx2");
		this.setCollectingFreeChest(basePath + "collectingFreeChest");
		this.setCollectedFreeChest(basePath + "collectedFreeChest");
		this.setCollectingGoldChest(basePath + "collectingGoldChest");
		this.setCollectedGoldChest(basePath + "collectedGoldChest");
		this.setCollectingCrwonChest(basePath + "collectingCrownChest");
		this.setCollectedCrownChest(basePath + "collectedCrownChest");
		this.setBattleMenu(basePath + "battleMenu");
		this.setCardsMenu(basePath + "cardsMenu");
		this.setShopMenu(basePath + "shopMenu");
		this.setSocialMenu(basePath + "socialMenu");
		this.setTournamentsMenu(basePath + "tournamentsMenu");
		this.setLockedMagicChest(basePath + "lockedMagicChest");
		this.setUnlockingMagicChest(basePath + "unlockingMagicChest");
		this.setOpenGoldChest(basePath + "openGoldChest");
		this.setOpenMagicChest(basePath + "openMagicChest");
		this.setCollectingMagicChest(basePath + "collectingMagicChest");
		this.setCollectedMagicChest(basePath + "collectedMagicChest");
		this.setCollectingSilverChest(basePath + "collectingSilverChest");
		this.setCollectedSilverChest(basePath + "collectedSilverChest");
		
	}
	
	public ImageStore(){
	}
	
	public BufferedImage getBattleButton() {
		return battleButton;
	}

	public void setBattleButton(String battleButtonPath) throws IOException {
		this.battleButton = ImageIO.read(new File(battleButtonPath));
	}
	
	public BufferedImage getLockedSilverChest(){
		return this.lockedSilverChest;
	}
	
	public void setLockedSilverChest(String lockedSilverChestPath) throws IOException{
		this.lockedSilverChest = ImageIO.read(new File(lockedSilverChestPath));
	}
	
	public BufferedImage getEmptyChestSlot(){
		return this.emptyChestSlot;
	}
	
	public void setEmptyChestSlot(String emptyChestSlotPath) throws IOException{
		this.emptyChestSlot = ImageIO.read(new File(emptyChestSlotPath));
	}
	
	public BufferedImage getUnlockingSilverChest(){
		return this.unlockingSilverChest;
	}
	
	public void setUnlockingSilverChest(String unlockingSilverChestPath) throws IOException{
		this.unlockingSilverChest = ImageIO.read(new File(unlockingSilverChestPath));
	}
	
	public BufferedImage getOpenSilverChest() {
		return this.openSilverChest;
	}
	
	public void setOpenSilverChest(String openSilverChestPath) throws IOException{
		this.openSilverChest = ImageIO.read(new File(openSilverChestPath));
	}
	
	public BufferedImage getOpenCrownChest() {
		return this.openCrownChest;
	}
	
	public void setOpenCrownChest(String openCrownChestPath) throws IOException{
		this.openCrownChest = ImageIO.read(new File(openCrownChestPath));
	}
	
	public BufferedImage getLockedCrownChest() {
		return this.lockedCrownChest;
	}
	
	public void setLockedCrownChest(String lockedCrownChestPath) throws IOException{
		this.lockedCrownChest = ImageIO.read(new File(lockedCrownChestPath));
	}
	
	public BufferedImage getLockedFreeChest() {
		return this.lockedFreeChest;
	}
	
	public void setLockedFreeChest(String lockedFreeChestPath) throws IOException{
		this.lockedFreeChest = ImageIO.read(new File(lockedFreeChestPath));
	}
	
	public BufferedImage getLockedGoldChest() {
		return this.lockedGoldChest;
	}
	
	public void setLockedGoldChest(String lockedGoldChestPath) throws IOException{
		this.lockedGoldChest = ImageIO.read(new File(lockedGoldChestPath));
	}
	
	public BufferedImage getOpenFreeChestx1() {
		return this.openFreeChestx1;
	}
	
	public void setOpenFreeChestx1(String openFreeChestx1Path) throws IOException{
		this.openFreeChestx1 = ImageIO.read(new File(openFreeChestx1Path));
	}
	
	public BufferedImage getUnlockingGoldChest() {
		return this.unlockingGoldChest;
	}
	
	public void setUnlockingGoldChest(String unlockingGoldChestPath) throws IOException{
		this.unlockingGoldChest = ImageIO.read(new File(unlockingGoldChestPath));
	}
	
	public BufferedImage getOpenFreeChestx2() {
		return this.openFreeChestx2;
	}
	
	public void setOpenFreeChestx2(String openFreeChestx2Path) throws IOException{
		this.openFreeChestx2 = ImageIO.read(new File(openFreeChestx2Path));
	}

	public BufferedImage getCollectingFreeChest() {
		return collectingFreeChest;
	}

	public void setCollectingFreeChest(String collectingFreeChestPath) throws IOException {
		this.collectingFreeChest = ImageIO.read(new File(collectingFreeChestPath));
	}

	public BufferedImage getCollectedFreeChest() {
		return collectedFreeChest;
	}

	public void setCollectedFreeChest(String collectedFreeChestPath) throws IOException {
		this.collectedFreeChest = ImageIO.read(new File(collectedFreeChestPath));
	}

	public BufferedImage getCollectingGoldChest() {
		return collectingGoldChest;
	}

	public void setCollectingGoldChest(String collectingGoldChestPath) throws IOException {
		this.collectingGoldChest = ImageIO.read(new File(collectingGoldChestPath));
	}

	public BufferedImage getCollectedGoldChest() {
		return collectedGoldChest;
	}

	public void setCollectedGoldChest(String collectedGoldChestPath) throws IOException {
		this.collectedGoldChest = ImageIO.read(new File(collectedGoldChestPath));
	}

	public BufferedImage getCollectingCrwonChest() {
		return collectingCrwonChest;
	}

	public void setCollectingCrwonChest(String collectingCrwonChestPath) throws IOException {
		this.collectingCrwonChest = ImageIO.read(new File(collectingCrwonChestPath));
	}

	public BufferedImage getCollectedCrownChest() {
		return collectedCrownChest;
	}

	public void setCollectedCrownChest(String collectedCrownChestPath) throws IOException {
		this.collectedCrownChest = ImageIO.read(new File(collectedCrownChestPath));
	}

	public BufferedImage getBattleMenu() {
		return battleMenu;
	}

	public void setBattleMenu(String battleMenuPath) throws IOException {
		this.battleMenu = ImageIO.read(new File(battleMenuPath));
	}

	public BufferedImage getCardsMenu() {
		return cardsMenu;
	}

	public void setCardsMenu(String cardsMenuPath) throws IOException {
		this.cardsMenu = ImageIO.read(new File(cardsMenuPath));
	}

	public BufferedImage getShopMenu() {
		return shopMenu;
	}

	public void setShopMenu(String shopMenuPath) throws IOException {
		this.shopMenu = ImageIO.read(new File(shopMenuPath));
	}

	public BufferedImage getSocialMenu() {
		return socialMenu;
	}

	public void setSocialMenu(String socialMenuPath) throws IOException {
		this.socialMenu = ImageIO.read(new File(socialMenuPath));
	}

	public BufferedImage getTournamentsMenu() {
		return tournamentsMenu;
	}

	public void setTournamentsMenu(String tournamentsMenuPath) throws IOException {
		this.tournamentsMenu = ImageIO.read(new File(tournamentsMenuPath));
	}

	public BufferedImage getLockedMagicChest() {
		return lockedMagicChest;
	}

	public void setLockedMagicChest(String lockedMagicChestPath) throws IOException {
		this.lockedMagicChest = ImageIO.read(new File(lockedMagicChestPath));
	}

	public BufferedImage getUnlockingMagicChest() {
		return unlockingMagicChest;
	}

	public void setUnlockingMagicChest(String unlockingMagicChestPath) throws IOException {
		this.unlockingMagicChest = ImageIO.read(new File(unlockingMagicChestPath));
	}

	public BufferedImage getOpenGoldChest() {
		return openGoldChest;
	}

	public void setOpenGoldChest(String openGoldChestPath) throws IOException {
		this.openGoldChest = ImageIO.read(new File(openGoldChestPath));
	}

	public BufferedImage getOpenMagicChest() {
		return openMagicChest;
	}

	public void setOpenMagicChest(String openMagicChestPath) throws IOException {
		this.openMagicChest = ImageIO.read(new File(openMagicChestPath));
	}

	public BufferedImage getCollectingMagicChest() {
		return collectingMagicChest;
	}

	public void setCollectingMagicChest(String collectingMagicChestPath) throws IOException {
		this.collectingMagicChest = ImageIO.read(new File(collectingMagicChestPath));
	}

	public BufferedImage getCollectedMagicChest() {
		return collectedMagicChest;
	}

	public void setCollectedMagicChest(String collectedMagicChestPath) throws IOException {
		this.collectedMagicChest = ImageIO.read(new File(collectedMagicChestPath));
	}

	public BufferedImage getCollectingSilverChest() {
		return collectingSilverChest;
	}

	public void setCollectingSilverChest(String collectingSilverChestPath) throws IOException {
		this.collectingSilverChest = ImageIO.read(new File(collectingSilverChestPath));
	}

	public BufferedImage getCollectedSilverChest() {
		return collectedSilverChest;
	}

	public void setCollectedSilverChest(String collectedSilverChestPath) throws IOException {
		this.collectedSilverChest = ImageIO.read(new File(collectedSilverChestPath));
	}
}
