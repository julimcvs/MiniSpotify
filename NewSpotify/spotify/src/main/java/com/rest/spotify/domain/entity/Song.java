package com.rest.spotify.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tb_song")
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mp3_file", nullable = false)
    @Lob
    private byte[] mp3;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;

    @ManyToMany(mappedBy = "playlistSongs")
    private Set<Playlist> playlists;
}
