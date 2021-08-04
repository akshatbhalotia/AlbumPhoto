package com.example.album.photos.AlbumPhotos.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.album.photos.AlbumPhotos.Dao.AlbumPhotoDao;
import com.example.album.photos.AlbumPhotos.Entity.Album;
import com.example.album.photos.AlbumPhotos.Entity.Photo;

@Service
public class AlbumPhotosServiceIMPL implements AlbumPhotoService{

	RestTemplate restTemplate;
	@Autowired
	AlbumPhotoDao albumPhotoDao;
	List<Album> albums;
	List<Photo> photos;
	
	
	// PART -  1
	/**
	 * This method stores Albums
	 * 
	 * returns list of Albums available
	 */
	@Override
	public List<Album> storeAlbumInDB() {
		restTemplate = new RestTemplate();
		ResponseEntity<List<Album>> albumRespEntity = restTemplate
				.exchange("https://jsonplaceholder.typicode.com/albums", HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {});
		List<Album> albumList = albumRespEntity.getBody();
		albums = albumList.stream().collect(Collectors.toList());
		//albumPhotoDao.saveAll(albums);
		return albums;
	}

	/**
	 * This method stores Album By ID in Photo 
	 * 
	 * returns list of Photos for the Id we requested
	 */
	@Override
	public List<Photo> getAlbumList(int id) {
		restTemplate = new RestTemplate();
		ResponseEntity<List<Photo>> albumRespEntity = restTemplate
				.exchange("https://jsonplaceholder.typicode.com/photos?albumId=" + id, HttpMethod.GET, null, new ParameterizedTypeReference<List<Photo>>() {});
		List<Photo> photoList = albumRespEntity.getBody();
		photos = photoList.stream().collect(Collectors.toList());
		
		return photos;
	}

	
	
	
	
	//PART -2
	
	/**
	 * This method returns Album , for the ID we requested for
	 * 
	 * retuns null if not present in the list
	 */
	@Override
	public Album getAlbumDetailsByID(int id) {
		Album album = null;
		Optional<Album> albumOption = this.albums.stream().filter(eachAlbum -> id == eachAlbum.getId()).findFirst();
		if(albumOption.isPresent()) {
			album =  (Album) albumOption.get();
		}
		return album;
	}

	
	/**
	 * This method returns Photo , for the AlbumID and PhotoID we requested for
	 * 
	 * retuns null if not present in the list
	 */
	@Override
	public Photo getPhotoDetailsByID(int albumId, int id) {

		Photo photo = null;
		Optional<Photo> photoOption = this.photos.stream().filter(eachPhoto -> albumId == eachPhoto.getAlbumId() && id == eachPhoto.getId()).findFirst();
		if(photoOption.isPresent()) {
			photo = (Photo) photoOption.get();
		}
		return photo;
	}

}
