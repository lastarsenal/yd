package com.edong.entity;

public class TrackSummary {
	
	private double sumUp;
	private double sumDown;
	private double sumUpDistance;
	private double sumDownDistance;
	
	public TrackSummary() {
		this.sumUp = 0;
		this.sumDown = 0;
		this.sumUpDistance = 0;
		this.sumDownDistance = 0;
	}
	
	public TrackSummary(double sumUp, double sumDown,
			double sumUpDistance, double sumDownDistance) {
		this.sumUp = sumUp;
		this.sumDown = sumDown;
		this.sumUpDistance = sumUpDistance;
		this.sumDownDistance = sumDownDistance;
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

	@Override
	public String toString() {
		return "TrackSummary [sumUp=" + sumUp + ", sumDown=" + sumDown
				+ ", sumUpDistance=" + sumUpDistance + ", sumDownDistance="
				+ sumDownDistance + "]";
	}

}
