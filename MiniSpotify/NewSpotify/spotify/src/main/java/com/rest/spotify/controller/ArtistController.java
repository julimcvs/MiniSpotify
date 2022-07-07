package com.rest.spotify.controller;

import com.rest.spotify.domain.dto.ArtistDTO;
import com.rest.spotify.domain.dto.BasicDTO;
import com.rest.spotify.service.ArtistService;
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

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService service;

    @PostMapping("/save")
    public ResponseEntity<BasicDTO> save(@Valid @RequestPart ArtistDTO dto, @RequestPart MultipartFile picture) throws IOException {
        log.info("REST to save artist.");
        return ResponseEntity.ok(service.save(dto, picture));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ArtistDTO> findById(@PathVariable Long id) {
        log.info("REST to find artist by ID");
        return ResponseEntity.ok(service.getArtistById(id));
    }
}
