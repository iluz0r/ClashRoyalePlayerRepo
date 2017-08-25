package clashroyaleplayer.app;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;

import clashroyaleplayer.core.AutoPlayer;
import clashroyaleplayer.imageprocessing.ImageCapturer;

public class Main {

	public static void main(String[] args) throws Exception {
		// Search for NoxPlayer window
		HWND noxHandle = User32.INSTANCE.FindWindow(null, "NoxPlayer 2");

		if (noxHandle == null) {
			System.err.println("Window not found. Exit.");
			return;
		} else {
			System.out.println("Window found!");
			// Set the focus on Nox window
			User32.INSTANCE.SetForegroundWindow(noxHandle);

			//findPosInWnd();
			//ImageCapturer capt = new ImageCapturer();
			//BufferedImage img = capt.captureImage(new Rectangle(180, 348, 124, 96));
			//capt.saveImage(img, "images/", "lockedSuperMagicChest", "jpg");

			AutoPlayer player = new AutoPlayer();
			player.start();
		}
	}

	// shopMenu: 9, 778, 145, 49
	// cardsMenu: 87, 778, 145, 49
	// battleMenu: 169, 778, 145, 49
	// socialMenu: 251, 778, 145, 49
	// tournamentsMenu: 330, 778, 145, 49
	// lockedFreeChest: 32, 145, 198, 58
	// lockedCrownChest: 250, 145, 198, 58
	// collectingGoldChest: 140, 470, 196, 135
	// collectedFreeChest: 140, 295, 196, 135
	// firstChest: 28, 639, 95, 80 shift between chests -> 112
	// emotesIcon: 36, 690, 40, 26
	// firstCard: 124, 700, 63, 81 shift between cards -> 85
	// elisir: 136, 790, 30, 20
	// okButton: 190, 713, 102, 42
	// lowBarArenaInfo: 3, 758, 474, 67
	// rewardLimitReached: 39, 274, 402, 311
	// rewardLimitReachedMini: 180, 348, 124, 96
	// Method that prints the mouse position relative to the Nox window
	@SuppressWarnings("unused")
	private static void findPosInWnd() {
		// Search for NoxPlayer window
		HWND noxHandle = User32.INSTANCE.FindWindow(null, "NoxPlayer 2");

		// Print every 5 seconds the mouse position relative to Nox window
		while (true) {
			// Get the RECT representing the Nox window
			RECT noxWndRect = new RECT();
			User32.INSTANCE.GetWindowRect(noxHandle, noxWndRect);

			// Get the current mouse position
			Point mousePosition = MouseInfo.getPointerInfo().getLocation();

			// Print the current mouse position relative to the Nox window
			System.out.println("(MousePosX - NoxWndX): " + (mousePosition.x - noxWndRect.left)
					+ ", (MousePosY - NoxWndY): " + (mousePosition.y - noxWndRect.top));

			// Sleeps for 5 seconds
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
