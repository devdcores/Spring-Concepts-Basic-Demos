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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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
    @Column(updatable = false, nullable = false)
    private UUID songId;

    @NotNull(message = "Song Name should not be empty or null")
    @NotEmpty(message = "Song Name should not be empty or null")
    private String songName;

    @NotNull(message = "Artist Name should not be empty or null")
    @NotEmpty(message = "Song Name should not be empty or null")
    private String artist;

    private LocalDate createdDate = LocalDate.now();

}
