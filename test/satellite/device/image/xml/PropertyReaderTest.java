package satellite.device.image.xml;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropertyReaderTest {
	
	String input = "nStringWidth=1632nMiddlePixel=820";
	PropertyTokenizer tokenizer = new PropertyTokenizer(input);
	
	@Test
	public void parseFirstProperty() throws Exception {
			
		
		
		tokenizer.readNextProperty();
		assertEquals('n', tokenizer.type);
		assertEquals("StringWidth", tokenizer.name);
		assertEquals("1632",tokenizer.value);
		assertTrue(tokenizer.hasNextProperty()); 
	}

	@Test
	public void parseLastProperty() throws Exception {
	
		tokenizer.readNextProperty();
		tokenizer.readNextProperty();
		assertEquals('n', tokenizer.type);
		assertEquals("MiddlePixel", tokenizer.name);
		assertEquals("820", tokenizer.value);
	}
}
