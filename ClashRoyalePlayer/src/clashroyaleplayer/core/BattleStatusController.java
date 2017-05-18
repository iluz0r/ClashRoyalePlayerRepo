package clashroyaleplayer.core;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;

import clashroyaleplayer.imageprocessing.ImageComparison;

public class BattleStatusController{
	
	protected BattleImageCapturer battleImageCapturer;
	protected ImageComparison imageComparison;
	protected BattleImageStore battleImageStore;
	protected AutoPlayer autoPlayer;
	
	public enum Elisir {
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
	}

	protected Elisir elisir = Elisir.ZERO;
	
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
	
	protected void checkElisir() throws AWTException{
		BufferedImage capturedElisir = battleImageCapturer.captureElisir();
		
		BufferedImage zeroElisir = battleImageStore.getZeroElisir();
		BufferedImage oneElisir = battleImageStore.getOneElisir();
		BufferedImage twoElisir = battleImageStore.getTwoElisir();
		BufferedImage threeElisir = battleImageStore.getThreeElisir();
		BufferedImage fourElisir = battleImageStore.getFourElisir();
		BufferedImage fiveElisir = battleImageStore.getFiveElisir();
		BufferedImage sixElisir = battleImageStore.getSixElisir();
		BufferedImage sevenElisir = battleImageStore.getSevenElisir();
		BufferedImage eightElisir = battleImageStore.getEightElisir();
		BufferedImage nineElisir = battleImageStore.getNineElisir();
		BufferedImage tenElisir = battleImageStore.getTenElisir();
		
		autoPlayer.actions.pointOutside();
		
		if(imageComparison.imgEqual
				(
				capturedElisir, 
				tenElisir, 
				5))
		{
			elisir = Elisir.TEN;
		}
		else
			if(imageComparison.imgEqual
					(
					capturedElisir, 
					threeElisir, 
					5))
			{
				elisir = Elisir.THREE;
			}
			else
				if(imageComparison.imgEqual
						(
						capturedElisir, 
						nineElisir, 
						5))
				{
					elisir = Elisir.NINE;
				}
				else
					if(imageComparison.imgEqual
							(
							capturedElisir, 
							fourElisir, 
							5))
					{
						elisir = Elisir.FOUR;
					}
					else
						if(imageComparison.imgEqual
								(
								capturedElisir, 
								eightElisir, 
								5))
						{
							elisir = Elisir.EIGHT;
						}
						else
							if(imageComparison.imgEqual
									(
									capturedElisir, 
									fiveElisir, 
									5))
							{
								elisir = Elisir.FIVE;
							}
							else
								if(imageComparison.imgEqual
										(
										capturedElisir, 
										sevenElisir, 
										5))
								{
									elisir = Elisir.SEVEN;
								}
								else
									if(imageComparison.imgEqual
											(
											capturedElisir, 
											sixElisir, 
											5))
									{
										elisir = Elisir.SIX;
									}
									else
										if(imageComparison.imgEqual
												(
												capturedElisir, 
												threeElisir, 
												5))
										{
											elisir = Elisir.THREE;
										}
										else
											if(imageComparison.imgEqual
													(
													capturedElisir, 
													twoElisir, 
													5))
											{
												elisir = Elisir.TWO;
											}
											else
												if(imageComparison.imgEqual
														(
														capturedElisir, 
														oneElisir, 
														5))
												{
													elisir = Elisir.ONE;
												}
												else
													if(imageComparison.imgEqual
															(
															zeroElisir, 
															capturedElisir, 
															5)
															)
													{
														elisir = Elisir.ZERO;
													}
		
		autoPlayer.updateLog("Action: checkElisir, the elisir is " + elisir.toString());
	}

}
