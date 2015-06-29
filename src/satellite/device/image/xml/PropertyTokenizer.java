package satellite.device.image.xml;

public class PropertyTokenizer {

	public String name;
	public char type;
	public String value;
	public void readFirstProperty(String input) {
		StringBuffer buf = new StringBuffer();
		int i = 0;
		type = input.charAt(i);
		for(i++;'='!=input.charAt(i);i++)
			buf.append(input.charAt(i)); 
		name = buf.toString();
		
		buf = new StringBuffer();		
		for(i++;'n'!=input.charAt(i);i++)
			buf.append(input.charAt(i));
		value = buf.toString();
	}

}
