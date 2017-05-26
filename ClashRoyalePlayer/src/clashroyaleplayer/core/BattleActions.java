package clashroyaleplayer.core;

import javax.sql.rowset.CachedRowSet;

public class BattleActions extends Actions{

	protected static enum FieldPosition {
		TOP_RIGHT, TOP_LEFT, MIDDLE_RIGHT, MIDDLE_LEFT,
		DOWN_RIGHT, DOWN_LEFT, CENTRE, IN_FRONT_OF_TOWER_RIGHT, IN_FRONT_OF_TOWER_LEFT
	}
	protected static enum CardPosition {
		FIRST, SECOND, THIRD, FOURTH
	}
	
	
	protected BattleActions(AutoPlayer autoPlayer) {
		super(autoPlayer);
	}
	
	protected void tapFirstCard() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(841, 916);
			break;
		case R_1366X768 : 
			this.tap(592, 644);
			break;
		default: break;
		}
		
	}
	
	protected void tapSecondCard() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(942, 916);
			break;
		case R_1366X768 : 
			this.tap(664, 652);
			break;
		default: break;
		}
		
	}
	
	protected void tapThirdCard() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(1045, 916);
			break;
		case R_1366X768 : 
			this.tap(729, 641);
			break;
		default: break;
		}
	}
	
	protected void tapFourthCard() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(1158, 916);
			break;
		case R_1366X768 : 
			this.tap(806, 647);
			break;
		default: break;
		}
	}
	
	protected void tapFieldCentre() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : 
			this.tap(953, 557);
			break;
		case R_1366X768 : 
			this.tap(676, 394);
			break;
		default: break;
		}
	}
	
	protected void tapFieldDownLeft() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : {
			this.tap(927, 792);
			break;
		}
		case R_1366X768 : {
			this.tap(654, 559);
			break;
		}
		}
	}
	
	protected void tapFieldDownRight() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : {
			this.tap(955, 792);
			break;
		}
		case R_1366X768 : {
			this.tap(675, 559);
			break;
		}
		}
	}
	
	protected void tapFieldMiddleLeft() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : {
			this.tap(796, 490);
			break;
		}
		case R_1366X768 : {
			this.tap(570, 353);
			break;
		}
		}
	}
	
	protected void tapFieldMiddleRight() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : {
			this.tap(1088, 490);
			break;
		}
		case R_1366X768 : {
			this.tap(765, 353);
			break;
		}
		}
	}
	
	protected void tapFieldTopLeft() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : {
			this.tap(795, 297);
			break;
		}
		case R_1366X768 : {
			this.tap(570, 251);
			break;
		}
		}
	}
	
	protected void tapFieldTopRight() {
		switch(autoPlayer.resolution){
		case R_1920X1080 : {
			this.tap(1089, 297);
			break;
		}
		case R_1366X768 : {
			this.tap(765, 251);
			break;
		}
		}
	}
	
	protected void tapFieldInFrontOfTowerRight() {
		switch(autoPlayer.resolution){
			case R_1920X1080 : {
				this.tap(0, 0);
				break;
			}
			case R_1366X768 : {
				this.tap(764, 427);
				break;
			}
		
		}
	}
	
	protected void tapFieldInFrontOfTowerLeft() {
		switch(autoPlayer.resolution){
			case R_1920X1080 : {
				this.tap(0, 0);
				break;
			}
			case R_1366X768 : {
				this.tap(563, 427);
				break;
			}
		
		}
	}
	
	protected void playCard(CardPosition card, FieldPosition position){

		switch(card){
		case FIRST : {
			tapFirstCard();
			break;
		}
		case SECOND : {
			tapSecondCard();
			break;
		}
		case THIRD : {
			tapThirdCard();
			break;
		}
		case FOURTH : {
			tapFourthCard();
			break;
		}
		}
		
		autoPlayer.robot.delay(500);
		

		switch(position){
		case CENTRE : {
			tapFieldCentre();
			break;
		}
		case DOWN_LEFT : {
			tapFieldDownLeft();
			break;
		}
		case DOWN_RIGHT : {
			tapFieldDownRight();
			break;
		}
		case MIDDLE_LEFT : {
			tapFieldMiddleLeft();
			break;
		}
		case MIDDLE_RIGHT : {
			tapFieldMiddleRight();
			break;
		}
		case TOP_LEFT : {
			tapFieldTopLeft();
			break;
		}
		case TOP_RIGHT : {
			tapFieldTopRight();
			break;
		}
		case IN_FRONT_OF_TOWER_RIGHT : {
			tapFieldInFrontOfTowerRight();
			break;
		}
		case IN_FRONT_OF_TOWER_LEFT : {
			tapFieldInFrontOfTowerLeft();
			break;
		}
		}
		autoPlayer.updateLog("Action: play " + card.toString() + " card in position " + position.toString());

	}
	
	protected void playCard(BattleStatusController.Card card, FieldPosition position){
	
		if(card == autoPlayer.battleController.firstCard) 
		{
			playCard(CardPosition.FIRST, position);
			autoPlayer.updateLog("Action: play " + card.toString() + " card in position " + position.toString());
		} else
			if(card == autoPlayer.battleController.secondCard)
			{
				playCard(CardPosition.SECOND, position);
				autoPlayer.updateLog("Action: play " + card.toString() + " card in position " + position.toString());
			} else
				if(card == autoPlayer.battleController.thirdCard)
				{
					playCard(CardPosition.THIRD, position);
					autoPlayer.updateLog("Action: play " + card.toString() + " card in position " + position.toString());
				}
				else if(card == autoPlayer.battleController.fourthCard)
				{
					playCard(CardPosition.FOURTH, position);
					autoPlayer.updateLog("Action: play " + card.toString() + " card in position " + position.toString());
				} else
				{
					autoPlayer.updateLog("Action: failed to play " + card.toString() + " card in position " + position.toString());
				}
	}
}
