package com.rest.spotify.service;

import com.rest.spotify.domain.dto.UserBasicDTO;
import com.rest.spotify.domain.dto.UserDTO;
import com.rest.spotify.domain.entity.User;
import com.rest.spotify.domain.enums.StatusEnum;
import com.rest.spotify.mapper.UserMapper;
import com.rest.spotify.repository.UserRepository;
import com.rest.spotify.service.utils.DateValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserBasicDTO getUserById(Long id) {
        return mapper.toBasicDto(repository.findById(id).get());
    }

    public UserBasicDTO saveUser(UserDTO dto) {
        if(DateValidator.isValidDate(dto.getBirthDate())){
            throw new RuntimeException("Esta data não é valida.");
        }
        if(dto.getId()!=null) updateUser(dto);
        User entity = mapper.toEntity(dto);
        entity.setStatus(StatusEnum.ACTIVE);
        entity = repository.save(entity);
        return mapper.toBasicDto(entity);
    }

    private void updateUser(UserDTO dto) {
        User user = repository.findById(dto.getId()).orElseThrow(()->new RuntimeException("Usuário não encontrado."));
        if(user.getStatus()!= StatusEnum.ACTIVE) {
            throw new RuntimeException("O usuário encontra-se inativo.");
        }
    }
}
