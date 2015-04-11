package com.yidong.entity;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.edong.entity.GPXParser;
import com.edong.entity.Track;
import com.edong.entity.TrackHelper;
import com.edong.entity.TrackPoint;
import com.edong.entity.TrackSummary;

public class TestTrackHelper {
	
	/**
	 * testCase
	 * 格式是: 纬度1，经度1，纬度2，经度2，距离答案
	 */
	private static double gpsInfo[][] = {
		{39.91667, 116.41667, 30.51667, 114.31667, 1062403.2024982641},
		{39.91667, 116.41667, 39.91667, 116.41667, 0.0},
		{30.51667, 114.31667, 30.51667, 114.31667, 0.0},
		{34.0522, -118.2436, 35.6850, 139.7514, 8811322.3764383}
	};

	@Test
	public void testGetHorizonDist() {
		
		for (int i = 0; i < gpsInfo.length; i++) {
			TrackPoint tp1 = new TrackPoint(gpsInfo[i][0], gpsInfo[i][1], 0, new Date());
			TrackPoint tp2 = new TrackPoint(gpsInfo[i][2], gpsInfo[i][3], 0, new Date());
			double distance = TrackHelper.getHorizonDist(tp1, tp2);
			System.out.println("Calc tp1=" + tp1 + " and tp2=" + tp2 
					+ ", Distance=" + distance + " VS. expectedDistance=" + gpsInfo[i][4] );
			assertEquals(gpsInfo[i][4], distance, 0);
			distance = TrackHelper.getHorizonDist(tp2, tp1);
			System.out.println("Calc tp2=" + tp2 + " and tp1=" + tp1 
					+ ", Distance=" + distance + " VS. expectedDistance=" + gpsInfo[i][4] );
			assertEquals(gpsInfo[i][4], distance, 0);
		}
	}
	
	@Test
	public void testSumTrack() throws DocumentException, ParseException {
		String gpxFile = "/Users/ekixun/Work/test/yd/data/1235m.gpx";
		GPXParser gpxParser = new GPXParser();
		Track track = gpxParser.parse(gpxFile);
		System.out.println("point size=" + track.getTrack().size());
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
