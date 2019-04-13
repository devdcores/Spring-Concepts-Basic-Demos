package com.devd.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "SONG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "SONG_ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "SONG_NAME")
    private String name;

    @Column(name = "FILM_NAME")
    private String filmName;

    @Column(name = "SINGER")
    private String singer;

    @Column(name = "YEAR")
    private String year;

}
