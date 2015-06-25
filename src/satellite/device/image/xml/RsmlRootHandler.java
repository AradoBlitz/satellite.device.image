package satellite.device.image.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class RsmlRootHandler extends AbstractElementHandler  {

	RsmlRoot rsmlRoot;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	/* (non-Javadoc)
	 * @see example.test.ElementHandler#create()
	 */
	@Override
	public void create() {
		rsmlRoot = new RsmlRoot();
		
	}

	public RsmlRoot getRsmlRoot() {
		
		return rsmlRoot;
	}

	@Override
	public void setProperty(String key, String value) throws Exception {
		 {
			 Logger.getLogger(getClass().getName()) .info("Key[" + key + "],value[" + "]");
				switch (key) {
				case "Version":
				
					rsmlRoot.setVersion(value);
					break;
				case "nHeaderSize":
					rsmlRoot.setHeaderSize(Long.parseLong(value));
					break;
				case "nModelCode":
					rsmlRoot.setModelCode(Integer.parseInt(value));
					break;
				case "nModelCodeBase":
					rsmlRoot.setModelCodeBase(Integer.parseInt(value));
					break;
				case "cModel":
					rsmlRoot.setModel(value.replaceAll("\"", ""));
					break;
				case "dDateFile":
				try {
					
					rsmlRoot.setDateFile(simpleDateFormat.parse(value));
				} catch (ParseException e) {
				
					e.printStackTrace();
				}
					break;
				case "nGMT": 
					rsmlRoot.setGMT(Integer.parseInt(value));
					break;					
				case "cStation": 
					rsmlRoot.setStation(value.replaceAll("\"", ""));
					break;
				case "cDllVersion":
					rsmlRoot.setDllVersion(Integer.parseInt(value.replaceAll("\"", "")));
					break;
				case "cDllExtVersion":
					rsmlRoot.setDllExtVersion(Integer.parseInt(value.replaceAll("\"", "")));
					break;
				case "nCheckSum":
					rsmlRoot.setCheckSum(Integer.parseInt(value));
					 break;
			default:
				break;
			}
			
		}
		
	}

}
