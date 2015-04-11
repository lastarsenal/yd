package com.edong.entity;

import java.util.ArrayList;
import java.util.List;

public class Track {
	private String name;
	private List<Location> locations;
	
	public Track() {
		name = "";
		locations = new ArrayList<Location>();
	}
	
	public Track(String name, List<Location> locations) {
		this.name = name;
		this.locations = locations;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> track) {
		this.locations = track;
	}
	
	public void addLocation(Location tp) {
		this.locations.add(tp);
	}

	@Override
	public String toString() {
		return "Track [name=" + name + ", locations=" + locations + "]";
	}
	
}
