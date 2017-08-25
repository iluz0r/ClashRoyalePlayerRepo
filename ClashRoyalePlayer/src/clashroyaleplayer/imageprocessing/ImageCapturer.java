package clashroyaleplayer.imageprocessing;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;

public class ImageCapturer {

	private Robot bot;
	private RECT noxWndRect;

	public ImageCapturer() throws AWTException {
		bot = new Robot();
		
		// Search for NoxPlayer window
		HWND noxHandle = User32.INSTANCE.FindWindow(null, "NoxPlayer 2");

		// Get the RECT representing the Nox window
		noxWndRect = new RECT();
		User32.INSTANCE.GetWindowRect(noxHandle, noxWndRect);
	}

	public BufferedImage captureImage(Rectangle captureRect) throws AWTException {
		// Capture the screen and save it to file
		Rectangle screen = new Rectangle(captureRect.x + noxWndRect.left, captureRect.y + noxWndRect.top,
				captureRect.width, captureRect.height);
		BufferedImage img = bot.createScreenCapture(screen);

		return img;
	}

	public void saveImage(BufferedImage image, String basePath, String fileName, String format) throws IOException {
		fileName = fileName + "." + format;
		ImageIO.write(image, format, new File(basePath + fileName));
	}

}