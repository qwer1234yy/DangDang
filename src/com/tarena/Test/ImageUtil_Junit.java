package com.tarena.Test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor.MapEntry;
import org.junit.Test;

import com.tarena.util.ImageUtil;



public class ImageUtil_Junit {

	@Test
	public void testCreateImage() {
		Map<String, BufferedImage> pic= ImageUtil.createImage();
		for (Map.Entry<String, BufferedImage> map : pic.entrySet()) {
			//ImageIO.write(map.getValue(), "jpg", BufferedImage.TYPE_INT_RGB);
		}
		System.out.println(pic);
	}

}
