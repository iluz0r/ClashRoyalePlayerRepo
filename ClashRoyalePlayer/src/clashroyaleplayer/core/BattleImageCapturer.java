package clashroyaleplayer.core;

import java.awt.AWTException;

public class BattleImageCapturer extends clashroyaleplayer.imageprocessing.ImageCapturer{

	private AutoPlayer autoPlayer;
	
	public BattleImageCapturer(AutoPlayer autoPlayer) throws AWTException {
		super();
		this.autoPlayer = autoPlayer;
	}

}
