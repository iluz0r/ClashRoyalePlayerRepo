package imageProcessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageStore {

	private BufferedImage battleButton;
	private BufferedImage emptyChestSlot;
	private BufferedImage lockedSilverChestA9;
	private BufferedImage unlockingSilverChest;
	private BufferedImage openSilverChest;
	private BufferedImage openCrownChest;
	private BufferedImage openFreeChestx1;
	private BufferedImage lockedCrownChest;
	private BufferedImage lockedFreeChest;
	private BufferedImage lockedGoldChestA9;
	private BufferedImage unlockingGoldChest;
	private BufferedImage openFreeChestx2;
	
	public ImageStore(
			String battleButtonPath, 
			String emptyChestSlotPath, 
			String lockedSilverChestA9Path,
			String unlockingSilverChestPath,
			String openSilverChestPath,
			String openCrownChestPath,
			String openFreeChestx1Path,
			String lockedCrownChestPath,
			String lockedFreeChestPath,
			String lockedGoldChestA9Path,
			String unlockingGoldChestPath,
			String openFreeChestx2Path) 
					throws IOException
	{
		this.battleButton = ImageIO.read(new File(battleButtonPath));
		this.emptyChestSlot = ImageIO.read(new File(emptyChestSlotPath));
		this.lockedSilverChestA9 = ImageIO.read(new File(lockedSilverChestA9Path));
		this.unlockingSilverChest = ImageIO.read(new File(unlockingSilverChestPath));
		this.openSilverChest = ImageIO.read(new File(openSilverChestPath));
		this.openCrownChest = ImageIO.read(new File(openCrownChestPath));
		this.lockedCrownChest = ImageIO.read(new File(lockedCrownChestPath));
		this.lockedFreeChest = ImageIO.read(new File(lockedFreeChestPath));
		this.lockedGoldChestA9 = ImageIO.read(new File(lockedGoldChestA9Path));
		this.openFreeChestx1 = ImageIO.read(new File(openFreeChestx1Path));
		this.unlockingGoldChest = ImageIO.read(new File(unlockingGoldChestPath));
		this.openFreeChestx2 = ImageIO.read(new File(openFreeChestx2Path));
	}
	
	public ImageStore(){
		this.battleButton = null;
		this.emptyChestSlot = null;
		this.lockedSilverChestA9 = null;
		this.unlockingSilverChest = null;
		this.openSilverChest = null;
		this.lockedCrownChest = null;
		this.lockedGoldChestA9 = null;
		this.openCrownChest = null;
		this.lockedFreeChest = null;
		this.openFreeChestx1 = null;
		this.unlockingGoldChest = null;
		this.openFreeChestx2 = null;
	}
	
	public BufferedImage getBattleButton() {
		return battleButton;
	}

	public void setBattleButton(String battleButtonPath) throws IOException {
		this.battleButton = ImageIO.read(new File(battleButtonPath));
	}
	
	public BufferedImage getLockedSilverChestA9(){
		return this.lockedSilverChestA9;
	}
	
	public void setLockedSilverChestA9(String lockedSilverChestA9Path) throws IOException{
		this.lockedSilverChestA9 = ImageIO.read(new File(lockedSilverChestA9Path));
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
	
	public BufferedImage getLockedGoldChestA9() {
		return this.lockedGoldChestA9;
	}
	
	public void setLockedGoldChestA9(String lockedGoldChestA9Path) throws IOException{
		this.lockedGoldChestA9 = ImageIO.read(new File(lockedGoldChestA9Path));
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
}
