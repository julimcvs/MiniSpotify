package com.rest.spotify.domain.entity;

import com.rest.spotify.domain.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "tb_album")
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "picture", nullable = false)
    @Lob
    private byte[] picture;

    @Column(name = "status", nullable = false)
    private StatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;
}
