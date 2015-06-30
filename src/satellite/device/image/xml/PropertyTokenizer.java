package satellite.device.image.xml;

public class PropertyTokenizer {

	public String name;
	public char type;
	public String value;
	private int index;
	
	public void readFirstProperty(String input) {
		StringBuffer buf = new StringBuffer();
;
		type = input.charAt(index);
		for(index++;'='!=input.charAt(index);index++)
			buf.append(input.charAt(index)); 
		name = buf.toString();
		
		buf = new StringBuffer();		
		for(index++;index<input.length()&&'n'!=input.charAt(index);index++)
			buf.append(input.charAt(index));
		value = buf.toString();
	}
	
	public void readLastProperty(String input) {

		type = input.charAt(index);
		StringBuffer buf = new StringBuffer();
		for(index++;'='!=input.charAt(index);index++)
			buf.append(input.charAt(index));
		name = buf.toString();
		buf = new StringBuffer();
		for(index++;index<input.length()&&'n'!=input.charAt(index);index++)
			buf.append(input.charAt(index));
		value = buf.toString();
	}

}
