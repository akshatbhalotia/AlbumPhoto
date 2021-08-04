package com.example.album.photos.AlbumPhotos.Services;

import java.util.List;

import com.example.album.photos.AlbumPhotos.Entity.Album;
import com.example.album.photos.AlbumPhotos.Entity.Photo;

public interface AlbumPhotoService {
	
	public List<Album> storeAlbumInDB();

	public List<Photo> getAlbumList(int id);
	
	public Album getAlbumDetailsByID(int id);
	
	public Photo getPhotoDetailsByID(int albumId, int id);
}
