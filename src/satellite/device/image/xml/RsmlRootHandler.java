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

	enum RsmlRootToken implements ElementToken{
		Version{
			public void accept(RsmlRoot rsmlRoot,String value){
				rsmlRoot.setVersion(value);
			}
		}
		,nHeaderSize{

		@Override
			public void accept(RsmlRoot rsmlRoot, String value) {
				rsmlRoot.setHeaderSize(Long.parseLong(value));		
			}
		}
		,nModelCode{

			@Override
				public void accept(RsmlRoot rsmlRoot, String value) {
				rsmlRoot.setModelCode(Integer.parseInt(value));		
				}
		}
		,nModelCodeBase{

			@Override
				public void accept(RsmlRoot rsmlRoot, String value) {
					rsmlRoot.setModelCodeBase(Integer.parseInt(value));	
				}
		}
		,cModel{

			@Override
				public void accept(RsmlRoot rsmlRoot, String value) {
					rsmlRoot.setModel(value.replaceAll("\"", ""));	
				}
		}
		,dDateFile{

			@Override
				public void accept(RsmlRoot rsmlRoot, String value) {
					try {
						
						rsmlRoot.setDateFile(simpleDateFormat.parse(value));
					} catch (ParseException e) {
					
						e.printStackTrace();
					}	
				}
		}
		,nGMT {

			@Override
				public void accept(RsmlRoot rsmlRoot, String value) {
				rsmlRoot.setGMT(Integer.parseInt(value));	
				}
		}
		,cStation { 

			@Override
				public void accept(RsmlRoot rsmlRoot, String value) {
					rsmlRoot.setStation(value.replaceAll("\"", ""));
				}
		}
		,cDllVersion { 

			@Override
				public void accept(RsmlRoot rsmlRoot, String value) {
					rsmlRoot.setDllVersion(Integer.parseInt(value.replaceAll("\"", "")));
				}
		}
		,cDllExtVersion { 

				@Override
				public void accept(RsmlRoot rsmlRoot, String value) {
					rsmlRoot.setDllExtVersion(Integer.parseInt(value.replaceAll("\"", "")));
				}
		}
		,nCheckSum { 

			@Override
			public void accept(RsmlRoot rsmlRoot, String value) {
				rsmlRoot.setCheckSum(Integer.parseInt(value));
			}
	};
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	};
	
	@Override
	public void setProperty(String key, String value) throws Exception {
		 {
			 Logger.getLogger(getClass().getName()) .info("Key[" + key + "],value[" + "]");
			 RsmlRootToken.valueOf(key).accept(rsmlRoot, value);			
		}
		
	}

}
