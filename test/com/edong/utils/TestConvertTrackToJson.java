package com.edong.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;

import net.sf.json.JSONObject;

import org.dom4j.DocumentException;
import org.junit.Test;

import com.edong.entity.Track;
import com.edong.parser.GPXParser;

/**
 * 测试将gpx文件写成json格式的文件
 * @author yixun
 *
 */
public class TestConvertTrackToJson {
	
	public static final String TestGpxFiles[] = {
		"data/1235m.gpx", "data/1319m.gpx", "data/1880m.gpx", "data/2161m.gpx",
		"data/2779m.gpx", "data/439m.gpx", "data/884m.gpx", "data/mini.gpx"
	};
	public static final String TestJSONFiles[] = {
		"data/1235m.json", "data/1319m.json", "data/1880m.json", "data/2161m.json",
		"data/2779m.json", "data/439m.json", "data/884m.json", "data/mini.json"
	};

	@Test
	public void testConvertTrackToJson() throws DocumentException, ParseException, FileNotFoundException {
		for (int i = 0; i < TestGpxFiles.length; i++) {
			System.out.println("Load track form gpx file: " + new File(TestGpxFiles[i]).getAbsolutePath());
			Track track = GPXParser.parse(TestGpxFiles[i]);
			JSONObject jsonObj = JsonFormatConverter.convertTrackToJson(track);
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(
						new File(TestJSONFiles[i]))),true);  
				pw.println(jsonObj);
			} finally {
				if (pw != null) {
					pw.close();
				}
			}
			System.out.println("Write track to json file: " + new File(TestJSONFiles[i]).getAbsolutePath());
		}
	}

}
