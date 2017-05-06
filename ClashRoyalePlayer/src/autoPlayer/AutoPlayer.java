package autoPlayer;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class AutoPlayer{

	private Robot robot = new Robot();
	
	public AutoPlayer() throws AWTException {
	}

	public void start(){
		
	}
	
	public void stop(){
		
	}
	
	private void tap(int x, int y){
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(250);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	private void tapBattleButton(){
		this.tap(944, 668);
	}
	
	private void tapFirstChest(){
		this.tap(739, 847);
	}
	
	private void tapSecondChest(){
		this.tap(873, 847);
	}
	
	private void tapThirdChest(){
		this.tap(1013, 847);
	}
	
	private void tapFourthChest(){
		this.tap(1153, 847);
	}
	
	private void tapBattleSection(){
		this.tap(945, 975);
	}
	
}
