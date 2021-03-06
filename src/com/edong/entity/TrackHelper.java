package com.edong.entity;

/**
 * 对运动轨迹的计算类
 * @author yixun
 *
 */
public class TrackHelper {
	
	private final static double EARTH_RADIUS = 6371004; //地球半径
	private final static int LOC_ELEM_NUM = 6;
	
	/**
	 * 将角度转化成弧度
	 * @param angle
	 * @return
	 */
	public final static double getRedian(double angle) {
		return angle * Math.PI / 180;
	}
	
	/**
	 * 由两点的经纬度计算两点之间的距离，单位(米)
	 * 注意这里的实现没有考虑东经西经，北纬南纬，一般的运动很难瞬间在两个点之间变换东经西经，北纬南纬。
	 * 给定的数据中也没有标明东经西经北纬南纬，也许客户端传过来的时候已经变换好了？
	 * 一般的经纬度，可以做如下的的变换：
	 * 东经取正值，西经取负值，北纬取正值，南纬取负值，这样做也就是将经纬度的取值范围从原始的0-180变为-180->180和-90->90，
	 * 以此防止东经西经，南纬北纬搞混
	 * @param lonA A点经度(弧度制)
	 * @param latA A点纬度(弧度制)
	 * @param lonB B点经度(弧度制)
	 * @param latB B点纬度(弧度制)
	 * @return AB两点的剧烈（单位：米）
	 * Reference: http://www.codeproject.com/Articles/12269/Distance-between-locations-using-latitude-and-long
	 */
	public static double getHorizonDist(double lonA, double latA, double lonB, double latB) {
		double deltaLat = latA - latB;
		double deltaLon = lonA - lonB;
		double a = Math.pow(Math.sin(deltaLat/2), 2) 
				+ Math.cos(latA) * Math.cos(latB) * Math.pow(Math.sin(deltaLon/2), 2);
	    double c = 2 * Math.asin(Math.sqrt(a));
		double dist = c * EARTH_RADIUS;
		return dist;
	}
	
	public static double getHorizonDist(Location tp1, Location tp2) {
		double lonA = getRedian(tp2.getLongitude());
		double latA = getRedian(tp2.getLatitude());
		double lonB = getRedian(tp1.getLongitude());
		double latB = getRedian(tp1.getLatitude());
		double horizonDist = getHorizonDist(lonA, latA, lonB, latB);
		return horizonDist;
	}
	
	public static double getDistance(Location tp1, Location tp2) {
        double horizonDist = getHorizonDist(tp1, tp2);
		double eleDiff = tp2.getElevation() - tp1.getElevation();
		double distance = Math.sqrt(horizonDist * horizonDist + eleDiff * eleDiff);
	    return distance;
	}
	
	public static TrackSummary sumTrack(Track track) {
		Location prev = null;
		double sumUp = 0;
		double sumDown = 0;
		double sumUpDist = 0;
		double sumDownDist = 0;
		double sumHorizonDist = 0;
		Location startTp = null;
		Location endTp = null;
		for (Location tp: track.getLocations()) {
			if (prev != null) {
			     double eleDiff = tp.getElevation() - prev.getElevation();
			     double distance = getDistance(prev, tp);
			     if (eleDiff > 0) {
			    	 sumUp += eleDiff;
			    	 sumUpDist += distance;
			     } else if (eleDiff < 0) {
			    	 sumDown -= eleDiff;
			    	 sumDownDist += distance;
			     } else {
			    	 sumHorizonDist += distance;
			     }
			} else {
				startTp = tp;
			}
			prev = tp;
			endTp = tp;
		}
		if (startTp != null && endTp != null) {
			TrackSummary trackSummary = new TrackSummary(sumUp, sumDown, sumUpDist, 
					sumDownDist, sumHorizonDist, startTp.getTime(), endTp.getTime());
			return trackSummary;
		} else {
			return new TrackSummary();
		}
	}
	
	/**
	 * 把打点数据转换成String
	 * @param loc
	 * @return
	 */
	public static String locationToStr(Location loc) {
		StringBuffer buf = new StringBuffer();
		buf.append(String.valueOf(loc.getLatitude())).append(",").append(String.valueOf(loc.getLongitude())).append(",")
		   .append(String.valueOf(loc.getElevation())).append(",").append(String.valueOf(loc.getTime())).append(",")
		   .append(String.valueOf(loc.getSpeed())).append(",").append(String.valueOf(loc.getDistance()));
		return buf.toString();
	}
	
	/**
	 * 由String类转换成打点类
	 * @param str
	 * @return
	 */
	public static Location strToLocation(String str) {
		String[] strs = str.split(",");
		if (strs.length != LOC_ELEM_NUM) {
			throw new IllegalArgumentException("json format error!");
		}
		return new Location(Double.parseDouble(strs[0]), Double.parseDouble(strs[1]),
			Double.parseDouble(strs[2]), Long.parseLong(strs[3]), 
			Double.parseDouble(strs[4]), Double.parseDouble(strs[5]));	
	}

}
