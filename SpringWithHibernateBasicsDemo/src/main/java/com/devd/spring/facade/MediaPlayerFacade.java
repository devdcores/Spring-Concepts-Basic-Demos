package com.devd.spring.facade;

import com.devd.spring.entity.Song;
import com.devd.spring.service.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-08 07:24
 */
@Component
@Transactional
public class MediaPlayerFacade {

    //mediaPlayer bean gets created at runtime depending on the configuration.
    //in this case CD Player bean is used as dependency and injected this is called autowiring.
    @Autowired
    private MediaPlayer mediaPlayer;


    public void playSongInMediaPlayer(String songName) {
        mediaPlayer.playSong(songName);
    }


    public void addSong(Song song) {
        mediaPlayer.addSong(song);
    }


    public List<Song> getAllSongs() {
        return mediaPlayer.getAllSongs();
    }
}
