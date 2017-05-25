package clashroyaleplayer.core;

import clashroyaleplayer.core.BattleActions.FieldPosition;
import clashroyaleplayer.core.BattleStatusController.Card;
import clashroyaleplayer.core.BattleStatusController.Elisir;

public class Strategies {

	private AutoPlayer autoPlayer;
	protected Strategies(AutoPlayer autoPlayer){
		this.autoPlayer = autoPlayer;
	}
	
	protected void furnace() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 4)
		{
			autoPlayer.battleActions.playCard(Card.FURNACE, FieldPosition.CENTRE);
			autoPlayer.updateLog("Action: play strategie furnace");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie furnace");
		}
	}
	
	protected void barbariansValkyre() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 10)
		{
			autoPlayer.battleActions.playCard(Card.VALKYRE, FieldPosition.TOP_RIGHT);
			autoPlayer.battleActions.playCard(Card.ELITE_BARBARIANS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie barbariansValkyre");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie barbariansValkyre");
		}
	}

	protected void baloonSpirits() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 7)
		{
			autoPlayer.battleActions.playCard(Card.BALLOON, FieldPosition.TOP_RIGHT);
			autoPlayer.battleActions.playCard(Card.FIRE_SPIRITS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie baloonSpirits");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie baloonSpirits");
		}		
	}

	protected void barbariansSpirits() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 8)
		{
			autoPlayer.battleActions.playCard(Card.ELITE_BARBARIANS, FieldPosition.TOP_RIGHT);
			autoPlayer.battleActions.playCard(Card.FIRE_SPIRITS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie barbariansSpirits");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie barbariansSpirits");
		}
	}

	protected void balloonArrows() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 7)
		{
			autoPlayer.battleActions.playCard(Card.BALLOON, FieldPosition.TOP_RIGHT);
			autoPlayer.robot.delay(4500);
			autoPlayer.battleActions.playCard(Card.ARROWS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie balloonArrows");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie balloonArrows");
		}
	}

	protected void giantSpirits() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 7)
		{
			autoPlayer.battleActions.playCard(Card.GIANT, FieldPosition.TOP_RIGHT);
			autoPlayer.battleActions.playCard(Card.FIRE_SPIRITS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie giantSpirits");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie giantSpirits");
		}
	}

	protected void barbariansDragon() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 7)
		{
			autoPlayer.battleActions.playCard(Card.BABY_DRAGON, FieldPosition.DOWN_RIGHT);
			autoPlayer.robot.delay(8000);
			autoPlayer.battleActions.playCard(Card.ELITE_BARBARIANS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie barbariansDragon");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie barbariansDragon");
		}
	}

	protected void balloon() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 5)
		{
			autoPlayer.battleActions.playCard(Card.BALLOON, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie balloon");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie balloon");
		}
		
	}

	protected void giantDragon() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 6)
		{
			autoPlayer.battleActions.playCard(Card.BABY_DRAGON, FieldPosition.DOWN_RIGHT);
			autoPlayer.robot.delay(8000);
			autoPlayer.battleActions.playCard(Card.GIANT, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie giantDragon");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie giantDragon");
		}		
	}

	protected void barbariansArrows() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 8)
		{
			autoPlayer.battleActions.playCard(Card.ELITE_BARBARIANS, FieldPosition.TOP_RIGHT);
			autoPlayer.robot.delay(5000);
			autoPlayer.battleActions.playCard(Card.ARROWS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie barbariansArrows");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie barbariansArrows");
		}	
	}

	protected void balloonDragon() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 6)
		{
			autoPlayer.battleActions.playCard(Card.BABY_DRAGON, FieldPosition.DOWN_RIGHT);
			autoPlayer.robot.delay(8000);
			autoPlayer.battleActions.playCard(Card.BALLOON, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie balloonDragon");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie balloonDragon");
		}
	}

	protected void balloonGiant() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 10)
		{
			autoPlayer.battleActions.playCard(Card.GIANT, FieldPosition.TOP_RIGHT);
			autoPlayer.robot.delay(2500);
			autoPlayer.battleActions.playCard(Card.BALLOON, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie balloonGiant");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie balloonGiant");
		}
	}

	protected void valkyreDragon() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 5)
		{
			autoPlayer.battleActions.playCard(Card.BABY_DRAGON, FieldPosition.DOWN_RIGHT);
			autoPlayer.robot.delay(8000);
			autoPlayer.battleActions.playCard(Card.VALKYRE, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie valkyreDragon");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie valkyreDragon");
		}
	}

	protected void babyDragon() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 4)
		{
			autoPlayer.battleActions.playCard(Card.BABY_DRAGON, FieldPosition.DOWN_RIGHT);
			autoPlayer.updateLog("Action: play strategie babyDragon");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie babyDragon");
		}
	}

	protected void valkyre() {
		if(Elisir.toInt(autoPlayer.battleController.elisir) >= 4)
		{
			autoPlayer.battleActions.playCard(Card.VALKYRE, FieldPosition.MIDDLE_RIGHT);
			autoPlayer.updateLog("Action: play strategie valkyre");
		}
		else
		{
			autoPlayer.updateLog("Action: failed to play strategie valkyre");
		}
	}
}
