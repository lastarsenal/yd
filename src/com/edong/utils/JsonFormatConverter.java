package com.edong.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.edong.entity.Location;
import com.edong.entity.Track;
import com.edong.entity.TrackHelper;

/**
 * 把gpx文件转换成json格式
 * @author yixun
 *
 */
public class JsonFormatConverter {
	
	public static final JSONObject convertTrackToJson(Track track) {
		List<String> locations = new ArrayList<String>();
		for (Location loc: track.getLocations()) {
			locations.add(TrackHelper.locationToStr(loc));
		}
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.element("locations", locations);
		return jsonObj;
	}
	
/*
	public static final void dealTrack(JSONObject report) {
		JSONArray locations = new JSONArray();
		
		Long startTime = report.getLong(ProtocolCode.NAME_STARTTIME);
		Long end = report.getLong(ProtocolCode.NAME_ENDTIME);
		
		System.out.println("endTime = "+end);

		int type = report.getInt(ProtocolCode.NAME_SPROTTYPE);
		double speed = report.getDouble(ProtocolCode.NAME_ASPEED);
		double max_speed = report.getDouble(ProtocolCode.NAME_MAXSPEED);
		double min_speed = report.getDouble(ProtocolCode.NAME_MINSPEED);
		double max_height = report.getDouble(ProtocolCode.NAME_MAXHEIGHT);
		double min_height = report.getDouble(ProtocolCode.NAME_MINHEIGHT);
		double longitudeoffset = report.getDouble(ProtocolCode.NAME_LONGITUDEOFFSET);
		double latitudeoffset = report.getDouble(ProtocolCode.NAME_LATITUDEOFFSET);
		double distance = report.getDouble(ProtocolCode.NAME_DISTANCE);

		int heartRateAvg = report.optInt(ProtocolCode.NAME_HEARTRATEAVG);
		int heartRateMax = report.optInt(ProtocolCode.NAME_HEARTRATEMAX);
		int heartRateMin = report.optInt(ProtocolCode.NAME_HEARTRATEMIN);
		int slopeAvg = report.optInt(ProtocolCode.NAME_SLOPEAVG);

		long stepcount = 0;
		if (report.containsKey(ProtocolCode.NAME_STEPCOUNT)) {
			stepcount = report.getLong(ProtocolCode.NAME_STEPCOUNT);
		}

		int calories = report.getInt(ProtocolCode.NAME_CALORIES);
		int timed = report.getInt(ProtocolCode.NAME_SPORTTIME);

		int[] eles = new int[locations.size()];
		List<double[]> rds = new ArrayList<double[]>();
		StringBuffer temp = new StringBuffer();
		float firstLng = 0;
		float fifstLat = 0;
		
		for (int j = 0; j < locations.size(); j++) {

			String localtion = (String) locations.get(j);
	
			if (j == 0) {


				String[] data = localtion.split(",");
				try {
					firstLng = BaseBean.getFloat(data[1]);
					fifstLat = BaseBean.getFloat(data[0]);
				} catch (Exception e) {
					firstLng = 0;
					fifstLat = 0;
				}
			}
			if (eleoff == 1) {
				String[] data = localtion.split(",");
				float lat = BaseBean.getFloat(data[0]);
				float lng = BaseBean.getFloat(data[1]);
				int ele = BaseBean.getInt(data[2]);
				double distanctemp = BaseBean.getDouble(data[5]);
				ele = MapUtil.getElevation(lat, lng, ele);
				StringBuffer loc = new StringBuffer();
				loc.append(data[0]).append(",").append(data[1]).append(",").append(ele).append(",").append(data[3]).append(",").append(data[4]).append(",").append(data[5]);
				localtion = loc.toString();
				eles[j] = ele;
				rds.add(new double[] { ele, distanctemp });
			}
		}
	}
*/	
}
