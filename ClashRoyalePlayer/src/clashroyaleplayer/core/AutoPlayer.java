package clashroyaleplayer.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;

import clashroyaleplayer.core.BattleActions;
import clashroyaleplayer.core.BattleStatusController.Card;
import clashroyaleplayer.core.BattleStatusController.Elisir;
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
	
	private FileOutputStream logFile;
	private PrintStream writeLog;
	
	GameStatusController gameController;
	BattleStatusController battleController;
	Actions actions;
	BattleActions battleActions;
	Strategies strategies;
	
	public AutoPlayer(Resolution screenResolution) throws Exception{
		
		String path = "." + File.separator + "log" + File.separator + LocalDate.now().toString()+ "_" + LocalTime.now().toString().replaceAll(":", "-") + ".log";
		this.logFile = new FileOutputStream(path);
        writeLog = new PrintStream(logFile);
		
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
		
		while(gameController.gameStatus != GameStatus.UNKNOWN){
			robot.delay(1000);
			gameController.checkGameStatus();
			for(int i=0; i < 2; i++){
				robot.delay(1000);
				if(gameController.gameStatus == GameStatus.UNKNOWN)
				{
					gameController.checkGameStatus();
				}else
				{
					i = 100;
				}
			}
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
						robot.delay(1000);
						battleController.checkElisir();
						if(Elisir.toInt(battleController.elisir) >= 5)
						{
							playStrategie();
						}
						gameController.checkGameStatus();
					}
					for(int i=0; i < 10; i++){
						robot.delay(1000);
						if(gameController.gameStatus != GameStatus.END_BATTLE)
						{
							gameController.checkGameStatus();
						}else
						{
							i = 100;
						}
					}
					break;
				}

			}
		}
		this.stop();
	}

	public void stop() throws IOException{
		updateLog("Final state: " + this.gameController.getGameStatus().toString());
		System.exit(0);
	}
	
	private void playStrategie() throws AWTException{
		boolean switchScope = false;
		battleController.checkAllCards();
		battleController.checkElisir();
		switch(scope){
		case OFFENSIVE : {
			if(battleController.haveCard(Card.FURNACE))
			{
				if(strategies.furnace())
				{
					switchScope = false;
				}
			}
			else
				if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.VALKYRE))
				{
					if(strategies.barbariansValkyre())
					{
						switchScope = true;
					}
				}
				else
					if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.FIRE_SPIRITS))
					{
						if(strategies.baloonSpirits())
						{
							switchScope = true;
						}
					}
					else
						if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.FIRE_SPIRITS))
						{
							if(strategies.barbariansSpirits())
							{
								switchScope = true;
							}
						}
						else
							if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.ARROWS))
							{
								if(strategies.balloonArrows())
								{
									switchScope = true;
								}
							}
							else
								if(battleController.haveCard(Card.GIANT) && battleController.haveCard(Card.FIRE_SPIRITS))
								{
									if(strategies.giantSpirits())
									{
										switchScope = true;
									}
								}
								else
									if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.BABY_DRAGON))
									{
										if(strategies.barbariansDragon())
										{
											switchScope = true;
										}
									}
									else
										if(battleController.haveCard(Card.BALLOON))
										{
											if(strategies.balloon())
											{
												switchScope = true;
											}
										}
										else
											if(battleController.haveCard(Card.GIANT) && battleController.haveCard(Card.BABY_DRAGON))
											{
												if(strategies.giantDragon())
												{
													switchScope = true;
												}
											}
											else
												if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.ARROWS))
												{
													if(strategies.barbariansArrows())
													{
														switchScope = true;
													}
												}
												else
													if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.BABY_DRAGON))
													{
														if(strategies.balloonDragon())
														{
															switchScope = true;
														}
													}
													else
														if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.GIANT))
														{
															if(strategies.balloonGiant())
															{
																switchScope = true;
															}
														}
														else
															if(battleController.haveCard(Card.VALKYRE) && battleController.haveCard(Card.BABY_DRAGON))
															{
																if(strategies.valkyreDragon())
																{
																	switchScope = true;
																}
															}
			break;
		}
		case DEFENSIVE : {
			if(battleController.haveCard(Card.FURNACE))
			{
				if(strategies.furnace())
				{
					switchScope = true;
				}
			}
			else
				if(battleController.haveCard(Card.BABY_DRAGON))
				{
					if(strategies.babyDragon())
					{
						switchScope = true;
					}
				}
				else
					if(battleController.haveCard(Card.VALKYRE))
					{
						if(strategies.valkyre())
						{
							switchScope = true;
						}
					}
					else
						if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.VALKYRE))
						{
							if(strategies.barbariansValkyre())
							{
								switchScope = true;
							}
						}
						else
							if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.FIRE_SPIRITS))
							{
								if(strategies.baloonSpirits())
								{
									switchScope = true;
								}
							}
							else
								if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.FIRE_SPIRITS))
								{
									if(strategies.barbariansSpirits())
									{
										switchScope = true;
									}
								}
								else
									if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.ARROWS))
									{
										if(strategies.balloonArrows())
										{
											switchScope = true;
										}
									}
									else
										if(battleController.haveCard(Card.GIANT) && battleController.haveCard(Card.FIRE_SPIRITS))
										{
											if(strategies.giantSpirits())
											{
												switchScope = true;
											}
										}
										else
											if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.BABY_DRAGON))
											{
												if(strategies.barbariansDragon())
												{
													switchScope = true;
												}
											}
											else
												if(battleController.haveCard(Card.BALLOON))
												{
													if(strategies.balloon())
													{
														switchScope = true;
													}
												}
												else
													if(battleController.haveCard(Card.GIANT) && battleController.haveCard(Card.BABY_DRAGON))
													{
														if(strategies.giantDragon())
														{
															switchScope = true;
														}
													}
													else
														if(battleController.haveCard(Card.ELITE_BARBARIANS) && battleController.haveCard(Card.ARROWS))
														{
															if(strategies.barbariansArrows())
															{
																switchScope = true;
															}
														}
														else
															if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.BABY_DRAGON))
															{
																if(strategies.balloonDragon())
																{
																	switchScope = true;
																}
															}
															else
																if(battleController.haveCard(Card.BALLOON) && battleController.haveCard(Card.GIANT))
																{
																	if(strategies.balloonGiant())
																	{
																		switchScope = true;
																	}
																}
																else
																	if(battleController.haveCard(Card.VALKYRE) && battleController.haveCard(Card.BABY_DRAGON))
																	{
																		if(strategies.valkyreDragon())
																		{
																			switchScope = true;
																		}
																	}
			break;

		}
		}

		if(switchScope)
		{
			switchStrategieScope();
		}
	}

	private void switchStrategieScope(){
		StrategieScope oldScope = scope;
		switch(scope){
			case OFFENSIVE : 
			{
				scope = StrategieScope.DEFENSIVE;
				break;
			}
			case DEFENSIVE :
			{
				scope = StrategieScope.OFFENSIVE;
				break;
			}
		}
		updateLog("Action: switched scope from " + oldScope.toString() + " to " + scope.toString());
	}
	
	protected void updateLog(String update){
		update +=";\n";
		System.out.print(update);
		writeLog.print(update);
	}


}