package com.rest.spotify.service;

import com.rest.spotify.domain.dto.BasicDTO;
import com.rest.spotify.domain.dto.SongDTO;
import com.rest.spotify.domain.entity.Artist;
import com.rest.spotify.domain.entity.Song;
import com.rest.spotify.domain.enums.StatusEnum;
import com.rest.spotify.mapper.SongMapper;
import com.rest.spotify.repository.SongRepository;
import com.sun.org.apache.xpath.internal.operations.Mult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository repository;
    private final SongMapper mapper;

    public SongDTO getSongById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("A música não foi encontrada.")));
    }

    public BasicDTO save(SongDTO dto, MultipartFile picture, MultipartFile song) throws IOException {
        Song entity = mapper.toEntity(dto);
        if(dto.getId() != null) {
            updateSong(dto);
        }
        entity.setPicture(picture.getBytes());
        entity.setMp3(song.getBytes());
        entity = repository.save(entity);
        return mapper.toBasicDto(entity);
    }

    private void updateSong(SongDTO dto) {
        Song song = repository.findById(dto.getId()).orElseThrow(()->new RuntimeException("A música não foi encontrada."));
    }
}
