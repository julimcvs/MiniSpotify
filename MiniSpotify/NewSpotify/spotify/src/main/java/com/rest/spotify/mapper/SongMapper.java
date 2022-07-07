package com.rest.spotify.mapper;

import com.rest.spotify.domain.dto.BasicDTO;
import com.rest.spotify.domain.dto.SongDTO;
import com.rest.spotify.domain.entity.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {
    Song toEntity(SongDTO dto);
    SongDTO toDto(Song entity);
    BasicDTO toBasicDto(Song entity);
}
