package com.rest.spotify.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class ArtistDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String twitterLink;
    @NotBlank
    private String instagramLink;
    @NotBlank
    private String facebookLink;

}
