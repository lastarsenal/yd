package com.edong.entity;

import java.util.ArrayList;
import java.util.List;

public class Track {
	private String name;
	private List<TrackPoint> track;
	
	public Track() {
		name = "";
		track = new ArrayList<TrackPoint>();
	}
	
	public Track(String name, List<TrackPoint> track) {
		this.name = name;
		this.track = track;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TrackPoint> getTrack() {
		return track;
	}
	public void setTrack(List<TrackPoint> track) {
		this.track = track;
	}
	
	public void addTrackPoint(TrackPoint tp) {
		this.track.add(tp);
	}

	@Override
	public String toString() {
		return "Track [name=" + name + ", track=" + track + "]";
	}
	
}
