package satellite.device.image.xml;

import java.util.ArrayList;
import java.util.List;

public class InfoChannel {

	private List<Double> specLBend = new ArrayList<Double>();
	private List<Double> specHBend = new ArrayList<Double>();
	private List<String> yawAngle = new ArrayList<>();
	private List<Integer> channel = new ArrayList<>();
	private List<String> scanAngle = new ArrayList<>();
	private List<String> rollAngle = new ArrayList<>();
	private List<String> pitchAngle = new ArrayList<>();
	private String deviceName;
	private int devNumber;
	private int idleWidth;
	private double mainFreq;
	private int videoWidth;
	private int stringWidth;
	private int middlePixel;
	private int videoStartRec;
	

	public void addSpecLBend(double parseDouble) { 
		specLBend.add(parseDouble);		
	}
	
	public void addSpecHBend(double parseDouble) {
		specHBend.add(parseDouble);		
	}

	public void addYawAngle(String yawAngle) {
		this.yawAngle.add(yawAngle);
	}

	public void addPitchAngle(String pitchAngle) {
		this.pitchAngle.add(pitchAngle);
	}

	public void addRollAngle(String rollAngle) {
		this.rollAngle.add(rollAngle);		
	}

	public void addScanAngle(String scanAngle) {
		this.scanAngle.add(scanAngle);
	}

	public void addChannel(int channel) {
		this.channel.add(channel);
		
	}

	public void setDeviceName(String DeviceName) {
		deviceName = DeviceName;
		// TODO Auto-generated method stub
		
	}

	public void setDevNumber(int DevNumber) {
		devNumber = DevNumber;
		// TODO Auto-generated method stub
		
	}

	public void setIdleWidth(int IdleWidth) {
		idleWidth = IdleWidth;
		// TODO Auto-generated method stub
		
	}

	public void setMainFreq(double MainFreq) {
		mainFreq = MainFreq;
		// TODO Auto-generated method stub
		
	}

	public void setVideoWidth(int VideoWidth) {
		videoWidth = VideoWidth;
		// TODO Auto-generated method stub
		
	}

	public void setStringWidth(int StringWidth) {
		stringWidth = StringWidth;
		// TODO Auto-generated method stub
		
	}

	public void setMiddlePixel(int MiddlePixel) {
		middlePixel = MiddlePixel;
		// TODO Auto-generated method stub
		
	}

	public void setVideoStartRec(int VideoStartRec) {
		videoStartRec = VideoStartRec; 
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "InfoChannel [specLBend=" + specLBend + ", specHBend="
				+ specHBend + ", yawAngle=" + yawAngle + ", channel=" + channel
				+ ", scanAngle=" + scanAngle + ", rollAngle=" + rollAngle
				+ ", pitchAngle=" + pitchAngle + ", deviceName=" + deviceName
				+ ", devNumber=" + devNumber + ", idleWidth=" + idleWidth
				+ ", mainFreq=" + mainFreq + ", videoWidth=" + videoWidth
				+ ", stringWidth=" + stringWidth + ", middlePixel="
				+ middlePixel + ", videoStartRec=" + videoStartRec + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + devNumber;
		result = prime * result
				+ ((deviceName == null) ? 0 : deviceName.hashCode());
		result = prime * result + idleWidth;
		long temp;
		temp = Double.doubleToLongBits(mainFreq);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + middlePixel;
		result = prime * result
				+ ((pitchAngle == null) ? 0 : pitchAngle.hashCode());
		result = prime * result
				+ ((rollAngle == null) ? 0 : rollAngle.hashCode());
		result = prime * result
				+ ((scanAngle == null) ? 0 : scanAngle.hashCode());
		result = prime * result
				+ ((specHBend == null) ? 0 : specHBend.hashCode());
		result = prime * result
				+ ((specLBend == null) ? 0 : specLBend.hashCode());
		result = prime * result + stringWidth;
		result = prime * result + videoStartRec;
		result = prime * result + videoWidth;
		result = prime * result
				+ ((yawAngle == null) ? 0 : yawAngle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfoChannel other = (InfoChannel) obj;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (devNumber != other.devNumber)
			return false;
		if (deviceName == null) {
			if (other.deviceName != null)
				return false;
		} else if (!deviceName.equals(other.deviceName))
			return false;
		if (idleWidth != other.idleWidth)
			return false;
		if (Double.doubleToLongBits(mainFreq) != Double
				.doubleToLongBits(other.mainFreq))
			return false;
		if (middlePixel != other.middlePixel)
			return false;
		if (pitchAngle == null) {
			if (other.pitchAngle != null)
				return false;
		} else if (!pitchAngle.equals(other.pitchAngle))
			return false;
		if (rollAngle == null) {
			if (other.rollAngle != null)
				return false;
		} else if (!rollAngle.equals(other.rollAngle))
			return false;
		if (scanAngle == null) {
			if (other.scanAngle != null)
				return false;
		} else if (!scanAngle.equals(other.scanAngle))
			return false;
		if (specHBend == null) {
			if (other.specHBend != null)
				return false;
		} else if (!specHBend.equals(other.specHBend))
			return false;
		if (specLBend == null) {
			if (other.specLBend != null)
				return false;
		} else if (!specLBend.equals(other.specLBend))
			return false;
		if (stringWidth != other.stringWidth)
			return false;
		if (videoStartRec != other.videoStartRec)
			return false;
		if (videoWidth != other.videoWidth)
			return false;
		if (yawAngle == null) {
			if (other.yawAngle != null)
				return false;
		} else if (!yawAngle.equals(other.yawAngle))
			return false;
		return true;
	}	
}
