package satellite.device.image.xml;

public class PropertyTokenizer {

	public String name;
	public char type;
	public String value;
	private int index;
	
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
		index = i;
	}
	public void readLastProperty(String input) {
		int i = index;
		type = input.charAt(i);
		StringBuffer buf = new StringBuffer();
		for(i++;'='!=input.charAt(i);i++)
			buf.append(input.charAt(i));
		name = buf.toString();
		buf = new StringBuffer();
		for(i++;i<input.length();i++)
			buf.append(input.charAt(i));
		value = buf.toString();
	}

}
