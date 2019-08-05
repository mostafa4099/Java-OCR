package com.mostafa.sna;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

public class App {

	String nameBng, nameEng, father, husband, mother, dob, id;
	
	public static void main(String[] args) throws TesseractException {

		App app = new App();

		app.imageToText("F:\\images\\NID Collection\\nid.jpg");

	}

	public void imageToText(String path) throws TesseractException {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		img = ImageHelper.convertImageToGrayscale(img);

		File outputfile = new File("F:\\images\\NID Collection\\nid.png");
		try {
			ImageIO.write(img, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ITesseract tesseract = new Tesseract();
		tesseract.setLanguage("Bengali+eng+ben+eng2b+Bengali2f+eng2f+ben2f+Bengali2n+eng2n+ben2n");
//		tesseract.setLanguage("Bengali+eng+ben");
//		tesseract.setLanguage("Bengali2b+eng2b+ben2b");
//		tesseract.setLanguage("Bengali2f+eng2f+ben2f");
//		tesseract.setLanguage("Bengali2n+eng2n+ben2n");
		String text = tesseract.doOCR(img);

		System.out.println(text);
	}

}
