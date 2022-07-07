package com.rest.spotify.domain.dto;

import com.rest.spotify.domain.enums.KindEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class SongDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String name;
    @NotNull
    private LocalDate releaseDate;
    @NotNull
    private KindEnum kind;
    @NotNull
    private Long idAlbum;
    @NotNull
    private Long idArtist;
}
