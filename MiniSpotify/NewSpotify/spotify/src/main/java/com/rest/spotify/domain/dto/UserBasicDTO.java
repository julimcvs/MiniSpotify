package com.rest.spotify.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserBasicDTO extends BasicDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
}
