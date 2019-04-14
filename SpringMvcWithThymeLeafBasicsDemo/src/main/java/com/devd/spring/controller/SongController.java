package com.devd.spring.controller;

import com.devd.spring.entity.Song;
import com.devd.spring.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-08 08:25
 */

@Controller
@Slf4j
public class SongController {


    @Autowired
    private SongService songService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("message", "Hello Spring MVC 5!");
        ResponseEntity<List<Song>> allSongs = getAllSongs();
        List<Song> songs = allSongs.getBody();
        log.info("Songs : "+ songs);
        model.addAttribute("songs", songs);
        return "index";
    }


    @GetMapping("/song/{songId}")
    public ResponseEntity<Song> getSongById(@PathVariable("songId") String songId) {
        Song songById = songService.getSongById(songId);
        return new ResponseEntity<>(songById, HttpStatus.OK);
    }

    @PostMapping("/song")
    public ResponseEntity<?> saveStudent(@RequestBody Song song) {

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(songService.saveSong(song)).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        //created song id will be sent in the response headers.
        return new ResponseEntity<>(headers,HttpStatus.CREATED);

    }

    @PutMapping("/song")
    public ResponseEntity<Void> updateStudent(@RequestBody Song song) {
        songService.updateSong(song);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/song")
    public ResponseEntity<List<Song>> getAllSongs() {

        return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
    }

    @DeleteMapping("/song/{songId}")
    public ResponseEntity<Song> deleteSong(@PathVariable("songId") String songId){
        songService.deleteSongById(songId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
