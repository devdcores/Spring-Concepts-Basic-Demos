package com.devd.spring.service;

import com.devd.spring.dao.SongRepository;
import com.devd.spring.entity.Song;
import com.devd.spring.exception.SongIdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-08 08:38
 */
@Service
@Slf4j
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public Song getSongById(String songId) {
        UUID songUUID;
        try {
            songUUID = UUID.fromString(songId);
        } catch (Exception e) {
            log.error("Exception : "+e.getMessage());
            throw new SongIdNotFoundException("SongId doesn't exist!!");
        }
        return songRepository.getSongById(songUUID);
    }

    public String saveSong(Song song) {
        log.info("Saving Song in DB!!");
        if(song.getSongId()!=null){
            songRepository.updateSong(song);
            return song.getSongId().toString();
        }
        return songRepository.saveSong(song);
    }

    public void updateSong(Song song) {
        //to check weather song exists.
        getSongById(String.valueOf(song.getSongId()));
        songRepository.updateSong(song);
    }

    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    public void deleteSongById(String songId) {
        Song song = getSongById(songId);
        songRepository.deleteSongById(song);
    }
}
