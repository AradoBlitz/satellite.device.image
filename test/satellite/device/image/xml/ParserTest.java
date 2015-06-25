package satellite.device.image.xml;

import static org.junit.Assert.*;
import static java.util.Arrays.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss.S");
	
	RsmlRoot rsmlRoot = new RsmlRoot();
	
	Drop drop = new Drop();

	private FileInputStream rsmlRootInfoChannel1;

	private FileInputStream sampleDropStream;

	private FileInputStream sampleStream;

	private InputStream rsmlRootSplitedByNestedElementSample;
	
	@Before
	public void initRsmlRoot() throws Exception{
		rsmlRoot.setVersion("2.2.1.3");
		rsmlRoot.setHeaderSize(65536);
		rsmlRoot.setModelCode(14);
		rsmlRoot.setModelCodeBase(16);
		rsmlRoot.setModel("Meteor_M2");
		rsmlRoot.setDateFile(dateFormat.parse("22/12/2014"));
		rsmlRoot.setGMT(3);		
	}
	
	@Before
	public void initFileStreams() throws Exception {
		sampleStream = new FileInputStream("./etc/sample.xml");
		sampleDropStream = new FileInputStream("./etc/sample_drop.xml");
		rsmlRootInfoChannel1 = new FileInputStream("./etc/rsmlRoot_InfoChannel1.xml");
		rsmlRootSplitedByNestedElementSample = new FileInputStream("./etc/rsmlRootSplitedByElement.xml");
	}
	
	@After
	public void closeFileSampleStreams() throws Exception {
		sampleStream.close();
		sampleDropStream.close();
		rsmlRootInfoChannel1.close();
		rsmlRootSplitedByNestedElementSample.close();
	}
	
	@Test
	public void parseRsmlRootInfoChannel1() throws Exception {		
		
		InfoChannel infoChannel1 = new InfoChannel();		
		
		infoChannel1.setDeviceName("MSU-MR");
		infoChannel1.setDevNumber(1);
		infoChannel1.setIdleWidth(50);
		infoChannel1.setMainFreq(6.498040);
		infoChannel1.setVideoWidth(1572);
		infoChannel1.setStringWidth(1632);
		infoChannel1.setMiddlePixel(820);
		infoChannel1.setVideoStartRec(51);
		
		asList(7.000000,11.000000,18.000000)
			.forEach((specHBend)->{infoChannel1.addSpecHBend(specHBend);});
		
		asList(5.000000,7.000000,16.000000)
			.forEach((specLBend)->{ infoChannel1.addSpecLBend(specLBend); });
		
		asList("-001:23:22.461","-001:23:22.461","-001:23:22.461")
			.forEach((yawAngle)->{infoChannel1.addYawAngle(yawAngle);});
		
		asList("-000:02:57.562","-000:02:57.562","-000:02:57.562")
			.forEach((pitchAngle)->{infoChannel1.addPitchAngle(pitchAngle);});
		
		asList("0002:24:50.901","0002:24:50.901","0002:24:50.901")
		.forEach((pitchAngle)->{infoChannel1.addRollAngle(pitchAngle);});
		
		
		asList("0110:31:00.250","0110:31:00.250","0110:31:00.250")
		.forEach((pitchAngle)->{infoChannel1.addScanAngle(pitchAngle);});
		
		asList(1,1,1)
		.forEach((pitchAngle)->{infoChannel1.addChannel(pitchAngle);});
				
		RsmlRoot actual = RsmlRoot.parse(rsmlRootInfoChannel1);
		assertEquals(infoChannel1, actual.getInfoChannel()); 
	}
	

	@Test
	public void parseFromFileDrop() throws Exception {
				
		drop.setCycleNumber(2374);
		drop.setDateCycle(dateFormat.parse("22/12/2014"));			
		drop.setTimeCycle(timeFormat.parse("22:16:31.0"));
		drop.setSessionType(1);
				
		
		RsmlRoot rsmlRootDrop = RsmlRoot.parse(sampleDropStream);
		assertEquals(drop,rsmlRootDrop.getDrop());
	}
	
	
	
	@Test
	public void parseRsmlElement() throws Exception {
			
			RsmlRoot parse = RsmlRoot.parse(sampleStream);
			assertEquals(rsmlRoot,parse);
	}
	
	@Test
	public void parseEsmlElementSpletedNestedElements() throws Exception {
		
		rsmlRoot.setStation("Обнинск     (1)");
		rsmlRoot.setDllVersion(20141024);
		rsmlRoot.setDllExtVersion(20140908);
		rsmlRoot.setCheckSum(9861);
		assertEquals(rsmlRoot, RsmlRoot.parse(rsmlRootSplitedByNestedElementSample));
	}
}
