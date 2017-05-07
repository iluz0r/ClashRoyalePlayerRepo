package imageProcessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageStore {

	private BufferedImage battleButton = null;
	private BufferedImage emptyChestSlot = null;
	private BufferedImage lockedSilverChest = null;
	private BufferedImage unlockingSilverChest = null;
	private BufferedImage openSilverChest = null;
	private BufferedImage openCrownChest = null;
	private BufferedImage openFreeChestx1 = null;
	private BufferedImage lockedCrownChest = null;
	private BufferedImage lockedFreeChest = null;
	private BufferedImage lockedGoldChest = null;
	private BufferedImage unlockingGoldChest = null;
	private BufferedImage openFreeChestx2 = null;
	private BufferedImage collectingFreeChest = null;
	private BufferedImage collectedFreeChest = null;
	private BufferedImage collectingGoldChest = null;
	private BufferedImage collectedGoldChest = null;
	private BufferedImage collectingCrwonChest = null;
	private BufferedImage collectedCrownChest = null;
	
	public ImageStore(
			String battleButtonPath, 
			String emptyChestSlotPath, 
			String lockedSilverChestPath,
			String unlockingSilverChestPath,
			String openSilverChestPath,
			String openCrownChestPath,
			String openFreeChestx1Path,
			String lockedCrownChestPath,
			String lockedFreeChestPath,
			String lockedGoldChestPath,
			String unlockingGoldChestPath,
			String openFreeChestx2Path,
			String collectingFreeChestPath,
			String collectedFreeChestPath,
			String collectingGoldChestPath,
			String collectedGoldChestPath,
			String collectingCrownChestPath,
			String collectedCrownChestPath) 
					throws IOException
	{
		this.setBattleButton(battleButtonPath);
		this.setEmptyChestSlot(emptyChestSlotPath);
		this.setLockedSilverChest(lockedSilverChestPath);
		this.setUnlockingSilverChest(unlockingSilverChestPath);
		this.setOpenSilverChest(openSilverChestPath);
		this.setOpenCrownChest(openCrownChestPath);
		this.setLockedCrownChest(lockedCrownChestPath);
		this.setLockedFreeChest(lockedFreeChestPath);
		this.setLockedGoldChest(lockedGoldChestPath);
		this.setOpenFreeChestx1(openFreeChestx1Path);
		this.setUnlockingGoldChest(unlockingGoldChestPath);
		this.setOpenFreeChestx2(openFreeChestx2Path);
		this.setCollectingFreeChest(collectingFreeChestPath);
		this.setCollectedFreeChest(collectedFreeChestPath);
		this.setCollectingGoldChest(collectingGoldChestPath);
		this.setCollectedGoldChest(collectedGoldChestPath);
		this.setCollectingCrwonChest(collectingCrownChestPath);
		this.setCollectedCrownChest(collectedCrownChestPath);
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
}
