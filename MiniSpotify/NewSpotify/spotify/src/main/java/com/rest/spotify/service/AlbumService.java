package com.rest.spotify.service;

import com.rest.spotify.domain.dto.AlbumDTO;
import com.rest.spotify.domain.dto.BasicDTO;
import com.rest.spotify.domain.dto.UserBasicDTO;
import com.rest.spotify.domain.entity.Album;
import com.rest.spotify.domain.enums.StatusEnum;
import com.rest.spotify.mapper.AlbumMapper;
import com.rest.spotify.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository repository;
    private final AlbumMapper mapper;

    public AlbumDTO getAlbumById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("O album não foi encontrado.")));
    }

    public BasicDTO save(AlbumDTO dto, MultipartFile picture) throws IOException {
        Album entity = mapper.toEntity(dto);
        if(dto.getId() != null) {
            updateAlbum(dto);
        }
        entity.setPicture(picture.getBytes());
        entity.setStatus(StatusEnum.ACTIVE);
        entity = repository.save(entity);
        return mapper.toBasicDto(entity);
    }

    private void updateAlbum(AlbumDTO dto) {
        Album entity = repository.findById(dto.getId()).orElseThrow(()->new RuntimeException("Album não foi encontrado"));
        if(entity.getStatus()!=StatusEnum.ACTIVE) {
            throw new RuntimeException("Album encontra-se inativo");
        }
    }
}
