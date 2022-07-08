package com.rest.spotify.service;

import com.rest.spotify.domain.dto.BasicDTO;
import com.rest.spotify.domain.dto.SongDTO;
import com.rest.spotify.domain.entity.Song;
import com.rest.spotify.mapper.SongMapper;
import com.rest.spotify.repository.FileSystemRepository;
import com.rest.spotify.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class SongService {
    private static final String FORMAT = "classpath::videos/%s.mp3";
    private final SongRepository repository;
    private final SongMapper mapper;
    private final ResourceLoader resourceLoader;
    private final FileSystemRepository fileSystemRepository;

    public SongDTO getSongById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("A música não foi encontrada.")));
    }

    public BasicDTO save(SongDTO dto, MultipartFile picture, MultipartFile song) throws IOException {
        Song entity = mapper.toEntity(dto);
        if (dto.getId() != null) {
            updateSong(dto);
        }
        String location = fileSystemRepository.save(song.getBytes(), song.getOriginalFilename());
        entity.setLocation(location);
        return mapper.toBasicDto(entity);
    }

    public FileSystemResource getSong(Long id) {
        Song song = repository.findById(id).orElseThrow(() -> new RuntimeException("A música não foi encontrada."));
        return fileSystemRepository.findInFileSystem(song.getLocation());
    }

    private void updateSong(SongDTO dto) {
        Song song = repository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("A música não foi encontrada."));
    }
}
