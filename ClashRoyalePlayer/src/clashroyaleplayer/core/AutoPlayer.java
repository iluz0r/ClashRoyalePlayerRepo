package clashroyaleplayer.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import clashroyaleplayer.core.BattleActions;
import clashroyaleplayer.core.BattleStatusController.Card;
import clashroyaleplayer.core.GameStatusController.GameStatus;

public class AutoPlayer{
	
	public static enum Resolution{
		R_1920X1080, R_1366X768 
	}
	
	public static enum StrategieScope {
		OFFENSIVE, DEFENSIVE
	}
	
	protected Robot robot;
	
	protected Resolution resolution;
	protected final static Resolution DEFAULT_RESOLUTION = Resolution.R_1920X1080;
	private StrategieScope scope = StrategieScope.OFFENSIVE;
	
	private String log = "";
	private PrintStream writeLog;
	
	GameStatusController gameController;
	BattleStatusController battleController;
	Actions actions;
	BattleActions battleActions;
	Strategies strategies;
	
	public AutoPlayer(Resolution screenResolution) throws Exception{
		
		switch(screenResolution){
		
		case R_1366X768 : {
			this.resolution = screenResolution;
			break;
		}
		
		case R_1920X1080 : {
			this.resolution = screenResolution;
			break;
		}
		
		default : throw new Exception("Resolution mismatch");
		}
		updateLog("ScreenResolution: " + resolution);
		
		gameController = new GameStatusController(this);
		battleController = new BattleStatusController(this);
		actions = new Actions(this);
		battleActions = new BattleActions(this);
		strategies = new Strategies(this);
	}
	
	public AutoPlayer() throws Exception{
		this(DEFAULT_RESOLUTION);
	}

	protected String resolutionToString(){
		String resolutionToString = "";
		switch(resolution){
		case R_1920X1080 : {
			resolutionToString = "1920x1080";
			break;
		}
		case R_1366X768 : {
			resolutionToString = "1366x768";
			break;
		}
		}
		return resolutionToString;
	}
	
	private void init() throws Exception{
		robot = new Robot();
		
		robot.delay(10000);
		this.gameController.checkGameStatus();
		
		updateLog("Initial state: " + this.gameController.getGameStatus().toString());
	}

	
	public void start() throws Exception{
		init();
		
		while(this.gameController.getGameStatus() != GameStatusController.GameStatus.UNKNOWN){
		    this.gameController.checkGameStatus();
			switch(gameController.getGameStatus()){
			
				case UNKNOWN : break;
			
				case BATTLE_MENU : {
					gameController.checkAllChestStatus();
					
					if(this.gameController.getFirstChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE)
					{
						actions.openFirstChest();
						break;
					}
					if(this.gameController.getSecondChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE)
					{
						actions.openSecondChest();
						break;
					}
					if(this.gameController.getThirdChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE)
					{
						actions.openThirdChest();
						break;
					}
					if(this.gameController.getFourthChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE)
					{
						actions.openFourthChest();
						break;
					}
					if(this.gameController.getFreeChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE)
					{
						actions.openFreeChest();
						break;
					}
					if(this.gameController.getCrownChestStatus() == GameStatusController.ChestStatus.UNLOCKABLE)
					{
						actions.openCrownChest();
						break;
					}
					if(
							this.gameController.getFirstChestStatus() != GameStatusController.ChestStatus.UNLOCKING &&
							this.gameController.getSecondChestStatus() != GameStatusController.ChestStatus.UNLOCKING &&
							this.gameController.getThirdChestStatus() != GameStatusController.ChestStatus.UNLOCKING &&
							this.gameController.getFourthChestStatus() != GameStatusController.ChestStatus.UNLOCKING)
					{
						if(this.gameController.getFirstChestStatus() == GameStatusController.ChestStatus.LOCKED)
						{
							actions.unlockFirstChest();
							break;
						}
						else
							if(this.gameController.getSecondChestStatus() == GameStatusController.ChestStatus.LOCKED)
							{
								actions.unlockSecondChest();
								break;
							}
							else
								if(this.gameController.getThirdChestStatus() == GameStatusController.ChestStatus.LOCKED)
								{
									actions.unlockThirdChest();
									break;
								}
								else
									if(this.gameController.getFourthChestStatus() == GameStatusController.ChestStatus.LOCKED)
									{
										actions.unlockFourthChest();
										break;
									}
					}
					
					actions.startBattle();
					break;
				}
				
				case TOURNAMENTS_MENU : {
					actions.switchMenu("BATTLE_MENU");
					break;
				}
				
				case SOCIAL_MENU : {
					actions.switchMenu("BATTLE_MENU");
					break;
				}
				
				case SHOP_MENU : {
					actions.switchMenu("BATTLE_MENU");
					break;
				}
				
				case CARDS_MENU : {
					actions.switchMenu("BATTLE_MENU");
					break;
				}
				
				case ARENA_INFO : {
					actions.closeArenaInfo();
					break;
				}
				
				case END_BATTLE : {
					actions.closeBattle();
					break;
				}
				
				case REWARD_LIMIT_REACHED: {
					actions.startBattle();
					break;
				}
				
				case IN_BATTLE : {
					
					while(gameController.gameStatus == GameStatus.IN_BATTLE){
						robot.delay(500);
						playStrategie(scope);
						switch(scope){
						case OFFENSIVE : {
							scope = StrategieScope.DEFENSIVE;
							break;
						}
						case DEFENSIVE : {
							scope = StrategieScope.OFFENSIVE;
							break;
						}
						}
						gameController.checkGameStatus();
					}
					robot.delay(5000);
					gameController.checkGameStatus();
					break;
				}
			
			}
		}
		this.stop();
	}

