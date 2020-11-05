package com.example.rickandmorty.model;

import java.io.Serializable;

public class Location implements Serializable {
	private String name;
	private String url;
	public Location() {
	}
	public Location(String name, String url) {
		this.name = name;
		this.url = url;
	}
	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Location{" +
				"name='" + name + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}
