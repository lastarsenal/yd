package com.edong.entity;

import java.util.Date;

public class TrackPoint {
	private double latitude; //纬度
	private double longitude; //经度
	private double elevation; //海拔
	private Date time; //时间
	
	public TrackPoint(double latitude, double longitude, double elevation,
			Date time) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		this.time = time;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getElevation() {
		return elevation;
	}

	public void setElevation(double elevation) {
		this.elevation = elevation;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "TrackPoint [latitude=" + latitude + ", longitude=" + longitude
				+ ", elevation=" + elevation + ", time=" + time + "]";
	}
	
	

}
