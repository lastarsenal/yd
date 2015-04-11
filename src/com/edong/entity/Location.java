package com.edong.entity;



public class Location {
	private double latitude; //纬度
	private double longitude; //经度
	private double elevation; //海拔
	private long time; //打点时间
	private double speed;
	private double distance;
	
	public Location(double latitude, double longitude, double elevation,
			long time, double speed, double distance) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		this.time = time;
		this.speed = speed;
		this.distance = distance;
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

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return "TrackPoint [latitude=" + latitude + ", longitude=" + longitude
				+ ", elevation=" + elevation + ", time=" + time + ", speed="
				+ speed + ", distance=" + distance + "]";
	}
	
}
