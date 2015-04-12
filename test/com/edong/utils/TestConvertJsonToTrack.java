package com.edong.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.edong.entity.Track;
import com.edong.entity.TrackHelper;
import com.edong.entity.TrackSummary;
import com.edong.parser.JSONParser;

public class TestConvertJsonToTrack {

	@Test
	public void testConvertJsonToTrack() throws IOException {
		System.out.println("Load track from json file: " 
	       + new File(TestConvertTrackToJson.TestJSONFiles[0]).getAbsolutePath());
		Track track = JSONParser.parse(TestConvertTrackToJson.TestJSONFiles[0]);
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
	
	@Test
	public void testConvertJsonToTracks() throws IOException {
		for (int i = 0; i < TestConvertTrackToJson.TestJSONFiles.length; i++) {
			System.out.println("Load track from json file: " 
				       + new File(TestConvertTrackToJson.TestJSONFiles[i]).getAbsolutePath());
			Track track = JSONParser.parse(TestConvertTrackToJson.TestJSONFiles[i]);
			System.out.println("point size=" + track.getLocations().size());
			TrackSummary trackSummary = TrackHelper.sumTrack(track);	
			System.out.println(trackSummary);
		}
	}

}
