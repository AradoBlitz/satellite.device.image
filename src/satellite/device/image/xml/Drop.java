package satellite.device.image.xml;

import java.util.Date;

public class Drop {

	int nCycleNumber;
    Date dDateCycle;
    Date tTimeCycle;
    int  nSessionType;

	public Drop(String content) {
				// TODO Auto-generated constructor stub
	}

	public Drop() {
		// TODO Auto-generated constructor stub
	}

	public void setContent(String content) {
				
	}

	@Override
	public String toString() {
		return "Drop [nCycleNumber=" + nCycleNumber + ", dDateCycle="
				+ dDateCycle + ", tTimeCycle=" + tTimeCycle + ", nSessionType="
				+ nSessionType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dDateCycle == null) ? 0 : dDateCycle.hashCode());
		result = prime * result + nCycleNumber;
		result = prime * result + nSessionType;
		result = prime * result
				+ ((tTimeCycle == null) ? 0 : tTimeCycle.hashCode());
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
		Drop other = (Drop) obj;
		if (dDateCycle == null) {
			if (other.dDateCycle != null)
				return false;
		} else if (!dDateCycle.equals(other.dDateCycle))
			return false;
		if (nCycleNumber != other.nCycleNumber)
			return false;
		if (nSessionType != other.nSessionType)
			return false;
		if (tTimeCycle == null) {
			if (other.tTimeCycle != null)
				return false;
		} else if (!tTimeCycle.equals(other.tTimeCycle))
			return false;
		return true;
	}

	public void setCycleNumber(int cycleNumber) {
		nCycleNumber = cycleNumber;
	}

	public void setDateCycle(Date parse) {
		dDateCycle = parse;		
	}

	public void setTimeCycle(Date parse) {
		tTimeCycle = parse;
	}

	public void setSessionType(int i) {
		nSessionType = i;
	}	
}
