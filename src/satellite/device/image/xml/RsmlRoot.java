package satellite.device.image.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RsmlRoot {

 
	
  private Drop drop;
  
  String version;
  long  headerSize;
  int   modelCode;
  int   modelCodeBase;
  String model;
  Date dateFile;
  int GMT;

private InfoChannel infoChannel;

private int checkSum;

private Integer dllExtVersion;

private Integer dllVersion;

private String station;
  	
  public RsmlRoot() {}
    
	public RsmlRoot(String string) {
	
	
	}

	
	public static RsmlRoot parse(String string) throws Exception {
		ByteArrayInputStream is = new ByteArrayInputStream(string.getBytes());
		
		return parse(is);
	}

	public static RsmlRoot parse(InputStream is) throws Exception {
		MyParser dh = new MyParser();
		SAXParserFactory
		.newInstance()
		.newSAXParser()		
		.parse(is, dh);
		return dh.getRsmlRoot();
	}

	public void setDrop(Drop drop) {
		this.drop = drop;		
	}
	
	public void setInfoChannel(InfoChannel infoChannel) {
		this.infoChannel = infoChannel;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public long getHeaderSize() {
		return headerSize;
	}

	public void setHeaderSize(long headerSize) {
		this.headerSize = headerSize;
	}

	public int getModelCode() {
		return modelCode;
	}

	public void setModelCode(int modelCode) {
		this.modelCode = modelCode;
	}

	public int getModelCodeBase() {
		return modelCodeBase;
	}

	public void setModelCodeBase(int modelCodeBase) {
		this.modelCodeBase = modelCodeBase;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getDateFile() {
		return dateFile;
	}

	public void setDateFile(Date dateFile) {
		this.dateFile = dateFile;
	}

	public int getGMT() {
		return GMT;
	}

	public void setGMT(int gMT) {
		GMT = gMT;
	}
	
	public InfoChannel getInfoChannel() {
		// TODO Auto-generated method stub
		return infoChannel;
	}

	public Drop getDrop() {
		// TODO Auto-generated method stub
		return drop;
	}

	public void setStation(String Station) {
		station = Station;
	}

	public void setDllVersion(Integer DllVersion) {
		dllVersion = DllVersion;		
	}

	public void setDllExtVersion(Integer DllExtVersion) {
		dllExtVersion = DllExtVersion;
	}

	public void setCheckSum(int CheckSum) {
		checkSum = CheckSum;
	}

	@Override
	public String toString() {
		return "RsmlRoot [version=" + version + ", headerSize=" + headerSize
				+ ", modelCode=" + modelCode + ", modelCodeBase="
				+ modelCodeBase + ", model=" + model + ", dateFile=" + dateFile
				+ ", GMT=" + GMT + ", checkSum=" + checkSum
				+ ", dllExtVersion=" + dllExtVersion + ", dllVersion9="
				+ dllVersion + ", station=" + station + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + GMT;
		result = prime * result + checkSum;
		result = prime * result
				+ ((dateFile == null) ? 0 : dateFile.hashCode());
		result = prime * result
				+ ((dllExtVersion == null) ? 0 : dllExtVersion.hashCode());
		result = prime * result
				+ ((dllVersion == null) ? 0 : dllVersion.hashCode());
		result = prime * result + (int) (headerSize ^ (headerSize >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + modelCode;
		result = prime * result + modelCodeBase;
		result = prime * result + ((station == null) ? 0 : station.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		RsmlRoot other = (RsmlRoot) obj;
		if (GMT != other.GMT)
			return false;
		if (checkSum != other.checkSum)
			return false;
		if (dateFile == null) {
			if (other.dateFile != null)
				return false;
		} else if (!dateFile.equals(other.dateFile))
			return false;
		if (dllExtVersion == null) {
			if (other.dllExtVersion != null)
				return false;
		} else if (!dllExtVersion.equals(other.dllExtVersion))
			return false;
		if (dllVersion == null) {
			if (other.dllVersion != null)
				return false;
		} else if (!dllVersion.equals(other.dllVersion))
			return false;
		if (headerSize != other.headerSize)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (modelCode != other.modelCode)
			return false;
		if (modelCodeBase != other.modelCodeBase)
			return false;
		if (station == null) {
			if (other.station != null)
				return false;
		} else if (!station.equals(other.station))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	
}
