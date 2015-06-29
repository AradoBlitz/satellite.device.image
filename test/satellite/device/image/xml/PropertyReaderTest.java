package satellite.device.image.xml;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PropertyReaderTest {
	
	@Test
	public void parseFirstProperty() throws Exception {
		
		
		List<String> result = new ArrayList<String>();
		String input = "nStringWidth=1632nMiddlePixel=820";
		PropertyTokenizer tokenizer = new PropertyTokenizer();
		
		tokenizer.readFirstProperty(input);
		assertEquals('n', tokenizer.type);
		assertEquals("StringWidth", tokenizer.name);
		assertEquals("1632",tokenizer.value);
	}

}
