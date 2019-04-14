package com.devd.spring.dao;


import com.devd.spring.entity.Song;

import java.util.List;
import java.util.UUID;

public interface SongRepository {

    Song getSongById(UUID songId);
    String saveSong(Song song);
    
    List<Song> getAllSongs();
    void deleteSongById(Song song);

    void updateSong(Song song);
}
