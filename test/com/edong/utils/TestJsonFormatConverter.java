package com.edong.utils;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.edong.entity.GPXParser;
import com.edong.entity.Track;
import com.edong.utils.JsonFormatConverter;

public class TestJsonFormatConverter {
	
	private static final String TestGpxFile = "/Users/ekixun/Work/test/yd/data/mini.gpx";

	@Test
	public void testConvertTrackToJson() throws DocumentException, ParseException {
		GPXParser gpxParser = new GPXParser();
		Track track = gpxParser.parse(TestGpxFile);
		JsonFormatConverter.convertTrackToJson(track);
	}

}
