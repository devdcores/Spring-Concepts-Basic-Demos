package com.devd.spring;

import com.devd.spring.config.AppConfig;
import com.devd.spring.entity.Song;
import com.devd.spring.facade.MediaPlayerFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-09 02:06
 */
public class App {

    public static void main(String[] args) {

        //Create Application Context using AnnotationConfig
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //get the bean from applicationContext
        MediaPlayerFacade mediaPlayerFacade = applicationContext.getBean(MediaPlayerFacade.class,"");

        System.out.println("*********************************** Adding songs to the MediaPlayer! ***************************************");

        // Add Songs
        mediaPlayerFacade.addSong(new Song("LA-LA-LA", "LALA-LAND", "A", "2010"));
        mediaPlayerFacade.addSong(new Song("RUM-PUM-PUM", "RUM-PUM", "B", "2002"));
        mediaPlayerFacade.addSong(new Song("SunRise", "Sun", "C", "2014"));
        mediaPlayerFacade.addSong(new Song("MoonNight", "Moon", "D", "2018"));


        //Play All Songs
        mediaPlayerFacade.getAllSongs().stream().forEach((song -> {
            System.out.println();
            //Play song
            System.out.println("Now playing song: " + song.getName() + ", film: " + song.getFilmName() + ", singer: " + song.getSinger() + ", year: " + song.getYear());
            mediaPlayerFacade.playSongInMediaPlayer(song.getName());
            System.out.println(". . .");
        }));
    }
}
