package satellite.device.image.xml;

import java.text.ParseException;
import java.util.logging.Logger;

public class InfoChannelHandler  extends AbstractElementHandler {

	private RsmlRootHandler rsmlRootHandler;
	private InfoChannel infoChannel;
	private int chnlNum;
	public InfoChannelHandler(RsmlRootHandler rsmlRootHandler) {
		this.rsmlRootHandler = rsmlRootHandler;
		
	}

	@Override
	public void create() {
		infoChannel = new InfoChannel();
		chnlNum=1;
		rsmlRootHandler.getRsmlRoot().setInfoChannel(infoChannel);
	}

	public void setProperty(String key, String value) throws Exception {
		if(("nChannel" + chnlNum).equals(key)) {
			infoChannel.addChannel(Integer.parseInt(value));				
		}
		
		if(("aScanAngle" + chnlNum).equals(key)) {
			
			infoChannel.addScanAngle(value);				
		}
		
		if(("aRollAngle" + chnlNum).equals(key)) {
			infoChannel.addRollAngle(value);				
		}

		if(("aPitchAngle" + chnlNum).equals(key)) {
			infoChannel.addPitchAngle(value);				
		}
		
		if(("aYawAngle" + chnlNum).equals(key)) {
			infoChannel.addYawAngle(value);				
		}
		
		if(("nSpecLBend" + chnlNum).equals(key)) {
				infoChannel.addSpecLBend(Double.parseDouble(value));					
		}
		
		if(("nSpecHBend" + chnlNum).equals(key)) {
			infoChannel.addSpecHBend(Double.parseDouble(value));
			chnlNum++;
		}
		
		if("cDeviceName".equals(key)){
			infoChannel.setDeviceName(value.replace("\"", ""));
		}
		
		if("nDevNumber".equals(key)){
			infoChannel.setDevNumber(Integer.parseInt(value));
		}else			
		
		if("nIdleWidth".equals(key)){
			infoChannel.setIdleWidth(Integer.parseInt(value));
		} else if("nMainFreq".equals(key)){
			infoChannel.setMainFreq(Double.parseDouble(value));
		} else if("nVideoWidth".equals(key)){
			infoChannel.setVideoWidth(Integer.parseInt(value));
		} else if("nStringWidth".equals(key)){
			infoChannel.setStringWidth(Integer.parseInt(value));
		} else  if("nMiddlePixel".equals(key)){
			infoChannel.setMiddlePixel(Integer.parseInt(value));
		} else if("nVideoStartRec".equals(key)){
			infoChannel.setVideoStartRec(Integer.parseInt(value));
		}
	}

}
