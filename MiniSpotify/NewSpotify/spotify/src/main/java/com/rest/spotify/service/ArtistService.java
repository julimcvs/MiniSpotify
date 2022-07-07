package com.rest.spotify.service;

import com.rest.spotify.domain.dto.ArtistDTO;
import com.rest.spotify.domain.dto.BasicDTO;
import com.rest.spotify.domain.entity.Artist;
import com.rest.spotify.domain.enums.StatusEnum;
import com.rest.spotify.mapper.ArtistMapper;
import com.rest.spotify.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository repository;
    private final ArtistMapper mapper;

    public ArtistDTO getArtistById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("O artista não foi encontrado.")));
    }

    public BasicDTO save(ArtistDTO dto, MultipartFile picture) throws IOException {
        Artist entity = mapper.toEntity(dto);
        if(dto.getId() != null) {
            updateArtist(dto);
        }
        entity.setPicture(picture.getBytes());
        entity.setStatus(StatusEnum.ACTIVE);
        entity = repository.save(entity);
        return mapper.toBasicDto(entity);
    }

    private void updateArtist(ArtistDTO dto) {
        Artist entity = repository.findById(dto.getId()).orElseThrow(()->new RuntimeException("O artista não existe."));
        if(entity.getStatus()!= StatusEnum.ACTIVE) {
            throw new RuntimeException("O artista encontra-se inativo.");
        }
    }
}
