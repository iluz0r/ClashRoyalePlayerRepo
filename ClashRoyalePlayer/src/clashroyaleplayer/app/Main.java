package clashroyaleplayer.app;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

import clashroyaleplayer.core.AutoPlayer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		/*
		AutoPlayer player = new AutoPlayer();
		player.start();
		*/
		
		Robot robot = new Robot();
		robot.delay(10000);
		Point coord = MouseInfo.getPointerInfo().getLocation();
		System.out.println("X: " + coord.getX() + " Y: " + coord.getY());
		
	}

}
