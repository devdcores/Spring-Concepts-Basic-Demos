package com.devd.spring.service;

import com.devd.spring.dao.SongRepository;
import com.devd.spring.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-08 08:38
 */
@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    public Song getSongById(String songId) {

        return songRepository.getSongById(songId);
    }

    public String saveSong(Song song) {

        return songRepository.saveSong(song);
    }

    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    public void deleteSongById(String songId) {
        songRepository.deleteSongById(songId);
    }
}
