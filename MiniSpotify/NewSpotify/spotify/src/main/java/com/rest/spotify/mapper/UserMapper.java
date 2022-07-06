package com.rest.spotify.mapper;

import com.rest.spotify.domain.dto.UserBasicDTO;
import com.rest.spotify.domain.dto.UserDTO;
import com.rest.spotify.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO dto);
    UserDTO toDto(User entity);
    UserBasicDTO toBasicDto(User entity);
}
