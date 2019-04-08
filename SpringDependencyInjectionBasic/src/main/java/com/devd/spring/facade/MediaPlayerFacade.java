package com.devd.spring.facade;

import com.devd.spring.service.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-08 07:24
 */
@Component
public class MediaPlayerFacade {

    //mediaPlayer bean gets created at runtime depending on the configuration.
    //in this case CD Player bean is used as dependency and injected this is called autowiring.
    @Autowired
    private MediaPlayer mediaPlayer;

    public void playSongInMediaPlayer(String songName){
        mediaPlayer.play(songName);
    }
}
