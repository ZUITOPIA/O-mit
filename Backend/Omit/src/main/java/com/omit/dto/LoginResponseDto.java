package com.omit.dto;

import com.omit.domain.Authority;
import com.omit.domain.user.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private Long id;
    private String userid;
    private String username;
    private String email;

    private List<Authority> roles=new ArrayList<>();
    private String token;

    public LoginResponseDto(Users users){
        this.id=users.getId();
        this.userid=users.getUserid();
        this.username=users.getUsername();
        this.email=users.getEmail();
        this.roles=users.getRoles();
    }
}