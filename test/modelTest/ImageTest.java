package modelTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

import model.Image;

class ImageTest {

	@Test
	void testImage() {
		//String TestedImagePathAbsolute = "C:\\Users\\elwin\\ETS-LOG121-Laboratoire3\\test\\modelTest\\TestedImage.png" ; 
		String TestedImagePathRelative = "modelTest\\TestedImage.png" ; 

		//Image img1 = new Image(TestedImagePathAbsolute);
		Image img2 = new Image(TestedImagePathRelative);

		assertTrue(img2 instanceof model.Image);
	}


	@Test
	void testZoom() {
		//fail("Not yet implemented");
	}

	@Test
	void testTranslateTo() {
		//fail("Not yet implemented");
	}

	@Test
	void testTranslateHorizontally() {
		//fail("Not yet implemented");
	}

	@Test
	void testTranslateVerticaly() {
		//fail("Not yet implemented");
	}

}
