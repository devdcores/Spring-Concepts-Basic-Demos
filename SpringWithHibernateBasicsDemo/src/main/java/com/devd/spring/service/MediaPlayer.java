package com.devd.spring.service;


import com.devd.spring.entity.Song;

import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-09 02:09
 */
public interface MediaPlayer {

    void playSong(String songName);

    void addSong(Song song);

    List<Song> getAllSongs();

}
