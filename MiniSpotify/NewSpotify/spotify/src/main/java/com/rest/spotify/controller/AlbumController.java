package com.rest.spotify.controller;


import com.rest.spotify.domain.dto.AlbumDTO;
import com.rest.spotify.domain.dto.BasicDTO;
import com.rest.spotify.service.AlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/album")
public class AlbumController {
    private final AlbumService service;

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDTO> findAlbumById(@PathVariable Long id) {
        log.info("REST to find album by id");
        return ResponseEntity.ok(service.getAlbumById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<BasicDTO> save(@Valid @RequestPart AlbumDTO dto, @RequestPart MultipartFile picture) throws IOException {
        log.info("REST to save album");
        return ResponseEntity.ok(service.save(dto, picture));
    }
}
