package satellite.device.image.xml;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyParser extends DefaultHandler{
	
	final Logger log = Logger.getLogger(getClass().getName());
	
	Drop drop;
	
	String path;
	
	RsmlRootHandler rsmlRootHandler = new RsmlRootHandler();
	
	DropHandler dropHandler = new DropHandler(rsmlRootHandler);
	
	InfoChannelHandler infoChannelHandler = new InfoChannelHandler(rsmlRootHandler);
	
	Map<String, ElementHandler> handlerMap = new HashMap<>();
	{
		handlerMap.put("RSML_ROOT", rsmlRootHandler);
		handlerMap.put("RSML_ROOT:Drop", dropHandler);
		handlerMap.put("RSML_ROOT:InfoChannel1", infoChannelHandler);
	}
	
	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes attributes) throws SAXException {
		popToPath(qName);
		if(!handlerMap.containsKey(path)){
			log.info("No handler for path " + path);
			return;
		}
		handlerMap.get(path).create();
		
	}

	private void popToPath(String qName) {
		if(path == null){
			path = qName;
		} else {
		path += ":" + qName;
		}
		log.info(path);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		pushFromPath(qName);
		log.info(path);
	}

	private void pushFromPath(String qName) {
		int lastIndexOf = path.lastIndexOf(":" + qName);
		if(lastIndexOf>-1){
			path = path.substring(0, lastIndexOf);
		} else {
			path =null;
		}	
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		log.info("Path" +  start + "-" +  length + path + new String(ch,start,length));
		try {
			handlerMap.get(path).setContent(new String(ch,start,length));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

	public RsmlRoot getRsmlRoot() {
		// TODO Auto-generated method stub
		return rsmlRootHandler.getRsmlRoot();
	}

}
