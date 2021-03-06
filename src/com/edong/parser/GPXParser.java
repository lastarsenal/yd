package com.edong.parser;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.edong.entity.Location;
import com.edong.entity.Track;

/**
 * 把gpx文件parse成运动轨迹类Track
 * 
 * @author yixun
 * 
 */
public class GPXParser {

	private static SimpleDateFormat timeFormatter = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

	@SuppressWarnings("unchecked")
	public final static List<Track> parse(String gpxFile) throws DocumentException,
			ParseException {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(gpxFile));
		Element root = document.getRootElement();

		List<Element> trkElements = root.elements("trk");
		List<Track> trackList = new ArrayList<Track>();
		for (Element trkElem: trkElements) {
			Track track = new Track();
			String name = trkElem.element("name").getTextTrim();
			track.setName(name);
			Element trkSeg = trkElem.element("trkseg");
			Iterator<Element> it = trkSeg.elements("trkpt").iterator();
			// int i = 0;
			while (it.hasNext()) {
				Element elem = it.next();
				double latitude = Double.parseDouble(elem.attributeValue("lat"));
				double longitude = Double.parseDouble(elem.attributeValue("lon"));
				double elevation = Double.parseDouble(elem.elementTextTrim("ele"));
				String time = elem.elementText("time");
				Date tpTime = timeFormatter.parse(time);
				Location tp = new Location(latitude, longitude, elevation,
						tpTime.getTime(), 0, 0);
				track.addLocation(tp);
				// if (i < 10) {
				// System.out.println("[" + i + "]" + tp);
				// }
				// i++;
			}
			trackList.add(track);
		}
		return trackList;
	}

	public static void main(String[] args) throws DocumentException,
			ParseException {
		String gpxFile = "/Users/ekixun/Work/test/yd/data/1235m.gpx";
		List<Track> trackList = GPXParser.parse(gpxFile);
		for (Track track: trackList) {
		    System.out.println("point size=" + track.getLocations().size());
		}
	}
}
