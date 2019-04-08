package com.devd.spring;

import com.devd.spring.config.AppConfig;
import com.devd.spring.facade.MediaPlayerFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-08 07:09
 */
public class App {

    public static void main(String[] args) {

        //Create Application Context using AnnotationConfig
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //get the bean from applicationContext
        MediaPlayerFacade bean = applicationContext.getBean(MediaPlayerFacade.class);

        //invoke the method in bean
        bean.playSongInMediaPlayer("Faded");

    }

}
