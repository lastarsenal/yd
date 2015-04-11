package com.edong.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;

import net.sf.json.JSONObject;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.edong.entity.GPXParser;
import com.edong.entity.Track;
import com.edong.entity.TrackHelper;
import com.edong.entity.TrackSummary;
import com.edong.utils.JsonFormatConverter;

public class TestJsonFormatConverter {
	
	private static final String TestGpxFile = "data/1235m.gpx";
	private static final String TestJSONFile = "data/1235m.json";

	@Test
	public void testConvertTrackToJson() throws DocumentException, ParseException, FileNotFoundException {
		System.out.println("Load track form gpx file: " + new File(TestGpxFile).getAbsolutePath());
		GPXParser gpxParser = new GPXParser();
		Track track = gpxParser.parse(TestGpxFile);
		JSONObject jsonObj = JsonFormatConverter.convertTrackToJson(track);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(
					new File(TestJSONFile))),true);  
			pw.println(jsonObj);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
		System.out.println("Write track to json file: " + new File(TestJSONFile).getAbsolutePath());  
	}
	
	@Test
	public void testConvertJsonToTrack() throws IOException {
		System.out.println("Load track from json file: " + new File(TestJSONFile).getAbsolutePath());
		Track track = JsonFormatConverter.convertJsonToTrack(TestJSONFile);
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
