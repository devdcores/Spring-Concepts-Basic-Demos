package com.devd.spring.service;

import com.devd.spring.dao.SongRepository;
import com.devd.spring.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-09 02:10
 */
@Service
public class CdMediaPlayer implements MediaPlayer {

    @Autowired
    private SongRepository songRepository;


    public void playSong(String songName) {
        System.out.println(songName + " is playing from CD Player!!");
    }

    public void addSong(Song song) {
        songRepository.addSong(song);
    }

    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }
}
