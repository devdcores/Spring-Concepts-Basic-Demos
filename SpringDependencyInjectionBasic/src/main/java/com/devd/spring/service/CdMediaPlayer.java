package com.devd.spring.service;

import org.springframework.stereotype.Service;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-08 07:10
 */
@Service
public class CdMediaPlayer implements MediaPlayer {

    public void play(String songName) {
        System.out.println(songName + " is Playing in CD Player!!");
    }
}
