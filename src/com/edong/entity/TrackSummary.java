package com.edong.entity;

public class TrackSummary {
	
	private double accumulativeUp;
	private double accumulativeDown;
	private double accumulativeUpDistance;
	private double accumulativeDownDistance;
	
	public TrackSummary() {
		this.accumulativeUp = 0;
		this.accumulativeDown = 0;
		this.accumulativeUpDistance = 0;
		this.accumulativeDownDistance = 0;
	}
	
	public TrackSummary(double accumulativeUp, double accumulativeDown,
			double accumulativeUpDistance, double accumulativeDownDistance) {
		this.accumulativeUp = accumulativeUp;
		this.accumulativeDown = accumulativeDown;
		this.accumulativeUpDistance = accumulativeUpDistance;
		this.accumulativeDownDistance = accumulativeDownDistance;
	}
	
	public double getAccumulativeUp() {
		return accumulativeUp;
	}
	public void setAccumulativeUp(double accumulativeUp) {
		this.accumulativeUp = accumulativeUp;
	}
	public double getAccumulativeDown() {
		return accumulativeDown;
	}
	public void setAccumulativeDown(double accumulativeDown) {
		this.accumulativeDown = accumulativeDown;
	}
	public double getAccumulativeUpDistance() {
		return accumulativeUpDistance;
	}
	public void setAccumulativeUpDistance(double accumulativeUpDistance) {
		this.accumulativeUpDistance = accumulativeUpDistance;
	}
	public double getAccumulativeDownDistance() {
		return accumulativeDownDistance;
	}
	public void setAccumulativeDownDistance(double accumulativeDownDistance) {
		this.accumulativeDownDistance = accumulativeDownDistance;
	}

	@Override
	public String toString() {
		return "TrackSummary [accumulativeUp=" + accumulativeUp
				+ ", accumulativeDown=" + accumulativeDown
				+ ", accumulativeUpDistance=" + accumulativeUpDistance
				+ ", accumulativeDownDistance=" + accumulativeDownDistance
				+ "]";
	}

}
