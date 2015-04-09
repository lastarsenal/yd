package com.edong.entity;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GPXParser {

	private static SimpleDateFormat timeFormatter =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); 

	@SuppressWarnings("unchecked")	
	public Track parse(String gpxFile) throws DocumentException, ParseException {
		Track track = new Track();
		SAXReader reader = new SAXReader();
	    Document document = reader.read(new File(gpxFile));		
		Element root = document.getRootElement();

		List<Element> list = (List<Element>)root.elements();
		Element trkElement = list.get(0);
		String name = trkElement.element("name").getTextTrim();
		track.setName(name);
		Element trkSeg = trkElement.element("trkseg");
		Iterator<Element> it = trkSeg.elements("trkpt").iterator();
		//int i = 0;
		while (it.hasNext()) {
			Element elem = it.next();
			double latitude = Double.parseDouble(elem.attributeValue("lat"));
			double longitude = Double.parseDouble(elem.attributeValue("lon"));
			double elevation = Double.parseDouble(elem.elementTextTrim("ele"));
			String time = elem.elementText("time");
			Date tpTime = timeFormatter.parse(time);
			TrackPoint tp = new TrackPoint(latitude, longitude, elevation, tpTime);
			track.addTrackPoint(tp);
//			if (i < 10) {
//			    System.out.println("[" + i + "]" + tp);
//			}
			//i++;
		}
	    return track;
	}
	
	

	public static void main(String[] args) throws DocumentException, ParseException {
		String gpxFile = "/Users/ekixun/Work/test/yd/data/1235m.gpx";
		GPXParser gpxParser = new GPXParser();
		Track track = gpxParser.parse(gpxFile);
		System.out.println("point size=" + track.getTrack().size());
		//System.out.println(track);
	}
}
