package satellite.device.image.xml;

import java.util.logging.Logger;

public abstract class AbstractElementHandler implements ElementHandler {

	public AbstractElementHandler() {
		super();
	}

	@Override
	public void setContent(String content) throws Exception {
		
		String[] split = content.split("\n");
		if(split.length == 0)
			return;
		Logger.getAnonymousLogger().info("Content[" + content + "]\\n" +  "split[" + split[1] + "]");
		
		for(int i = 1;i<split.length;i++){
			if(split[i].trim().isEmpty())
				continue;
			String[] pair = split[i].split("=");
			Logger.getAnonymousLogger().info("Set version: " + pair[1]);						
			String value = pair[1];				
			String key = pair[0].trim();
			setProperty(key,value);
			
		}
	}

	public abstract void setProperty(String key, String value) throws Exception;

}