package clashroyaleplayer.core;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BattleImageCapturer extends clashroyaleplayer.imageprocessing.ImageCapturer {

	private AutoPlayer autoPlayer;

	public BattleImageCapturer(AutoPlayer autoPlayer) throws AWTException {
		super();
		this.autoPlayer = autoPlayer;
	}

	protected BufferedImage captureElisir() throws AWTException {
		Rectangle captureRect = null;

		switch (autoPlayer.resolution) {
		case R_1920X1080:
			captureRect = new Rectangle(136, 790, 30, 20);
			break;

		case R_1366X768:
			captureRect = new Rectangle(578, 693, 17, 15);
			break;
		}

		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}

	protected BufferedImage captureFirstCard() throws AWTException {
		Rectangle captureRect = null;

		switch (autoPlayer.resolution) {

		case R_1920X1080:
			captureRect = new Rectangle(124, 700, 63, 81);
			break;

		case R_1366X768:
			captureRect = new Rectangle(560, 610, 64, 79);
			break;

		}

		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}

	protected BufferedImage captureSecondCard() throws AWTException {
		Rectangle captureRect = null;

		switch (autoPlayer.resolution) {
		case R_1920X1080:
			captureRect = new Rectangle(209, 700, 63, 81);
			break;

		case R_1366X768:
			captureRect = new Rectangle(632, 610, 64, 79);
			break;
		}

		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}

	protected BufferedImage captureThirdCard() throws AWTException {
		Rectangle captureRect = null;

		switch (autoPlayer.resolution) {
		case R_1920X1080:
			captureRect = new Rectangle(294, 700, 63, 81);
			break;

		case R_1366X768:
			captureRect = new Rectangle(705, 610, 64, 79);
			break;
		}

		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}

	protected BufferedImage captureFourthCard() throws AWTException {
		Rectangle captureRect = null;

		switch (autoPlayer.resolution) {
		case R_1920X1080:
			captureRect = new Rectangle(379, 700, 63, 81);
			break;

		case R_1366X768:
			captureRect = new Rectangle(779, 610, 64, 79);
			break;
		}

		BufferedImage capturedImage = captureImage(captureRect);
		return capturedImage;
	}

}
