package com.rest.spotify.domain.dto;

import com.rest.spotify.domain.enums.StatusEnum;

import java.io.Serializable;

public class ArtistBasicDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private StatusEnum status;
}
