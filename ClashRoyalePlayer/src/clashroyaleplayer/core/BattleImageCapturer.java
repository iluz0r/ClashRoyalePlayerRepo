package clashroyaleplayer.core;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BattleImageCapturer extends clashroyaleplayer.imageprocessing.ImageCapturer{

	private AutoPlayer autoPlayer;
	
	public BattleImageCapturer(AutoPlayer autoPlayer) throws AWTException {
		super();
		this.autoPlayer = autoPlayer;
	}
	
	protected BufferedImage captureElisir() throws AWTException{
		Rectangle captureRect = null;
		
		switch(autoPlayer.resolution){
		
		case R_1920X1080 : 
			captureRect = new Rectangle(814, 983, 28, 20);
			break;
			
		case R_1366X768 : 
			captureRect = new Rectangle(578, 693, 17, 15);
			break;
		
		}
		
		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
		
	}

}
