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
		char type = 0;
		String name = null;
		String value = null;
		assertEquals('n', type );
		assertEquals("StringWidth", name);
		assertEquals("1632",value);
	}

}
