package satellite.device.image.xml;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropertyReaderTest {
	
	String input = "nStringWidth=1632nMiddlePixel=820";
	PropertyTokenizer tokenizer = new PropertyTokenizer();
	
	@Test
	public void parseFirstProperty() throws Exception {
			
		
		
		tokenizer.readFirstProperty(input);
		assertEquals('n', tokenizer.type);
		assertEquals("StringWidth", tokenizer.name);
		assertEquals("1632",tokenizer.value);
	}

	@Test
	public void parseLastProperty() throws Exception {
	
		tokenizer.type = input.charAt(17);
		tokenizer.name = input.substring(18, 29);
		tokenizer.value = input.substring(30,33);
		
		assertEquals('n', tokenizer.type);
		assertEquals("MiddlePixel", tokenizer.name);
		assertEquals("820", tokenizer.value);
	}
}
