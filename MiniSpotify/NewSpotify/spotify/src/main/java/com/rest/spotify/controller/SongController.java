package com.rest.spotify.controller;

import com.rest.spotify.domain.dto.BasicDTO;
import com.rest.spotify.domain.dto.SongDTO;
import com.rest.spotify.service.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/song")
@Slf4j
@RequiredArgsConstructor
public class SongController {
    private final SongService service;

    @PostMapping("/save")
    public ResponseEntity<BasicDTO> uploadSong(@Valid @RequestPart SongDTO dto,
                                               @RequestPart MultipartFile picture,
                                               @RequestPart MultipartFile song) throws IOException {
        return ResponseEntity.ok(service.save(dto, picture, song));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FileSystemResource> downloadSong(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSong(id));
    }
}
