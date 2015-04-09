package com.edong.entity;

public class TrackSummary {
	
	private float accumulativeUp;
	private float accumulativeDown;
	private float accumulativeUpDistance;
	private float accumulativeDownDistance;
	public TrackSummary(float accumulativeUp, float accumulativeDown,
			float accumulativeUpDistance, float accumulativeDownDistance) {
		this.accumulativeUp = accumulativeUp;
		this.accumulativeDown = accumulativeDown;
		this.accumulativeUpDistance = accumulativeUpDistance;
		this.accumulativeDownDistance = accumulativeDownDistance;
	}
	
	public float getAccumulativeUp() {
		return accumulativeUp;
	}
	public void setAccumulativeUp(float accumulativeUp) {
		this.accumulativeUp = accumulativeUp;
	}
	public float getAccumulativeDown() {
		return accumulativeDown;
	}
	public void setAccumulativeDown(float accumulativeDown) {
		this.accumulativeDown = accumulativeDown;
	}
	public float getAccumulativeUpDistance() {
		return accumulativeUpDistance;
	}
	public void setAccumulativeUpDistance(float accumulativeUpDistance) {
		this.accumulativeUpDistance = accumulativeUpDistance;
	}
	public float getAccumulativeDownDistance() {
		return accumulativeDownDistance;
	}
	public void setAccumulativeDownDistance(float accumulativeDownDistance) {
		this.accumulativeDownDistance = accumulativeDownDistance;
	}
	
	

}
