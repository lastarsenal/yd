package com.edong.entity;

/**
 * 运动轨迹的统计计算结果
 * @author yixun
 *
 */
public class TrackSummary {
	
	private double sumUp; //累计上升，米
	private double sumDown; //累计下降，米
	private double sumUpDistance; //累计上升的运动距离，米
	private double sumDownDistance; //累计下降的运动距离，米
	private double sumHorizonDistance; //累计平地上的运动距离，米
	private long startTime; //开始时间，in milliseconds;
	private long endTime; //结束时间，in milliseconds;
	
	public TrackSummary() {
		this.sumUp = 0;
		this.sumDown = 0;
		this.sumUpDistance = 0;
		this.sumDownDistance = 0;
		this.sumHorizonDistance = 0;
		this.startTime = 0;
		this.endTime = 0;
	}
	
	public TrackSummary(double sumUp, double sumDown, double sumUpDistance, 
			double sumDownDistance, double sumHorizonDistance, long startTime, long endTime) {
		this.sumUp = sumUp;
		this.sumDown = sumDown;
		this.sumUpDistance = sumUpDistance;
		this.sumDownDistance = sumDownDistance;
		this.sumHorizonDistance = sumHorizonDistance;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public double getSumUp() {
		return sumUp;
	}
	public void setSumUp(double sumUp) {
		this.sumUp = sumUp;
	}
	public double getSumDown() {
		return sumDown;
	}
	public void setSumDown(double sumDown) {
		this.sumDown = sumDown;
	}
	public double getSumUpDistance() {
		return sumUpDistance;
	}
	public void setSumUpDistance(double sumUpDistance) {
		this.sumUpDistance = sumUpDistance;
	}
	public double getSumDownDistance() {
		return sumDownDistance;
	}
	public void setSumDownDistance(double sumDownDistance) {
		this.sumDownDistance = sumDownDistance;
	}

	public double getSumHorizonDistance() {
		return sumHorizonDistance;
	}

	public void setSumHorizonDistance(double sumHorizonDistance) {
		this.sumHorizonDistance = sumHorizonDistance;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public double getDuration() {
		return (this.endTime - this.startTime) / 1000.0;
	}

	public double getSumDistance() {
		return sumUpDistance + sumDownDistance + sumHorizonDistance;
	}
	
	public double getSpeedPerHour() {
		return (getSumDistance() / 1000) / (getDuration() / 3600);
	}

	@Override
	public String toString() {
		return "TrackSummary [累计上升: " + sumUp + "米， 累计下降=" + sumDown + "米, 累计上升距离="
				+ sumUpDistance + "米，累计下降距离=" + sumDownDistance + "米，平地距离=" 
				+ sumHorizonDistance + "米，总运动距离=" + getSumDistance() + "米，运动时间="
				+ getDuration() + "秒，平均时速=" + getSpeedPerHour() + "km/hour";

	}
}
