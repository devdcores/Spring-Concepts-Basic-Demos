package com.devd.spring.dao;


import com.devd.spring.entity.Song;

import java.util.List;

public interface SongRepository {

    void addSong(Song song);
    List<Song> getAllSongs();

}
