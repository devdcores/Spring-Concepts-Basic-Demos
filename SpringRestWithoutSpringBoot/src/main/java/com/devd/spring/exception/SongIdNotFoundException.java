package com.devd.spring.exception;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-04-12 11:59
 */
public class SongIdNotFoundException extends RuntimeException{
    public SongIdNotFoundException(String message) {
        super(message);
    }
}
