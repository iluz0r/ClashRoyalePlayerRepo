package autoPlayer;

import java.io.File;
import java.io.IOException;

public class ImageStore extends imageProcessing.ImageStore{

	protected ImageStore(String resolution) 
			throws IOException
	{
		super("." + File.separator + "images" + resolution + File.separator);
	}
}
