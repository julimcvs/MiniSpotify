package com.rest.spotify.domain.entity;

import com.rest.spotify.domain.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tb_artists")
public class Artist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "twitter_link", nullable = false)
    private String twitterLink;

    @Column(name = "instagram_link", nullable = false)
    private String instagramLink;

    @Column(name = "facebook_link", nullable = false)
    private String facebookLink;

    @Column(name = "picture", nullable = false)
    @Lob
    private byte[] picture;

    @Column(name = "status", nullable = false)
    private StatusEnum status;
}
