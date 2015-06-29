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
	
		int i = 17;
		tokenizer.type = input.charAt(i);
		StringBuffer buf = new StringBuffer();
		for(i++;'n'!=input.charAt(i);i++)
			buf.append(input.charAt(i));
		tokenizer.name = buf.toString();
		buf = new StringBuffer();
		for(i++;i<input.length();i++)
			buf.append(input.charAt(i));
		tokenizer.value = buf.toString();
		
		assertEquals('n', tokenizer.type);
		assertEquals("MiddlePixel", tokenizer.name);
		assertEquals("820", tokenizer.value);
	}
}
