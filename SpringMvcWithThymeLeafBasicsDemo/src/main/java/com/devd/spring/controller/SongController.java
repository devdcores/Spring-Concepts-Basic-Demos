package com.devd.spring.controller;

import com.devd.spring.entity.Song;
import com.devd.spring.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("song", new Song());
        return "index";
    }


    @GetMapping("/song/{songId}")
    public ResponseEntity<Song> getSongById(@PathVariable("songId") String songId) {
        Song songById = songService.getSongById(songId);
        return new ResponseEntity<>(songById, HttpStatus.OK);
    }

    @PostMapping("/song")
    public String saveStudent(@ModelAttribute("song") @Validated Song song, BindingResult bindingResult, Model model) {

        ResponseEntity<List<Song>> allSongs = getAllSongs();
        List<Song> songs = allSongs.getBody();
        log.info("Songs : " + songs);
        model.addAttribute("songs", songs);

        if (bindingResult.hasErrors()) {

            return "index";
        }

        songService.saveSong(song);


        return "redirect:/";

    }

    @GetMapping("/editSong/{songId}")
    public String updateStudent(@PathVariable("songId") String songId, Model model) {
        ResponseEntity<Song> songById = this.getSongById(songId);
        Song body = songById.getBody();
        model.addAttribute("song", body);
        ResponseEntity<List<Song>> allSongs = getAllSongs();
        List<Song> songs = allSongs.getBody();
        log.info("Songs : " + songs);
        model.addAttribute("songs", songs);
        return "index";
    }

//    @PostMapping("/editSong/{songId}")
//    public  updateStudent(@RequestBody Song song) {
//        songService.updateSong(song);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/song")
    public ResponseEntity<List<Song>> getAllSongs() {

        return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
    }

    @PostMapping("/deleteSong/{songId}")
    public String deleteSong(@PathVariable("songId") String songId) {
        System.out.println("Song Id :" + songId);
        songService.deleteSongById(songId);

        return "redirect:" + "/";
//        return new ResponseEntity<>(HttpStatus.OK);
    }
}
