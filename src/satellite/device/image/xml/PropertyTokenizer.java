package satellite.device.image.xml;

public class PropertyTokenizer {

	public String name;
	public char type;
	public String value;
	private int index;
	private String input;
	
	public PropertyTokenizer(String input) {
		this.input = input;
	}

	public void readNextProperty() {

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
