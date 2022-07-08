package com.rest.spotify.repository;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Repository
public class FileSystemRepository {
    String RESOURCES_DIRECTORY = FileSystemRepository.class.getResource("/").getPath();

    public String save(byte[] content, String songName) throws IOException {
        Path newSong = Paths.get(RESOURCES_DIRECTORY + new Date().getTime() + "-" + songName);
        Files.createDirectory(newSong.getParent());

        Files.write(newSong, content);

        return newSong.toAbsolutePath().toString();
    }

    public FileSystemResource findInFileSystem(String location) {
        try {
            return new FileSystemResource(Paths.get(location));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao reproduzir música.");
        }
    }
}
