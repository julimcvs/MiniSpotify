package com.rest.spotify.mapper;

import com.rest.spotify.domain.dto.AlbumDTO;
import com.rest.spotify.domain.dto.BasicDTO;
import com.rest.spotify.domain.entity.Album;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    Album toEntity(AlbumDTO dto);
    AlbumDTO toDto(Album entity);
    BasicDTO toBasicDto(Album entity);
}
