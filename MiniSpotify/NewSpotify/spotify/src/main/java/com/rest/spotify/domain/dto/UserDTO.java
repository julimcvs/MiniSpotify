package com.rest.spotify.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String username;
    @NotBlank
    private String fullname;
    @NotBlank
    private String password;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private LocalDate birthDate;
}
