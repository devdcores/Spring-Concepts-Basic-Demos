package com.devd.spring.config;

import com.devd.spring.service.CdMediaPlayer;
import com.devd.spring.service.MediaPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-08 07:10
 */
@Configuration
@ComponentScan(basePackages = {"com.devd.spring"})
public class AppConfig {

    @Bean
    public MediaPlayer mediaPlayer(){
        return new CdMediaPlayer();
    }
}
