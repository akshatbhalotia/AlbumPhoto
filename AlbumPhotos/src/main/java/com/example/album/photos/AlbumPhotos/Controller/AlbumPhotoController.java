package com.example.album.photos.AlbumPhotos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.album.photos.AlbumPhotos.Entity.Album;
import com.example.album.photos.AlbumPhotos.Entity.Photo;
import com.example.album.photos.AlbumPhotos.Services.AlbumPhotoService;

@RestController
@RequestMapping("albumphoto")
public class AlbumPhotoController {
	
	@Autowired
	AlbumPhotoService albumPhtotoService;
	
	
	// PART - 1
	/**
	 * For getting the List of Albums and Storing them to Database
	 * 
	 * for example use  -   localhost:8084/albumphoto/insertInDB
	 * @return list of Album
	 */
	@GetMapping("/insertInDB")
	public List<Album> storeAlbumInDB(){
		return albumPhtotoService.storeAlbumInDB();
		
	}
	
	
	/**
	 * Get Photos by ID we requested and also Storing them in Photo
	 * 
	 * for example Use  -    localhost:8084/albumphoto/albumID/2
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/albumID/{id}")
	public List<Photo> getAlbumByID(@PathVariable int id){
		return albumPhtotoService.getAlbumList(id);
	}
	
	
	
	
	
	
	// PART - 2 
	/**
	 * Get Album using AlbumID we stored in the DB 
	 * Since ID is unique, so it will return only 1 Album detail
	 * 
	 * for ex. use -    localhost:8084/albumphoto/getAlbumDetails/13
	 * 
	 * @param id
	 * @return album
	 */
	@GetMapping("/getAlbumDetails/{id}")
	public Album getAlbumDetailsByID(@PathVariable int id){
		return albumPhtotoService.getAlbumDetailsByID(id);
	}
	

	
	/**
	 * Get Photos using photoId and AlbumId from the List we have
	 * 
	 * for ex. use -    localhost:8084/albumphoto/getPhotoDetails/albumId/2/photoID/63
	 * @param albumId
	 * @param id
	 * @return photo
	 */
	@GetMapping("/getPhotoDetails/albumId/{albumId}/photoID/{id}")
	public Photo getPhotoDetailsByID(@PathVariable int albumId, @PathVariable int id) {
		return albumPhtotoService.getPhotoDetailsByID(albumId,id);
	}
	

}
