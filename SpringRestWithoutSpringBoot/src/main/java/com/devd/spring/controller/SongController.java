package com.devd.spring.controller;

import com.devd.spring.entity.Song;
import com.devd.spring.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-08 08:25
 */

@RestController
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("/song/{songId}")
    public Song getSongById(@PathVariable("songId") String songId) {
        return songService.getSongById(songId);
    }

    @PostMapping("/song")
    public String saveStudent(@RequestBody Song song) {
        return ResponseEntity.ok(songService.saveSong(song)).getBody();
//        return songService.saveSong(song);

    }

    @GetMapping("/song")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @DeleteMapping("/song/{songId}")
    public ResponseEntity<Object> deleteSong(@PathVariable("songId") String songId){
        songService.deleteSongById(songId);
        return ResponseEntity.noContent().build();
    }
}
