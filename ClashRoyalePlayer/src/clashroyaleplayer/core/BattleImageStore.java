package clashroyaleplayer.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BattleImageStore{

	private BufferedImage zeroElisir;
	private BufferedImage oneElisir;
	private BufferedImage twoElisir;
	private BufferedImage threeElisir;
	private BufferedImage fourElisir;
	private BufferedImage fiveElisir;
	private BufferedImage sixElisir;
	private BufferedImage sevenElisir;
	private BufferedImage eightElisir;
	private BufferedImage nineElisir;
	private BufferedImage tenElisir;
	
	
	
	protected BattleImageStore(String basePath) throws IOException {
		this.setZeroElisir(basePath + "0.jpg");
		this.setOneElisir(basePath + "1.jpg");
		this.setTwoElisir(basePath + "2.jpg");
		this.setThreeElisir(basePath + "3.jpg");
		this.setFourElisir(basePath + "4.jpg");
		this.setFiveElisir(basePath + "5.jpg");
		this.setSixElisir(basePath + "6.jpg");
		this.setSevenElisir(basePath + "7.jpg");
		this.setEightElisir(basePath + "8.jpg");
		this.setNineElisir(basePath + "9.jpg");
		this.setTenElisir(basePath + "10.jpg");
	}



	protected BufferedImage getZeroElisir() {
		return zeroElisir;
	}



	protected void setZeroElisir(String zeroElisirPath) throws IOException {
		this.zeroElisir = ImageIO.read(new File(zeroElisirPath));
	}



	protected BufferedImage getOneElisir() {
		return oneElisir;
	}



	protected void setOneElisir(String oneElisirPath) throws IOException {
		this.oneElisir = ImageIO.read(new File(oneElisirPath));
	}



	protected BufferedImage getTwoElisir() {
		return twoElisir;
	}



	protected void setTwoElisir(String twoElisirPath) throws IOException {
		this.twoElisir = ImageIO.read(new File(twoElisirPath));
	}



	protected BufferedImage getThreeElisir() {
		return threeElisir;
	}



	protected void setThreeElisir(String threeElisirPath) throws IOException {
		this.threeElisir = ImageIO.read(new File(threeElisirPath));
	}



	protected BufferedImage getFourElisir() {
		return fourElisir;
	}



	protected void setFourElisir(String fourElisirPath) throws IOException {
		this.fourElisir = ImageIO.read(new File(fourElisirPath));
	}



	protected BufferedImage getFiveElisir() {
		return fiveElisir;
	}



	protected void setFiveElisir(String fiveElisirPath) throws IOException {
		this.fiveElisir = ImageIO.read(new File(fiveElisirPath));
	}



	protected BufferedImage getSixElisir() {
		return sixElisir;
	}



	protected void setSixElisir(String sixElisirPath) throws IOException {
		this.sixElisir = ImageIO.read(new File(sixElisirPath));
	}



	protected BufferedImage getSevenElisir() {
		return sevenElisir;
	}



	protected void setSevenElisir(String sevenElisirPath) throws IOException {
		this.sevenElisir = ImageIO.read(new File(sevenElisirPath));
	}



	protected BufferedImage getEightElisir() {
		return eightElisir;
	}



	protected void setEightElisir(String eightElisirPath) throws IOException {
		this.eightElisir = ImageIO.read(new File(eightElisirPath));
	}



	protected BufferedImage getNineElisir() {
		return nineElisir;
	}



	protected void setNineElisir(String nineElisirPath) throws IOException {
		this.nineElisir = ImageIO.read(new File(nineElisirPath));
	}



	protected BufferedImage getTenElisir() {
		return tenElisir;
	}



	protected void setTenElisir(String tenElisirPath) throws IOException {
		this.tenElisir = ImageIO.read(new File(tenElisirPath));
	}

}
