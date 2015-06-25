package satellite.device.image.xml;

public class Searcher {

	public int next;
	private String input;
	public int stopSymbol;
	private String pattern;
	public int patternsIndex;
	public int begin = -1;

	public Searcher(String input, String pattern) {
		this.input = input;
		this.pattern = pattern;	
		patternsIndex = pattern.length()-1;
	}

	public void next() {

		
		if(pattern.charAt(patternsIndex) != input.charAt(next + patternsIndex)){
			if(pattern.lastIndexOf(input.charAt(next + patternsIndex))!=-1){
			next = patternsIndex-pattern.lastIndexOf(input.charAt(next + patternsIndex));		
			stopSymbol=patternsIndex;
			} else {
				next = next + pattern.length();
				stopSymbol=0;
			}
			patternsIndex=pattern.length()-1;
		} else {
			patternsIndex--;
		}
		if(patternsIndex<0){
			begin = next;
			patternsIndex=pattern.length()-1;
		}
		
	}

	public void find() {
		while(begin==-1)
			next();		
	}

}
