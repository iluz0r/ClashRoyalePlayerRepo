package clashroyaleplayer.core;

import clashroyaleplayer.core.BattleActions.FieldPosition;
import clashroyaleplayer.core.BattleStatusController.Card;
import clashroyaleplayer.core.BattleStatusController.Elisir;

public class Strategies {

	private AutoPlayer autoPlayer;

	protected Strategies(AutoPlayer autoPlayer) {
		this.autoPlayer = autoPlayer;
	}

	protected boolean furnace() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 4) {
			autoPlayer.battleActions.playCard(Card.FURNACE, FieldPosition.CENTER);
			autoPlayer.updateLog("Action: play strategie furnace");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie furnace");
		}
		return success;
	}

	protected boolean barbariansValkyre() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 10) {
			autoPlayer.battleActions.playCard(Card.VALKYRE, FieldPosition.TOP_RIGHT);
			autoPlayer.battleActions.playCard(Card.ELITE_BARBARIANS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie barbariansValkyre");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie barbariansValkyre");
		}
		return success;
	}

	protected boolean baloonSpirits() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 7) {
			autoPlayer.battleActions.playCard(Card.BALLOON, FieldPosition.TOP_RIGHT);
			autoPlayer.battleActions.playCard(Card.FIRE_SPIRITS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie baloonSpirits");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie baloonSpirits");
		}
		return success;
	}

	protected boolean barbariansSpirits() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 8) {
			autoPlayer.battleActions.playCard(Card.ELITE_BARBARIANS, FieldPosition.TOP_RIGHT);
			autoPlayer.battleActions.playCard(Card.FIRE_SPIRITS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie barbariansSpirits");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie barbariansSpirits");
		}
		return success;
	}

	protected boolean balloonArrows() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 7) {
			autoPlayer.battleActions.playCard(Card.BALLOON, FieldPosition.TOP_RIGHT);
			autoPlayer.robot.delay(4500);
			autoPlayer.battleActions.playCard(Card.ARROWS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie balloonArrows");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie balloonArrows");
		}
		return success;
	}

	protected boolean giantSpirits() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 7) {
			autoPlayer.battleActions.playCard(Card.GIANT, FieldPosition.TOP_RIGHT);
			autoPlayer.battleActions.playCard(Card.FIRE_SPIRITS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie giantSpirits");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie giantSpirits");
		}
		return success;
	}

	protected boolean barbariansDragon() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 7) {
			autoPlayer.battleActions.playCard(Card.BABY_DRAGON, FieldPosition.DOWN_RIGHT);
			autoPlayer.robot.delay(8000);
			autoPlayer.battleActions.playCard(Card.ELITE_BARBARIANS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie barbariansDragon");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie barbariansDragon");
		}
		return success;
	}

	protected boolean balloon() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 5) {
			autoPlayer.battleActions.playCard(Card.BALLOON, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie balloon");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie balloon");
		}
		return success;
	}

	protected boolean giantDragon() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 6) {
			autoPlayer.battleActions.playCard(Card.BABY_DRAGON, FieldPosition.DOWN_RIGHT);
			autoPlayer.robot.delay(8000);
			autoPlayer.battleActions.playCard(Card.GIANT, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie giantDragon");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie giantDragon");
		}
		return success;
	}

	protected boolean barbariansArrows() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 8) {
			autoPlayer.battleActions.playCard(Card.ELITE_BARBARIANS, FieldPosition.TOP_RIGHT);
			autoPlayer.robot.delay(5000);
			autoPlayer.battleActions.playCard(Card.ARROWS, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie barbariansArrows");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie barbariansArrows");
		}
		return success;
	}

	protected boolean balloonDragon() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 6) {
			autoPlayer.battleActions.playCard(Card.BABY_DRAGON, FieldPosition.DOWN_RIGHT);
			autoPlayer.robot.delay(8000);
			autoPlayer.battleActions.playCard(Card.BALLOON, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie balloonDragon");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie balloonDragon");
		}
		return success;
	}

	protected boolean balloonGiant() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 10) {
			autoPlayer.battleActions.playCard(Card.GIANT, FieldPosition.TOP_RIGHT);
			autoPlayer.robot.delay(2500);
			autoPlayer.battleActions.playCard(Card.BALLOON, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie balloonGiant");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie balloonGiant");
		}
		return success;
	}

	protected boolean valkyrieDragon() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 5) {
			autoPlayer.battleActions.playCard(Card.BABY_DRAGON, FieldPosition.DOWN_RIGHT);
			autoPlayer.robot.delay(8000);
			autoPlayer.battleActions.playCard(Card.VALKYRE, FieldPosition.TOP_RIGHT);
			autoPlayer.updateLog("Action: play strategie valkyreDragon");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie valkyreDragon");
		}
		return success;
	}

	protected boolean babyDragon() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 4) {
			autoPlayer.battleActions.playCard(Card.BABY_DRAGON, FieldPosition.DOWN_RIGHT);
			autoPlayer.updateLog("Action: play strategie babyDragon");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie babyDragon");
		}
		return success;
	}

	protected boolean valkyrie() {
		boolean success = true;
		if (Elisir.toInt(autoPlayer.battleController.elisir) >= 4) {
			autoPlayer.battleActions.playCard(Card.VALKYRE, FieldPosition.IN_FRONT_OF_TOWER_RIGHT);
			autoPlayer.updateLog("Action: play strategie valkyre");
		} else {
			success = false;
			autoPlayer.updateLog("Action: failed to play strategie valkyre");
		}
		return success;
	}
}
