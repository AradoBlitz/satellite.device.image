package satellite.device.image.xml;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PropertyReaderTest {
	
	@Test
	public void parsePropertiesInSingleLine() throws Exception {
		
		List<String> result = new ArrayList<String>();
		String input = "nStringWidth=1632nMiddlePixel=820";
		char type = input.charAt(0);
		String name = new String(input.substring(1, 12));
		String value = new String(input.substring(13,17));
		assertEquals('n', type );
		assertEquals("StringWidth", name);
		assertEquals("1632",value);
	}

}
