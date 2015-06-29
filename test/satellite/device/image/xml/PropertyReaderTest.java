package satellite.device.image.xml;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PropertyReaderTest {
	
	@Test
	public void parsePropertiesInSingleLine() throws Exception {
		
		StringBuffer buf = new StringBuffer();
		List<String> result = new ArrayList<String>();
		String input = "nStringWidth=1632nMiddlePixel=820";
		int i = 0;
		char type = input.charAt(i);
		i=1;
		for(;'='!=input.charAt(i);i++)
		buf.append(input.charAt(i)); 
		String name = buf.toString();
		
		String value = new String(input.substring(13,17));
		assertEquals('n', type );
		assertEquals("StringWidth", name);
		assertEquals("1632",value);
	}

}
