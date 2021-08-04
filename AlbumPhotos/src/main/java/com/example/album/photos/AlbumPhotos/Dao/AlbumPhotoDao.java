package com.example.album.photos.AlbumPhotos.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.album.photos.AlbumPhotos.Entity.Album;

@Repository
public interface AlbumPhotoDao extends JpaRepository<Album, Long>{

}

