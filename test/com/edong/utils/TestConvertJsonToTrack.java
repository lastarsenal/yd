package com.edong.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.edong.entity.Track;
import com.edong.entity.TrackHelper;
import com.edong.entity.TrackSummary;
import com.edong.parser.JSONParser;

/**
 * 测试由json读入成{@code Track}类，然后进行统计计算成{@code TrackSummary}
 * 
 * @author yixun
 * 
 */
public class TestConvertJsonToTrack {

	@Test
	public void testConvertJsonToTrack() throws IOException {
		System.out.println("Load track from json file: "
				+ new File(TestConvertTrackToJson.TestJSONFiles[0] + ".0")
						.getAbsolutePath());
		Track track = JSONParser.parse(TestConvertTrackToJson.TestJSONFiles[0] + ".0");
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
			int j = 0;
			while (true) {
				String fileName = TestConvertTrackToJson.TestJSONFiles[i] + "." + j;
				File f = new File(fileName);
				if (f.exists()) {
					System.out.println("Load track from json file: " + f.getAbsolutePath());
					Track track = JSONParser.parse(fileName);
					System.out.println("point size=" + track.getLocations().size());
					TrackSummary trackSummary = TrackHelper.sumTrack(track);
					System.out.println(trackSummary);
					j++;
				} else {
					break;
				}
			}
		}
	}

}
