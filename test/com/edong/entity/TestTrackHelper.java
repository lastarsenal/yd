package com.edong.entity;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.edong.parser.GPXParser;

/**
 * TrackHelper测试类
 * 
 * @author yixun
 * 
 */
public class TestTrackHelper {

	/**
	 * testCase 格式是: 纬度1，经度1，纬度2，经度2，距离答案
	 */
	private static double gpsInfo[][] = {
			{ 39.91667, 116.41667, 30.51667, 114.31667, 1062403.2024982641 },
			{ 39.91667, 116.41667, 39.91667, 116.41667, 0.0 },
			{ 30.51667, 114.31667, 30.51667, 114.31667, 0.0 },
			{ 34.0522, -118.2436, 35.6850, 139.7514, 8811322.3764383 } };

	@Test
	public void testGetHorizonDist() {

		for (int i = 0; i < gpsInfo.length; i++) {
			Location tp1 = new Location(gpsInfo[i][0], gpsInfo[i][1], 0, 0, 0,
					0);
			Location tp2 = new Location(gpsInfo[i][2], gpsInfo[i][3], 0, 0, 0,
					0);
			double distance = TrackHelper.getHorizonDist(tp1, tp2);
			System.out.println("Calc tp1=" + tp1 + " and tp2=" + tp2
					+ ", Distance=" + distance + " VS. expectedDistance="
					+ gpsInfo[i][4]);
			assertEquals(gpsInfo[i][4], distance, 0);
			distance = TrackHelper.getHorizonDist(tp2, tp1);
			System.out.println("Calc tp2=" + tp2 + " and tp1=" + tp1
					+ ", Distance=" + distance + " VS. expectedDistance="
					+ gpsInfo[i][4]);
			assertEquals(gpsInfo[i][4], distance, 0);
		}
	}

	@Test
	public void testSumTrack() throws DocumentException, ParseException {
		String gpxFile = "data/1235m.gpx";
		List<Track> trackList = GPXParser.parse(gpxFile);
		Track track = trackList.get(0);
		System.out.println("point size=" + track.getLocations().size());
		TrackSummary trackSummary = TrackHelper.sumTrack(track);
		double expectedSumUp = 1287.3970000000002;
		double expectedSumDown = 1217.029000000001;
		double expectedSumUpDist = 20041.425682856945;
		double expectedSumDownDist = 23441.48697412073;
		assertEquals(expectedSumUp, trackSummary.getSumUp(), 0);
		assertEquals(expectedSumDown, trackSummary.getSumDown(), 0);
		assertEquals(expectedSumUpDist, trackSummary.getSumUpDistance(), 0);
		assertEquals(expectedSumDownDist, trackSummary.getSumDownDistance(), 0);
		System.out.println(trackSummary);
	}

}
