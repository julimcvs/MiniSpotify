package com.rest.spotify.domain.dto;

import com.rest.spotify.domain.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserBasicDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String email;
    private StatusEnum status;
}
