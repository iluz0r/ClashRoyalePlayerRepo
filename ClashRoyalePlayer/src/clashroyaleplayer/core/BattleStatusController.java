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

	public static enum Elisir {
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN;
		
		public static int toInt(Elisir elisir){
			switch(elisir){
			case ZERO : return 0;
			case ONE :  return 1;
			case TWO : return 2;
			case THREE : return 3;
			case FOUR : return 4;
			case FIVE : return 5;
			case SIX : return 6;
			case SEVEN : return 7;
			case EIGHT : return 8;
			case NINE : return 9;
			case TEN : return 10;
			}
			return -1;
		}
	}
	
	public static enum Card {
		UNKNOWN, ARROWS, BABY_DRAGON, BALLOON, ELITE_BARBARIANS, FIRE_SPIRITS, FURNACE, VALKYRE, GIANT
	}

	protected Elisir elisir = Elisir.ZERO;
	
	protected Card firstCard = Card.UNKNOWN;
	protected Card secondCard = Card.UNKNOWN;
	protected Card thirdCard = Card.UNKNOWN;
	protected Card fourthCard = Card.UNKNOWN;

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
		autoPlayer.actions.pointOutside();

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

	protected boolean checkFirstCard() throws AWTException{

		boolean success = false;
		this.firstCard = Card.UNKNOWN;

		autoPlayer.actions.pointOutside();

		BufferedImage capturedCard = battleImageCapturer.captureFirstCard();

		BufferedImage arrows = battleImageStore.getArrows();
		BufferedImage babyDragon = battleImageStore.getBabyDragon();
		BufferedImage balloon = battleImageStore.getBalloon();
		BufferedImage valkyre = battleImageStore.getValkyre();
		BufferedImage eliteBarbarians = battleImageStore.getEliteBarbarians();
		BufferedImage fireSpirits = battleImageStore.getFireSpirits();
		BufferedImage furnace = battleImageStore.getFurnace();
		BufferedImage giant = battleImageStore.getGiant();

		if(imageComparison.imgEqual(capturedCard, arrows, 3))
		{
			success = true;
			this.firstCard = Card.ARROWS;
		} else
			if(imageComparison.imgEqual(capturedCard, babyDragon, 3))
			{
				success = true;
				this.firstCard = Card.BABY_DRAGON;
			} else
					if(imageComparison.imgEqual(capturedCard, balloon, 3))
					{
						success = true;
						this.firstCard = Card.BALLOON;
					} else
						if(imageComparison.imgEqual(capturedCard, valkyre, 3))
						{
							success = true;
							this.firstCard = Card.VALKYRE;
						} else
							if(imageComparison.imgEqual(capturedCard, eliteBarbarians, 3))
							{
								success = true;
								this.firstCard = Card.ELITE_BARBARIANS;
							} else
								if(imageComparison.imgEqual(capturedCard, fireSpirits, 3))
								{
									success = true;
									this.firstCard = Card.FIRE_SPIRITS;
								} else
									if(imageComparison.imgEqual(capturedCard, furnace, 3))
									{
										success = true;
										this.firstCard = Card.FURNACE;
									} else
										if(imageComparison.imgEqual(capturedCard, giant, 3))
										{
											success = true;
											this.firstCard = Card.GIANT;
										}

		autoPlayer.updateLog("Action: checkFirstCard, the card is " + this.firstCard.toString());
		return success;
	}

	protected boolean checkSecondCard() throws AWTException{

		boolean success = false;
		this.secondCard = Card.UNKNOWN;

		autoPlayer.actions.pointOutside();

		BufferedImage capturedCard = battleImageCapturer.captureSecondCard();

		BufferedImage arrows = battleImageStore.getArrows();
		BufferedImage babyDragon = battleImageStore.getBabyDragon();
		BufferedImage balloon = battleImageStore.getBalloon();
		BufferedImage valkyre = battleImageStore.getValkyre();
		BufferedImage eliteBarbarians = battleImageStore.getEliteBarbarians();
		BufferedImage fireSpirits = battleImageStore.getFireSpirits();
		BufferedImage furnace = battleImageStore.getFurnace();
		BufferedImage giant = battleImageStore.getGiant();

		if(imageComparison.imgEqual(capturedCard, arrows, 3))
		{
			success = true;
			this.secondCard = Card.ARROWS;
		} else
			if(imageComparison.imgEqual(capturedCard, babyDragon, 3))
			{
				success = true;
				this.secondCard = Card.BABY_DRAGON;
			} else
					if(imageComparison.imgEqual(capturedCard, balloon, 3))
					{
						success = true;
						this.secondCard = Card.BALLOON;
					} else
						if(imageComparison.imgEqual(capturedCard, valkyre, 3))
						{
							success = true;
							this.secondCard = Card.VALKYRE;
						} else
							if(imageComparison.imgEqual(capturedCard, eliteBarbarians, 3))
							{
								success = true;
								this.secondCard = Card.ELITE_BARBARIANS;
							} else
								if(imageComparison.imgEqual(capturedCard, fireSpirits, 3))
								{
									success = true;
									this.secondCard = Card.FIRE_SPIRITS;
								} else
									if(imageComparison.imgEqual(capturedCard, furnace, 3))
									{
										success = true;
										this.secondCard = Card.FURNACE;
									} else
										if(imageComparison.imgEqual(capturedCard, giant, 3))
										{
											success = true;
											this.secondCard = Card.GIANT;
										}

		autoPlayer.updateLog("Action: checkSecondCard, the card is " + this.secondCard.toString());
		return success;
	}

	protected boolean checkThirdCard() throws AWTException{

		boolean success = false;
		this.thirdCard = Card.UNKNOWN;

		autoPlayer.actions.pointOutside();

		BufferedImage capturedCard = battleImageCapturer.captureThirdCard();

		BufferedImage arrows = battleImageStore.getArrows();
		BufferedImage babyDragon = battleImageStore.getBabyDragon();
		BufferedImage balloon = battleImageStore.getBalloon();
		BufferedImage valkyre = battleImageStore.getValkyre();
		BufferedImage eliteBarbarians = battleImageStore.getEliteBarbarians();
		BufferedImage fireSpirits = battleImageStore.getFireSpirits();
		BufferedImage furnace = battleImageStore.getFurnace();
		BufferedImage giant = battleImageStore.getGiant();

		if(imageComparison.imgEqual(capturedCard, arrows, 3))
		{
			success = true;
			this.thirdCard = Card.ARROWS;
		} else
			if(imageComparison.imgEqual(capturedCard, babyDragon, 3))
			{
				success = true;
				this.thirdCard = Card.BABY_DRAGON;
			} else
					if(imageComparison.imgEqual(capturedCard, balloon, 3))
					{
						success = true;
						this.thirdCard = Card.BALLOON;
					} else
						if(imageComparison.imgEqual(capturedCard, valkyre, 3))
						{
							success = true;
							this.thirdCard = Card.VALKYRE;
						} else
							if(imageComparison.imgEqual(capturedCard, eliteBarbarians, 3))
							{
								success = true;
								this.thirdCard = Card.ELITE_BARBARIANS;
							} else
								if(imageComparison.imgEqual(capturedCard, fireSpirits, 3))
								{
									success = true;
									this.thirdCard = Card.FIRE_SPIRITS;
								} else
									if(imageComparison.imgEqual(capturedCard, furnace, 3))
									{
										success = true;
										this.thirdCard = Card.FURNACE;
									} else
										if(imageComparison.imgEqual(capturedCard, giant, 3))
										{
											success = true;
											this.thirdCard = Card.GIANT;
										}

		autoPlayer.updateLog("Action: checkThirdCard, the card is " + this.thirdCard.toString());
		return success;
	}

	protected boolean checkFourthCard() throws AWTException{

		boolean success = false;
		this.fourthCard = Card.UNKNOWN;

		autoPlayer.actions.pointOutside();

		BufferedImage capturedCard = battleImageCapturer.captureFourthCard();

		BufferedImage arrows = battleImageStore.getArrows();
		BufferedImage babyDragon = battleImageStore.getBabyDragon();
		BufferedImage balloon = battleImageStore.getBalloon();
		BufferedImage valkyre = battleImageStore.getValkyre();
		BufferedImage eliteBarbarians = battleImageStore.getEliteBarbarians();
		BufferedImage fireSpirits = battleImageStore.getFireSpirits();
		BufferedImage furnace = battleImageStore.getFurnace();
		BufferedImage giant = battleImageStore.getGiant();

		if(imageComparison.imgEqual(capturedCard, arrows, 3))
		{
			success = true;
			this.fourthCard = Card.ARROWS;
		} else
			if(imageComparison.imgEqual(capturedCard, babyDragon, 3))
			{
				success = true;
				this.fourthCard = Card.BABY_DRAGON;
			} else
					if(imageComparison.imgEqual(capturedCard, balloon, 3))
					{
						success = true;
						this.fourthCard = Card.BALLOON;
					} else
						if(imageComparison.imgEqual(capturedCard, valkyre, 3))
						{
							success = true;
							this.fourthCard = Card.VALKYRE;
						} else
							if(imageComparison.imgEqual(capturedCard, eliteBarbarians, 3))
							{
								success = true;
								this.fourthCard = Card.ELITE_BARBARIANS;
							} else
								if(imageComparison.imgEqual(capturedCard, fireSpirits, 3))
								{
									success = true;
									this.fourthCard = Card.FIRE_SPIRITS;
								} else
									if(imageComparison.imgEqual(capturedCard, furnace, 3))
									{
										success = true;
										this.fourthCard = Card.FURNACE;
									} else
										if(imageComparison.imgEqual(capturedCard, giant, 3))
										{
											success = true;
											this.fourthCard = Card.GIANT;
										}

		autoPlayer.updateLog("Action: checkFourthCard, the card is " + this.fourthCard.toString());
		return success;
	}
	
	protected boolean checkAllCards() throws AWTException{
		boolean success = false;
		checkElisir();

		if(Elisir.toInt(this.elisir) >= 5)
		{
			boolean successFirstCard = checkFirstCard();
			boolean successSecondCard = checkSecondCard();
			boolean successThirdCard = checkThirdCard();
			boolean successFourthCard = checkFourthCard();

			if(Elisir.toInt(this.elisir) >= 6)
			{
				if(
						successFirstCard &&
						successSecondCard &&
						successThirdCard &&
						successFourthCard
						)
				{
					success = true;
				}
			} else
				if(
						!successFirstCard &&
						successSecondCard &&
						successThirdCard &&
						successFourthCard)
				{
					this.firstCard = Card.ELITE_BARBARIANS;
					success = true;
				} else 
					if(
							successFirstCard &&
							!successSecondCard &&
							successThirdCard &&
							successFourthCard)
					{
						this.secondCard = Card.ELITE_BARBARIANS;
						success = true;
					} else 
						if(
								successFirstCard &&
								successSecondCard &&
								!successThirdCard &&
								successFourthCard)
						{
							this.thirdCard = Card.ELITE_BARBARIANS;
							success = true;
						} else 
							if(
									successFirstCard &&
									successSecondCard &&
									successThirdCard &&
									!successFourthCard)
							{
								this.fourthCard = Card.ELITE_BARBARIANS;
								success = true;
							}
		}

		autoPlayer.updateLog("Action: checkAllCards");
		autoPlayer.updateLog("	firstCard: " + firstCard.toString());
		autoPlayer.updateLog("	secondCard: " + secondCard.toString());
		autoPlayer.updateLog("	thirdCard: " + thirdCard.toString());
		autoPlayer.updateLog("	fourthCard: " + fourthCard.toString());
		return success;
	}

	protected boolean haveCard(Card card){
		if(
				firstCard == card ||
				secondCard == card ||
				thirdCard == card ||
				fourthCard == card
				)
		{
			return true;
		} else
		{
			return false;
		}
	}
				
}
