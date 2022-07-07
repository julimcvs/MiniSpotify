package com.rest.spotify.mapper;

import com.rest.spotify.domain.dto.ArtistDTO;
import com.rest.spotify.domain.dto.BasicDTO;
import com.rest.spotify.domain.entity.Artist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    Artist toEntity(ArtistDTO dto);
    ArtistDTO toDto(Artist entity);
    BasicDTO toBasicDto(Artist entity);
}
