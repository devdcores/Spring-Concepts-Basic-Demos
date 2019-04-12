package com.devd.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SONG")
@Data
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SONG_NAME")
    private String name;

    @Column(name = "FILM_NAME")
    private String filmName;

    @Column(name = "SINGER")
    private String singer;

    @Column(name = "YEAR")
    private String year;

    public Song(String name, String filmName, String singer, String year) {
        this.name = name;
        this.filmName = filmName;
        this.singer = singer;
        this.year = year;
    }
}
