package com.omit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    private Long id;
    private String userid;
    private String password;
    private String username;
    private String email;
}
