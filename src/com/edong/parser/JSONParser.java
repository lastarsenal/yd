package com.edong.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.edong.entity.Location;
import com.edong.entity.Track;
import com.edong.entity.TrackHelper;
import com.edong.utils.ProtocolCode;

/**
 * 把json数据parse成运动轨迹Track类
 * @author yixun
 *
 */
public class JSONParser {

	public final static Track parse(String jsonFile) throws IOException {
		BufferedReader reader = null;
		List<Location> locations = new ArrayList<Location>();
		try {
			reader = new BufferedReader(new FileReader(new File(jsonFile)));
			JSONObject jsonObj = JSONObject.fromObject(reader.readLine());
			JSONArray locationStrArr = jsonObj.getJSONArray(ProtocolCode.NAME_LOCATIONS);
		    
		    for (int i = 0; i < locationStrArr.size(); i++) {
		    	String str = (String)locationStrArr.get(i);
		    	Location loc = TrackHelper.strToLocation(str);
		    	locations.add(loc);
		    }
		    
		} finally {
			if (reader != null) {
		        reader.close();
			}
		}
		return new Track(jsonFile, locations);		
	}
}
