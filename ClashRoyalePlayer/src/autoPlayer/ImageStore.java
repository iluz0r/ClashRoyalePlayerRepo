package autoPlayer;

import java.io.File;
import java.io.IOException;

public class ImageStore extends imageProcessing.ImageStore{
	
	public ImageStore(AutoPlayer autoPlayer) throws IOException {
		super("." + File.separator + "images" + autoPlayer.resolutionToString() + File.separator);
	}
	
}