package com.rest.spotify.controller;

import com.rest.spotify.domain.dto.UserBasicDTO;
import com.rest.spotify.domain.dto.UserDTO;
import com.rest.spotify.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @PostMapping("/save")
    public ResponseEntity<UserBasicDTO> save(@Valid @RequestBody UserDTO dto) {
        log.info("REST to save user.");
        return ResponseEntity.ok(service.saveUser(dto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserBasicDTO> findById(@PathVariable Long id) {
        log.info("REST to find user by ID");
        return ResponseEntity.ok(service.getUserById(id));
    }
}
