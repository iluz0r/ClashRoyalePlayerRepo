package clashroyaleplayer.core;

import java.io.File;

import clashroyaleplayer.imageprocessing.ImageComparison;

public class BattleStatusController{
	
	protected BattleImageCapturer battleImageCapturer;
	protected ImageComparison imageComparison;
	protected BattleImageStore battleImageStore;
	protected AutoPlayer autoPlayer;

	public BattleStatusController(AutoPlayer autoPlayer) throws Exception {
		this.autoPlayer = autoPlayer;
		battleImageCapturer = new BattleImageCapturer(autoPlayer);
		imageComparison = new ImageComparison();
		battleImageStore = new BattleImageStore(
						"." + 
						File.separator + 
						"images" + 
						autoPlayer.resolutionToString() + 
						File.separator + 
						"battle" + 
						File.separator);
	}

}
