package imageProcessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageStore {

	private BufferedImage battleButton;
	private BufferedImage emptyChestSlot;
	private BufferedImage lockedSilverChestA9;
	private BufferedImage lockingSilverChest;
	
	public ImageStore(
			String battleButtonPath, 
			String emptyChestSlotPath, 
			String lockedSilverChestA9Path,
			String lockingSilverChestPath) 
					throws IOException
	{
		this.battleButton = ImageIO.read(new File(battleButtonPath));
		this.emptyChestSlot = ImageIO.read(new File(emptyChestSlotPath));
		this.lockedSilverChestA9 = ImageIO.read(new File(lockedSilverChestA9Path));
		this.lockingSilverChest = ImageIO.read(new File(lockingSilverChestPath));
	}
	
	public ImageStore(){
		this.battleButton = null;
		this.emptyChestSlot = null;
		this.lockedSilverChestA9 = null;
		this.lockingSilverChest = null;
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
	
	public BufferedImage getLockingSilverChest(){
		return this.lockingSilverChest;
	}
	
	public void setLockingSilverChest(String lockingSilverChestPath) throws IOException{
		this.lockingSilverChest = ImageIO.read(new File(lockingSilverChestPath));
	}
	
}
