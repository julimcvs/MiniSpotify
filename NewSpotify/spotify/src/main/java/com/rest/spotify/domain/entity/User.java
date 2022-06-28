package com.rest.spotify.domain.entity;

import com.rest.spotify.domain.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "status", nullable = false)
    private StatusEnum status;
}
