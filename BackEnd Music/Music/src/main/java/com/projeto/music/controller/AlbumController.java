package com.projeto.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.music.model.Album;
import com.projeto.music.service.AlbumService;

@RestController
@CrossOrigin("${origem-permitida}")
public class AlbumController {
	
	AlbumService albumService = new AlbumService();
	
	@GetMapping("/albuns")
	public List<Album> list() {
		return albumService.getAlbuns();
	}
	
	@PostMapping("/albuns")
	public void create(@RequestBody Album album) {
		albumService.createAlbum(album);
	}
	
	@PutMapping("/albuns/{id}")
	public void update(@PathVariable String id, @RequestBody Album album) {
		albumService.updateAlbum(album, Integer.parseInt(id));
	}
	
	@DeleteMapping("/albuns/{id}")
	public void delete(@PathVariable String id) {
		albumService.deleteAlbum(Integer.parseInt(id));
	}

}
