package com.accenture.insurance.beans;

import java.io.Serializable;

public class File implements Serializable {

	private static final long serialVersion=1L;
	private String name;
	private String id;
	private String thumbnailLink;
	
	public File() {
		super();
	}
	
	public File(String name, String id, String thumbnailLink) {
		super();
		this.name = name;
		this.id = id;
		this.thumbnailLink = thumbnailLink;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getThumbnailLink() {
		return thumbnailLink;
	}
	public void setThumbnailLink(String thumbnailLink) {
		this.thumbnailLink = thumbnailLink;
	}
	public static long getSerialversion() {
		return serialVersion;
	}
	
}