	public void stop() throws IOException{
		
		updateLog("Final state: " + this.gameController.getGameStatus().toString());
		
		String path = ".\\log.txt";
		FileOutputStream logFile = new FileOutputStream(path);
        writeLog = new PrintStream(logFile);
        writeLog.print(log);
		System.out.println(log);

		System.exit(0);
	}
	
	private void playStrategie(StrategieScope scope) throws AWTException{
		battleController.checkAllCards();
		battleController.checkElisir();
		switch(scope){
		case OFFENSIVE : {
			if(battleController.haveCard(Card.FURNACE))
			{
				strategies.furnace();
			}
			else
				if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.VALKYRE))
				{
					strategies.barbariansValkyre();
				}
				else
					if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.FIRE_SPIRITS))
					{
						strategies.baloonSpirits();
					}
					else
						if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.FIRE_SPIRITS))
						{
							strategies.barbariansSpirits();
						}
						else
							if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.ARROWS))
							{
								strategies.balloonArrows();
							}
							else
								if(battleController.haveCard(Card.GIANT) && battleController.haveCard(Card.FIRE_SPIRITS))
								{
									strategies.giantSpirits();
								}
								else
									if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.BABY_DRAGON))
									{
										strategies.barbariansDragon();
									}
									else
										if(battleController.haveCard(Card.BALLOON))
										{
											strategies.balloon();
										}
										else
											if(battleController.haveCard(Card.GIANT) && battleController.haveCard(Card.BABY_DRAGON))
											{
												strategies.giantDragon();
											}
											else
												if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.ARROWS))
												{
													strategies.barbariansArrows();
												}
												else
													if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.BABY_DRAGON))
													{
														strategies.balloonDragon();
													}
													else
														if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.GIANT))
														{
															strategies.balloonGiant();
														}
														else
															if(battleController.haveCard(Card.VALKYRE) && battleController.haveCard(Card.BABY_DRAGON))
															{
																strategies.valkyreDragon();
															}
		}
		case DEFENSIVE : {
			if(battleController.haveCard(Card.FURNACE))
			{
				strategies.furnace();
			}
			else
				if(battleController.haveCard(Card.BABY_DRAGON))
				{
					strategies.babyDragon();
				}
				else
					if(battleController.haveCard(Card.VALKYRE))
					{
						strategies.valkyre();
					}
					else
						if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.VALKYRE))
						{
							strategies.barbariansValkyre();
						}
						else
							if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.FIRE_SPIRITS))
							{
								strategies.baloonSpirits();
							}
							else
								if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.FIRE_SPIRITS))
								{
									strategies.barbariansSpirits();
								}
								else
									if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.ARROWS))
									{
										strategies.balloonArrows();
									}
									else
										if(battleController.haveCard(Card.GIANT) && battleController.haveCard(Card.FIRE_SPIRITS))
										{
											strategies.giantSpirits();
										}
										else
											if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.BABY_DRAGON))
											{
												strategies.barbariansDragon();
											}
											else
												if(battleController.haveCard(Card.BALLOON))
												{
													strategies.balloon();
												}
												else
													if(battleController.haveCard(Card.GIANT) && battleController.haveCard(Card.BABY_DRAGON))
													{
														strategies.giantDragon();
													}
													else
														if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.ARROWS))
														{
															strategies.barbariansArrows();
														}
														else
															if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.BABY_DRAGON))
															{
																strategies.balloonDragon();
															}
															else
																if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.GIANT))
																{
																	strategies.balloonGiant();
																}
																else
																	if(battleController.haveCard(Card.VALKYRE) && battleController.haveCard(Card.BABY_DRAGON))
																	{
																		strategies.valkyreDragon();
																	}

		}
		}
	}

	protected void updateLog(String update){
		log += update + ";\n";
	}


}