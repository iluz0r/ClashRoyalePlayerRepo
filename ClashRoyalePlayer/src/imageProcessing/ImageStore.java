package imageProcessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageStore {

	private BufferedImage battleButton;
	
	public ImageStore(String battleButtonPath) throws IOException{
		this.battleButton = ImageIO.read(new File(battleButtonPath));
	}
	
	public ImageStore(){
		this.battleButton = null;
	}

	public BufferedImage getBattleButton() {
		return battleButton;
	}

	public void setBattleButton(String battleButtonPath) throws IOException {
		this.battleButton = ImageIO.read(new File(battleButtonPath));
	}
	
}
