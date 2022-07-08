package com.rest.spotify.mapper;

import com.rest.spotify.domain.dto.BasicDTO;
import com.rest.spotify.domain.dto.SongDTO;
import com.rest.spotify.domain.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SongMapper {
    @Mapping(source = "idArtist", target = "artist.id")
    @Mapping(source = "idAlbum", target = "album.id")
    Song toEntity(SongDTO dto);

    SongDTO toDto(Song entity);

    BasicDTO toBasicDto(Song entity);
}
