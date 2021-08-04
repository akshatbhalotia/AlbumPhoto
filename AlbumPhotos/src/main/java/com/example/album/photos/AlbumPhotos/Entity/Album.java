package com.example.album.photos.AlbumPhotos.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Album")
public class Album {

	private long userId;
	@Id
	private long id;
	private String title;
	
	public Album() {
		// TODO Auto-generated constructor stub
	}
	
	public Album(long userId, long id, String title) {
		this.userId = userId;
		this.id = id;
		this.title = title;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Album [userId=" + userId + ", id=" + id + ", title=" + title + "]";
	}
	

}