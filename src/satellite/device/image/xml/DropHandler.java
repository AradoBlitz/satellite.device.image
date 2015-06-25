package satellite.device.image.xml;

import java.text.SimpleDateFormat;

public class DropHandler extends AbstractElementHandler {

	private RsmlRootHandler rsmlRootHandler;
	private Drop drop;

	public DropHandler(RsmlRootHandler rsmlRootHandler) {
		this.rsmlRootHandler = rsmlRootHandler;
		// TODO Auto-generated constructor stub
	}

	public void create() {
		 drop = new Drop();
		 rsmlRootHandler.getRsmlRoot().setDrop(drop);
	}	

	public void setProperty(String key, String value) throws Exception {
			switch (key) {
			case "nCycleNumber":
			
			drop.setCycleNumber(Integer.parseInt(value));
				break;
			case "dDateCycle":
				drop.setDateCycle(new SimpleDateFormat("dd/MM/yyyy").parse(value));
				break;
			case "tTimeCycle":
				drop.setTimeCycle(new SimpleDateFormat("hh:mm:ss.S").parse(value));
				break;
			case "nSessionType":
				drop.setSessionType(Integer.parseInt(value));
				break;
		default:
			break;
		}
	}

}
